package Week8.Learn;

public class Demo1 {
    static void main() {
        Integer i = new Integer("10");
        System.out.println(i);
        Integer i2 = Integer.valueOf("10");
        System.out.println(i2);
        Integer i3 = i+i2;// 此时会给i3的value属性赋值为200;
        System.out.println(i3);
    }
}
