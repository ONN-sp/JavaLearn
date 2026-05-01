package Week2.Learn.PanduanXunhuan;

public class Demo8 {
    static void main() {
//        for(int i=1;i<=5;++i) {
//            for(int j=1;j<=i;++j)
//        for(int i=5;i>0;--i) {
//            for(int j=1;j<=i;++j)
//                System.out.print("*");
//            System.out.print("\n");
//        }
        // 打印平行四边形
//        for(int i=1;i<=3;++i) {
//            for(int j=i;j<=2;++j)
//                System.out.print(" ");
//            for(int j=1;j<=6;++j)
//                System.out.print("*");
//            System.out.println();
//        }
        // 打印9*9乘法表
        for (int i = 1; i <= 9; ++i) {
            for(int j=1;j<=i;++j)
                System.out.print(j+"*"+i+"="+j*i+"\t");
            System.out.println();
        }
    }
}
