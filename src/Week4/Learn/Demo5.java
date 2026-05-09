package Week4.Learn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 接雨水
public class Demo5 {
    static void main() {

        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // 动态规划法
        // 从左向右扫描（想象右边边界有个无限高的墙壁）。记录柱子+雨水总单位
//        int[] leftMax = new int[arr.length];
//        leftMax[0] = arr[0];
//        for(int i=1;i<arr.length;i++)
//            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
//        // 从右向左扫描（想象左边边界有个无限高的墙壁）。记录柱子+雨水总单位
//        int[] rightMax = new int[arr.length];
//        rightMax[arr.length-1] = arr[arr.length-1];
//        for(int i=arr.length-2;i>=0;i--)
//            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
//        // 取交集-柱子高度
//        int[] ans = new int[arr.length];
//        int sum = 0;
//        for(int i=0;i<arr.length;i++) {
//            ans[i] = Math.min(leftMax[i], rightMax[i]) - arr[i];
//            sum += ans[i];
//        }
//        System.out.println("总雨水量为："+sum);
        // 双指针法


        // 单调栈法
        Deque<Integer> stack = new ArrayDeque<>();// 单调递减栈
        int n = arr.length;
        int res = 0;
        for(int i=0;i<n;i++) {
            while(!stack.isEmpty()&&arr[i]>arr[stack.peek()]) {
                int mid = stack.pop();
                if(!stack.isEmpty()) {
                    int left = stack.peek();
                    int right = i;
                    int height = Math.min(arr[left], arr[right])-arr[mid];
                    int width = right-left-1;
                    int area = height*width;
                    res  += area;
                }
            }
            stack.push(i);
        }
        System.out.println("单调栈法总雨水量为："+res);
    }
}
