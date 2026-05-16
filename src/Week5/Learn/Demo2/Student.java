package Week5.Learn.Demo2;

public class Student {
    private String name;
    private int age;
    private double height;
    private double weight;
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    // 使用构造函数初始化成员变量

    public Student() {
    }

    public Student(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    // 学习
    public void studu() {
        System.out.println(this.name+"正在学习");
    }
}
