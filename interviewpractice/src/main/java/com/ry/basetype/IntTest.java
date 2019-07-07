package com.ry.basetype;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2018/6/20 00:12
 * @Description:
 */
public class IntTest {

    @Test
    public void fin1(){
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        //System.out.println(f1 == f2);
        //System.out.println(f3 == f4);

        Integer a = new Integer(20);
        Integer b = new Integer(20);
        int c = 20;
        System.out.println(a == b);
        System.out.println(a==c);
    }

    @Test
    public void fun2(){
        int a = 0;
        Integer b = new Integer(0);
        String c = "hello";
        StringBuffer d = new StringBuffer("hello");
        increase(a,b,c,d);
    }

    @Test
    public void fun3(){
        int a = 2;
        int b= 3;
        int c = fn(a+b, ++b);
        System.out.println(c);
    }

    public void increase(int a, Integer b, String c, StringBuffer d){

        a++;
        b++;
        c = c + " world";
        d.append(" world");
        System.out.println("a="+ a + ",b=" + b +",c="+c+",d="+d );
    }

    /**
     * Java中函数的参数传递顺序问题
     * */
    public int fn(int a, int b){
        return a+b;
    }
}
