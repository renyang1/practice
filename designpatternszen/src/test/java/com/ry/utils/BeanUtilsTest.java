package com.ry.utils;

import com.ry.entity.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Auther: renyang
 * @Date: 2018/6/2 18:28
 * @Description:
 */
public class BeanUtilsTest {
    @Test
    public void describe() throws Exception {

        User user = new User("tom",1);
        Map<String, Object> propMap = BeanUtils.describe(user);
        System.out.println(propMap);
    }

    @Test
    public void populate() throws Exception {

        Map<String, Object> propMap = new HashMap<>();
        propMap.put("name","hehe");
        propMap.put("age",2);
        propMap.put("password","123");
        User user = new User();
        BeanUtils.populate(user,propMap);
        System.out.println(user);
    }

}