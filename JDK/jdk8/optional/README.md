Java8新特性之五：Optional
NullPointerException相信每个JAVA程序员都不陌生，是JAVA应用程序中最常见的异常。之前，Google Guava项目曾提出用Optional类来包装对象从而解决NullPointerException。受此影响，JDK8的类中也引入了Optional类，在新版的SpringData Jpa和Spring Redis Data中都已实现了对该方法的支持。

#### 1、Optional类
```java
/**
 * A container object which may or may not contain a non-null value.
 * If a value is present, {@code isPresent()} will return {@code true} and
 * {@code get()} will return the value.
 *
 * @since 1.8
 */
public final class Optional<T> {
    /**
     * Common instance for {@code empty()}.
     */
    private static final Optional<?> EMPTY = new Optional<>();

    /**
     * If non-null, the value; if null, indicates no value is present
     */
    private final T value;

   // 其他省略
}
```
该方法的注释大致意思是：Optional是一个容器对象，它可能包含空值，也可能包含非空值。当属性value被设置时，isPesent()方法将返回true，并且get()方法将返回这个值。

该类支持泛型，即其属性value可以是任何对象的实例。

#### 2、Optional类的方法

|序号|方法|方法说明|
|-|-|-|
|1|private Optional()|无参构造，构造一个空Optional|
|2|private Optional(T value)|根据传入的非空value构建Optional|
|3|public static<T> Optional<T> empty()|返回一个空的Optional，该实例的value为空|
|4|public static <T> Optional<T> of(T value)|根据传入的非空value构建Optional，与Optional(T value)方法作用相同|
|5|public static <T> Optional<T> ofNullable(T value)|与of(T value)方法不同的是，ofNullable(T value)允许你传入一个空的value，当传入的是空值时其创建一个空Optional，当传入的value非空时，与of()作用相同|
|6|public T get()|返回Optional的值，如果容器为空，则抛出NoSuchElementException异常|
|7|public boolean isPresent()|判断当家Optional是否已设置了值|
|8|public void ifPresent(Consumer<? super T> consumer)|判断当家Optional是否已设置了值，如果有值，则调用Consumer函数式接口进行处理|
|9|public Optional<T> filter(Predicate<? super T> predicate)|如果设置了值，且满足Predicate的判断条件，则返回该Optional，否则返回一个空的Optional|
|10|public<U> Optional<U> map(Function<? super T, ? extends U> mapper)|如果Optional设置了value，则调用Function对值进行处理，并返回包含处理后值的Optional，否则返回空Optional|
|11|public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)|与map()方法类型，不同的是它的mapper结果已经是一个Optional，不需要再对结果进行包装|
|12|public T orElse(T other)|如果Optional值不为空，则返回该值，否则返回other|
|13|public T orElseGet(Supplier<? extends T> other)|如果Optional值不为空，则返回该值，否则根据other另外生成一个|
|14|public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X|如果Optional值不为空，则返回该值，否则通过supplier抛出一个异常|

# 3、Optional类的方法举例
《Java 8 Features Tutorial &ndash; The ULTIMATE Guide》中给出了两个简单的例子，我们从这两个例子入手来简单了解一下Optional容器的使用。
**示例一：**
```java
public static void main(String[] args) {
　　Optional< String > fullName = Optional.ofNullable( null );
　　System.out.println( "Full Name is set? " + fullName.isPresent() );
　　System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
　　System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
}
```
运行结果：
```java
Full Name is set? false
Full Name: [none]
Hey Stranger!　
```
**说明：**

ifPresent()方法当Optional实例的值非空时返回true，否则返回false;&nbsp;

orElseGet()方法当Optional包含非空值时返回该值，否则通过接收的function生成一个默认的；

map()方法转换当前Optional的值，并返回一个新的Optional实例；

orElse()方法与orElseGet方法相似，不同的是orElse()直接返回传入的默认值。


**示例二：修改示例一，使其生成一个非空值的Optional实例**
```java
Optional< String > firstName = Optional.of( "Tom" );
System.out.println( "First Name is set? " + firstName.isPresent() );
System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
```
输出结果：
```java
First Name is set? true
First Name: Tom
Hey Tom!
```
可以清晰地看出与示例一的区别。这不但简洁了我们的代码，而且使我们的代码更便于阅读。

下面看一下例子中使用到的几个方法的源码：

**1）、of**
```java
public static <T> Optional<T> of(T value) {
    return new Optional<>(value);
}
```

**2）、isPresent**

```java
public boolean isPresent() {
    return value != null;
}
```

**3）、orElseGet**
```java
public T orElseGet(Supplier<? extends T> other) {
    return value != null ? value : other.get();
}
```

**4）、orElse**
```java
public T orElse(T other) {
    return value != null ? value : other;
}
```
其他方法源码，读者可以去Optional源码中查看。

#### 4、使用Optional避免空指针
在我们日常开发过程中不可避免地会遇到空指针问题，在以前，出现空指针问题，我们通常需要进行调试等方式才能最终定位到具体位置，尤其是在分布式系统服务之间的调用，问题更难定位。在使用Optional后，我们可以将接受到的参数对象进行包装，比如，订单服务要调用商品服务的一个接口，并将商品信息通过参数传入，这时候，传入的商品参数可能直接传入的就是null，这时，商品方法可以使用Optional.of(T)对传入的对象进行包装，如果T为空，则会直接抛出空指针异常，我们看到异常信息就能立即知道发生空指针的原因是参数T为空；或者，当传入的参数为空时，我们可以使用Optional.orElse()或Optional.orElseGet()方法生成一个默认的实例，再进行后续的操作。

下面再看个具体例子：在User类中有个Address类，在Address类中有个Street类,Street类中有streetName属性，现在的需求是：根据传入的User实例，获取对应的streetName，如果User为null或Address为null或Street为null，返回&ldquo;nothing found&rdquo;，否则返回对应的streetName。

**实现一：**
```java
@Data
public class User {
    private String name;
    private Integer age;
    private Address address;
}
```
```java
@Data
public class Address {
    private Street street;
}
```
```java
@Data
public class Street {
    private String streetName;
    private Integer streetNo;
}
```
```java
public String getUserSteetName(User user) {

    if(null != user) {

        Address address = user.getAddress();

        if(null != address) {

            Street street = address.getStreet();

            if(null != street) {
                return street.getStreetName();
            }
        }
    }

    return "nothing found";
}
```

**实现二，使用Optional：**

在实现一中明显的问题是if判断层级太深，下面复用Optional改写：
```java
@Data
public class User {
    private String name;
    private Integer age;
    private Optional<Address> address = Optional.empty();
}
```
```java
@Data
public class Address {
    private Optional<Street> street = Optional.empty();
}
```
```java
@Data
public class Street {
    private String streetName;
    private Integer streetNo;
}
```
```java
public String getUserSteetName(User user) {

    Optional<User> userOptional = Optional.ofNullable(user);
    final String streetName = userOptional.orElse(new User()).getAddress().orElse(new Address()).getStreet().orElse(new Street()).getStreetName();
    return StringUtils.isEmpty(streetName) ? "nothing found" : streetName;
}
```
利用orElse()方法给定默认值的方式确保不会报空指针问题问题，同时也能实现需求。

**[原文链接](https://www.cnblogs.com/wuhenzhidu/p/10765655.html)**