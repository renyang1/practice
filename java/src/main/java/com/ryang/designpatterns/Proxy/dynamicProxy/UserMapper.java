package com.ryang.designpatterns.Proxy.dynamicProxy;

public class UserMapper implements Mapper{

    @Override
    public void select() {
        System.out.println("UserMapper: select()");
    }

    @Override
    public void insert() {
        System.out.println("UserMapper: insert()");
    }
}
