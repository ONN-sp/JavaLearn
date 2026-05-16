package Week6.Learn.Demo2;

public class Delivery {
    private String number;
    private int weight;
    private String reciver;
    public Delivery(String number, int weight, String reciver) {
        this.number = number;
        this.weight = weight;
        this.reciver = reciver;
    }
    public Delivery() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }
    public final int calculateCost() {
        return weight * 10;
    }
}
