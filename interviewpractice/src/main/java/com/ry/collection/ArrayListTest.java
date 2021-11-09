package com.ry.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: renyang
 * @Date: 2018/7/16 19:12
 * @Description: 该类用于测试List相关的维问题，包括学习源码的一些验证等
 */
public class ArrayListTest {

    @Test
    public void removeTest(){
        List<String> strings = new ArrayList<>(4);
        strings.add("a");
        strings.add(2, null);
        strings.add(1, null);

        System.out.println(strings.get(1));
    }

    @Test
    public void test1(){
        List<User> users1 = new ArrayList<>();
        User user1 = new User("a", 1);
        User user11 = new User("a", 1);

        User user21 = new User("a", 1);

        users1.add(user1);
        users1.add(user11);

        System.out.println(users1.contains(user21));


    }

}

@Data
@AllArgsConstructor
class User {
    private String name;
    private int age;
}
