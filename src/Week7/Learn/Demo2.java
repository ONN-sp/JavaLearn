package Week7.Learn;

import java.util.Arrays;
import java.util.Scanner;

public class Demo2 {
    static void main() {
        String s = "abc";
        char c = s.charAt(1);
        System.out.println(c);
        System.out.println(s.length());
        // 统计字符串中出现的字符的个数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = sc.next();
        int upperCount = 0;
        int lowerCount = 0;
        int numberCount = 0;
        for(char ss:str.toCharArray()) {
            if(ss>='a'&&ss<='z')
                lowerCount++;
            else if(ss>='A'&&ss<='Z')
                upperCount++;
            else if(Character.isDigit(ss))
                numberCount++;
            else
                System.out.println("当前字符不参与统计");
        }
        System.out.println("大写字母个数:"+upperCount);
        System.out.println("小写字母个数:"+lowerCount);
        System.out.println("数字个数:"+numberCount);
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(arr));
    }
}
