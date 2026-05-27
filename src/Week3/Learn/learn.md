1. 数组的静态初始化：
    ```java
    int[] arr = new int[]{1,2,3};
    // 简化格式<=>
    int [] arr = {1,2,3};
    ```
2. <mark>数组的初始化其实就算数组实例化的过程：`int[] arr = new int[10];`=声明引用类型变量+实例化数组对象</mark>
3. 数组是连续的空间；一旦定义长度不可变
4. 数组也是一个类，直接继承自`Object`
5. 获取数组的长度，`arr.length`:这就是数组这个类的属性
6. 数组元素的访问：·`arr[i]`直接用下标索引
7. 对于数组和集合，Java和CPP一样，也可以使用`for (int i: arr) {}`，需要注意的是：java中这种方式只能取值，不能修改数组/集合里的原元素（和CPP引用版本不一样）
8. 数据类型的默认值：
   * 整型：0
   * 浮点型：0.0
   * 布尔型：false
   * 字符型：'\u0000'（空格）
   * 引用： null
9. 数组的动态初始化：创建数组的时候指定长度，由系统为数组分配默认初始值，格式为：`int[] arr = new int[10];`（动态初始化没有简写格式）
10. Java的数组越界会报错,CPP不会报错，而是未定义行为，只有`.at()`才会检查是否越界
11. Java中专门用来操作数组的工具类`Arrays`，这是`java.util`包下的类，全是静态方法，`Arrays.xxx()`就能用，不用new对象。`Arrays`专门是给数组打工的工具类，排序、查找、转字符串、复制、求最值等
    * 排序：`Arrays.sort(arr)`，底层用的是插入排序+二分排序，可以自定义排序规则，需要实现`Comparator`接口，重写`compare()`方法，如：
    ```java
    // compare方法的形参：
    // o1：表示在无序序列中，
    // o2：表示在无序序列中的第二个元素
    // 返回值：如果o1大于o2，返回正数；如果o1小于o2，返回负数；如果o1等于o2，返回0；
    // o1-o2为升序排
    // o2-o1为降序排列
    Arrays.sort(arr, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }));
    // 用lambda表达式 => o2 - o1
    Arrays.sort(arr, (o1, o2) -> o2 - o1);
    ```
    * 二分查找：`Arrays.binarySearch(arr, 5)`，(默认是需要升序)。需要先排好序才能用。找不到返回一个负数"-（插入点）-1"，插入点指的是比目标大的第一个元素的位置（按降序规则二分查找：`int idx = Arrays.binarySearch(arr, 5, Collections.reverseOrder());`）
    * 转字符串：`Arrays.toString(arr)`
    * 复制：`Arrays.copyOf(arr, 5)`，如果新数组长度大于原数组长度，会用默认值填充
    * 指定范围复制：`Arrays.copyOfRange(arr, 2, 5)`，复制[2,5)的元素
    * 填充：`Arrays.fill(arr, 5)`
    * 获取最大值：`Arrays.stream(arr).max()`，此时返回的是一个Optional对象，不是基本类型，需要用`get()`方法，如：`Arrays.stream(arr).max().getAsInt()`,如果是double类型就是`getAsDouble()`
    * 获取最小值：`Arrays.stream(arr).min()`
    * 获取和：`Arrays.stream(arr).sum()`:返回的是数组对应的基本类型
    * 比较相等：`Arrays.equals(arr1, arr2)`
    * 转换为字符串：`Arrays.toString(arr)`
    * 截取数组：`Arrays.steram(arr).limit(5)`:只取前5个;`Arrays.stream(arr).skipo(2).limit(3)`:跳过前2个，只取后3个
    * 判断数组是否能存在某个元素：`boolean has = Arrays.stream(arr).anyMatch(x -> x == target)`;`.anyMatch()`表示流里任意一个元素满足条件就返回true,`x->x==target`是java的Lambda表达式，x表示数组里的每一个元素，`x==target`就是判断当前元素是不是等于目标值
