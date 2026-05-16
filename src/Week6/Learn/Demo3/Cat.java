package Week6.Learn.Demo3;

public class Cat extends Animal{
    public Cat() {
        super();
    }
    public Cat(int age, String color) {
        super(age, color);
    }
    @Override
    public void eat(String something) {
        System.out.println(getAge()+"岁且颜色为"+getColor()+"的猫正在吃" + something);
    }
    public void catchMouse() {
        System.out.println("catch mouse");
    }
}
