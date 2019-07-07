package com.ry.suanfa;

import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/2/15 17:30
 * @Description:
 */
public class ReversalPortionStringTest {

    @Test
    public void reversal() throws Exception {
        String original = "asc(uube07beitc";
        String target = "be";
        String result = new ReversalPortionString().reversalPortionString(original, target);
        System.out.println(result);

    }

}