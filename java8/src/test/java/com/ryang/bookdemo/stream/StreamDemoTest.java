package com.ryang.bookdemo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: renyang
 * @Date: 2019/7/23 17:08
 * @Description:
 */
public class StreamDemoTest {

    @Test
    public void creatStream() {
        new StreamDemo().creatStream();
    }

    @Test
    public void transformStream() {

    }

    @Test
    public void streamOperation() {
        new StreamDemo().streamIntermediateOperation();
    }
}