package Week3.Learn;

import java.util.Scanner;

public class Demo2 {
    static void main() {
        int[] arr = new int[]{33, 5, 22, 44, 55, 33};
        System.out.println("请输入任意一个数据:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0;i<arr.length;++i) {
            if(arr[i]==num) {
                System.out.println("该数据在数组中的索引为：" + i);
                return;
            }
        }
        System.out.println("没有找到该数据");
    }
}
