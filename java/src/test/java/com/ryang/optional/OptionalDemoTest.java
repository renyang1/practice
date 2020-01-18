package com.ryang.optional;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author renyang
 * @date: 2020/1/6 20:40
 */
public class OptionalDemoTest {

    OptionalDemo optionalDemo = new OptionalDemo();

    @Test
    public void create() {
        optionalDemo.create();
    }

    @Test
    public void optionalMap() {
        optionalDemo.optionalMap();
    }

    @Test
    public void optionalFlatMap() {
        optionalDemo.optionalFlatMap();
    }
}