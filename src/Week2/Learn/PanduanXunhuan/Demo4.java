package Week2.Learn.PanduanXunhuan;

import java.util.Scanner;

public class Demo4 {
    static void main() {
//        int num1, num2;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入两个数字：");
//        num1 = sc.nextInt();
//        num2 = sc.nextInt();
//        int start = num1>num2?num2:num1;
//        int end = num1<num2?num2:num1;
//        int count=0;
//        for(int i=start; i<=end; i++)
//            if(i%3==0&&i%5==0)
//                count++;
//        System.out.println("在"+start+"到"+end+"内既能被3整除又能被5整数共有"+count+"个");
        // 斐波那契数列
//        int a = 0, b = 1;
//        Demo4 demo = new Demo4();
//        System.out.println(demo.fibnacci(10));
//    }
//    int fibnacci(int n) {
//        if(n==1)
//            return 0;
//        if(n==2)
//            return 1;
//        return fibnacci(n-1)+fibnacci(n-2);
//    }
        // 求前n项数列和 S(n)=1-2+3-4+5+...
        int sum = 0;
        int num;
        System.out.println("请输入数列和项数：");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        Demo4 demo = new Demo4();
        System.out.println(demo.getSum(num));

    }
    int getSum(int n) {
        int sum = 0;
        for(int i=1; i<=n; i++) {
            if (i % 2 == 0)
                sum -= i;
            else
                sum += i;
        }
        return sum;
    }
}
