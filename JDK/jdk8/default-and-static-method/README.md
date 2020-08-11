### Java8新特性之四：接口默认方法和静态方法
在JDK1.8以前，接口(interface)没有提供任何具体的实现，在《JAVA编程思想》中是这样描述的：&ldquo;interface这个关键字产生了一个完全抽象的类，它根本就没有提供任何具体的实现。它允许创建者确定方法名、参数列表和返回类型，但是没有任何方法体。接口只提供了形式，而未提供任何具体实现&rdquo;。

但是这一限制在JDK1.8中被打破了，JDK1.8开始，接口允许定义默认方法和静态方法。

接口默认方法的语法很简单，即：
```java
default methodName(参数列表) {
    // 实现体 
}
```
接口静态方法语法与类的静态方法类似，不同的是接口静态方法的修饰符只能是public。
#### 1、默认方法
为了提高代码的可重用性。接口的默认方法有助于在扩展系统功能的同时，不对现有的继承关系及类库产生很大的影响。例如在JDK1.8中，Java集合框架的Collection接口增加了stream()等默认方法，这些默认方法即增强了集合的功能，又能保证对低版本的JDK的兼容。

举个简单的例子，假如有一个Animal接口其中有fly()和swim()方法，有一个鸟类Bird和一个鱼类Fish同时实现这个接口，代码如下：

**Animal接口：**
```java
public interface Animal {
    void run();
    void swim();
}
```

**Bird.java**
```java
public class Bird implements Animal {

    @Override
    public void swim() {
        // do nothing
    }

    @Override
    public void fly() {
        System.out.println("birds can fly...");
    }
}
```
**Fish.java**
```java
public class Fish implements Animal {

    @Override
    public void swim() {
        System.out.println("fish can swim......");
    }

    @Override
    public void fly() {
        // donothing
    }
}
```
从上代码可以看到，因为Animal中定义了fly()和swim()方法，所以所有实现它的类都要覆写这两个方法，在Bird类中，鸟会飞，不会游泳，但是又必须要实现swim()方法，Fish类不会飞，但是又必须要实现fly()方法。代码出现冗余。

假如现在又有了新的需求，需要在Animal接口中再增加一个cry()方法，那么之前所有实现了Animal接口的方法势必都在再覆写cry()方法，整个系统中可能会有很多地方需要同步修改，而此时，default方法和静态方法就显得尤为必要了。

改写上面的例子：

**Animal.java**
```java
public interface Animal {
    default void fly() {
        System.out.println("birds can fly...");
    }

    default void swim() {
        System.out.println("fishes can swim......");
    }
}
```
**Bird.java**
```java
public class Bird implements Animal {
}
```
**Fish.java**
```java
public class Fish implements Animal {
}
```
测试类：
```java
public class TestMain {

    public static void main(String[] args) {

        Bird bird = new Bird();
        bird.fly();

        Fish fish = new Fishe();
        fish.swim();
    }
}
```
运行结果：
```java
birds can fly...
fishes can swim......
```
从修改后代码可以看出，代码得到了复用，Animal实现类中也没有了冗余。

#### 2、静态方法
假如有一个Animal工厂接口，该接口中有一个静态方法create()专门生产不同的Animal，在JDK1.8后由于引入了Lambda表达式，使子类不用覆写该接口的create()方法也可以生产任意的Animal，代码如下：
```java
public interface AnimalFactory {

    static Animal create(Supplier<Animal> supplier) {
        return supplier.get();
    }
}
```
测试类：
```java
public class TestAnimalFactory {

    public static void main(String[] args) {

        // 生产一只鸟
        Animal bird = AnimalFactory.create(Bird::new);
        bird.fly();
　　　　　// 生产一条鱼
        Animal fish = AnimalFactory.create(Fishe::new);
        fish.swim();
    }
}
```
运行结果：
```java
birds can fly...
fishes can swim......
```

#### 3、接口静态方法的&ldquo;类优先&rdquo;原则
如果一个接口实现类提供了具体的实现，那么接口中具有相同名称和参数的默认方法会被忽略，如改写之前的Bird类：
```java
public class Bird implements Animal {

    public void fly() {
        System.out.println("Bird类中的fly方法：birds can fly...");
    }
}
```
测试类：
```java
public class TestMain {

    public static void main(String[] args) {

        Bird bird = new Bird();
        bird.fly();
    }
}
```
运行结果：
```java
Bird类中的fly方法：birds can fly...
```
可见，调用的是Bird类中自己的fly()方法而不是Animal接口中的默认方法。

#### 4、接口冲突

假如一个类实现了两个接口，两个接口中都有同样的默认方法，哪个是有效的？

答案是：两个都无效！

该类必须要覆该方法来解决冲突，否则编译器将会报错。

**[原文链接](https://www.cnblogs.com/wuhenzhidu/p/10753328.html)**