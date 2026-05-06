package Week3.Learn;

import java.util.Scanner;

public class Demo9 {
    static void main() {
        System.out.println("需要打印几×几的乘法表：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printMulTable(n);
    }
    // 打印n*n乘法表
    static void printMulTable(int n) {
        for (int i = 1; i <= n; ++i) {
            for(int j=1;j<=i;++j)
                System.out.print(j+"*"+i+"="+j*i+"\t");
            System.out.println();
        }
    }
}
