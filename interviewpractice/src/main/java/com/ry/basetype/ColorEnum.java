package com.ry.basetype;


/**
 * @Auther: renyang
 * @Date: 2018/7/3 18:52
 * @Description: 颜色枚举类
 */
public enum  ColorEnum {
    red(1,"红色"),
    green(2,"绿色"),
    blue(3,"蓝色");

    private String name;
    private int code;

    /*
    * 枚举类必须有一个与定义的枚举中数据类型对应的构造函数，如这里的第一个参数为int,第二个为String
    * */
    private ColorEnum(int code, String name){
        this.code = code;
        this.name = name;
    }

    public static String getName(int code){
        for(ColorEnum c : values()){
            if(c.getCode() == code){
                return c.getName();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
