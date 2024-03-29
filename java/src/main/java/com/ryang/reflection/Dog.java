package com.ryang.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-09-20
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dog extends Animal{

    private String org;

    @Override
    public void run() {
        System.out.println("Dog run...");
    }
}
