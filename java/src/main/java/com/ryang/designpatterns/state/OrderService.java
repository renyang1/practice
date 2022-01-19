package com.ryang.designpatterns.state;

public class OrderService {

    /**
     * 订单发货
     * @param orderId
     */
    public void deliver(Integer orderId) {
        // 这里的订单数据应该从数据库中查询得到, orderMapper.getById(orderId);
        Order order = new Order();
        order.setOrderId(orderId);
        order.setStatus(OrderStateEnum.WAIT_DELIVER.getCode());

        // 这个可以从工厂中获取单例对象，通过ApplicationContextAware接口在容器启动时完成实例化
        // AbstractOrderState currentState = OrderStateFactory.getState(OrderStateEnum.getEnumByCode(order.getStatus()));
        AbstractOrderState orderState = new WaitDeliverOrderState();

        OrderStateContext context = new OrderStateContext();
        context.setOrderState(orderState);
        context.deliver(order);
    }

    public static void main(String[] args) {
        new OrderService().deliver(1);
    }
}
