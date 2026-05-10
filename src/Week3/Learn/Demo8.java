package Week3.Learn;

import java.util.Arrays;
import java.util.Random;

public class Demo8 {
    static void main() {
        int[] arr = new int[10];
        Random random = new Random();
        Demo8 demo8 = new Demo8();
        for(int i=0;i<arr.length;++i) {
            int num = random.nextInt(1, 101);
            if(demo8.isExist(arr, num, i)) {
                i--;
                continue;
            }
            arr[i] = num;
        }
        for(int num:arr)
            System.out.println(num);
    }
    boolean isExist(int[] arr, int num, int endIndex) {
        boolean has = Arrays.stream(arr).anyMatch(x -> x == num);
        return has;
//        for(int j=0;j<endIndex;++j) {// 只遍历前面已经生成的数字
//            if (arr[j] == num)
//                return true;
//        }
//        return false;
    }
}
