package com.ryang.base;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2021-04-12
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class T2 extends T1{


    @Override
    protected String name() {
        System.out.println("t2");
        return "t2";
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.getClassName();
    }
}
