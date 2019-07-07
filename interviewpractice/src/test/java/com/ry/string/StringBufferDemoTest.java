package com.ry.string;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2018/5/28 14:06
 * @Description:
 */
public class StringBufferDemoTest {
    StringBufferDemo demo = new StringBufferDemo();

    @Test
    public void replaceSpace(){
        StringBuffer sbf = new StringBuffer("We Are Happy.");
        String returnString = demo.replaceSpace(sbf);
        System.out.println(returnString);
    }

    
}
