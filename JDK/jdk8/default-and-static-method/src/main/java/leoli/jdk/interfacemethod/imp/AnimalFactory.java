package leoli.jdk.interfacemethod.imp;

import java.util.function.Supplier;

/**
 * static method interface
 *
 * @author leoli
 * @date 2020/8/11
 */
public interface AnimalFactory {

    static Animal create(Supplier<Animal> supplier) {
        return supplier.get();
    }

}
