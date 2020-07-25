package com.ryang.stream;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Stream在集合处理中的常见使用场景
 * @author renyang
 * @date: 2020/2/9 18:13
 */
public class StreamDemo1 {

    private static List<User> users = new ArrayList<>();

    static {
        User user1 = new User(1, 10, "张三1", "男");
        User user2 = new User(2, 20, null, null);
        User user3 = new User(3, 30, "小红1", "女");
        User user4 = new User(3, 40, "小红2", "女");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    /**
     * 将list转为Map,value为String
     * 1.如果报 map里的value空指针异常，则需要在value，也就是toMap()的第二个参数进行空(null)值的判断逻辑
     * 2.toMap()第三个参数是当有重复的Key时，会执行这段逻辑，传入2个参数，第一个参数是已经存在Map的value值，第二个是即将覆盖的value值，最终以返回哪个值为准
     * */
    @Test
    public void toMap() {

        Map<Integer, String> nameMap = users.stream().collect(Collectors.toMap(User::getId,
                user -> user.getName() == null ? "" :user.getName(), (id1, id2) -> id2));
        System.out.println(nameMap);
    }

    /**
     * 将list转为Map,value为对象
     * */
    @Test
    public void toMap1() {

        // 出现重复id,则直接用后面的覆盖前面的
        Map<Integer, User> userMap = users.stream().collect(Collectors.toMap(User::getId, Function.identity(), (id1, id2) -> id2));
        System.out.println(userMap.toString());
        users.forEach(user -> {
            user.setName(user.getName() + "test");
        });
        System.out.println(userMap.toString());
    }

    @Test
    public void test1() {
        System.out.println(users.toString());
        users.stream().filter(user -> user.getId() == 2)
                .forEach(user -> {
            user.setName(user.getName()+"-test");
        });
        System.out.println(users.toString());
    }
}
