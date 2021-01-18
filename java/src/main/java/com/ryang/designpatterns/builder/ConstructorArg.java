package com.ryang.designpatterns.builder;

import lombok.ToString;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2021-01-15
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
@ToString
public class ConstructorArg {

    /**
        当 isRef 为 true 的时候，arg 表示 String 类型的
        refBeanId，type 不需要设置；当 isRef 为 false 的时候，arg、type 都需要设置
    */
    private boolean isRef;
    private Class type;
    private Object arg;

    /**
     * 需要通过构造者模式创建的对象的构造方法需要设置为私有,让该对象的创建只能通过构造者模式的build方法创建
     */
    private ConstructorArg (Builder build) {
        this.isRef = build.isRef;
        this.type = build.type;
        this.arg = build.arg;
    }

    /**
     * 建造者类
     * */
    public static class Builder {
        private boolean isRef;
        private Class type;
        private Object arg;

        /**
         * 实例化对象方法，可以统一做入参校验
         * */
        public ConstructorArg build() {
            if (isRef) {
                if (!(arg instanceof String)) {
                    throw new RuntimeException("参数类型错误");
                }
            }else {
                if (arg == null || type == null) {
                    throw new RuntimeException("参数不能为空");
                }
            }
            return new ConstructorArg(this);
        }

        public Builder setRef(boolean ref) {
            isRef = ref;
            return this;
        }

        public Builder setType(Class type) {
            this.type = type;
            return this;
        }

        public Builder setArg(Object arg) {
            this.arg = arg;
            return this;
        }
    }


}
