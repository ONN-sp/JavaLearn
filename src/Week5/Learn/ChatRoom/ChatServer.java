package Week5.Learn.ChatRoom;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * 聊天室服务器
 * 负责管理所有客户端连接和消息转发
 */
public class ChatServer {
    private static final int PORT = 8888;
    private ServerSocket serverSocket;
    
    // 存储所有连接的客户端处理器
    private final Map<String, ClientHandler> clients = new ConcurrentHashMap<>();
    
    // 线程池用于处理客户端连接
    private ExecutorService threadPool;
    
    public ChatServer() {
        // 创建固定大小的线程池
        this.threadPool = Executors.newFixedThreadPool(50);
    }
    
    /**
     * 启动服务器
     */
    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("===========================================");
            System.out.println("   聊天室服务器已启动");
            System.out.println("   监听端口: " + PORT);
            System.out.println("   等待客户端连接...");
            System.out.println("===========================================");
            
            while (!serverSocket.isClosed()) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("新客户端连接: " + clientSocket.getInetAddress().getHostAddress());
                    
                    // 为每个客户端创建一个处理线程
                    ClientHandler handler = new ClientHandler(clientSocket);
                    threadPool.execute(handler);
                } catch (IOException e) {
                    if (!serverSocket.isClosed()) {
                        System.err.println("接受客户端连接失败: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("服务器启动失败: " + e.getMessage());
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }
    
    /**
     * 关闭服务器
     */
    public void shutdown() {
        try {
            System.out.println("正在关闭服务器...");
            
            // 关闭所有客户端连接
            for (ClientHandler handler : clients.values()) {
                handler.close();
            }
            
            // 关闭线程池
            threadPool.shutdown();
            
            // 关闭服务器套接字
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            
            System.out.println("服务器已关闭");
        } catch (IOException e) {
            System.err.println("关闭服务器时出错: " + e.getMessage());
        }
    }
    
    /**
     * 广播消息给所有客户端
     */
    public void broadcastMessage(Message message) {
        for (ClientHandler handler : clients.values()) {
            handler.sendMessage(message);
        }
    }
    
    /**
     * 发送私聊消息
     */
    public void sendPrivateMessage(Message message) {
        String receiver = message.getReceiver();
        ClientHandler handler = clients.get(receiver);
        
        if (handler != null) {
            handler.sendMessage(message);
        } else {
            // 接收者不在线，通知发送者
            ClientHandler sender = clients.get(message.getSender());
            if (sender != null) {
                Message errorMsg = new Message(Message.MessageType.SYSTEM, "系统", 
                    "用户 '" + receiver + "' 不在线");
                sender.sendMessage(errorMsg);
            }
        }
    }
    
    /**
     * 添加客户端
     */
    public void addClient(String username, ClientHandler handler) {
        clients.put(username, handler);
        broadcastUserList();
    }
    
    /**
     * 移除客户端
     */
    public void removeClient(String username) {
        clients.remove(username);
        broadcastUserList();
    }
    
    /**
     * 广播在线用户列表
     */
    private void broadcastUserList() {
        String userList = String.join(", ", clients.keySet());
        Message message = new Message(Message.MessageType.USER_LIST, "系统", 
            "当前在线用户 (" + clients.size() + "人): " + userList);
        broadcastMessage(message);
    }
    
    /**
     * 检查用户名是否已存在
     */
    public boolean isUsernameTaken(String username) {
        return clients.containsKey(username);
    }
    
    /**
     * 获取在线用户数量
     */
    public int getClientCount() {
        return clients.size();
    }
    
    /**
     * 客户端处理器内部类
     * 每个客户端连接对应一个处理器线程
     */
    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private String username;
        
        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                // 初始化输入输出流
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            } catch (IOException e) {
                System.err.println("创建客户端处理器失败: " + e.getMessage());
                close();
            }
        }
        
        @Override
        public void run() {
            try {
                // 首先读取用户名
                String line = in.readLine();
                if (line == null || line.trim().isEmpty()) {
                    close();
                    return;
                }
                
                this.username = line.trim();
                
                // 检查用户名是否已存在
                if (isUsernameTaken(username)) {
                    sendMessage(new Message(Message.MessageType.SYSTEM, "系统", "用户名已存在，请重新连接"));
                    close();
                    return;
                }
                
                // 添加客户端到列表
                addClient(username, this);
                
                // 发送欢迎消息
                Message welcomeMsg = new Message(Message.MessageType.SYSTEM, "系统", 
                    "欢迎 " + username + " 加入聊天室！");
                broadcastMessage(welcomeMsg);
                
                System.out.println("用户 " + username + " 已登录");
                
                // 循环读取客户端消息
                while ((line = in.readLine()) != null) {
                    if (line.trim().isEmpty()) {
                        continue;
                    }
                    
                    // 解析消息
                    Message message = parseMessage(line);
                    
                    if (message != null) {
                        handleMessage(message);
                    }
                }
            } catch (IOException e) {
                System.out.println("用户 " + username + " 连接断开: " + e.getMessage());
            } finally {
                // 客户端断开连接
                if (username != null) {
                    removeClient(username);
                    Message logoutMsg = new Message(Message.MessageType.SYSTEM, "系统", 
                        username + " 已离开聊天室");
                    broadcastMessage(logoutMsg);
                    System.out.println("用户 " + username + " 已登出");
                }
                close();
            }
        }
        
        /**
         * 解析消息字符串为Message对象
         */
        private Message parseMessage(String line) {
            try {
                // 简单协议：TYPE|SENDER|RECEIVER|CONTENT
                // 私聊：CHAT|sender|receiver|content
                // 群聊：CHAT|sender||content
                String[] parts = line.split("\\|", 4);
                
                if (parts.length < 3) {
                    return null;
                }
                
                Message.MessageType type = Message.MessageType.valueOf(parts[0]);
                String sender = parts[1];
                String receiver = parts.length > 2 ? parts[2] : "";
                String content = parts.length > 3 ? parts[3] : "";
                
                if (receiver.isEmpty()) {
                    return new Message(type, sender, content);
                } else {
                    return new Message(type, sender, receiver, content);
                }
            } catch (Exception e) {
                System.err.println("消息解析失败: " + e.getMessage());
                return null;
            }
        }
        
        /**
         * 处理接收到的消息
         */
        private void handleMessage(Message message) {
            switch (message.getType()) {
                case CHAT:
                    if (message.getReceiver() != null && !message.getReceiver().isEmpty()) {
                        // 私聊
                        sendPrivateMessage(message);
                    } else {
                        // 群聊
                        broadcastMessage(message);
                    }
                    break;
                default:
                    System.out.println("未知消息类型: " + message.getType());
            }
        }
        
        /**
         * 发送消息给客户端
         */
        public void sendMessage(Message message) {
            if (out != null) {
                // 将消息转换为字符串格式
                String msgStr = message.getType() + "|" + 
                              message.getSender() + "|" + 
                              (message.getReceiver() != null ? message.getReceiver() : "") + "|" + 
                              message.getContent();
                out.println(msgStr);
            }
        }
        
        /**
         * 关闭连接
         */
        public void close() {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null && !socket.isClosed()) socket.close();
            } catch (IOException e) {
                System.err.println("关闭连接时出错: " + e.getMessage());
            }
        }
    }
    
    /**
     * 主方法 - 启动服务器
     */
    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        
        // 添加关闭钩子，确保服务器优雅关闭
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\n接收到关闭信号...");
            server.shutdown();
        }));
        
        server.start();
    }
}
