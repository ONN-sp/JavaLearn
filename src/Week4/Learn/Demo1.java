package Week4.Learn;

public class Demo1 {
    static void main() {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        if(nums.length<=1) {
            for(int num:nums)
                System.out.println(num);
        }
        int slow = 0;// 指向更新新数组下标的位置
        int fast = 0;// 寻找新数组的元素，新数组就是不含有目标元素的数组
        for(; fast < nums.length; fast++) {
            if(nums[fast]!=val) {
                nums[slow++] = nums[fast];
            }
        }
        for(int i=0;i<slow;++i)
            System.out.println(nums[i]);
        System.out.println("剩余数组还有："+slow+"个元素");
    }
}
