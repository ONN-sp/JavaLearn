package Week5.Learn.ChatRoom;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * 聊天室客户端
 * 用户可以连接服务器并与其他用户聊天
 */
public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8888;
    
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Scanner scanner;
    private String username;
    private volatile boolean connected = false;
    
    /**
     * 连接到服务器
     */
    public boolean connect(String username) {
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            scanner = new Scanner(System.in);
            
            this.username = username;
            
            // 发送用户名到服务器
            out.println(username);
            
            connected = true;
            System.out.println("成功连接到服务器！");
            
            // 启动接收消息的线程
            Thread receiveThread = new Thread(this::receiveMessages);
            receiveThread.setDaemon(true);
            receiveThread.start();
            
            return true;
        } catch (IOException e) {
            System.err.println("连接服务器失败: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * 接收服务器消息的线程方法
     */
    private void receiveMessages() {
        try {
            String line;
            while (connected && (line = in.readLine()) != null) {
                displayMessage(line);
            }
        } catch (IOException e) {
            if (connected) {
                System.err.println("接收消息时出错: " + e.getMessage());
            }
        }
    }
    
    /**
     * 显示接收到的消息
     */
    private void displayMessage(String messageLine) {
        try {
            // 解析消息：TYPE|SENDER|RECEIVER|CONTENT
            String[] parts = messageLine.split("\\|", 4);
            
            if (parts.length < 3) {
                System.out.println(messageLine);
                return;
            }
            
            Message.MessageType type = Message.MessageType.valueOf(parts[0]);
            String sender = parts[1];
            String receiver = parts[2];
            String content = parts.length > 3 ? parts[3] : "";
            
            switch (type) {
                case SYSTEM:
                    System.out.println("\n>>> [系统] " + content);
                    break;
                    
                case USER_LIST:
                    System.out.println("\n>>> " + content);
                    break;
                    
                case CHAT:
                    if (receiver != null && !receiver.isEmpty()) {
                        // 私聊消息
                        if (receiver.equals(username)) {
                            System.out.println("\n[私聊] " + sender + ": " + content);
                        } else {
                            System.out.println("\n[我的私聊] 发送给 " + receiver + ": " + content);
                        }
                    } else {
                        // 群聊消息
                        System.out.println("\n" + sender + ": " + content);
                    }
                    break;
                    
                default:
                    System.out.println(messageLine);
            }
            
            // 重新显示输入提示
            System.out.print("我> ");
            
        } catch (Exception e) {
            System.out.println(messageLine);
            System.out.print("我> ");
        }
    }
    
    /**
     * 发送消息
     */
    public void sendMessage(String message) {
        if (out != null && connected) {
            out.println(message);
        }
    }
    
    /**
     * 断开连接
     */
    public void disconnect() {
        connected = false;
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null && !socket.isClosed()) socket.close();
            if (scanner != null) scanner.close();
            System.out.println("已断开与服务器的连接");
        } catch (IOException e) {
            System.err.println("断开连接时出错: " + e.getMessage());
        }
    }
    
    /**
     * 检查是否已连接
     */
    public boolean isConnected() {
        return connected;
    }
    
    /**
     * 获取用户名
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * 主方法 - 启动客户端
     */
    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===========================================");
        System.out.println("   欢迎使用 Java 聊天室客户端");
        System.out.println("===========================================");
        
        // 输入用户名
        System.out.print("请输入您的昵称: ");
        String username = scanner.nextLine().trim();
        
        if (username.isEmpty()) {
            username = "游客" + (int)(Math.random() * 1000);
            System.out.println("使用随机昵称: " + username);
        }
        
        // 连接服务器
        System.out.println("正在连接服务器...");
        if (!client.connect(username)) {
            System.err.println("无法连接到服务器，请确保服务器已启动");
            scanner.close();
            return;
        }
        
        // 显示帮助信息
        System.out.println("\n===========================================");
        System.out.println("   聊天室使用说明");
        System.out.println("===========================================");
        System.out.println("直接输入消息 - 发送群聊消息");
        System.out.println("/private <用户> <消息> - 发送私聊消息");
        System.out.println("/users - 查看在线用户");
        System.out.println("/help - 显示帮助信息");
        System.out.println("/quit 或 /exit - 退出聊天室");
        System.out.println("===========================================\n");
        
        // 主循环 - 读取用户输入
        System.out.print("我> ");
        try {
            while (client.isConnected()) {
                String input = scanner.nextLine();
                
                if (input.trim().isEmpty()) {
                    System.out.print("我> ");
                    continue;
                }
                
                // 处理命令
                if (input.startsWith("/")) {
                    handleCommand(client, input, scanner);
                } else {
                    // 发送群聊消息
                    String message = "CHAT|" + client.getUsername() + "||" + input;
                    client.sendMessage(message);
                }
                
                if (client.isConnected()) {
                    System.out.print("我> ");
                }
            }
        } catch (Exception e) {
            System.err.println("发生错误: " + e.getMessage());
        } finally {
            client.disconnect();
            scanner.close();
        }
    }
    
    /**
     * 处理命令
     */
    private static void handleCommand(ChatClient client, String command, Scanner scanner) {
        String[] parts = command.split("\\s+", 3);
        String cmd = parts[0].toLowerCase();
        
        switch (cmd) {
            case "/quit":
            case "/exit":
                System.out.println("再见！");
                client.disconnect();
                break;
                
            case "/help":
                System.out.println("\n--- 帮助信息 ---");
                System.out.println("直接输入消息 - 发送群聊消息");
                System.out.println("/private <用户> <消息> - 发送私聊消息");
                System.out.println("/users - 查看在线用户");
                System.out.println("/help - 显示帮助信息");
                System.out.println("/quit 或 /exit - 退出聊天室");
                System.out.println("---------------\n");
                break;
                
            case "/private":
            case "/pm":
            case "/msg":
                if (parts.length < 3) {
                    System.out.println("用法: /private <用户名> <消息内容>");
                } else {
                    String receiver = parts[1];
                    String content = parts[2];
                    String message = "CHAT|" + client.getUsername() + "|" + receiver + "|" + content;
                    client.sendMessage(message);
                }
                break;
                
            case "/users":
                System.out.println("提示: 在线用户列表会在有人加入或离开时自动显示");
                break;
                
            default:
                System.out.println("未知命令: " + cmd);
                System.out.println("输入 /help 查看帮助信息");
        }
    }
}
