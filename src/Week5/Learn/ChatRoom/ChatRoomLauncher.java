package Week5.Learn.ChatRoom;

/**
 * 聊天室启动类
 * 提供快速启动服务器和客户端的入口
 */
public class ChatRoomLauncher {
    
    /**
     * 主方法
     * 根据参数启动服务器或客户端
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            printUsage();
            return;
        }
        
        String mode = args[0].toLowerCase();
        
        switch (mode) {
            case "server":
                System.out.println("启动聊天室服务器模式...\n");
                ChatServer.main(new String[]{});
                break;
                
            case "client":
                System.out.println("启动聊天室客户端模式...\n");
                ChatClient.main(new String[]{});
                break;
                
            default:
                System.out.println("未知模式: " + mode);
                printUsage();
        }
    }
    
    /**
     * 打印使用说明
     */
    private static void printUsage() {
        System.out.println("===========================================");
        System.out.println("   Java 聊天室项目");
        System.out.println("===========================================");
        System.out.println();
        System.out.println("使用方法:");
        System.out.println("  java ChatRoomLauncher server  - 启动服务器");
        System.out.println("  java ChatRoomLauncher client  - 启动客户端");
        System.out.println();
        System.out.println("或者分别运行:");
        System.out.println("  java ChatServer  - 启动服务器");
        System.out.println("  java ChatClient  - 启动客户端");
        System.out.println();
        System.out.println("===========================================");
    }
}
