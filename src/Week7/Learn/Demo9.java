package Week7.Learn;

public class Demo9 {
    public static void main(String[] args) {
        String str1 = "12345";
        String str2 = "678";
        // 需要注意：上面代码没有考虑数据过大，超出int取值范围的情况
        // 考虑数据过大的情况用数组
        String res = multiply(str1, str2);
        System.out.println(res);
    }
    // 模拟数字字符串乘法并考虑数据过大
    public static String multiply(String str1, String str2) {
        // 处理特殊情况
        if (str1.equals("0") || str2.equals("0")) {
            return "0";
        }
        int len1 = str1.length();
        int len2 = str2.length();
        // 结果最多有 len1 + len2 位
        int[] result = new int[len1 + len2];
        // 从右到左逐位相乘
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int num1 = str1.charAt(i) - '0';
                int num2 = str2.charAt(j) - '0';
                // 乘积加上当前位置已有的值
                int product = num1 * num2 + result[i + j + 1];
                // 更新当前位置的值（个位）
                result[i + j + 1] = product % 10;
                // 进位加到前一位
                result[i + j] += product / 10;
            }
        }
        // 构建结果字符串，跳过前导零
        StringBuilder sb = new StringBuilder();
        int start = 0;
        // 跳过前导零
        while (start < result.length && result[start] == 0) {
            start++;
        }
        // 将剩余数字添加到结果中
        for (int i = start; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
