package com.ryang.base;

public class AImpl implements A{

    private String msg;

    public AImpl() {

    }

    @Override
    public void M1() {
        System.out.println(msg);
        System.out.println("AImpl: M1()");


    }
}
