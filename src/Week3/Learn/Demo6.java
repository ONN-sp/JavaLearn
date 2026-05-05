package Week3.Learn;

// 定义一个递增有序数组，去除其中重复元素
public class Demo6 {
    static void main() {
        int[] arr = new int[]{1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        int slow = 0;
        int fast = 1;
        while(fast < arr.length) {
            if(arr[slow]!=arr[fast]) {// 不相等，则将快指针的数据存入慢指针位置
                slow++;
                arr[slow] = arr[fast];
            }
            fast++;// 相等则舍弃快指针位置的数据（其实就是fast++）。并且相等和不相等时fast都要++
        }
        for(int i = 0; i <= slow; i++)
            System.out.println(arr[i]);
    }
}
