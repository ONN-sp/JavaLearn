package Week9.Learn;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Demo10 {
    static void main() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        map.put("张三", 100);
        map.put("李四", 200);
        map.put("王五", 300);
        System.out.println(map);
        System.out.println(map.get("张三"));
    }
}
