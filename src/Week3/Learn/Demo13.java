package Week3.Learn;

import java.util.Arrays;
import java.util.Random;

public class Demo13 {
    static void main() {
        String str = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        char[] arr = str.toCharArray();
        for(int i=0;i<str.length();++i) {
            int index = random.nextInt(arr.length);
            char temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
