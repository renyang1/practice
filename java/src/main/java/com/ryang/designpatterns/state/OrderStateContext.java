package com.ryang.designpatterns.state;

public class OrderStateContext {

    // 当前状态
    private AbstractOrderState orderState;

    public AbstractOrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(AbstractOrderState orderState) {
        this.orderState = orderState;
    }

    /**
     *
     * 发起支付
     * @param order
     */
    public void pay(Order order){
        orderState.pay(this, order);
    }

    /**
     * 订单发货
     *
     * @param order
     */
    void deliver(Order order) {
        orderState.deliver(this, order);
    }

    /**
     * 订单收货
     *
     * @param order
     */
    void receive(Order order) {
        orderState.receive(this, order);
    }

    /**
     * 申请售后
     *
     * @param order
     */
    void applyRefund(Order order) {
        orderState.applyRefund(this, order);
    }

    /**
     * 退款完成
     *
     * @param order
     */
    void finishRefund(Order order) {
        orderState.finishRefund(this, order);
    }

}
