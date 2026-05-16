package Week6.Learn.Demo1;

public class Clothe extends Products {
    private double size;
    private String color;
    public Clothe(String name, double price, double size, String color) {
        super(name, price);
        this.size = size;
        this.color = color;
    }
    public Clothe() {
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    void showInfo() {
        super.showInfo();
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
    }

}
