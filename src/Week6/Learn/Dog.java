package Week6.Learn;

public class Dog extends Animal{
    public Dog() {
    }
    public Dog(int age, String color) {
        super(age, color);
    }
    @Override
    public void eat(String something) {
        System.out.println(getAge()+"岁且颜色为"+getColor()+"的狗正在吃"+something);
    }
    public void lookHome() {
        System.out.println("dogs are looking home");
    }
}
