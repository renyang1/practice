package com.ryang.designpatterns.state;

public class WaitReceiveOrderState extends AbstractOrderState{

    @Override
    public OrderStateEnum type() {
        return OrderStateEnum.WAIT_RECEIVE;
    }
}
