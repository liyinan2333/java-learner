package leoli.jdk.methodreference;

import leoli.jdk.methodreference.bean.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        System.out.println("静态方法引用->");
        // 按年龄排序
        Person[] rosterAsArray = new Person[]{new Person("张三", 18), new Person("李四", 19), new Person("王五", 20)};
        // 普通写法
//        Arrays.sort(rosterAsArray, new PersonAgeComparator());
        // lamda
//        Arrays.sort(rosterAsArray, (a, b) -> Person.compareByAge(a, b));
        // method reference
        Arrays.sort(rosterAsArray, Person::compareByAge);
        Arrays.stream(rosterAsArray).forEach(System.out::println);

        // 数字排序
        List<Integer> list = Arrays.asList(82, 22, 34, 50, 9);
        list.sort(Integer::compare);
        System.out.println(list);
        System.out.println("---------------------------------------------------------------------");

        System.out.println("实例方法引用->");
        Person person = new Person("欧阳峰",32);
        Supplier<String> supplier = () -> person.getName();
        System.out.println("Lambda表达式输出结果：" + supplier.get());

        Supplier<String> supplier2 = person::getName;
        System.out.println("实例方法引用输出结果：" + supplier2.get());
        System.out.println("---------------------------------------------------------------------");


        System.out.println("对象方法引用->");
        BiPredicate<String,String> bp = (x, y) -> x.equals(y);
        BiPredicate<String,String> bp1 = String::equals;
        boolean test = bp1.test("xy", "xx");
        System.out.println(test);
        System.out.println("---------------------------------------------------------------------");

        System.out.println("构造方法引用->");
        Supplier<List<Person>> userSupplier = () -> new ArrayList<>();
        List<Person> person2 = userSupplier.get();
        // 构造方法引用写法
        Supplier<List<Person>> personSupplier2 = ArrayList<Person>::new;
        List<Person> person3 = userSupplier.get();
    }


}
