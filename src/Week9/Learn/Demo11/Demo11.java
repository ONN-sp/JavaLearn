package Week9.Learn.Demo11;

import java.util.TreeMap;
import java.util.TreeSet;

public class Demo11 {
    static void main() {
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 18);
        TreeMap<Student, String> ts = new TreeMap<>();
        ts.put(s1, "江苏");
        ts.put(s2, "北京");
        for(var entry:ts.entrySet()){
            System.out.println(entry.getKey().getName()+" "+entry.getValue());
        }
    }
}
