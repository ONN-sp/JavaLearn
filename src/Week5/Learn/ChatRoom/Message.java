package Week5.Learn.ChatRoom;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 消息模型类
 * 用于在客户端和服务器之间传输消息
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // 消息类型
    public enum MessageType {
        LOGIN,          // 登录
        LOGOUT,         // 登出
        CHAT,           // 聊天消息
        SYSTEM,         // 系统消息
        USER_LIST       // 用户列表
    }
    
    private MessageType type;           // 消息类型
    private String sender;              // 发送者
    private String receiver;            // 接收者（私聊时使用）
    private String content;             // 消息内容
    private String timestamp;           // 时间戳
    
    public Message() {
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    public Message(MessageType type, String sender, String content) {
        this.type = type;
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    public Message(MessageType type, String sender, String receiver, String content) {
        this.type = type;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    
    // Getters and Setters
    public MessageType getType() {
        return type;
    }
    
    public void setType(MessageType type) {
        this.type = type;
    }
    
    public String getSender() {
        return sender;
    }
    
    public void setSender(String sender) {
        this.sender = sender;
    }
    
    public String getReceiver() {
        return receiver;
    }
    
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return "[" + timestamp + "] " + sender + ": " + content;
    }
}
