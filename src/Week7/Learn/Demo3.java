package Week7.Learn;

public class Demo3 {
    static void main() {
        String str = " 你玩的好菜呀，TMD ";
        String newStr = str.replace("TMD", "***");
        System.out.println(newStr);
        System.out.println(str.toCharArray()[0]);
        System.out.println(str.toLowerCase());
        System.out.println(str.trim());
    }
}
