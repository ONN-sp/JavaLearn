package Week2.Learn.PanduanXunhuan;

import java.util.Scanner;

public class Demo5 {
    static void main() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入正整数：");
        n = sc.nextInt();
        int num = n;
        int result = 0;
        while(num!=0) {
            result += Math.abs(num%10);// 提取此时的个位，取绝对值
            num /= 10;// 去除此时的个位
        }
        System.out.println(n+"的每位数字的绝对值之和为"+result);
    }
}
