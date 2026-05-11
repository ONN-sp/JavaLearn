1. 对象：把相关的数据和方法组织为一个整体来看待
2. 面向对象：利用对象进行软件开发
3. 标准Java项目结构（其它语言是类似的）
    * 单独一个主类，只负责放 main 方法（其实就是调用它的地方（上游服务），可能是上游服务、测试代码等）
    * 其他所有类只写功能、不写 main
    * 其他类只写：属性、方法、功能逻辑
4. 同一个目录下的java中的类是可以不用import，而是直接使用的
5. 描述一类事务的类叫JavaBean类，Javabean类可以写属性和方法。Javabean类的属性不能是static
6. 带有main方法的类叫测试类
7. <mark>类中对于私有成员变量，一般都需要写对应的`public`的`set/get`方法</mark>
8. 使用变量，会使用就近原则，先在方法中看是否有局部变量，如果没有才会去看成员变量，重名时就会用this引用
9. 如果要在方法内部明确使用成员变量，可以加`this`前缀，比如
   ```java
    public void setName(String name) {
        this.name = name;
    }
   // 如果局部变量和成员变量不重名，在方法中就可以不用this
   public Student(String name, int age, double height, double weight) {
        name_ = name;
        age_ = age;
        height_ = height;
        weight_ = weight;
    }
   // 重名就加this
   public Student(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
   ```
10. java中this和CPP的this本质都是指向当前实例对象的自身引用/指针。都代表当前正在调用这个方法的对象，都用来区分成员变量和局部变量重名。静态方法不能用this，因为静态方法不属于某个实例对象，而是属于这个类（没有对象就没有this）
11. 如果没有自定义构造方法，那么系统会给出一个默认的无参构造方法
12. 如果自己写了任意构造方法，系统将不再提供默认构造方法。如果自定义了有参构造，那么初始化时就不能无参构造了，因此此时没有无参构造方法了
13. 以后无论是否使用，都手动书写无参构造方法，和带全部参数的构造方法
14. 注意：<mark>`java`不支持方法/构造器默认参数值,CPP支持默认参数</mark>
   ```java
   // Java 非法！
   public void show(int a, int b = 10) {
   }
   ```
15. 