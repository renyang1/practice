package com.ryang.base.extend;

public class ConcrectActionA extends AbstractAction{

    private AbstractAction action;

    public ConcrectActionA(AbstractAction action) {
        this.action = action;
    }

    @Override
    public void play1() {
        System.out.println("ConcrectActionA增强play1");
        super.play1();
    }

    @Override
    public void play2() {

        action.play2();
    }
}
