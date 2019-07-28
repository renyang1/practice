package com.ryang.bookdemo.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: renyang
 * @Date: 2019/2/26 17:16
 * @Description: Stream 就如同一个迭代器（Iterator），单向，不可往复，数据只能遍历一次，遍历过一次后即用尽了，
 * 就好比流水从面前流过，一去不复返。
 * 流的操作类型分为两种：Intermediate、Terminal。
 * Intermediate：一个流可以后面跟随零个或多个 intermediate 操作。其目的主要是打开流，做出某种程度的数据映射/过滤，
 * 然后返回一个新的流，交给下一个操作使用。这类操作都是惰性化的（lazy），就是说，仅仅调用到这类方法，并没有真正开始流的遍历。
 * Terminal：一个流只能有一个 terminal 操作，当这个操作执行后，流就被使用“光”了，无法再被操作。
 * 所以这必定是流的最后一个操作。Terminal 操作的执行，才会真正开始流的遍历，并且会生成一个结果，或者一个 side effect。
 */
public class StreamDemo {

    /**
     * Description: 1.创建Stream对象
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/23 16:41
     */
    public void creatStream() {
        // 1.Individual values
        Stream stream1 = Stream.of("a", "b", "c");

        // 2.利用数据创建Stream
        String[] args = new String[]{"a", "b", "c"};
        Stream stream2 = Stream.of(args);

        // 3.使用Collections接口创建
        List<String> list = Arrays.asList(args);
        Stream stream3 = list.stream();
        forEachStream(stream3);
    }

    /**
     * Description: 2.将流转换为其它数据结构
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/23 17:13
     */
    public void transformStream() {
        Stream<String> stream = Stream.of("a", "b", "c", "d");
        // 1.将Stream转为Array
        String[] array = stream.toArray(String[]::new);

        // 2.Stream转为Collection
        List<String> list1 = stream.collect(Collectors.toList());
        List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        Set<String> set1 = stream.collect(Collectors.toSet());
        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));

        // 3.stream转为String
        String str = stream.collect(Collectors.joining());
        System.out.println(str);
    }

    /**
     * Description: 3.流的Intermediate(非中断)操作
     *              map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、
     *              parallel、 sequential、 unordered
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/28 15:24
     */
    public void streamIntermediateOperation() {
        List<User> userList = new ArrayList<User>() {
            {
                this.add(new User(1, 40, "小明", "男"));
                this.add(new User(2,10, "小敏", "女"));
                this.add(new User(3,30, "小红", "女"));
                this.add(new User(4,20, "小李", "男"));
                this.add(new User(4,20, "小李", "男"));
                this.add(new User(5,30, "小王", "男"));
            }
        };

        // 注意各个函数式接口方法的入参，参数类型是否为Stream泛型类型

        /**
         * 1.map/flatMap：将对象转换为其它对象，注意函数式接口Function的使用
         */
        List<String> nameList = userList.stream().map(user -> user.getName()).collect(Collectors.toList());
//        System.out.println(nameList);

        /**
         * 2.filter: 筛选符合条件的元素,注意函数式接口Predicate的使用
         * */
        List<User> ageMoreThan20UserList = userList.stream().filter(user -> user.getAge() > 20)
                .collect(Collectors.toList());// 得到年龄大于20的user
//        System.out.println(ageMoreThan20UserList);

        /**
         * 3.distinct: 返回一个元素各异(根据元素的hashCode和equals方法)的流
         * */
        // 因为User类使用了lombok的@Data，重写了hashCode()、equals()方法，所以属性值一样的对象equals()返回true,会被distinct过滤
        List<User> distinctUserList = userList.stream().distinct().collect(Collectors.toList());
//        System.out.println(distinctUserList);

        //结合filter
        // a. 使用map()得到age集合
        // b. 使用filter()筛选出age大于10的age
        // c. 使用distinct()去掉重复的age
        List<Integer> ageList = userList.stream().map(user -> user.getAge())
                .filter(age -> age > 10).distinct().collect(Collectors.toList());
//        System.out.println(ageList);

        /**
         * 4.limit: 截断流，返回不超过给定长度的流
         * */
        List<User> limitUserList = userList.stream().filter(user -> user.getAge() > 10)
                .limit(2).collect(Collectors.toList());// 返回age>10的前2个元素
//        System.out.println(limitUserList);

        /**
         * 5.sorted: 排序
         * */
        // 按age正序
        List<User> sortedUserList = userList.stream().distinct()
                .sorted(Comparator.comparing(user -> user.getAge())).collect(Collectors.toList());
//        System.out.println(sortedUserList);

        // 按age倒序
        // todo:为什么这里只能用User::getAge而不能使用user -> user.getAge(),两者的区别是什么
        // java8泛型推导的问题，所以如果comparing里面是非方法引用的lambda表达式就没办法直接使用reversed()
        List<User> reversedSortedUserList = userList.stream().distinct()
                .sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
//        System.out.println(reversedSortedUserList);

        // 先按age排序升序，再按id升序，两次排序同为升序
        List<User> sortedUsers = userList.stream().distinct()
                .sorted(Comparator.comparing(User::getAge).thenComparing(User::getId)).collect(Collectors.toList());
//        System.out.println(sortedUsers);

        /*
             先按age排序升序，再按id降序，两次排序一升一降，注意reversed()方法的位置，是在第二个Comparator.comparing()方法的后面,
             不是在第一个Comparator.comparing()方法的后面
         */
        List<User> sortedUsers1 = userList.stream().distinct()
                .sorted(Comparator.comparing(User::getAge)
                .thenComparing(Comparator.comparing(User::getId).reversed()))
                .collect(Collectors.toList());
//        System.out.println(sortedUsers1);

        /**
         * 6.peek: 对每个元素执行操作并返回一个新的 Stream
         * */
        // todo: peek的用法
//        userList.stream().map(User::getId).peek(id -> "学员id为：" + id).collect(Collectors.toList());

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .filter(e -> e.length() > 4)
                .collect(Collectors.toList());
    }

    /**
     * Description: 流的终端操作：forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、
     *              anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/28 17:46
     */
    public void streamTerminalOperation() {
        // todo:流的终端操作

    }

    private void forEachStream(Stream stream) {
        stream.forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    class User {
        private Integer id;
        private Integer age;
        private String name;
        private String sex;
    }
}
