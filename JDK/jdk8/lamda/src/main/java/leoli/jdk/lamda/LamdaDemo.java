package leoli.jdk.lamda;

import java.util.function.Consumer;

/**
 * Lamda表达式演示
 *
 * @author leoli
 * @date 2020/8/11
 */
public class LamdaDemo {
    // 语法格式一：无参数，无返回值
    Runnable runnable1 = () -> {
        System.out.println("Hello World");
    };
    Runnable runnable2 = () -> System.out.println("Hello World");  // 简写形式


    // 语法格式二：有一个参数，无返回值
    public void print(Consumer<String> msg) {
        System.out.println(msg);
    }

    public void doPrint(String msg) {
        print((str) -> System.out.println(msg));
        print(str -> System.out.println(msg));  // 简写

    }

    // 语法格式三：Lambda体内只有一条语句，且有返回值，return可省略
//    public Integer subtr(Integer v1, Integer v2) {
//        return operator(v1, v2, (x, y) -> x - y);
//    }

    // 语法格式四：有两个以上参数，且Lambda体中有多条语句
//    public Integer add(Integer v1, Integer v2) {
//        return operator(v1, v2, (x, y) -> {
//            System.out.println("进行加法运算");
//            return x + y;
//        });
//    }

    // 语法格式五：Lambda表达式的数据类型可以省略不写
//    public Integer subtr(Integer v1,Integer v2) {
//        // 错误
//        return operator(v1,v2,(Integer x,y) -> x - y);
//    }

//    public Integer subtr(Integer v1,Integer v2) {
//        // 正确
//        return operator(v1,v2,(x,y) -> x - y);
//    }
}
