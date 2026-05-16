package Week6.Learn.Demo4;

import java.util.Scanner;

public class Demo4 {
    static void main() {
        PingpangPSporter pps = new PingpangPSporter("张三", 18);
        System.out.println(pps.getName()+","+pps.getAge());
        pps.study();
        pps.SpeakEnglish();
        System.out.println("运行JDK版本: " + System.getProperty("java.version"));
        Scanner sc = new Scanner(System.in);
        sc.next();
    }
}
