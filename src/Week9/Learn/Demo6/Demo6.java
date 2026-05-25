package Week9.Learn.Demo6;

import java.util.HashSet;

public class Demo6 {
    static void main() {
        Student s1 = new Student("张三", 18, 1.75, 70);
        Student s2 = new Student("李四", 19, 1.8, 75);
        Student s3 = new Student("张三", 18, 1.75, 70);
        HashSet<Student> set = new HashSet<>();
        System.out.println("set.add(s1) = "+set.add(s1));
        System.out.println("set.add(s2) = "+set.add(s2));
        System.out.println("set.add(s3) = "+set.add(s3));
    }
}
