package com.ryang.reflection;

import com.ryang.optional.Car;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BigDogTest {

    public static void main(String[] args) {



    }

    @Test
    public void t1() {
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("a", "a");
        map.put("a", "b");
        System.out.println(map.get("a"));

        map.replace("a", "c");
        System.out.println(map.get("a"));

        String s = "a";
        Car car = new Car();
         List<String> list = new ArrayList<>();




    }
}