12. <mark>Java的Lambda表达式`(参数列表)->{方法体}`,CPP是`[捕获列表](参数列表)->返回值类型{函数体};`。java的Lambda表达式是一个函数式接口的实例对象，它本身没有独立类型，自动匹配并返回函数式接口类型，即Lambda 本身没有自己类型，看它左边是什么接口变量，它就是什么类型。函数式接口比如：`Runnable`、`Comparator`、`Consumer`、`Function`、`Predicate`，Lambda 就是用来快速创建这类接口对象的简写，`.anyMatch()`就是`IntPredicate`接口的一个实例对象</mark>
13. <mark>当对应接口是函数式接口，此时单独写这个接口的实现比较麻烦，那么就可以用Lambda表达式来创建，比如：`new Thread((...)->{...})`、`集合遍历list.forEach(s->System.out.println(s));`等</mark>
14. <mark>怎么使用Lambda表达式：确定函数式接口样子，对照函数式接口中的抽象方法写，也就是照搬抽象方法的参数个数、类型，再写实现的方法体，即写成`(参数列表)->{方法体}`，括号可以省略</mark>
15. <mark>只有函数式接口的实现类才能用Lambda表达式</mark>
16. <mark>java的lambda表达式参数列表可以省略括号(对于方法体如果可以省括号，那么方法体内的分号也要省略)、类型</mark>
   ```java
   // 标准
   (String s) -> {System.out.println(s);};
   // 如果只有一个参数，参数类型可以省
   (s) -> {System.out.println(s);};
   // 如果只有一个参数，参数类型可以省，参数列表括号也可以省略
   s -> {System.out.println(s);}
   // 如果只有一个参数，且方法体只有一行，那么大括号、分号，return都可以省略，这三个需要同时一起省略
   s -> System.out.println(s);
   ```
17. `boolean has = Arrays.stream(arr).anyMatch(x -> x == target)`中lambda表达式详解
    * `x -> x == target`是函数式接口`IntPredicate`的实例对象，完全展开是：`IntPredicate r = x -> x == target;`
    * `anyMatch`会把数组arr中的每一个元素都去判断是否满足条件
18. java中接口就是一份行为规范/协议清单，只定义要做什么方法，不写方法具体实现 
    * 里面全是抽象方法，只有方法名，没有方法体
    * 类可以实现接口，然后重写接口里的所有方法
    * 接口不能new对象，只能被实现、被当作引用类型用 
19. 函数式接口：只有且仅有1个抽象方法的接口，抽象方法就是只有方法名没有方法体的方法，函数式接口上方可以加`@FunctionalInterface`注解，表示这是一个函数式接口。java自带的函数式接口：`Runnable`、`Comparator`、`Consumer`、`Function`、`Predicate`等
20. 方法：程序中的独立功能，也是最小的执行单元
21. 需要被重复调用、main方法里代码太长、功能独立能单独拎出来、需要给别人调用多出共用、为了简化逻辑分层清晰后时可写为方法
22. 方法调用处如果需要将这个结果后续继续做其它事情，就要在方法里return
23. 方法重载：同一个类里，方法名相同，参数列表（类型、个数、顺序）不同，返回值类型可以相同也可以不同。同一个类里，方法名相同，参数列表不同的方法就是方法重载（注意：不看返回值类型）
24. 重载方法调用需要注意：
   ```java
   public class Demo10 {
       static void main() {
           int a = 10;
           int b = 20;
           System.out.println(getSum(a,b));
       }
   //    public static double getSum(int a, int b) {
   //        return a+b;
   //    }
       public  static double getSum(int a, double b) {
           return a+b;
       }
       public static double getSum(double a, int b) {
           return a+b;
       }
       public static double getSum(double a, double b) {
           return a+b;
    }
    // 此时方法调用会报错，因为此时没有实参-形参一一对应的那个方法。int到double的转换虽然可以隐式自动进行，
    // 但是此时getSum(int, double)和getSum(double, int)都是需要实参一次隐式向上转换的，所以无法确定使用哪个，从而报错
   ```
25. 调用方法会优先调用形参和实参一一对应的，如果没有才会进行隐式转换