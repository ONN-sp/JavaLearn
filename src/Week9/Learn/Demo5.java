package Week9.Learn;

import java.util.ArrayList;

public class Demo5 {
    static void main() {
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<Integer> intList = new ArrayList<>();

        System.out.println(strList.getClass() == intList.getClass());  // true
        System.out.println(strList.getClass());  // class java.util.ArrayList
    }
}
