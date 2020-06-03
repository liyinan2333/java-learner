package leoli.pattern.builder;

import leoli.pattern.builder.director.Director;
import org.junit.Test;

/**
 * 建造者模式Test
 *
 * @author leoli
 * @date 2020/6/3
 */
public class Client {

    @Test
    public void testBuilder() {

        Director director = new Director();
        director.getAProduct().doSomething();

    }

}
