package leoli.stream.api;

import leoli.stream.api.bean.Person;
import leoli.stream.api.bean.PersonCountry;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiDemo {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("欧阳雪", 18, "中国", 'F'));
        personList.add(new Person("Tom", 24, "美国", 'M'));
        personList.add(new Person("Harley", 22, "英国", 'F'));
        personList.add(new Person("向天笑", 20, "中国", 'M'));
        personList.add(new Person("李康", 22, "中国", 'M'));
        personList.add(new Person("小梅", 20, "中国", 'F'));
        personList.add(new Person("何雪", 21, "中国", 'F'));
        personList.add(new Person("李康", 22, "中国", 'M'));

        // 1）找到年龄大于18岁的人并输出；
        System.out.println("找到年龄大于18岁的人并输出 -> ");
        personList.stream().filter((p) -> p.getAge() > 18).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // 2）找出所有中国人的数量
        System.out.println("找出所有中国人的数量 -> ");
        long chinaPersonNum = personList.stream().filter((p) -> p.getCountry().equals("中国")).count();
        System.out.println("中国人有：" + chinaPersonNum);
        System.out.println("--------------------------------------------------------------------------------------");

        // limit
        System.out.println("limit -> ");
        personList.stream().filter((p) -> p.getSex() == 'F').limit(2).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // skip
        System.out.println("skip -> ");
        personList.stream().filter((p) -> p.getSex() == 'F').skip(1).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // distinct
        System.out.println("distinct -> ");
        personList.stream().filter((p) -> p.getSex() == 'M').distinct().forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // map
        System.out.println("map -> ");
        personList.stream().map((p) -> {
            PersonCountry personName = new PersonCountry();
            personName.setCountry(p.getCountry());
            return personName;
        }).distinct().forEach(System.out::println);
        System.out.println("\n--------------------------------------------------------------------------------------");

        // map2
        System.out.println("map2 -> ");
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "ddd");

        final Stream<Stream<Character>> streamStream
                = list.stream().map(StreamApiDemo::getCharacterByString);
//        streamStream.forEach(System.out::println);
        streamStream.forEach(sm -> sm.forEach(System.out::print));
        System.out.println("\n--------------------------------------------------------------------------------------");

        // flatMap
        System.out.println("flatMap -> ");
        final Stream<Character> characterStream = list.stream().flatMap(StreamApiDemo::getCharacterByString);
        characterStream.forEach(System.out::print);
        System.out.println("--------------------------------------------------------------------------------------");

        // sort
        System.out.println("sort -> ");
        final Stream<Person> sorted = personList.stream().sorted((p1, p2) -> {

            if (p1.getAge().equals(p2.getAge())) {
                return p1.getName().compareTo(p2.getName());
            } else {
                return p1.getAge().compareTo(p2.getAge());
            }
        });
        sorted.forEach(System.out::println);
        System.out.println("--------------------------------------------------------------------------------------");

        // allMatch
        System.out.println("allMatch -> ");
        final Stream<Person> stream = personList.stream();
        final boolean adult = stream.allMatch(p -> p.getAge() >= 18);
        System.out.println("是否都是成年人：" + adult);

        final boolean chinaese = personList.stream().allMatch(p -> p.getCountry().equals("中国"));
        System.out.println("是否都是中国人：" + chinaese);
        System.out.println("--------------------------------------------------------------------------------------");

        // max min
        System.out.println("max min -> ");
        final Optional<Person> maxAge = personList.stream().max((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
        System.out.println("年龄最大的人信息：" + maxAge.get());

        final Optional<Person> minAge = personList.stream().min((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
        System.out.println("年龄最小的人信息：" + minAge.get());
        System.out.println("--------------------------------------------------------------------------------------");

        // reduce
        System.out.println("reduce -> ");
        List<Integer> integerList = new ArrayList<>(100);
        for (int i = 1; i <= 100; i++) {
            integerList.add(i);
        }
        final Integer reduce = integerList.stream().reduce(0, (x, y) -> x + y);
        System.out.println("结果为：" + reduce);

        final Optional<Integer> totalAge = personList.stream().map(Person::getAge).reduce(Integer::sum);
        System.out.println("年龄总和：" + totalAge);
        System.out.println("--------------------------------------------------------------------------------------");

        // collect
        System.out.println("collect -> ");
        final List<String> collect = personList.stream().map(p -> p.getCountry()).distinct().collect(Collectors.toList());
        System.out.println(collect);

        final Double collect1 = personList.stream().collect(Collectors.averagingInt(p -> p.getAge()));
        System.out.println("平均年龄为：" + collect1);

        final Optional<Integer> maxAge2 = personList.stream().map(Person::getAge).collect(Collectors.maxBy(Integer::compareTo));
        System.out.println(maxAge2.get());

        try (final Stream<Integer> integerStream = personList.stream().map(Person::getAge)) {
            final Optional<Integer> minAge2 = integerStream.collect(Collectors.minBy(Integer::compareTo));
            System.out.println(minAge2.get());
        }
        System.out.println("-----------------unlimited streaming-------------------");

        // unlimited streaming
        Stream<UUID> generate = Stream.generate(UUID::randomUUID);
        generate.limit(3).forEach(System.out::println);
        Stream<Integer> iterator = Stream.iterate(0, x -> x + 1);
        iterator.skip(1).limit(3).forEach(System.out::println);
    }

    public static Stream<Character> getCharacterByString(String str) {

        List<Character> characterList = new ArrayList<>();

        for (Character character : str.toCharArray()) {
            characterList.add(character);
        }

        return characterList.stream();
    }
}