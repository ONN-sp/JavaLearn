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
