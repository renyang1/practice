package com.ryang.optional;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Auther: renyang
 * @Date: 2019/1/24 11:15
 * @Description: Optional API demo
 */
public class OptionalApiDemo {

    User1 user1 = new User1("ZhangSan", 20);
    User1 user2 = null;
    User1 user3 = new User1("LiSi");

    public static void main(String[] args) {
        OptionalApiDemo optionalApiDemo = new OptionalApiDemo();
        optionalApiDemo.testOfNullable();
    }

    /**
     * Description: 返回一个指定非null值的Optional
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/25 15:29
     */
    @Test
    public void testOf() {

        User1 user1 = new User1("ry", 20);
        User1 user2 = null;

        Optional optional1 = Optional.ofNullable(user1);
        User1 user = (User1) optional1.get();
        System.out.println(user);
        Optional optional2 = Optional.ofNullable(user2);
        optional2.get();
    }

    /**
     * Description:如果为非空，返回 Optional 描述的指定值，否则返回空的 Optional
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/25 15:29
     */
    public void testOfNullable() {
        Optional optional1 = Optional.ofNullable(user1);
        System.out.println(optional1.get());
        Optional<User1> optional2 = Optional.ofNullable(user2);
        System.out.println(optional2.map(User1::getName).orElse("unknown"));
        System.out.println(optional2.get());
    }

    /**
     * Description: 如果存在该值，返回值， 否则返回 other
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/25 15:30
     */
    @Test
    public void testOrElse() {

        User1 user1 = new User1("ry", 20);
        User1 user2 = null;

        User1 u1 = Optional.ofNullable(user1).orElse(creatUser());
        System.out.println(u1);

        User1 u2 = Optional.ofNullable(user2).orElse(creatUser());
        System.out.println(u2);
    }

    /**
     * Description:如果存在该值，返回值， 否则触发 other，并返回 other 调用的结果
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/25 15:30
     */
    @Test
    public void testOrElseGet() {
//        User u1 = Optional.ofNullable(user1).orElseGet(() -> creatUser());
//        System.out.println(u1);

        User1 user1 = new User1("ry", 20);
        User1 user2 = null;

        Optional optional1 = Optional.ofNullable(user1);
        // creatUser()不会执行
        User1 user3 = (User1) optional1.orElseGet(()-> creatUser());
        System.out.println(user3);

        Optional optional2 = Optional.ofNullable(user2);
        // creatUser()会执行
        User1 user4 = (User1) optional2.orElseGet(() -> creatUser());
        System.out.println(user4);

        // 用lambda表达式创建Supplier接口实例对象
        // todo：这里lambda表达式中对抽象方法的实现为"test"和调creatUser()方法，supplier对象debug看到的对象有区别，
        // debug调用creatUser()时里面有args
        // 解释：调用creatUser()时里面有args是因为这里有个一this的隐式调用，即this.creatUser();这里的this就相当于
        //      supplier的一个成员变量，当将creatUser()方法定义为public static时，就没有args参数信息
    }

    /**
     * Description:如果存在该值，返回包含的值，否则抛出由 Supplier 继承的异常
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/25 15:31
     */
    @Test
    public void testOrElseThrow() {

        User1 user1 = new User1("ry", 20);
        User1 user2 = null;

        User1 user3 = Optional.ofNullable(user1).orElseThrow(
                () -> new RuntimeException("该用户不存在"));
        System.out.println(user3);
        Optional.ofNullable(user2).orElseThrow(() -> new RuntimeException("该用户不存在"));
    }

    /**
     * Description: 如果Optional对象的value不为null，则执行调用映射函数得到返回值。如果返回值不为 null，
     * 则创建包含映射返回值的Optional作为map方法返回值，否则返回空Optional
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/25 15:39
     */
    public void testMap() {

        // 这样写一定得显示声明Function的泛型类型，这样才能知道u的类型为User，进而调用u.getAge()方法
//        Function<User, Integer> function = u -> u.getAge();
//        Object object = Optional.ofNullable(user1).map(function).get();
        Object object = Optional.ofNullable(user1).map(u -> u.getAge()).get();
        System.out.println(object);

        user1.setAge(null);
        Object object1 = Optional.ofNullable(user1).map(u -> u.getAge()).get();
        System.out.println(object1);
    }

    /**
     * Description:如果值存在，返回基于Optional包含的映射方法的值，否则返回一个空的Optional
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/25 16:37
     */
    public void testFlatMap() {
        Function<User1, Optional<Integer>> function = user -> Optional.ofNullable(user.getAge());
        Object object = Optional.ofNullable(user1).flatMap(function).get();
        System.out.println(object);
//        Object object1 = Optional.ofNullable(user1).flatMap(user -> Optional.ofNullable(user.getAge()));
    }

    /**
     * Description:如果值存在则方法会返回true，否则返回 false
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/25 17:12
     */
    @Test
    public void testIsPresent() {

        User1 user1 = new User1("ry", 20);
        User1 user2 = null;

        boolean result1 = Optional.ofNullable(user1).isPresent();
        System.out.println(result1);// true

        boolean result2 = Optional.ofNullable(user2).isPresent();
        System.out.println(result2);// false

        System.out.println(Optional.empty().isPresent());// false
    }

    /**
     * Description:如果值存在则使用该值调用consumer, 否则不做任何事情
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/25 17:17
     */
    @Test
    public void testIfPresent() {

        User1 user1 = new User1("ry", 20);
        Optional.ofNullable(user1).ifPresent(user -> System.out.println(user.getAge()));

        User1 user2 = null;
        Optional.ofNullable(user2).ifPresent(user -> System.out.println(user.getAge()));
    }

    /**
     * Description:如果值存在，并且这个值匹配给定的 predicate，返回一个Optional用以描述这个值，否则返回一个空的Optional
     *
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/1/26 14:15
     */
    @Test
    public void testFilter() {

        User1 user1 = new User1("ry", 20);
        User1 user2 = null;

        Optional.ofNullable(user1)
                .filter(user -> user.getName().equals("ry"))
                .ifPresent(user -> System.out.println(user));

        Optional.ofNullable(user2)
                .filter(user -> user.getName().equals("ZhangSan1"))
                .ifPresent(user -> System.out.println(user));
    }

    private User1 creatUser() {
        System.out.println("creat default user");
        return new User1("default", 0);
    }

}


class User1 {

    private String name;
    private Integer age;

    public User1() {
    }

    public User1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}