package Week3.Learn;

public class Demo10 {
    static void main() {
        int a = 10;
        int b = 20;
        System.out.println(getSum(a,b));
    }
    public static double getSum(int a, int b) {
        return a+b;
    }
    public  static double getSum(int a, double b) {
        return a+b;
    }
    public static double getSum(double a, double b) {
        return a+b;
    }
}
