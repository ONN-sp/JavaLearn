package Week2.Learn.PanduanXunhuan;

public class Demo3 {
    static void main() {
        int num = 3;
//        switch (num) {
//            case 1 -> System.out.println("星期一");
//            case 2 -> System.out.println("星期二");
//            case 3 -> System.out.println("星期三");
//            default -> System.out.println("没有这个星期");
//        }
        int a = 10;
        int b = 20;
        String operator = "*";
        int result = switch (operator) {
            case "+" -> {
                yield
                a + b;
            }
            case "-" -> {
                yield
                a - b;
            }
            case "*" -> {
                yield
                a * b;
            }
            case "/" -> {
                yield
                a / b;
            }
            default -> 0;
        };// !!!
        System.out.println(result);
    }
}
