package com.ryang.base;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2021-04-12
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class T1 {

    public String getClassName() {
        System.out.println(this.name());
        return this.name();
    }

    protected String name() {
        System.out.println("t1");
        return "t1";
    }
}
