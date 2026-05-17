package Week7.Learn;

import java.util.Scanner;

public class Demo5 {
    static void main() {
       while(true) {
           Scanner sc = new Scanner(System.in);
           System.out.println("请输入一个字符串:");
           String str = sc.next();
           if(str.equals("拜拜")) {
               break;
           }else {
               StringBuilder sb = new StringBuilder(str);
               System.out.println(sb.reverse());
           }
       }
    }
}
