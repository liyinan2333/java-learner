### Java8新特性之一：Lambda表达式
Java8是自java5之后最重大的一次更新，它给JAVA语言带来了很多新的特性（包括编译器、类库、工具类、JVM等），其中最重要的升级是它给我们带来了Lambda表达式和Stream API。
#### 1、什么是Lambda表达式？
Lambda是一个匿名函数，可以理解为是一段可以传递的代码，可以将代码像传递参数、传递数据一样进行传输。使用Lambda表达式，可以写出更加紧凑、更加简洁、更加灵活的代码。
#### 2、使用Lambda的限制条件
Lambda并不是任何地方都可以使用，Lambda表达式需要&ldquo;函数式接口&rdquo;的支持。
#### 3、什么是函数式接口？
接口中只有一个抽象方法的接口，称为函数式接口，可以用@FunctionalInterface修饰一下，这里需要注意的是：未使用&nbsp;@FunctionalInterfaces注解的接口未必就不是函数式接口，一个接口是不是函数式接口的条件只有一条，即接口中只有一个抽象方法的接口（Object类中的方法不算）。而使用@FunctionalInterface注解修饰了的接口就一定是函数式接口，添加@FunctionalInterface注解可以帮助我们检查是否是函数式接口。
JDK中常见的函数式接口有：
```java
@FunctionalInterface
public interface Runnable {
    void run();
}
```
```java
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
```
以下接口中虽然有两个方法，但因hashCode()是Object类中的方法，因此该接口也是函数式接口：
```java
@FunctionalInterface
public interface FuncInterface {

    void doSomething();

    int hashCode();  // Object类中的方法
}
```
#### 4、Lambda表达式示例

**需求一：开启一个线程，在线程中打印出"Hello World"**

未使用Lambda表达式时的写法：
```java
public class LambdaTest {

    public void print() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });

        thread.start();
    }
}
```
使用Lambda时的写法：
```java
public class LambdaTest {
    
    public void print() {
        Thread thread = new Thread(() -> System.out.println("Hello World"));
    }
}
```

**需求二：模拟一个计算器，使其可以进行简单的加、减、乘操作**

（1）、计算器操作函数式接口

```java
@FunctionalInterface
public interface Calculator<T> {
    T operation(T t1,T t2);
}
```

（2）具体操作
```java
public class CalculatorTest {

    public Integer operator(Integer v1,Integer v2,Calculator<Integer> calculator) {
        return calculator.operation(v1,v2);
    }

    public Integer add(Integer v1,Integer v2) {
        return operator(v1,v2,(x,y) -> x + y);
    }

    public Integer subtr(Integer v1,Integer v2) {
        return operator(v1,v2,(x,y) -> x - y);
    }

    public Integer multi(Integer v1,Integer v2) {
        return operator(v1,v2,(x,y) -> x * y);
    }

    public static void main(String[] args) {

        CalculatorTest calculatorTest = new CalculatorTest();

        // 加法
        Integer add = calculatorTest.add(1,2);

        // 减法
        Integer sub = calculatorTest.subtr(100,82);

        // 乘法
        Integer multi = calculatorTest.multi(5,3);

        System.out.println(add);
        System.out.println(sub);
        System.out.println(multi);
    }
}
```

运行结果：
```
3
18
15
```
从需求一中，我们可以看出，使用Lambda比使用匿名内部类代码更加简洁，同时，也可以理解为什么Lambda必须需要函数式接口的支持。我们假设Runnable中有两个方法，那么，&ldquo;() -&gt; System.out.println(Thread.currentThread().getName())&rdquo;应该去找哪个方法去实现？

从需求二的例子中，我们可以更加理解&ldquo;一段可以传递的代码&rdquo;这句话的含义。对数据的操作方法定义在Calculator接口中，而加、减、乘的具体实现代码在各自的方法中，并将这些实现作为参数传递给CalculatorTest类的operator()方法，最终返回操作结果。

#### 5、Lambda表达式的语法

##### 5.1 Lambda表达式的语法结构

    (参数列表，对应的是接口中对应的抽象方法的参数列表) -> {对抽象方法的实现}

Lambda表达式语法分在3个部分：

1. 左边的参数列表，对应的是函数式接口中抽象方法的参数列表；
2. 中间的符号:-&gt;,为固定写法；
3. 右边大括号内对函数接口抽象方法的实现。

