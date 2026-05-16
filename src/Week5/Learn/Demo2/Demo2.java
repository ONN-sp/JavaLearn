package Week5.Learn.Demo2;

public class Demo2 {
    static void main() {
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(18);
        s1.setHeight(183);
        s1.setWeight(60);
        System.out.println("姓名："+s1.getName()+"，年龄："+s1.getAge()+"，身高："+s1.getHeight()+"cm，体重："+s1.getWeight()+"kg");
        s1.studu();
        // 大二期间
        s1.setAge(s1.getAge()+1);
        double newW = s1.getWeight() + 10;
        s1.setWeight(newW);
        System.out.println("姓名："+s1.getName()+"，年龄："+s1.getAge()+"，身高："+s1.getHeight()+"cm，体重："+s1.getWeight()+"kg");
        // 大三期间
        s1.setAge(s1.getAge()+1);
        double newH = s1.getHeight() + 2;
        s1.setHeight(newH);
        double newW2 = s1.getWeight() - 3;
        s1.setWeight(newW2);
        System.out.println("姓名："+s1.getName()+"，年龄："+s1.getAge()+"，身高："+s1.getHeight()+"cm，体重："+s1.getWeight()+"kg");
        // 大四期间
        s1.setAge(s1.getAge()+1);
        System.out.println("姓名："+s1.getName()+"，年龄："+s1.getAge()+"，身高："+s1.getHeight()+"cm，体重："+s1.getWeight()+"kg");
    }
}
