package Week7.Learn;

import java.util.Arrays;

public class Demo7 {
    static void main() {
        String str1 = "12395";
        String str2 = "133";
//        int num1 = Integer.parseInt(str1);
//        int num2 = Integer.parseInt(str2);
//        System.out.println(num1+num2);
        // 需要注意：上面代码没有考虑数据过大，超出int取值范围的情况
        // 考虑数据过大的情况用数组
        String res = add(str1, str2);
        System.out.println(res);
    }
    // 模拟数字字符串加法并考虑数据过大
    public static String add(String str1, String str2) {
        int maxLen = Math.max(str1.length(), str2.length());
        int[] arr = new int[maxLen+1];
        int minLen = Math.min(str1.length(), str2.length());
        int jinwei = 0;
        int pos = arr.length-1;
        int count = 0;
        for(int i=minLen-1;i>=0;--i) {
            int strNum1 = str1.charAt(str1.length()-1-count)-'0';
            int strNum2 = str2.charAt(i)-'0';
            int num = (strNum1+strNum2+jinwei)%10;
            jinwei = (strNum1+strNum2+jinwei)/10;
            arr[pos--] = num;
            count++;
        }
        if(str1.length()>str2.length()) {
            for(int i=str1.length()-minLen-1;i>=0;--i) {
                int strNum = str1.charAt(i)-'0';
                int num = (strNum+jinwei)%10;
                jinwei = (strNum+jinwei)/10;
                arr[pos--] = num;
            }
        }
        else {
            for(int i=str2.length()-minLen-1;i>=0;--i) {
                int strNum = str2.charAt(i)-'0';
                int num = (strNum+jinwei)%10;
                jinwei = (strNum+jinwei)/10;
                arr[pos--] = num;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(jinwei>0) {
            arr[pos] = jinwei;
            sb.append(jinwei);
        }
        for(int i=1;i<arr.length;++i)
            sb.append(arr[i]);
        return sb.toString();
    }
}
