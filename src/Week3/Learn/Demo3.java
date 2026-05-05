package Week3.Learn;

import java.util.Arrays;

public class Demo3 {
    static void main() {
        int[] arr = new int[]{33, 5, 22, 44, 55};
//        int maxV = arr[0];
        int maxV= Arrays.stream(arr).max().getAsInt();
//        for(int num:arr) {
//            if(num>maxV)
//                maxV = num;
//        }
        System.out.println("最大值为：" + maxV);
    }
}
