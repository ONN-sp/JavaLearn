package Week6.Learn.Demo5;

public class Demo5 {
    static void main() {
        Student stu = new Student();
        goSwimming(stu);
        goSwimming(new Student(){
            @Override
            public void swim() {
                System.out.println("学生1正在游泳");
            }
        });// 用匿名内部类创建对象传入
        Swim s = () -> System.out.println("学生2正在游泳");
        goSwimming(s);
    }
    public static void goSwimming(Swim s) {
        s.swim();
    }
}
