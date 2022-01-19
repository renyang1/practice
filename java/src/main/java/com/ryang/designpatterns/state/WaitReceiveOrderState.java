package com.ryang.designpatterns.state;

public class WaitReceiveOrderState extends AbstractOrderState{

    @Override
    public Enum type() {
        return OrderStateEnum.WAIT_RECEIVE;
    }
}
