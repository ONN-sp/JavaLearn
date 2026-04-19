package Week1.Learn.Scanner;

import java.util.Scanner;

public class ScannerDemo3 {
    static void main() {
        // BMI = 体重 / 身高的平方
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入你的体重和身高：");
//        double weight = sc.nextDouble();
//        double height = sc.nextDouble();
//        double bmi = weight / (height * height);
//        System.out.printf("你的BMI是：%f", bmi);

        // 录入一个三位数，将其拆分为个位、十位、百位
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入一个三位数：");
//        int num = sc.nextInt();
//        int ge = num % 10;
//        int shi = num / 10 % 10;
//        int bai = num / 100;
//        System.out.println("个位是：" + ge);
//        System.out.println("十位是：" + shi);
//        System.out.println("百位是：" + bai);
        // 录入一个秒数，将其拆分为小时、分钟、秒
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个三位数：");
        int num = sc.nextInt();
        int hour = num / 3600;
        int min = num % 3600 / 60;
        int sec = num % 3600 % 60;
//        System.out.println("小时是：" + hour + " 分钟是：" + min + " 秒是：" + sec);
        System.out.printf("小时是: %d, 分钟是: %d, 秒是: %d\n", hour, min, sec);
    }
}
