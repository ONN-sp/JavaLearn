package Week2.Learn.PanduanXunhuan;

import java.util.Scanner;

public class Demo2 {
    static void main() {
//        需求：小明每次订外卖都会在多家平台对比，看谁的优惠力度更大
        double price = 50;
        Demo2 demo2 = new Demo2();
        double price_result = demo2.getPrice(price);
        System.out.println("最终价格是：" + price_result);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入价格：");
        price = sc.nextDouble();
        price_result = demo2.getPrice(price);
        System.out.println("最终价格是：" + price_result);
    }
    double getPrice(double price) {
        double price1 = price*0.9;// 9折
        double price2 = price>30?price-10:price;// 满30-10
        return price1>price2?price2:price1;
    }
}
