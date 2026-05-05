1. 数组的静态初始化：
    ```java
    int[] arr = new int[]{1,2,3};
    // 简化格式<=>
    int [] arr = {1,2,3};
    ```
2. 数组是连续的空间；一旦定义长度不可变
3. 获取数组的长度，`arr.length`:这就是数组这个类的属性
4. 对于数组和集合，Java和CPP一样，也可以使用`for (int i: arr) {}`，需要注意的是：java中这种方式只能取值，不能修改数组/集合里的原元素（和CPP引用版本不一样）
5. 数据类型的默认值：
   * 整型：0
   * 浮点型：0.0
   * 布尔型：false
   * 字符型：'\u0000'（空格）
   * 引用： null
6. 数组的动态初始化：创建数组的时候指定长度，由系统为数组分配默认初始值，格式为：`int[] arr = new int[10];`（动态初始化没有简写格式）
7. Java的数组越界会报错,CPP不会报错，而是未定义行为，只有`.at()`才会检查是否越界
8. Java中专门用来操作数组的工具类`Arrays`，这是`java.util`包下的类，全是静态方法们之间`Arrays.xxx()`就能用，不用new对象。`Arrays`专门是给数组打工的工具类，排序、查找、转字符串、复制、求最值等
   * 排序：`Arrays.sort(arr)`
   * 二分查找：`Arrays.binarySearch(arr, 5)`，需要先排好序才能用
   * 转字符串：`Arrays.toString(arr)`
   * 复制：`Arrays.copyOf(arr, 5)`
   * 填充：`Arrays.fill(arr, 5)`
   * 获取最大值：`Arrays.stream(arr).max()`，此时返回的是一个Optional对象，不是基本类型，需要用`get()`方法，如：`Arrays.stream(arr).max().getAsInt()`,如果是double类型就是`getAsDouble()`
   * 获取最小值：`Arrays.stream(arr).min()`
   * 获取和：`Arrays.stream(arr).sum()`:返回的是数组对应的基本类型
   * 比较相等：`Arrays.equals(arr1, arr2)`
   * 判断数组是否能存在某个元素：`boolean has = Arrays.stream(arr).anyMatch(x -> x == target)`;`.anyMatch()`表示流里任意一个元素满足条件就返回true,`x->x==target`是java的Lambda表达式，x表示数组里的每一个元素，`x==target`就是判断当前元素是不是等于目标值
9. Java的Lambda表达式`(参数列表)->{方法体}`,CPP是`[捕获列表](参数列表)->返回值类型{函数体};`。java的Lambda表达式是一个函数式接口的实例对象，它本身没有独立类型，自动匹配并返回函数式接口类型。函数式接口比如：`Runnable`、`Comparator`、`Consumer`、`Function`、`Predicate`，Lambda 就是用来快速创建这类接口对象的简写，`.anyMatch()`就是`IntPredicate`接口的一个实例对象
10. java中接口就是一份行为规范/协议清单，只定义要做什么方法，不写方法具体实现 
    * 里面全是抽象方法，只有方法名，没有方法体
    * 类可以实现接口，然后重写接口里的所有方法
    * 接口不能new对象，只能被实现、被当作引用类型用 
11. 函数式接口：只有且仅有1个抽象方法的接口，抽象方法就是只有方法名没有方法体的方法，java自带的函数式接口：`Runnable`、`Comparator`、`Consumer`、`Function`、`Predicate`等