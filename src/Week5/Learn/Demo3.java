package Week5.Learn;

public class Demo3 {
    static void main() {
        OrderState o1 = OrderState.PAYMENT_PENDING;
        System.out.println(o1.getName());
        switch (o1) {
            case PAYMENT_PENDING -> System.out.println("待付款状态");
            case PAYMENT_SUCCESS -> System.out.println("已付款状态");
            case DELIVERING -> System.out.println("配送中状态");
            case DELIVERED -> System.out.println("已送达状态");
            case CANCELED -> System.out.println("已取消状态");
        }
        OrderState[] arr = OrderState.values();
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        OrderState paypending = OrderState.valueOf("PAYMENT_PENDING");
        System.out.println(paypending);
        }
    }
