package Week9.Learn;

import java.util.ArrayList;
import java.util.Collection;

public class Demo4 {
    static void main() {
        Collection<String> coll = new ArrayList<>();
        coll.add("a");
        coll.add("b");

        coll.forEach(e -> System.out.println(e));
    }
}
