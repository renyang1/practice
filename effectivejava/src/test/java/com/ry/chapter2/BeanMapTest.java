package com.ry.chapter2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: renyang
 * @Date: 2018/9/25 10:50
 * @Description:
 */
public class BeanMapTest {

    private static final String PARAMSTRING = "{\n" +
            "    \"info\": \"AnimalsInfo\",\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"age\": 1,\n" +
            "            \"colour\": \"black\",\n" +
            "            \"name\": \"user1\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"age\": 1,\n" +
            "            \"colour\": \"red\",\n" +
            "            \"name\": \"user1\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"age\": 1,\n" +
            "            \"colour\": \"write\",\n" +
            "            \"name\": \"user1\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Test
    public void mapToObject() {

        // 1.将Json文本数据信息转换为JsonObject对象，然后利用键值对的方式获取信息
        JSONObject paramsObject = JSON.parseObject(PARAMSTRING);
        String info = paramsObject.get("info").toString();
//        System.out.println(info);

        // 2.将json数据转化为JSONArray
        JSONArray jsonArray =  JSONArray.parseArray(paramsObject.get("data") + "");
//        System.out.println(jsonArray.get(0).toString());

        // 3.将Json文本数据转换为JavaBean数据
        List<Map<String, Object>> datas = (List) paramsObject.get("data");
        Animal a1 = JSON.parseObject(datas.get(0) + "", Animal.class);
//        System.out.println(a1);

        // 4.将JSON文本转换为JavaBean的集合
        List<Animal> animals = JSON.parseArray(paramsObject.get("data") + "", Animal.class);
        for (Animal animal : animals) {
//            System.out.println(animal);
        }

        Animal animal = new Animal("jack", 5, "black");

        animal.setBirthDay(LocalDate.now());

        // 6.将JavaBean转换为JSON对象(JSON对象本身就是Map)
        JSONObject jsonObject = (JSONObject) JSON.toJSON(animal);
//        System.out.println(jsonObject.get("name"));

        // 7.将Map类型的数据转换为Json格式的数据
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ryang");
        map.put("age", 25);
        map.put("sex", "男");
//        System.out.println(map.toString());
        String jsonString = JSONObject.toJSONString(map);
//        System.out.println(jsonString);

        // 8.将JavaBean转换为Json格式的数据
        String animalJsonString = JSONObject.toJSONString(animal);
        System.out.println(animalJsonString);
    }

    @Test
    public void objectToMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "baby");
        map.put("age", "2");
        map.put("color", "black");
        System.out.println(map.toString());
    }
}

