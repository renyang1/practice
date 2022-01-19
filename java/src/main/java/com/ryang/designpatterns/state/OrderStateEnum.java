package com.ryang.designpatterns.state;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStateEnum {

    WAIT_PAY(0, "待支付"),
    WAIT_DELIVER(1, "待发货"),
    WAIT_RECEIVE(2, "待收货"),
    REFUNDING(3, "退款中"),
    FINISH(10, "已完成"),
    REFUNDED(11, "已退款"),
    ;

    private Integer code;
    private String desc;

    public static OrderStateEnum getEnumByCode(Integer code) {
        for (OrderStateEnum stateEnum : values()) {
            if (stateEnum.getCode().equals(code)) {
                return stateEnum;
            }
        }
        throw new RuntimeException("code非法");
    }

}
