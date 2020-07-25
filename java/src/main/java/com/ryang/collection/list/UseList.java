package com.ryang.collection.list;

import com.ryang.stream.User;
import org.junit.Test;

import java.util.*;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-03-04
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class UseList {

    public static void main(String[] args) {

        List<String> list = Arrays.asList(new String[]{"a", "b", "c"});
        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1, new String[]{"a", "b", "c", "e"});
        list1.add("e");
        System.out.println(list1);
//        list.add("e");
        System.out.println(list);

        List<String> list2 = new ArrayList<>(Arrays.asList("a", "b"));
        list2.add("c");
        System.out.println(list2.toString());
    }

    @Test
    public void testClone(){
        User user1 = new User(1, 10, "小红1", "女");
        User user2 = new User(2, 20, "小红2", "女");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

    }
}
