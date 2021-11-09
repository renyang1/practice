package com.ryang.optional;


import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

/**
 * @author renyang
 * @date: 2020/1/1 13:40
 */
@Data
@Accessors(chain = true)
public class Car {

    private String name;

    private String color;

    /** 保险公司 */
    private Optional<Insurance> insurance;

    public static void main(String[] args) {
        String objectStr = "{\"name\": \"ryang\"}";
        //1、使用JSONObject
        Car car= JSON.parseObject(objectStr, Car.class);
        System.out.println(car);
    }
}
