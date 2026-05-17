1. API就是Java提供好的一些类
2. java中不用导入包

   * 使用本包下面的类
   * 使用java.lang包下面的类
3. 字符串拼接不会改变原来的的字符串，而是产生一个新的字符串
4. 字符串的内容是不可变的，它的对象在创建后不能被更改
5. 创建String对象的方式：

   * 直接赋值
   * new+构造方法：
     * new+空参构造`String s = new String();`
     * new+有参构造`String s = new String("hello");`
     * new+字节数组构造`String s = new String(byte[] bytes);`
     * new+字符数组构造`String s = new String(char[] chars);`
6. <mark>java不支持`[]`通过下标索引取字符的方法，只能`charAt()`，而CPP可以</mark>
7. <mark>字符串常见方法:</mark>

   * 对于字符串这种引用数据类型，`==`比较运算符比较的是内存地址
   * `s1.equals(b)`可以用来比较字符串引用数据类型的内容；`s1.equalsIngoreCase(s2)`可以忽略大小写来比较内容
   * 根据索引返回字符串中的字符`s.charAt(index)`；返回字符串长度`s.length()`
   * 从控制台输入字符串：`sc.next()`:
   * for增强不能直接遍历 String，因为Java 里 String 不是数组，也不是集合，不能直接放增强 for 里遍历，需要通过`for (char c: str.toCharArray()) {}`
   * 判断字符是否大写`Character.isUpperCase(ch)`;`Character.isLowerCase(ch)`
   * 判断字符是否数字`Character.isDigit(ch)`
   * 字符串截取：`s.substring(startIndex)`从开始索引截取到该字符串最后;`s.substring(startIndex, endIndex)`（包头不包尾）
   * 字符串替换：`s.replace(oldChar, newChar)`，`str.replace("TMD", "***");`，找不到就不替换
   * 字符串查找子串：`s.indexOf(subString)`：找到返回下标，找不到返回-1；`s.lastIndexOf(subString)`：查找子串在字符串s中最后出现位置，也就是从后往前查找
   * 判断字符串是否以子串开头/结尾：`s.startsWith(subString)`/`s.endsWith(subString)`
   * 判断是否包含子串：`s.contains(subString)`
   * 判断是否为空：`s.isEmpty()`
   * 数组转为字符串`Arrays.toString(arr)`此时的arr任何类型数组都可以，但是需要注意此时转换的字符串包含了`[]`；`String newStr = new String(arr);`此时的arr只能是字符数组、字节数组，
   * 数字转字符串：`int a=10; String.valueOf(a);`;`""+num`:空字符串+数字
   * 字符转字符串：`char ch = 'a'; String.valueOf(ch);`;`""+ch`:空字符串+字符
   * 字符串转字符数组：`s.toCharArray()`
   * 字符串中字符的大小写转换：`s.toUpperCase()`/`s.toLowerCase()`
   * 去除字符串头尾空格：`s.trim()`
   * 重复字符串：`s.repeat(count)`
8. 需要注意：字符串不可更改，因此用了字符串方法修改字符串后需要用其返回字符串进行操作，原字符串没变
9. <mark>字符拼接不是字符串，纯字符相加 = ASCII 数值相加，不是字符串，CPP也是一样的</mark>
10. java中`'a'*3`≠`"aaa"`，CPP中才是这样的，java中只能`"a".repeat(3)`才行
11. StringBuilder是字符串的一个工具类，可以让我们拼接字符串的时候效率更高。传统的`+`会产生很多冗余的中间数据，StringBuilder可以看作容器，此时就是把待拼接的字符串放入容器，没有中间冗余字符串

    * `StringBuilder sb = new StringBuilder()`/`tringBuilder sb = new StringBuilder(str)`
    * `StringBulider append(任意类型)`：添加任意类型数据，返回自身
    * `StringBulider toString()`：将StringBuilder转换成String
    * `StringBulider insert(int index, 任意类型)`：在指定位置插入任意类型数据，返回自身
    * `StringBuilder reverse()`：翻转字符串
    * `int length()`：获取字符串长度
    * `sb.toString()`：将StringBuilder转换成String
12. java中数字字符串转数字：

    * `int num = Integer.parseInt(s);`
    * `Integer i = Integer.valueOf(s);`
    * `double d = Double.parseDouble(s);`
    * `Long l = Long.parseLong(s);`
13. CPP中数字字符串转数字：`stoi`、`stod`
14. java的整数数组转换为字符串：

    * `String s = Arrays.toString(arr)`：带括号格式 [1,2,3]
    * 纯数字拼接可以用`StringBuilder`

    ```java
    int[] arr = {1,2,3};
    StringBuilder sb = new StringBuilder();
    for(int num : arr)
        sb.append(num);
    String res = sb.toString();
    ```
    CPP可以借用`to_string()`

    ```cpp
    int main()
    {
        int arr[] = {1,2,3,4};
        int len = sizeof(arr)/sizeof(arr[0]);
        string res;
        for(int i=0;i<len;i++)
            res += to_string(arr[i]);
        cout << res; // 1234
        return 0;
    }
    ```
