1. Math是帮助我们进行数学计算的工具类，里面的方法都是静态的，直接`Math.方法名`调用
2. 获取一个整数的位数：
    * int=>String：`""+num`
    * 求字符串的长度：`str.length()`
3. `System`也是一个工具类，提供一些与系统相关的方法
   * `public static void exit(int status)`：退出程序，status为0表示正常退出，终止当前运行的java虚拟机；非0表示异常退出
   * `public static long currentTimeMillis()`：获取当前时间的毫秒数，从1970年1月1日8时0分0秒开始的毫秒数
   * `public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`：将一个数组的元素复制到另一个数组中
4. <mark>`Object`类中的方法可以被所有类访问，例如`toString()`：返回对象的字符串表示形式，默认会返回对象的内存地址，如果不想返回这个，就要在子类重写；`equals()`、`hashCode()`等 </mark>
5. 如果想要把一个对象变成字符串并打印，不用手动调用`toString()`方法，直接打印对象即可，这其实是`System.out.println()`方法内部代码本身就调用了`toString()`方法
6. <mark>包装类：用一个对象把基本数据类型封装起来，例如`Integer`、`Double`等。包装类可以直接赋值用，不需要 new 对象，JVM 自动把基本类型转为对应包装对象，底层依旧封装实例</mark>
   ```java
   Integer a = 10;
   Double b = 3.14;
   Character c = 'a';
   // 老式new写法
   Integer b = new Integer(10);
   ```
7. <mark>Integer包装类获取对象的方法：其它包装类也是这三种方法</mark>
   * new+构造方法：此类
   ```java
   Integer i = new Integer("10");// Integer 类专门提供了接收 String 类型的构造方法和静态方法
   Integer i2 = new Integer(10);
   ```
   * 静态方法(走缓存)：当Integer类被加载到内存中的时候，会提前创建-128~127之间所有数据的对象，共计256个，放入到一个数组（Integer常量池）当中。当我们利用`valueof()`方法获取对象的时候，判断是否在这个范围中，如果是，直接返回数组中的对象，如果不是，就会利用构造方法创建一个新的对象。
   ```java
   Integer i = Integer.valueOf("10");// Integer 类专门提供了接收 String 类型的构造方法和静态方法
   Integer i2 = Integer.valueOf(10);
   ```
   * 直接赋值：就是静态方法的简化写法，称作自动装箱
   ```java
   Integer i = 10;
   Integer i2 = 10;
   ```
8. `Integer=>int`：`public int intValue()`：把包装类转换为基本类型
9. 十进制转二进制：`Integer.toBinaryString(int i)`
10. 十进制转十六进制：`Integer.toHexString(int i)`
11. 十进制转八进制：`Integer.toOctalString(int i)`
12. 自动装箱：JVM会自动把基本类型装到一个对象当中，底层调用`valueOf()`方法
13. 自动拆箱：JVM会自动的把对象中的基本数据类型拿出来，底层调用`intValue()`方法，把包装类转换为基本类型
   ```java
   Integer i = 10;
   Integer i2 = 20;
   Integer i3 = i + i2;// 此时会给i3的value属性赋值为300
   // <=>
   // i.intValue()+i2.intValue() = 300;
   // Integer i3 = Integer.valueOf(300);
   System.out.println(i3);// 300   底层调用Integer重写的toString()方法，此时返回value属性的字符串表示形式
   ```
14. 有了自动装箱和自动拆箱，`Integer`<=>`int`、`Double`<=>`double`、`Character`<=>`char`等
15. `BigInteger`：大整数类，用于处理超过int范围的整数
16. `BigDecimal`：大浮点数类，用于处理超过double范围的浮点数。`BigDecimal`底层是用数组来存储浮点数的每个数字的，所以它可以精确地表示浮点数，获取其对象的方式：
   * new+构造方法：字符串传入的话怎样都不会损失精度
   ```java
   char[] arr = {'1', '0', '.', '0'};
   BigDecimal b = new BigDecimal(arr);
    // 或者直接用字符串构造方法
    BigDecimal b2 = new BigDecimal("10.0");
    BigDecimal b3 = new BigDecimal(0.226);// 会损失精度，因为传入的double本身就是损失精度的类型
   ```
   * 静态方法：double范围内不会损失精度
   ```java
   BigDecimal b = BigDecimal.valueOf(0.226);// 会损失精度，因为传入的double本身就是损失精度的类型
   ```
