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
