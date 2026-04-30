package Week2.Learn.PanduanXunhuan;

import java.util.Scanner;

public class Demo6 {
    static void main() {
        // 判断是否是质数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入正整数：");
        int n = sc.nextInt();
        if(n<=1) {
            System.out.println("不是质数");
            return;
        }
        for(int i=2;i<Math.sqrt(n);++i) {
            if(n%i==0) {
                System.out.println("不是质数");
                return;
            }
        }
        System.out.println(n+"是质数");
    }
}
