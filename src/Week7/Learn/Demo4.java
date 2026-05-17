package Week7.Learn;

public class Demo4 {
    static void main() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("abc");
        sb.append("abc");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        String str = sb.toString();
        System.out.println(str);
    }
}
