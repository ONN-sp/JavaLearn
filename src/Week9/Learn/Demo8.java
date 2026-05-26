package Week9.Learn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo8 {
    static void main() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", "18");
        System.out.println(map);
        // 键找值遍历
        Set<String> keys = map.keySet();
        // 遍历单列集合
        for(String key : keys){
            System.out.println(key);
            System.out.println(map.get(key));
        }
        // 键值对遍历
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        // lambda表达式遍历
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }
}
