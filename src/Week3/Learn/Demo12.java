package Week3.Learn;

import java.util.Scanner;

public class Demo12 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入快递重量：");
        double weight = sc.nextDouble();
        while(weight <= 0) {
            System.out.println("请输入正确的重量：");
            weight = sc.nextDouble();
        }
        int switchFlag = (int)weight+1;
        switch(switchFlag) {
            case 1 -> System.out.println("快递价格是：" + getPriceOne(weight));
            case 2, 3, 4, 5, 6 -> System.out.println("快递价格是：" + getPriceMoreOne(weight));
            default -> System.out.println("快递价格是：" + getPriceMoreFive(weight));
        }
    }
    public static double getPriceOne(double weight) {
        return 10;
    }
    public static double getPriceMoreOne(double weight) {
        return 10+(weight-1)*2;
    }
    public static double getPriceMoreFive(double weight) {
        return 10+4*2+(weight-5)*1.5;
    }
}
