package Week7.Learn;

import java.util.Random;

// 生成验证码
public class Demo8 {
    static void main() {
        // 生成四个随机的字母 a-z A-Z
        Random random = new Random();
        char[] ch = new char[5];
        for(int i=0;i<4;++i) {
            int num = random.nextInt(52);
            if(num<26)
                ch[i] = (char)(num+'a');
            else
                ch[i] = (char)(num-26+'A');
        }
        int num = random.nextInt(10);
        int index = random.nextInt(5);
        ch[4] = (char)(num+'0');
        // 最大索引上的数据和随机缩进的数据进行交换
        char temp = ch[index];
        ch[index] = ch[4];
        ch[4] = temp;
        System.out.println(new String(ch));
    }
}
