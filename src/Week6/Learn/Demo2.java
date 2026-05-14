package Week6.Learn;

public class Demo2 {
    static void main() {
        LocalDelivery localDelivery = new LocalDelivery("123456789", 10, "张三");
        System.out.println(localDelivery.calculateCost());
        AirFlyDelivery airFlyDelivery = new AirFlyDelivery("234567890", 15, "李四");
        System.out.println(airFlyDelivery.calculateCost());
    }
}
