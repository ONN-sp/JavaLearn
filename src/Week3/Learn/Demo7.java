package Week3.Learn;

// 合并两个有序数组
public class Demo7 {
    static void main() {
        int[] arr1 = new int[]{1, 3, 5, 7, 9};
        int[] arr2 = new int[]{2, 4, 6, 8, 10, 11};
        int[] arr3 = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while(index1 < arr1.length && index2 < arr2.length) {
            if(arr1[index1]<arr2[index2])
                arr3[index3++] = arr1[index1++];
                else
                    arr3[index3++] = arr2[index2++];
        }
        while(index2 < arr2.length)
            arr3[index3++] = arr2[index2++];
        while(index1 < arr1.length)
            arr3[index3++] = arr1[index1++];

        for (int i: arr3)
            System.out.println(i);
    }
}
