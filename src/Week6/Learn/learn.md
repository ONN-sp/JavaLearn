1. 继承是类与类之间的一种父子关系，java中提供extends用于建立类与类之间的关系
2. Java 没有私有继承、保护继承，只有 extends 一种公有继承，CPP三种都有
3. java只支持单继承，不支持多继承（CPP支持），但支持多层继承
4. java的顶级父类-Object
5. java继承的特点
    * java只支持单继承，不支持多继承（CPP支持），但支持多层继承
    * 直接继承的父类叫做直接父类，间接继承的爷爷叫做间接父类
    * java的每一个类都直接或者间接的继承于Object
6. <mark>继承中成员变量的查找顺序：就近原则，先在局部位置找，本类成员位置找，父类成员位置找，逐级往上</mark>
7. <mark>继承中成员变量的访问顺序：就近原则，先在局部位置找，本类成员位置找，父类成员位置找，逐级往上，直到 Object 类还找不到，编译报错，能找到但能不能使用，看权限修饰符（如果父类是private，那么子类也是不能用的）</mark>(比如：number 在 Delivery 中是 private 访问控制)
8. <mark>继承中成员方法的查找顺序：就近原则，先在当前子类本类找有没有该方法，子类没有 → 一级一级往上父类找；找到就执行，子类重写了就优先执行子类重写的；一直找到 Object 还没有 → 编译报错</mark>
9. <mark>继承中成员方法的访问顺序：就近原则，先在当前子类本类找有没有该方法，子类没有 → 一级一级往上父类找；找到就执行，子类重写了就优先执行子类重写的；一直找到 Object 还没有 → 编译报错，能找到但能不能使用，看权限修饰符（如果父类是private，那么子类也是不能用的）</mark>(比如编译报错：错误: calculateCost() 在 Delivery 中是 private 访问控制)
10. 继承中，this调用会先访问本类，再访问父类；super关键字直接访问父类
11. `super`关键字：表示使用父类的属性/方法。如`super.name`
12. 继承中`super`不能嵌套，比如`super.super.name`是错的
13. 继承中成员变量的书写规则：抽取共性
14. 方法重写：在子类中，把父类的方法再写一遍，方法声明保持一致
15. 重写方法的名称、形参列表必须与父类中的一致，方法体按照实际需要书写
16. @Override这是一个注解，是给JVM看的，表示下面的方法是重写的父类的方法。CPP方法重写是父类(用virtual)、子类(用override)
17. 如果父类里面的代码，一行都不用，此时把子类中的方法体重新完整写一遍即可；如果父类里面的代码还想用，此时只是在父类继承上再加其它逻辑。那么就可以先通过super关键字调用父类的方法得到一个结果，再堆这个结果进行操作
18. final修饰类为最终类，里面所有方法不能被重写，这个类也不能被继承
19. <mark>private方法、static方法、final方法都不能被重写</mark>
    * private方法/属性是不能被子类看见的，这和CPP一样，就算是公有继承，就算是`super.`也是不行的，也是看不见的，因此不能重写
    * static方法属于类，不属于对象，方法调用版本在编译期就确定，类加载链接阶段完成地址解析绑定，不依赖运行时对象类型，因此没有多态，不能被重写；而重写依赖动态绑定、依赖多态，运行时看真实对象（这一点和CPP中static方法不能为虚函数类似）
    * final方法本身就规定不能再修改
20. 重写和重载是不一样的概念
21. 多态允许相同的操作在不同的对象上表现出不同的行为,分为:静态多态(编译时多态)和动态多态(运行时多态)
22. <mark>java中静态多态用方法重载来实现；运行时多态用继承+重写来实现:</mark>
    ```java
    // 编译时多态
    public class StaticPoly {
    // 重载1：一个int参数
    public void calc(int a) {
    System.out.println("整数计算：" + a);
    }
    // 重载2：两个int参数
    public void calc(int a, int b) {
    System.out.println("两整数和：" + (a + b));
    }
    // 重载3：double参数
    public void calc(double a) {
    System.out.println("小数计算：" + a);
    }
    public static void main(String[] args) {
        StaticPoly sp = new StaticPoly();
        sp.calc(10);        // 编译匹配 第1个
        sp.calc(10, 20);    // 编译匹配 第2个
        sp.calc(3.14);      // 编译匹配 第3个
    }
    }
    ```
    ```java
    // 运行时多态
    // 1. 父类
    class Animal {
    public void cry() {
        System.out.println("动物叫");
    }
    }
    // 2. 子类继承 + 重写方法
    class Dog extends Animal {
    @Override
    public void cry() {
        System.out.println("汪汪汪");
    }
    }
    class Cat extends Animal {
    @Override
    public void cry() {
        System.out.println("喵喵喵");
    }
    }
    public class Test {
        public static void main(String[] args) {
        // 3. 向上转型：父类引用 指向 子类对象
        Animal a = new Dog();
        Animal b = new Cat();
        // 4. 调用重写方法 → 触发运行时多态
        a.cry();  // 输出：汪汪汪
        b.cry();  // 输出：喵喵喵
        }
    }
    ```
23. <mark>开发里99% 场景重写都配合多态一起用（类似CPP的虚函数/重写配合多态一样）</mark>
24. <mark>java中和CPP一样也自动向上类型转换:将派生类引用转换为基类的引用,这是自动进行的(<=>指向基类的引用可以引用派生类对象);java的向下类型转换(有风险)，必须手动强制转换：</mark>
    ```java
    // 子类类型 变量名 = (子类类型) 父类引用;
    class Fu {}
    class Zi extends Fu {}
    // 向上转型（自动）
    Fu f = new Zi();
    // 向下转型（手动强转）
    Zi z = (Zi) f;
    ```
25. Java 普通方法默认可重写、默认动态绑定，不需 virtual；CPP 默认静态绑定，必须父类加 virtual 才能重写 + 运行时多态
26. 父类构造方法不会被继承
27. this和super用法汇总
    ![img.png](this和super.png)
28. 如果在构造方法中写上了this(),就不能再写super()了，JVM也不会自动添加super()