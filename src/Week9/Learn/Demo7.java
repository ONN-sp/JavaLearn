package Week9.Learn;

import java.util.Iterator;
import java.util.TreeSet;

public class Demo7 {
    static void main() {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(3);
        ts.add(2);
        System.out.println(ts);
        Iterator<Integer> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
