package com.ryang.stream;

import org.junit.Test;

import java.text.NumberFormat;
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

    // 初始化集合
    private List<User> userList = new ArrayList<User>() {
        {
            this.add(new User(1, 100, "大明", "男"));
            this.add(new User(2, 20, "小明", null));
            this.add(new User(3, 20, "小敏", ""));
            this.add(new User(4, 60, "小红", "女"));
            this.add(new User(5, 30, "李四", "男"));
            this.add(new User(6, 40, "小李", ""));
            this.add(new User(7, 60, "王五", "男"));
        }
    };

    /**
     * Description: 1.创建Stream对象
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/23 16:41
     */
    @Test
    public void creatStream() {
        // 1.Individual values
        Stream stream1 = Stream.of("a", "b", "c");

        // 2.利用数组创建Stream
        String[] args = new String[]{"a", "b", "c"};
        Stream streamArgs = Arrays.stream(args);
        streamArgs.forEach(System.out::println);

        // 3.使用Collections接口创建
        List<String> list = Arrays.asList(args);
        Stream stream3 = list.stream();
        stream3.forEach(System.out::println);

        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 3).limit(4);
        stream4.forEach(System.out::println); // 0 2 4 6 8 10

        Stream<Double> stream5 = Stream.generate(Math::random).limit(3);
        stream5.forEach(System.out::println);
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
     * map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、
     * parallel、 sequential、 unordered
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/28 15:24
     */
    public void streamIntermediateOperation() {
        /*List<User> userList = new ArrayList<User>() {
            {
                this.add(new User(1, 40, "小明", "男"));
                this.add(new User(2,10, "小敏", "女"));
                this.add(new User(3,30, "小红", "女"));
                this.add(new User(4,20, "小李", "男"));
                this.add(new User(4,20, "小李", "男"));
                this.add(new User(5,30, "小王", "男"));
            }
        };*/

        // 注意各个函数式接口方法的入参，参数类型是否为Stream泛型类型

        /**
         * 1.map/flatMap：将对象转换为其它对象，注意函数式接口Function的使用
         */
        List<String> nameList = userList.stream().map(user -> user.getName()).collect(Collectors.toList());
//        System.out.println(nameList);

        /**
         * 2.filter: 筛选符合条件的元素,注意函数式接口Predicate的使用
         * */
        List<String> ageMoreThan20UserNameList = userList.stream().filter(user -> user.getAge() > 20).map(User::getName)
                .collect(Collectors.toList());// 得到年龄大于20的user名称
        System.out.println(ageMoreThan20UserNameList);

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
    }

    /**
     * Description: 流的终端操作：forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、
     * anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/28 17:46
     */
    public void streamTerminalOperation() {
        // ***流的终端操作之匹配
        /**
         * 1.anyMatch:检查谓词是否至少匹配一个元素
         * */
        // 检查是否有一个name为'小敏'的user
        boolean isAnyMatch = userList.stream().anyMatch(user -> user.getName().equals("小敏"));
        if (isAnyMatch) {
            System.out.println("有name为小敏的用户");
        }

        /**
         * 2.allMatch:检查谓词是否匹配所有元素
         * */
        boolean isAllMatch = userList.stream().allMatch(user -> user.getName().equals("小敏"));
        if (isAllMatch) {
            System.out.println("所有用户name均为小敏");
        }

        /**
         * 3.noneMatch：确保流中没有任何元素与给定的谓词匹配
         * */
        boolean isNoneMatch = userList.stream().noneMatch(user -> user.getName().equals("张三"));
        if (isNoneMatch) {
            System.out.println("所有用户中没有name为张三的用户");
        }

        // ***流的终端操作之查找
        /**
         * 4. findAny:返回当前流中的任意元素(不一定是集合中符合条件的第一个元素)
         * */
        Optional<User> optionalUser = userList.stream().findAny();
        User user = optionalUser.orElse(null);
        System.out.println("findAny: " + user);

        /**
         * 5. findFirst:查找第一个元素
         * */
        Optional<User> optionalFirstUser = userList.stream().findFirst();
        User userFirst = optionalFirstUser.orElse(null);
        System.out.println("findFirst: " + userFirst);
    }

    /**
     * Description:流的终端操作之归约(reduce)。归约：将流中所有元素反复结合起来，得到一个值，比如一个Integer
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/4 16:34
     */
    public void streamReduceTerminalOperation() {

        /**
         * 1. 元素求和
         * */
        int totalAge = userList.stream().map(User::getAge)
                .filter(age -> age != null) // 注意过滤null值,否则会出现NPE，因为Integer到int的拆箱
                .reduce(0, (age1, age2) -> age1 + age2);
        System.out.println("用户总age为： " + totalAge);

        /**
         * 2.求最大值
         * */
        Optional<Integer> maxAgeOptional = userList.stream().map(User::getAge)
                .filter(age -> age != null)
                .reduce(Integer::max);
        if (maxAgeOptional.isPresent()) {
            int maxAge = maxAgeOptional.get();
            System.out.println("用户最大年龄为 " + maxAge);
        }

        /**
         * 3.求最小值
         * */
        Optional<Integer> minAgeOptional = userList.stream().map(User::getAge)
                .filter(age -> age != null)
                .reduce(Integer::min);
        if (minAgeOptional.isPresent()) {
            int minAge = minAgeOptional.get();
            System.out.println("用户最小年龄为 " + minAge);
        }
    }

    /**
     * Description: 使用收集器进行高级归约操作，Collectors实用类提供了很多静态工厂方法，
     * 可以方便地创建常见收集器的实例，只要拿来用就可以了。最直接和最常用的收集器是toList
     * 静态方法，它会把流中所有的元素收集到一个List中。从Collectors类提供的工厂方法
     * （例如groupingBy）创建的收集器。它们主要提供了三大功能：
     * 1. 将流元素归约和汇总为一个值
     * 2. 元素分组
     * 3. 元素分区
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/8/4 18:39
     */
    @Test
    public void streamCollectors() {
        /*** 归约和汇总  ***/

        /**
         *1. 最大、最小值：使用Collectors.maxBy和Collectors.minBy收集器来计算流中的最大值和最小值
         * */
        Comparator<User> ageComparator = Comparator.comparingInt(User::getAge);
        Optional<User> ageMaxUser = userList.stream()
                .filter(user -> user.getAge() != null) // 注意null值过滤
                .max(ageComparator);
        if (ageMaxUser.isPresent()) {
            System.out.println("年龄最大的用户为：" + ageMaxUser);
        }

        /**
         * 2. 汇总：Collectors.summingInt，它可接受一个把对象映射为求和所需int的函数，
         * 并返回一个收集器；该收集器在传递给普通的collect方法后即执行我们需要的汇总操作。
         * */
        int totalAge = userList.stream()
                .filter(user -> user.getAge() != null) // 注意null值过滤
                .collect(Collectors.summingInt(User::getAge));
        System.out.println("总年龄为： " + totalAge);

        /**
         * 3. 计算平均值：Collectors.averagingInt
         * */
        double avgAge = userList.stream().
                map(user -> {
                    if (user.getAge() == null) {
                        user.setAge(0);// 将年龄值为null的置为0
                    }
                    return user;
                })
                .collect(Collectors.averagingInt(User::getAge));
        System.out.println("平均年龄为： " + avgAge);

        /**
         * 4. 连接字符串：Collectors.joining()、Collectors.joining()
         *    joining工厂方法返回的收集器会把对流中每一个对象应用toString方法得到的所有字符
         *   串连接成一个字符串。joining在内部使用了StringBuilder来把生成的字符串逐个追加起来。
         * */
        String name = userList.stream().map(User::getName).collect(Collectors.joining());// 元素间无分隔符
        System.out.println("拼接所有name,结果为：" + name);

        String name1 = userList.stream().map(User::getName).collect(Collectors.joining(""));// name将以逗号分隔
        System.out.println(name1);

        /*** 分组 ***/

        /**
         * 5. 分组：Collectors
         * */
        userList = Collections.emptyList();
        Map<String, List<User>> userBySex = userList.stream().collect(Collectors.groupingBy(User::getSex));
        System.out.println("按性别分组结果为：" + userBySex);

    }

    @Test
    public void test1() {
        Map<Integer, Integer> userMap = userList.stream().collect(Collectors.groupingBy(User::getId, Collectors.summingInt(User::getAge)));
        System.out.println(userMap);

//        userMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
//        System.out.println(map);
        // 分组排序
        Map<Integer, Integer> map = userList.stream().collect(Collectors.groupingBy(user -> user.getId(), TreeMap::new, Collectors.summingInt(User::getAge)));
        System.out.println(map);
        map = map.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(map);

    }

    private void forEachStream(Stream stream) {
        stream.forEach(System.out::println);
    }

    @Test
    public void test2() {

        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };

        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("流合并：" + newList);
        System.out.println("limit：" + collect);
        System.out.println("skip：" + collect2);
    }

    @Test
    public void test3() {
        int a = 1;
        int b = 3;
        double i = a/ (double) b;
        System.out.println(i);

        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(2);
        String format = nf.format(i);
        System.out.println(format);

    }

}
