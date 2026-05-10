package Week4.Learn;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 大乐透
public class Demo6 {
    static void main() {
        // 生成彩票号码
        int[] lotteryNumber = createLotteryNumber();
        printLotteryNumber(lotteryNumber);
        // 购买彩票
        int[] buyerNumber = buyLotteryNumber();
        printLotteryNumber(buyerNumber);
        // 判断中奖
        // 判断中了几个前区，几个后区(中奖和顺序无关，即1,2,3中奖的话3,2,1也中奖)
        int[] winnerNumber = getWinnerNumber(lotteryNumber, buyerNumber);
        System.out.println("前区蓝球中了"+winnerNumber[0]+"个");
        System.out.println("后区红球中了"+winnerNumber[1]+"个");
    }
    public static void printLotteryWinnerLevel(int[] arr) {
        if(arr[0]==5&&arr[1]==2)
            System.out.println("中奖等级：一等奖");
        else if (arr[0]==5&&arr[1]==1)
            System.out.println("中奖等级：二等奖");
        else if ((arr[0]==5&&arr[1]==0)||(arr[0]==4&&arr[1]==2))
            System.out.println("中奖等级：三等奖");
        else if ((arr[0]==4&&arr[1]==1)||(arr[0]==3&&arr[1]==2))
            System.out.println("中奖等级：四等奖");
        else if ((arr[0]==4&&arr[1]==0)||(arr[0]==3&&arr[1]==1)||(arr[0]==2&&arr[1]==2))
            System.out.println("中奖等级：五等奖");
        else if ((arr[0]==3&&arr[1]==0)||(arr[0]==2&arr[1]==1)||(arr[0]==1&&arr[1]==2)||(arr[0]==0&&arr[1]==2))
            System.out.println("中奖等级：六等奖");
        else
            System.out.println("很遗憾，没有中奖");
        for(int i=0;i<arr.length-1;++i)
            System.out.print(arr[i]+", ");
    }
    public static int[] getWinnerNumber(int[] lotteryNumber, int[] buyerNumber) {
        int frontCount = 0;
        int backCount = 0;
        for(int i=0;i<5;i++) {
            if(isExist(lotteryNumber, buyerNumber[i], 0, 5))
                frontCount++;
        }
        for(int i=5;i<7;i++) {
            if(isExist(lotteryNumber, buyerNumber[i], 5, 7))
                backCount++;
        }
        return new int[]{frontCount, backCount};
    }
    public static int[] createLotteryNumber() {
        int[] arr = new int[7];// 前区5个号码，后区2个号码
        Random random = new Random();
        for(int i=0;i<5;) {// 前区
            int number = random.nextInt(1,36);
            if(!isExist(arr, number, 0, 5)) {// 在前面5个数据中判断是否重复
                arr[i] = number;
                i++;
            }
        }
        for(int i=5;i<7;) {// 后区
            int number = random.nextInt(1,13);
            if(!isExist(arr, number, 5, 7)) {// 在后面2个数据中判断是否重复
                arr[i] = number;
                i++;
            }
        }
        return arr;
    }
    public static int[] buyLotteryNumber() {
        int[] arr = new int[7];
        Scanner sc = new Scanner(System.in);
        // 前区
        for(int i=0;i<5;) {
            System.out.println("请输入第"+(i+1)+"个彩票号码：");
            int number = sc.nextInt();
            if(number<1||number>35) {
                System.out.println("当前彩票号码不在范围中，请重写选择");
                continue;
            }
            boolean has = isExist(arr, number, 0, 5);// 选的彩票号码要唯一
            if(has) {
                System.out.println("当前彩票号码已存在，请重新选择");
                continue;
            }
            // 代码执行到这，表示number是合理且唯一的
            arr[i] = number;
            i++;
        }
        // 后区
        for(int i=5;i<7;) {
            System.out.println("请输入第"+(i+1)+"个彩票号码：");
            int number = sc.nextInt();
            if(number<1||number>12) {
                System.out.println("当前彩票号码不在范围中，请重新选择");
                continue;
            }
            boolean has = isExist(arr, number, 5, 7);
            if(has) {
                System.out.println("当前彩票号码已存在，请重新选择");
                continue;
            }
            arr[i] = number;
            i++;
        }
        return arr;
    }
    public static boolean isExist(int[] arr, int number, int start, int end) {
//        for(int j=start;j<end;++j) {// 只遍历前面已经生成的数字
//            if (arr[j] == num)
//                return true;
//        }
//        return false;
        boolean has = Arrays.stream(arr).skip(start).limit(end-start).anyMatch(x -> x == number);
        return has;
    }
    public static void printLotteryNumber(int[] arr) {
        System.out.print("[");
        for(int i=0;i<arr.length-1;++i)
            System.out.print(arr[i]+", ");
        System.out.println(arr[arr.length-1]+"]");
    }
}
