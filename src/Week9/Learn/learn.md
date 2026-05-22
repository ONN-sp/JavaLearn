1. lambda表达式是JDK8之后出现的
2. lambda表达式可以简化函数式接口的匿名内部类的写法
3. Lambda可被替换为方法引用，需要满足：
   * Lambda表达式里只有一行代码
   * 这行代码就是调用一个已有的方法
     ```txt
     (参数) -> 对象.方法(参数)   
        ↓ 替换成
     对象::方法
     ```
   * 比如常见的：
     ```java
     // 实例方法引用
     s -> System.out.println(s)
     // 方法引用
     System.out::println
     // 进一步举例
     Collection<String> coll = new ArrayList<>();
     coll.add("a");
     coll.add("b");
     coll.forEach(e -> System.out.println(e));
     // =>
     coll.forEach(System.out::println);
    
     // 静态方法引用
     i -> Integer.parseInt(i)
     // 方法引用
     Integer::parseInt
    
     // 构造方法引用
     () -> new String()
     // 方法引用
     String::new
    
     // 任意对象的实例方法
     s -> s.toString()
     // 方法引用
     Object::toString
     ```
4. 必须是接口的匿名内部类，接口中只能有一个抽象方法，才能用lambda表达式简化
5. <mark>java的常用集合都是泛型类/接口</mark>
6. <mark>java中的集合：</mark>
    * 单列集合：`ArrayList`、`LinkedList`、`Vector`、`HashSet`、`LinkedHashSet`、`TreeSet`、`ArrayDeque`、`PriorityQueue`等
    ![img.png](单列集合.png)
      * `List`（一个接口）系列集合：添加的元素是有序（存和取的顺序是一样的）、可重复、有索引（可以通过索引操作元素）
        * List新增了很多索引操作的方法，如：
          * `public E get(int index)`：根据索引获取元素
          * `public E set(int index, E element)`：根据索引设置元素
          * `public void add(int index, E element)`：根据索引添加元素，原来位置的元素向后移动，新元素插入到指定位置
          * `public E remove(int index)`：根据索引删除元素，返回被删除的元素
        * List集合的遍历方式：它继承于`Collection`，所以也可以用`Collection`的遍历方式遍历，即遍历方式有：
          * 迭代器遍历
          * 列表迭代器遍历：`ListIterator`，这也是一个接口，它是`Iterator`的子接口，新增了很多方法，如`add()`、`set()`等
          ```java
          ArrayList<String> list = new ArrayList<>();
          ListIterator<String> it = list.listIterator();// E是集合list中元素的类型
          while (it.hasNext()) {// 判断是否有下一个元素
              String e = it.next();// 返回当前迭代器位置的元素，并将迭代器移动到下一个元素的位置
              System.out.println(e);
              it.add("aaa");
          }
          ```
          * 增强for遍历
          * lambda表达式遍历
          * 普通for循环
          ```java
          for(int i=0;i<list.size();i++){
              System.out.println(list.get(i));
          }
          ```
      * `Set`（一个接口）系列集合：添加的元素是无序（存和取的顺序是不一致的）、不可重复、无索引
      * `Collection`是单列集合的祖宗接口，它的功能是全部单列集合都可以继承使用的：
        * `public boolean add(E e)`：添加一个元素
        * `public void clear()`：清空集合
        * `public boolean remove(Object o)`：删除一个元素
        * `public boolean contains(Object o)`：判断是否包含某个元素
        * `public int size()`：返回集合的大小
        * `public boolean isEmpty()`：判断集合是否为空
        * `public void clear()`：清空集合
      * `Collection`的遍历方式：
        * 迭代器遍历（C++ 的迭代器 = Java 的 Iterator）：迭代器（和cpp一样，可以理解为指针）在java中的类是`Iterator`，迭代器是集合专用的遍历方式，这种方式不依赖索引
          ```java
          ArrayList<E> list = new ArrayList<>();
          Iterator<E> it = list.iterator();// E是集合list中元素的类型
          while (it.hasNext()) {// 判断是否有下一个元素
              E e = it.next();// 返回当前迭代器位置的元素，并将迭代器移动到下一个元素的位置
              System.out.println(e);
          }
          ```
          ```cpp
          vector<int> list;
          vector<int>::iterator it;// 迭代器遍历
          for (it = list.begin(); it != list.end(); it++) {
              cout << *it << endl;
          }
          ```
          * 迭代器遍历完毕，指针不会复位
          * 循环中只能用一次next方法
          * 迭代器遍历时，不能用集合的方法进行增加或删除，要用迭代器的方法进行增加或删除
          * 如果当前位置没有元素，还要强行获取，会报`NoSuchElementException`异常
          * 普通`Iterator`遍历没有新增操作的方法，有`remove()`
        * 增强for循环遍历：底层就是迭代器，为了简化迭代器的代码书写，它是jdk5之后出现的
          ```java
          ArrayList<E> list = new ArrayList<>();
          for (E e : list) {
              System.out.println(e);
          }
          ```
        * lambda表达式遍历：底层就是迭代器，为了简化迭代器的代码书写，它是jdk8之后出现的。方法的底层其实也会自己遍历集合，依次得到每一个元素，把得到的每一个元素，传递给下面的lambda表达式
          ```java
          ArrayList<E> list = new ArrayList<>();
          list.forEach(new Consumer<E>() {
              @Override
              public void accept(E e) {
                  System.out.println(e);
              }
          });// Consumer是一个函数式接口
          // 用lambda表达式简化 <=>
          list.forEach((e) -> System.out.println(e));
          ``` 
7. <mark>遍历中需要删除元素，用迭代器；在遍历过程中需要添加元素，使用列表迭代器；单纯取值遍历优先增强for、lambda表达式；如果遍历的时候想操作索引，可以用普通for</mark>
8. <mark>java中集合的打印：集合类都重写了`toString()`方法，会打印内部元素，因此可以直接输出集合名，而不是用`Object`类的`toString()`方法而打印内存地址码，如`ArrayList、LinkedList、HashSet、HashMap`等</mark>