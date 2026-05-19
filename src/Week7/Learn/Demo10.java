package Week7.Learn;

import java.util.ArrayList;

public class Demo10 {
    static void main() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add(0, "ccc");
        System.out.println(list);
        list.remove("aaa");
        System.out.println(list);
        list.set(0, "ddd");
        System.out.println(list);
        String str = list.toString();
        System.out.println(str);
        String[] arr = list.toArray(new String[0]);
        System.out.println(arr[0]);
    }
}
