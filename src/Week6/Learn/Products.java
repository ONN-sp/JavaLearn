package Week6.Learn;

public class Products {
    private String name;
    private double price;

    public Products(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Products() {
        this.name = "No name";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}
