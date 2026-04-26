package Week2.Learn.PanduanXunhuan;

import java.util.Scanner;

public class Demo1 {
    static void main() {
//        double bodyTemperature = 39;
//        if (bodyTemperature >= 38) {
//            System.out.println("发烧了");
//        }
        // 游戏任务血量
        int hp = 100;
        int damage;
        System.out.println("请输入攻击力：");
        Scanner sc = new Scanner(System.in);
        damage = sc.nextInt();
        while(damage<=0) {
            System.out.println("输入的攻击力有误，请重新输入：");
            damage = sc.nextInt();
        }
        hp -= damage;
        if (hp<=0) {
            System.out.println("你挂了");
            return;
        }
        System.out.println("剩余血量：" + hp);
        int jinenghuifu;
        System.out.println("请输入技能回复：");
        jinenghuifu = sc.nextInt();
        hp += jinenghuifu;
        System.out.println("剩余血量：" + hp);
    }
}
