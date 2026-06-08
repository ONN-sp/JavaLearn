1. <mark>在 Java 开发中，我们可以使用 JUnit（最主流的测试框架）自己编写代码，来验证我们写的业务代码有没有 bug</mark>
2. Junit单元测试框架可以用来对方法进行测试，IDEA集成了的。Junit可以灵活的编写测试代码，可以针对某个方法进行测试，也支持一键完成对全部方法的自动测试，且各自独立。不需要程序员去分析测试的结果，会自动生成测试报告出来
3. <mark>JUnit 必须遵守的规范：</mark>
   * 测试代码位置：必须放在 src/test/java
   * 测试类命名：业务类名 + Test（如 CalculatorTest）
   * 测试方法：public void，无参数，无返回值
   * 不写业务逻辑：测试方法只做三件事 → 造数据、调方法、做断言
   * 独立性：每个测试方法互不干预
4. <mark>JUnit一般会和IDEA+MAVEN配合使用，来完成测试任务，此时在MAVEN框架下，`alt+(fn)+insert`新建的测试函数会直接到maven框架中的test目录下面去</mark>
5. 如果不是MAVEN项目，那么就可以新建java项目，然后安装JUint插件来实现
6. JUNIT5中常见注解：
   * `@Test`：标记方法为测试方法，运行时会被执行
   * `@BeforeEach`：每个 @Test 方法执行前都跑一次（初始化），JUnit4 对应：@Before
   * `@AfterEach`：每个 @Test 方法执行后都跑一次（清理），JUnit4 对应：@After
   * `@BeforeAll`：所有测试方法执行后，只跑一次（全局销毁），必须 static，JUnit4 对应：@AfterClass
   * `@AfterAll`：所有测试方法执行后，只跑一次（全局销毁），必须 static，JUnit4 对应：@AfterClass
   * `@DisplayName`：给测试类 / 方法起个中文名字，运行结果里显示
   * `@Disabled`：禁用测试方法，不执行
