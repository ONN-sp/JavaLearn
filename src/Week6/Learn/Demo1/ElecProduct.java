package Week6.Learn.Demo1;

public class ElecProduct extends Products{
    private String brand;
    private String model;
    public ElecProduct(String name, double price, String brand, String model) {
        super(name, price);
        this.brand = brand;
        this.model = model;
    }

    public ElecProduct() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    void showInfo() {
        super.showInfo();
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }
}
