package leoli.jdk.methodreference.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Person {

    private String name;
    private Integer age;

    public static int compareByAge(Person a, Person b) {
        return a.age.compareTo(b.age);
    }
}
