package com.ryang.base.innerclass;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2021-04-13
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class Parcel1 {

    public Contents contents() {
        // 匿名内部类，
        return new Contents() {
            private int i = 11;
            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel1 parcel1 = new Parcel1();
        Contents contents = parcel1.contents();
        System.out.println(contents.value());
    }
}
