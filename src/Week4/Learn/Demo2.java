package Week4.Learn;

import java.util.Random;
import java.util.Scanner;

// 红包问题
// 每个人最少1分钱
// 每个人领完红包后，至少给每个红包预留1分钱
public class Demo2 {
    static void main() {
        int money;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入红包金额(分)：");
        money = sc.nextInt();
        int hongbaoNum;
        System.out.println("请输入红包个数：");
        hongbaoNum = sc.nextInt();
        Random random = new Random();
        if(hongbaoNum>money) {
            System.out.println("红包个数不能大于红包金额");
            return;
        }
        for(int i=1;i<hongbaoNum;i++) {
            // money-(hongbaoNum-i)目的是为了给后面的每个红包预留至少一分钱
            int hongbao = random.nextInt(1,money-(hongbaoNum-i)+1);// 当前是第i个人随机抽取
            money = money-hongbao;
            System.out.println("第"+(i+1)+"个人抢到"+hongbao+"分");
        }
        System.out.println("最后一个人抢到"+money+"分");
    }
}
