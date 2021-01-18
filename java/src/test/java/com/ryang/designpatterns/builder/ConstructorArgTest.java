package com.ryang.designpatterns.builder;

import org.junit.Test;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2021-01-18
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class ConstructorArgTest {

    @Test
    public void test() {
        ConstructorArg constructorArg = new ConstructorArg.Builder().setRef(true).setArg("ry").build();
        System.out.println(constructorArg.toString());

    }

}