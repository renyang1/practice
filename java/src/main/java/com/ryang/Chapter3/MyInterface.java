package com.ryang.Chapter3;

import java.io.IOException;

/**
 * @Auther: renyang
 * @Date: 2019/2/21 18:49
 * @Description:
 */
@FunctionalInterface
public interface MyInterface {

    int process(String targetString) throws IOException;
}
