package com.ryang.reflection;

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
@ToString
@NoArgsConstructor
public class BigDog extends Dog{

    private String color;

    @Override
    public void run() {
        System.out.println("BigDog run...");
    }

}
