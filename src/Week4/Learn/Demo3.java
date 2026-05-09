package Week4.Learn;

public class Demo3 {
    static void main() {
        int[] arr1 = new int[]{1, 3, 5, 7, 9};
        int[] arr2 = new int[]{2, 4};
        // 合并两个有序数组
        int[] arr3 = merge(arr1, arr2);
        for(int i=0;i<arr3.length;i++)
            System.out.println(arr3[i]);
        double median = findMedianSortedArrays(arr3);
        System.out.println("中位数是："+median);
    }
    // 合并两个有序数组就是归并排序中“分-治”中的“治”这一步
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length && j<arr2.length) {
            if(arr1[i]<arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while(i<arr1.length)
            arr3[k++] = arr1[i++];
        while (j<arr2.length)
            arr3[k++] = arr2[j++];
        return arr3;
    }
    public static double findMedianSortedArrays(int[] arr) {
        int medianIndex = arr.length/2;
        if(arr.length%2==0)
            return (arr[medianIndex]+arr[medianIndex-1])/2.0;
        else
            return arr[medianIndex];
    }
}