Lambda表达式的在具体场景下可以有简略写法。
##### 5.2&nbsp;语法格式一：无参数，无返回值
```java
Runnable runnable = () -> {System.out.println("Hello World");} 
Runnable runnable = () -> System.out.println("Hello World");  // 简写形式
```
此时，如果右边的代码简单，只有一行代码时，{}可以省略。
##### 5.2&nbsp;语法格式二：有一个参数，无返回值
```java
public class CalculatorTest {

    public void print(Consumer<String> msg) {
        System.out.println(msg);
    }

    public void doPrint(String msg) {
        print((str) -> System.out.println(msg));
        print(str -> System.out.println(msg));  // 简写

    }
}
```
此时，左边的()可以省略。
##### 5.3&nbsp;语法格式三：Lambda体内只有一条语句，且有返回值，return可省略
```java
public Integer subtr(Integer v1,Integer v2) {
    return operator(v1,v2,(x,y) -> x - y);
}
```
##### 5.4&nbsp;语法格式四：有两个以上参数，且Lambda体中有多条语句
```java
public Integer add(Integer v1,Integer v2) {
        return operator(v1,v2,(x,y) -> {
            System.out.println("进行加法运算");
            return x + y;
        });
    }
```
##### 5.5&nbsp;语法格式五：Lambda表达式的数据类型可以省略不写

JVM编译器通过上下文可以推断出数据类型，但要注意的是，当多个参数时，要么都写，要么都不写，不能有的写，有的不写：
```java
public Integer subtr(Integer v1,Integer v2) {
    // 错误
    return operator(v1,v2,(Integer x,y) -> x - y);
}

public Integer subtr(Integer v1,Integer v2) {
    // 正确
    return operator(v1,v2,(x,y) -> x - y);
}
```
#### 6、Java8四大内置核心函数式接口
```java
Consumer<T> : 消费型接口（无返回值，有去无回）
         void accept(T t);
 Supplier<T> : 供给型接口
         T get();
         
 Function<T,R> : 函数型接口
        R apply(T t);
        
 Predicate<T> : 断言型接口
        boolean test(T t);
        
四大核心接口的-->扩展子接口
```
示例：
```java
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Getter
@Setter
class User {
    private String username;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}

public class InnerInterface {

    /**
     * 打印user信息
     */
    public void print(User user,Consumer<User> userConsumer) {
        userConsumer.accept(user);
    }

    /**
     * 返回一个user
     */
    public User getUser(Supplier<User> userSupplier) {
        return userSupplier.get();
    }

    /**
     * 转换一个user
     */
    public User transformUser(User user,Function<User,User> function) {
        return function.apply(user);
    }

    /**
     * 检验User是否合法
     */
    public boolean checkUser(User user, Predicate<User> predicate) {
        return predicate.test(user);
    }

    public static void main(String[] args) {

        User userObj = new User();
        userObj.setUsername("西门吹雪");
        userObj.setAge(22);

        // 测试Consumer
        InnerInterface mainInst = new InnerInterface();
        mainInst.print(userObj,user -> System.out.println(user));

        // 测试Supplier
        final User user1 = mainInst.getUser(() -> {
            User user = new User();
            user.setUsername("叶孤城");
            user.setAge(22);
            return user;
        });
        System.out.println(user1);

        // 将西门吹雪的年龄改为25
        final User user2 = mainInst.transformUser(userObj, (user -> {
            user.setAge(25);
            return user;
        }));
        System.out.println(user2);

        // 判断User是否是西门吹雪
        final boolean checkUser = mainInst.checkUser(userObj, (user -> user.getUsername().equals("西门吹雪")));
        System.out.println(checkUser);
    }
}
```
运行结果：
```java
User{username='西门吹雪', age=22}
User{username='叶孤城', age=22}
User{username='西门吹雪', age=25}
true
```
以上四大核心内置接口是我们日常开发中经常要用到的，同时，它们还有一些变种，如：

BiConsumer，Consumer的增强版，接受两个参数：
```java
@FunctionalInterface
public interface BiConsumer<T, U> {

    void accept(T t, U u);
}
```
BiFunction类似，Function的增强版，接受两个参数，返回一个参数：
```java
@FunctionalInterface
public interface BiFunction<T, U, R> {

    R apply(T t, U u);

    default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(apply(t, u));
    }
}
```
其他的类似，这些函数式接口都在java.util.function包下，读者可去这个包下去查询。