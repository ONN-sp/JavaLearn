package Week3.Learn;

import java.util.Arrays;
import java.util.Random;

public class Demo5 {
    static void main() {
        int[] arr = new int[10];
        Random random = new Random();
        for(int i=0;i<arr.length;++i) {
            int num = random.nextInt(1, 101);
//            boolean flag = false;
//            for(int j=0;j<i;++j) {// 只遍历前面已经生成的数字
//                if (j == num){
//                    i--;
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag)
//                arr[i] = num;
//            flag = false;
//            }
            boolean has = Arrays.stream(arr).anyMatch(n -> n == num);
            if(!has)
                arr[i] = num;
            else
                i--;
        }
        for(int num:arr)
            System.out.println(num);
    }
}
