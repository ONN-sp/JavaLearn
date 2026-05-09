package Week4.Learn;

import java.util.ArrayList;
import java.util.Random;

public class Demo4 {
    static void main() {
        int[] arr = new int[6];// 0号索引对应弃票，1-5号索引对应投票人的号数
        Random random = new Random();
        for(int i=0;i<1000;++i) {
            int vote = random.nextInt(6);
            arr[vote]++;
        }
        voteResults(arr);
    }
    public static void voteResults(int[] arr) {
        int max = 0;
        ArrayList<int[]> maxList = new ArrayList<>();// CPP中vector的完美替代
        double[] percent = new double[6];// 得票率
        for(int i=1;i<arr.length;i++) {
            percent[i] = arr[i] / 1000.0;
            if (arr[i] > max)
                max = arr[i];
            System.out.println("第"+i+"号投票人占比"+percent[i]);
        }
        for(int i=1;i<arr.length;++i) {
            if(arr[i]==max)
                maxList.add(new int[]{i, arr[i]});
        }
        for(int[] e:maxList)
            System.out.println("最多票数的候选者为："+e[0]+"，票数为："+e[1]);
        System.out.println("弃票数为："+ arr[0]+"，弃票率为："+ arr[0]/1000.0);
    }
}
