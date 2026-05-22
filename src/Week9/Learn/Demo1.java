package Week9.Learn;

import java.util.Arrays;
import java.util.Comparator;

public class Demo1 {
    static void main() {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.binarySearch(arr, 5));
        System.out.println(Arrays.binarySearch(arr, 8));
        int[] newArr = Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(newArr));
        Integer[] arr2 = {2, 3, 4, 9, 1, 8};
        Arrays.sort(arr2, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(arr2));
    }
}
