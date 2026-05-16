package Week5.Learn.Demo1;

public class Demo1 {

    static void main() {
        Dog d1 = new Dog();
        d1.setName("小花");
        d1.setAge(2);
        d1.setWeight(5.5);
        d1.setColor("白色");
        System.out.println("名字："+d1.getName()+"，年龄："+d1.getAge()+"，体重："+d1.getWeight()+"，颜色："+d1.getColor());
        Dog d2 = new Dog();
        d2.setName("小王");
        d2.setAge(1);
        d2.setWeight(3.5);
        d2.setColor("黑色");
        System.out.println("名字："+d2.getName()+"，年龄："+d2.getAge()+"，体重："+d2.getWeight()+"，颜色："+d2.getColor());
    }
}
