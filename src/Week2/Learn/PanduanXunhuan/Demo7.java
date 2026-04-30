package Week2.Learn.PanduanXunhuan;

import java.util.Random;
import java.util.Scanner;

public class Demo7 {
    static void main() {
        /*
        生成一个1~100的随机数，利用键盘录入模拟猜的动作，一直猜，直到猜中为止
        小保底：3次没猜中就给一个随机数字的±5的范围
        大保底：10次没猜中就给结果
        * */
        Random random = new Random();
        int number = random.nextInt(1,101);
        int count_small = 0;
        int count_big = 0;
        while(true) {
            System.out.println("请输入猜的数字：");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            if(n==number) {
                System.out.println("恭喜你猜对了");
                break;
            }
            else if(n<number)
                System.out.println("猜的数字小了");
            else
                System.out.println("猜的数字大了");
            count_small++;
            count_big++;
            if(count_small%3==0)
                System.out.println("触发小保底，随机数字范围"+(number-5)+"~"+(number+5));
            if(count_big==10) {
                System.out.println("触发大保底，结果是"+number);
                break;
            }
        }
    }
}
