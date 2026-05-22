package Week8.Learn.GedouFightGame.Ui;

import Week8.Learn.GedouFightGame.Bean.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Login {
    // 这个方法表示的是登录注册的主页面
    public void start() {
        System.out.println("游戏的登录注册页面打开了~");
        // 正常公司中是将数据保存在数据库中，这里为了方便，将数据保存在集合中来模拟
        HashSet<User> hs = new HashSet<>();
        while (true) {
            System.out.println("╔════════════════════════════════╗");
            System.out.println("    🎮 欢迎来到文字格斗游戏 🎮   ");
            System.out.println("╚════════════════════════════════╝");
            System.out.println("请选择操作：1登录 2注册 3忘记密码 4退出");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1" -> login(hs);
                case "2" -> register(hs);
                case "3" -> forgotPassword(hs);
                case "4" -> {
                    System.out.println("游戏已退出");
                    System.exit(0);//停止JVM
                }
                default -> System.out.println("输入有误，请重写输入~");
            }
        }
    }
    // 登录操作
    public void login(HashSet<User> hs) {
        System.out.println("用户选择了登录操作~");
        // 判断用户是否存在
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.next();
        if (!isContains(hs, username)) {
            System.out.println("当前用户名"+username+"不存在，请先注册~");
            return;
        }
        // 用户名存在，判断是否禁用
        // 通过username获取User对象
        User user = getUserByUsername(hs, username);
        if (!user.isStatus()) {
            System.out.println("当前用户"+username+"已被禁用，请联系管理员~");
            return;
        }
        // 验证密码是否正确
        for(int i=0;i<3;++i) {
            System.out.println("请输入密码：");
            String password = sc.next();
            // 每次输入密码都需要验证验证码
            while(true) {
                // 生成一个正确的验证码
                String rightCode = getCode();
                System.out.println("正确验证码为："+rightCode);
                System.out.println("请输入验证码：");
                String code = sc.next();
                if (code.equals(rightCode)) {
                    System.out.println("验证码输入正确");
                    break;
                }
                else {
                    System.out.println("验证码输入错误，请重新输入");
                    continue;
                }
            }
            if (!user.getPassword().equals(password)){
                System.out.println("密码错误，登录失败");
                if(i==2) {
                    user.setStatus(false);
                    System.out.println("当前用户"+username+"已被禁用，请联系管理员~");
                    return;
                }
                else
                    System.out.println("您还有"+(2-i)+"次机会");
            }
            else {
                System.out.println("登录成功！欢迎回来，" + username + "~");
                // 登录成功后启动游戏
                FightingGame fightingGame = new FightingGame();
                fightingGame.gameStart(username);
                break;
            }
        }
    }

    // 注册操作
    public void register(HashSet<User> hs) {
        System.out.println("用户选择了注册操作~");
        User u = new User();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("请输入用户名：");
            String username = sc.next();
            // 用户名唯一；长度3-16
            if (!checkLen(username, 3, 16)) {
                System.out.println("用户名长度必须在3-16之间");
                continue;
            }
            // 只能用字符、数字组成,不能是纯数字
            if (!checkUsername(username)) {
                System.out.println("用户名只能由字母和数字组成，且不能是纯数字");
                continue;
            }
            if (isContains(hs, username)) {
                System.out.println("用户名已存在，请重新输入~");
                continue;
            }
            // 用户名录入的用户名是合理的
            u.setUsername(username);
            break;
        }
        while(true) {
            System.out.println("请输入密码：");
            String password = sc.next();
            System.out.println("请输入确认密码：");
            String confirmPassword = sc.next();
            if (!checkLen(password, 3, 8)) {
                System.out.println("密码长度必须在3-8之间");
                continue;
            }
            if(!checkPassword(password)) {
                System.out.println("密码只能由字母加数字组成，不能是纯数字，不能有其它字符");
                continue;
            }
            if(!password.equals(confirmPassword)) {
                System.out.println("密码不一致，请重新输入~");
                continue;
            }
            // 密码合理
            u.setPassword(password);
            break;
        }
        while(true) {
            System.out.println("请输入手机号：");
            String phone = sc.next();
            if (!checkPhone(phone)) {
                System.out.println("手机号格式不正确，必须是11位数字且以1开头");
                continue;
            }
            u.setPhone(phone);
            break;
        }
        hs.add(u);
        System.out.println("用户注册成功~");
    }

    public boolean checkLen(String str, int min, int max) {
        return str.length() >= min && str.length() <= max;
    }

    // 统计字符串中字母、数字、其他字符的个数
    public int[] getCount(String str) {
        int numCount = 0;
        int charCount = 0;
        int otherCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 检查是否只包含字母或数字
            if (Character.isLetter(c))
                charCount++;
                // 统计数字个数
            else if (Character.isDigit(c))
                numCount++;
            else
                otherCount++;
        }
        return new int[]{numCount, charCount, otherCount};
    }

    public boolean checkUsername(String str) {
        // 用户名只能由字母和数字组成，且不能是纯数字
        if (str == null || str.isEmpty()) {
            return false;
        }
        int[] counts = getCount(str);
        return counts[2]==0&&counts[0]!=str.length();
    }

    public boolean checkPassword(String str) {
        // 密码只能由字母和数字组成，且不能是纯数字
        if (str == null || str.isEmpty()) {
            return false;
        }
        int[] counts = getCount(str);
        return counts[2]==0&&counts[0]>0&&counts[1]>0;
    }

    // 验证手机号格式：11位数字，以1开头
    public boolean checkPhone(String phone) {
        if (phone == null || phone.length() != 11) {
            return false;
        }
        if (!phone.startsWith("1")) {
            return false;
        }
        // 检查是否全部是数字
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // 通过username获取User对象
    public User getUserByUsername(HashSet<User> hs, String username) {
        for (User u : hs) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    // 判断用户名在集合中是否包含
    public boolean isContains(HashSet<User> hs, String username) {
        return getUserByUsername(hs, username) != null;
    }

    // 忘记密码功能
    public void forgotPassword(HashSet<User> hs) {
        System.out.println("用户选择了忘记密码操作~");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = "";
        for(int i=0;i<3;++i) {
            username = sc.next();
            if (!isContains(hs, username)) {
                if (i == 2) {
                    System.out.println("用户名错误，3次输入均失败");
                    return;
                } else
                    System.out.println("当前用户名" + username + "未注册，还有" + (2 - i) + "次机会重新输入");
            }
            else
                break;
        }
        User user = getUserByUsername(hs, username);
        System.out.println("请输入手机号：");
        // 给三次输入手机号的机会，如果三次都错误，提示手机号错误
        for(int i = 0; i<3; ++i) {
            String phone = sc.next();
            if (!user.getPhone().equals(phone)) {
                if(i==2) {
                    System.out.println("手机号错误，3次输入均失败");
                    return;
                }
                System.out.println("手机号不正确，还有" + (2-i) + "次机会重新输入");
            }
            else
                break;
        }
        while(true) {
            System.out.println("请输入新密码：");
            String newPassword = sc.next();
            System.out.println("请确认新密码：");
            String confirmPassword = sc.next();
            if (!newPassword.equals(confirmPassword)) {
                System.out.println("两次输入的密码不一致");
                continue;
            }
            if (!checkLen(newPassword, 3, 8)) {
                System.out.println("密码长度必须在3-8之间");
                continue;
            }
            if (!checkPassword(newPassword)) {
                System.out.println("密码只能由字母加数字组成，不能是纯数字，不能有其它字符");
                continue;
            }
            user.setPassword(newPassword);
            break;
        }
        System.out.println("密码修改成功！");
    }

    // 生成验证码：4个字母和1个数字
    public static String getCode() {
        ArrayList<Character> list = new ArrayList<>();
        // 把所有大小写字母加入集合中
        for (int i=0;i<26;++i) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        // 从集合中随机取出4个字母组成验证码
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<4;++i) {
            int index = random.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }
        // 随机生成一个数字
        int num = random.nextInt(10);
        sb.append(num);
        // 数字的位置可以是任意的：将最大索引和随机索引处的元素交换
        String code = sb.toString();
        char[] arr = code.toCharArray();
        int pos = random.nextInt(5);// 获取随机索引
        char temp = arr[pos];
        arr[pos] = arr[arr.length-1];
        arr[arr.length-1] = temp;
        return new String(arr);
    }
}
