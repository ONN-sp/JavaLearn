package Week3.Learn;

import java.util.Random;

// 打乱数组
public class Demo4 {
    static void main() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            // 获取随机索引
            int j = random.nextInt(arr.length);
            // 交换两个元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        for(int num:arr)
            System.out.println(num);
    }
}
