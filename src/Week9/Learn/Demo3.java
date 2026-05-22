package Week9.Learn;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo3 {
    static void main() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            String e = it.next();
            System.out.println(e);
        }
    }
}
