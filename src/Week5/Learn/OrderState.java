package Week5.Learn;

public enum OrderState {
    PAYMENT_PENDING("待付款"),// 隐式实例化
    PAYMENT_SUCCESS("已付款"),
    DELIVERING("配送中"),
    DELIVERED("已送达"),
    CANCELED("已取消");
    OrderState(String name) {
        this.name = name;
    }
    private final String name;
    public String getName() {
        return name;
    }
}
