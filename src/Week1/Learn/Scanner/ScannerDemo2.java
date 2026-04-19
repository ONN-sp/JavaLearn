package Week1.Learn.Scanner;

import java.util.Scanner;

public class ScannerDemo2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请键盘录入一个整数:");
        int num1 = sc.nextInt();
        System.out.println("请键盘录入一个整数:");
        int num2 = sc.nextInt();
        System.out.println("两数之和=");
        System.out.println(num1+num2);
    }
}
