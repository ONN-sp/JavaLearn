package Week1.Learn.Scanner;
import java.util.Scanner;

public class ScannerDemo1 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 接收键盘录入的整数
        int num1 = sc.nextInt();
        System.out.println(num1);
        // 接收键盘录入的小鼠
        double num2 = sc.nextDouble();
        System.out.println(num2);
        // 接收键盘录入的文本（字符串）
        String str = sc.next();
        System.out.println(str);
    }
}
