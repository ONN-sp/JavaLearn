package Week9.Learn;

import java.util.ArrayList;
import java.util.Collection;

public class Demo2 {
    static void main() {
        Collection<Integer> collection = new ArrayList<>();// 多态方式
        collection.add(100);
        collection.add(200);
        System.out.println(collection);// 调用ArrayList的toString()方法
    }
}
