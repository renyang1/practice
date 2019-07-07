package com.ry.exception;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2018/6/19 23:52
 * @Description:
 */
public class TryCatchFinallyTest {

    @Test
    public void test(){
        String s = fun1();
        System.out.println(s);
    }

    public String fun1(){
        String str = "";
        try{
            str = "try";
            return str;
        }catch (Exception e){
            str = "catch";
            return str;
        }finally {
            str = "finally";
        }
    }
}
