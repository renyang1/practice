package com.ry.string;

/**
 * @Auther: renyang
 * @Date: 2018/5/28 14:04
 * @Description: 对StringBuffer类的使用练习
 */
public class StringBufferDemo {

    /**
     * Description:请实现一个函数，将一个字符串中的空格替换成“%20”。
     *             例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2018/5/28 13:58
     */
    public String replaceSpace(StringBuffer str){

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                str.deleteCharAt(i);
                str.insert(i,"%20");
            }
        }
        return str.toString();
    }
}
