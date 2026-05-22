package Week8.Learn.GedouFightGame.Bean;

import java.util.Random;

public class User {
    private String id;
    private String username;
    private String password;
    private String phone;
    private boolean status;// false表示当前用户禁用，true表示当前用户正常

    public User() {
        this.id = createId();
        this.status = true;
    }

    public User(String id, String username, String password, String phone, boolean status) {
        this.id = createId();
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.status = true;
    }
    // 生成随机id，"bytedance"+5位随机数
    public String createId() {
        StringBuilder sb = new StringBuilder("bytedance");
        Random random = new Random();
        for(int i=0;i<5;++i) {
            int num = random.nextInt(10);
            sb.append(num);
        }
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
