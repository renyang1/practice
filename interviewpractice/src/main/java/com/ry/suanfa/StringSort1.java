package com.ry.suanfa;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.*;

/**
 * @Auther: renyang
 * @Date: 2019/4/19 10:00
 * @Description: 给出一个字符串，以出现最多的字符为第一关键字，字典顺序为第二关键字排序字符串。
 * 注意事项：所有字符皆为小写字母，a-z，中间无空格。
 * 样例：bloomberg 输出 bbooeglmr；hello 输出 lleho
 */
public class StringSort1 {

    /**
     * Description:
     * 实现思路：
     * 1. 先将字符串中字符按字典顺序排序
     * 2. 将按字典顺序排好序的字符数组放到LinkHashMap中(保证key按字典顺序排列)，key为字符，value为该字符出现的次数
     * 3. 统计已按字典顺序排序的字符Map中出现次数最多的元素(可能有多个同时出现最多次)
     * 4. 将字符数组转换为list且将出现次数最多的字符从list中移除
     * 5. 将出现次数最多的元素放到集合头部
     *
     * @auther: renyang
     * @param: []
     * @return: void
     * @date: 2019/4/19 10:34
     */
    @Test
    public void sortTest() {
        String source = "bloomberg";
        String result = this.sort(source);
        System.out.println(result);
    }

    public String sort(String source) {
        char[] chars = source.toCharArray();
        // 将字符按字典顺序进行排序
        Arrays.sort(chars);

        // 统计已按字典顺序排序的各字符各自出现次数
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char char1 : chars) {
            if (map.get(char1) != null) {
                // 已存在
                map.put(char1, map.get(char1) + 1);
            } else {
                // 原本不存在
                map.put(char1, 1);
            }
        }

        Integer maxTimes = 0;
        // 考虑有多个字符同时出现最多次数情况
        List<Character> character = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= maxTimes) {
                maxTimes = entry.getValue();
                character.add(entry.getKey());
            }
        }

        // 将char[]转换为Character[],只有这样调用Arrays.asList()时，才能成功得到想要的List<Character>
        Character[] ch1 = ArrayUtils.toObject(chars);
        List<Character> list = new ArrayList<>(Arrays.asList(ch1));

        // 循环中进行remove时需要倒序或者使用迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (character.contains(iterator.next()))
                iterator.remove();
        }

        // 将出现次数最多字符串放到头部，这里倒序是为了保证出现次数最多字符也按字典顺序排列
        for (int i = character.size() - 1; i >= 0; i--) {
            for (int j = 0; j < maxTimes; j++) {
                list.add(0, character.get(i));
            }
        }
        return list.toString();
    }
}
