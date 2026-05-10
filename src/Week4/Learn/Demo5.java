package Week4.Learn;

import java.util.ArrayDeque;
import java.util.Deque;

// 接雨水
public class Demo5 {
    static void main() {

        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // 动态规划法
        // 从左向右扫描。记录每个位置的左侧（包括当前位置）最高的柱子高度（其实想象右边边界有个无限高的墙壁）
//        int[] leftMax = new int[arr.length];
//        leftMax[0] = arr[0];
//        for(int i=1;i<arr.length;i++)
//            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
//        // 从右向左扫描。记录每个位置的右侧最高的柱子高度
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
        // 双指针法（动态规划法的空间复杂度优化版）
        int left = 0;
        int right = arr.length-1;
        int leftMax = arr[0];// 从数组左端到当前左指针位置 left 之间的最大柱子高度 leftMax>=arr[left]
        int rightMax = arr[right];// 从数组右端到当前右指针位置 right 之间最大柱子高度 rightMax>=arr[right]
        int sum = 0;
        // 当 arr[left] <= arr[right] 时，位置 left 的雨水量由 leftMax 决定，无论 rightMax 是多少
        // 因为如果 leftMax > 右边全局最高，那么在之前的迭代中，右指针会一直向左移动（因为 arr[left] > arr[right]），直到找到一个足够高的右边界
        // 算法的执行顺序保证了当我们处理位置 left 时，右边的屏障已经足够高
        while(left < right) {
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);
            if(arr[left] <= arr[right]) {
                sum += (leftMax-arr[left])*1;// 因为是一列一列的考虑，所以是×1
                left++;
            }
            else {
                sum += (rightMax-arr[right])*1;
                right--;
            }
        }
        System.out.println("双指针法总雨水量为："+sum);
        // 单调栈法
//        Deque<Integer> stack = new ArrayDeque<>();// 单调递减栈
//        int n = arr.length;
//        int res = 0;
//        for(int i=0;i<n;i++) {
//            while(!stack.isEmpty()&&arr[i]>arr[stack.peek()]) {
//                int mid = stack.pop();
//                if(!stack.isEmpty()) {
//                    int left = stack.peek();
//                    int right = i;
//                    int height = Math.min(arr[left], arr[right])-arr[mid];
//                    int width = right-left-1;
//                    int area = height*width;
//                    res  += area;
//                }
//            }
//            stack.push(i);
//        }
//        System.out.println("单调栈法总雨水量为："+res);
    }
}
