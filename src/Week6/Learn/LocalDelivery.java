package Week6.Learn;

public class LocalDelivery extends Delivery {
    public LocalDelivery(String number, int weight, String reciver) {
        super(number, weight, reciver);
    }
    public LocalDelivery() {

    }
    @Override
    public int calculateCost() {
        int OldCost = super.calculateCost();
        return OldCost+10;
    }
}
