package Week3.Learn;

import java.util.Scanner;

public class Demo11 {
    static void main() {
        int[] scores = new int[10];// 10位同学的成绩
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i+1) + "位同学的分数：");
            scores[i] = sc.nextInt();
            while(scores[i] < 0|| scores[i] > 100) {
                System.out.println("输入的分数有误！请重新输入");
                scores[i] = sc.nextInt();
            }
        }
        // 求及格人数
        System.out.println("及格人数为：" + jigeNums(scores));
        // 求及格率
        System.out.println("及格率为：" + jigeNums(scores) * 1.0 / scores.length);
        // 求总分
        System.out.println("总分为：" + sumScores(scores));
        // 求平均分
        System.out.println("平均分为：" + sumScores(scores) * 1.0 / scores.length);
        // 求最高峰
        System.out.println("最高分为：" + maxScore(scores));
    }
    public static int jigeNums(int[] scores) {
        int jigeNums = 0;
        for(int score : scores) {
            if(score >= 60)
                jigeNums++;
        }
        return jigeNums;
    }
    public static int maxScore(int[] scores) {
        int max = scores[0];
        for(int score : scores) {
            if(score > max)
                max = score;
        }
        return max;
    }
    public static int sumScores(int[] scores) {
        int sum = 0;
        for(int score : scores) {
            sum += score;
        }
        return sum;
    }

}
