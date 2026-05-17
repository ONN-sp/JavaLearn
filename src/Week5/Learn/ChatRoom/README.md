# Java 聊天室项目

## 项目简介
这是一个基于 Java Socket 编程实现的多用户聊天室系统，支持群聊和私聊功能。

## 功能特性
- ✅ 多用户同时在线聊天
- ✅ 群聊功能 - 消息广播给所有在线用户
- ✅ 私聊功能 - 一对一私密聊天
- ✅ 实时显示在线用户列表
- ✅ 用户登录/登出通知
- ✅ 时间戳显示
- ✅ 友好的命令行界面

## 项目结构
```
ChatRoom/
├── Message.java           # 消息模型类
├── ChatServer.java        # 服务器端
├── ChatClient.java        # 客户端
└── ChatRoomLauncher.java  # 启动类
```

## 技术要点
- **网络编程**: 使用 Java Socket API
- **多线程**: 服务器使用线程池处理多个客户端连接
- **IO流**: BufferedReader 和 PrintWriter 进行数据传输
- **并发安全**: 使用 ConcurrentHashMap 管理客户端
- **序列化**: Message 类实现 Serializable 接口

## 如何运行

### 方法一：分别启动

1. **编译所有文件**
```bash
cd E:\JavaLearn\JavaLearn\src\Week5\Learn\ChatRoom
javac *.java
```

2. **启动服务器**（在一个终端窗口）
```bash
java Week5.Learn.ChatRoom.ChatServer
```

3. **启动客户端**（在多个终端窗口，可以启动多个客户端）
```bash
java Week5.Learn.ChatRoom.ChatClient
```

### 方法二：使用启动类

1. **编译所有文件**
```bash
cd E:\JavaLearn\JavaLearn\src\Week5\Learn\ChatRoom
javac *.java
```

2. **启动服务器**
```bash
java Week5.Learn.ChatRoom.ChatRoomLauncher server
```

3. **启动客户端**（在新终端窗口）
```bash
java Week5.Learn.ChatRoom.ChatRoomLauncher client
```

## 使用说明

### 客户端命令
- **直接输入文本** - 发送群聊消息
- **/private \<用户名\> \<消息\>** - 发送私聊消息
- **/pm \<用户名\> \<消息\>** - 发送私聊消息（简写）
- **/users** - 查看在线用户提示
- **/help** - 显示帮助信息
- **/quit** 或 **/exit** - 退出聊天室

### 示例对话

**群聊：**
```
我> 大家好！
张三: 你好！
李四: 欢迎加入！
```

**私聊：**
```
我> /private 张三 你好，想和你私聊
[我的私聊] 发送给 张三: 你好，想和你私聊
[私聊] 张三: 好的，收到！
```

## 工作流程

1. **服务器启动**
   - 监听端口 8888
   - 等待客户端连接

2. **客户端连接**
   - 输入用户名
   - 连接到服务器
   - 接收欢迎消息和在线用户列表

3. **消息传输**
   - 客户端发送消息到服务器
   - 服务器根据消息类型转发（群聊广播/私聊定向发送）
   - 所有客户端接收并显示消息

4. **客户端断开**
   - 通知其他用户该用户已离开
   - 更新在线用户列表

## 消息协议
采用简单的文本协议格式：
```
TYPE|SENDER|RECEIVER|CONTENT
```

例如：
- `CHAT|张三||大家好` - 张三发送群聊消息
- `CHAT|张三|李四|你好` - 张三给李四发送私聊
- `SYSTEM|系统||欢迎张三加入` - 系统消息

## 注意事项
1. 必须先启动服务器，再启动客户端
2. 每个客户端需要使用不同的用户名
3. 服务器默认监听本地 8888 端口
4. 如需跨机器通信，需修改 ChatClient 中的 SERVER_ADDRESS

## 学习价值
本项目适合学习：
- Java 网络编程基础
- Socket 通信技术
- 多线程编程
- IO 流操作
- 简单的客户端-服务器架构
