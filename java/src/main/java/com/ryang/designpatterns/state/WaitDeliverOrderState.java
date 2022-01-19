package com.ryang.designpatterns.state;

public class WaitDeliverOrderState extends AbstractOrderState {

    @Override
    public Enum type() {
        return OrderStateEnum.WAIT_DELIVER;
    }

    /**
     * 发货
     *
     * @param context
     * @param order
     */
    @Override
    public void deliver(OrderStateContext context, Order order) {
        OrderStateEnum newState = OrderStateEnum.WAIT_RECEIVE;
        order.setStatus(newState.getCode());
        // 更新数据库订单状态
        // orderMapper.update(order);

        // 更新上下文状态
        context.setOrderState(new WaitReceiveOrderState());
        System.out.println("订单号：" + order.getOrderId() + "发货成功! 订单状态流转至" + newState.getDesc());

    }
}
