package com.ryang.base.innerclass;

/**
 * Description: 内部类
 *
 * @author renyang
 * @date 2021-04-01
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class Outer {

    private String outerName;

    private String getName() {
        return outerName;
    }


    /**
     * 内部类
     */
    public class Inner {
        private String innerName;

        public Inner(String name) {
            innerName = name;
        }

        public String getInnerName() {
            return innerName + outerName;
        }
    }

    /**
     * 静态内部类
     */
    public static class StaticInner {
        private String staticInnerName;

        public StaticInner(String name) {
            staticInnerName = name;
        }

        public String getInnerName() {
            return staticInnerName;
        }
    }

    public static void main(String[] args) {
        // 声明静态内部内对象
        StaticInner inner = new StaticInner("ry");
        String innerName = inner.getInnerName();
        System.out.println(innerName);
    }
}
