package com.ry.suanfa;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: renyang
 * @Date: 2019/4/24 10:44
 * @Description:
 */
public class Case2Test {

    @Test
    public void stringIsSymmetry() {
        boolean result = new Case2().stringIsSymmetry("aab");
        System.out.println(result);
    }
}