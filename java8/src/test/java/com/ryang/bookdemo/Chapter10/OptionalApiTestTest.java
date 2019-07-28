package com.ryang.bookdemo.Chapter10;

import com.ryang.bookdemo.optional.OptionalApiDemo;
import org.junit.Test;

/**
 * @Auther: renyang
 * @Date: 2019/1/24 11:31
 * @Description:
 */
public class OptionalApiTestTest<T> {

    @Test
    public void testFilter() throws Exception {
        optionalApiTest.testFilter();
    }

    @Test
    public void testIfPresent() throws Exception {
        optionalApiTest.testIfPresent();
    }

    @Test
    public void testIsPresent() throws Exception {
        optionalApiTest.testIsPresent();
    }

    @Test
    public void testFlatMap() throws Exception {
        optionalApiTest.testFlatMap();

    }

    @Test
    public void testMap() throws Exception {
        optionalApiTest.testMap();
    }

    @Test
    public void testOrElseThrow() throws Exception {
        optionalApiTest.testOrElseThrow();
    }

    @Test
    public void testOrElseGet() throws Exception {
        optionalApiTest.testOrElseGet();
    }

    @Test
    public void testOrElse() throws Exception {
        optionalApiTest.testOrElse();
    }

    @Test
    public void testOfNullable() throws Exception {
        optionalApiTest.testOfNullable();
    }

    @Test
    public void testOf() throws Exception {
        optionalApiTest.testOf();
    }

    @Test
    public void test() {
        Runnable runnable = ()-> System.out.println("测试");
        Thread thread = new Thread(runnable);
        thread.start();
    }

    OptionalApiDemo optionalApiTest = new OptionalApiDemo();
}
