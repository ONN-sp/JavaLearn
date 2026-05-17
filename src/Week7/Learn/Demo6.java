package Week7.Learn;

import java.util.Scanner;

public class Demo6 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = sc.next();
        if(str.length()<=8)
            System.out.println(str+"0".repeat(8-str.length()));
        else {
            System.out.println(str.substring(0, 8));
            for (int i = 8; i < str.length(); ++i) {
                char c = str.charAt(i);
                System.out.print(c);
                if ((i-7) % 8 == 0)
                    System.out.println();
            }
            int val = str.length() % 8;
            System.out.println("0".repeat(8-val));
        }
    }
}
