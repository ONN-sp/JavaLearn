package Week3.Learn;

public class Demo1 {
    static void main() {
        int[] age = new int[]{20, 24, 30};
        double[] height = new double[]{1.7, 1.8, 1.9};
        String[] name = new String[]{"张三", "李四", "王五"};
        int[] arr = new int[4];// 动态初始化
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        for (int i = 0; i < name.length; i++)
            System.out.println("姓名：" + name[i] + "，年龄：" + age[i] + "，身高：" + height[i]);
    }
}
