1. Java中和CPP类似：
    * 如果没有自定义构造函数，那么会默认生成一个无参构造函数；一旦类中定义了至少一个构造函数,编译器将不再提供默认构造函数
      * 对于子类继承，它一定是会先调用父类的构造函数的
      * 如果父类有自定义的无参构造函数或者没有自定义构造函数，那么子类可以不用显示调用父类构造函数(super())，因为此时会自动调用父类构造函数
        * 如果父类有自定义的有参构造并且要使用它或者只有有参构造，那么子类必须显示调用父类构造函数
        ```java
          // 无参构造函数
          class Father {
              // 显式写了无参构造
              public Father() {
              }
          }
          class Son extends Father {
              public Son() {
              // 不写 super() 也完全没问题
             // 编译器自动帮你加 super()
              }
          }
          // 有参构造函数
          class Father {
              // 显式写了无参构造
              public Father(int a) {
              }
          }
          class Son extends Father {
              public Son() {
              super(10);// 必须写
             // 编译器自动帮你加 super()
              }
          }
        // CPP
        // class Father {
        // public:
            // Father(int a) {
            // std::cout << "Father()" << std::endl;
            // }  // 显式无参构造
            // };
        // class Son : public Father {
        // public:
            // Son(): Father(10) {
                // std::cout << "Son()" << std::endl;
            // }
            // };   
        ```
2. Java的if语句后面要用括号括起来
3. Java也有return，用法和CPP一样
4. if语句的大括号如果语句体只有一行，大括号可以省略，和CPP一样
5. Java中类的static方法是不能调用非static方法的，static方法属于类本身，不需要实例化对象就能运行；非static方法属于对象，必须有对象才能调用。这和CPP一样的
6. Java有三种if格式，和CPP一样
    * if
    * if-else
    * if-else if-else
7. switch语句表达式的数据类型必须为byte, short, char, int, String, enum
8. switch中的case和default位置可以anywhere。switch的判断是从上往下顺序判断，一旦匹配到就执行，并跳出switch
9. switch的default是可以省略的
10. switch的case穿透：case穿透就是switch中匹配好了的case后面的代码还是会继续执行，直到遇到break或者switch结束。具体产生原因：在执行语句体的时候没有看到break
11. switch的新特性（JDK14正式发布）：
    * 箭头特性(CPP没有)：不需要break，天生禁止case穿透
    ```java
    public class Demo3 {
    static void main() {
        int num = 3;
        switch (num) {
            case 1 -> System.out.println("星期一");
            case 2 -> System.out.println("星期二");
            case 3 -> System.out.println("星期三");
        }
    }
    }
    ```
    * case后面可以写多个值
    * switch可以有运行结果
    * yield关键字(CPP没有)：这是和switch可以有运行结果一起用的
    ```java
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
    // 如果该case语句体只有一行，即大括号和yield都可以省略
        int a = 10;
    int b = 20;
    String operator = "*";
    int result = switch (operator) {
        case "+" -> a + b;
        case "-" -> a - b;
        case "*" -> a * b;
        case "/" -> a / b;
        default -> 0;
    };
    System.out.println(result);
    ```
12. java的for循环和CPP一样
13. java里面没有<=>运算符，CPP20新增了的
14. java里面没有对基本类型进行引用的类型，即不能对基本类型进行引用传递。CPP里是可以的，如int &a；但是java是没有基本类型的引用语法，int永远是值传递，不能像CPP那样通过添加&来实现引用传递
    ```java
    void getSum(int sum, int n) {
        for(int i=1; i<=n; i++)
            if(i%2==0)
                sum -= i;
            else
                sum += i;
    }
    // CPP里可以通过引用传递来实现函数类修改参数并产生影响
    void getSum(int &sum, int n) {...}
    // java里若必须这样，只能通过数组
    void getSum(int[] sum, int n) {...}
    ```
15. java的while(...)，do...while(...)和CPP一样
16. 一个正整数取个位`res=num%10`，去除个位`num/=10`
17. break不能单独出现，只能写在switch或循环中，表示结束、跳出的意思
18. Java中的java.lang是默认基础核心包，编译器自动隐式导入，不用手写import。编译器在编译每个.java文件时，默认自动加上导入这个库。而里面所有的类，如：Math、String、Integer、Object等可以直接用
19. Random库中`.nextInt()`默认是在int的取值范围之内获取随机数。`.nextInt(n)`会产生一个随机数范围为0~n-1；`.nextInt(n, m)`产生一个随机数范围为n~m-1，此种写法是在JDK17后出现的