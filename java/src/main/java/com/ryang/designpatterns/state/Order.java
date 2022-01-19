package com.ryang.designpatterns.state;

import lombok.Data;

@Data
public class Order {

    private Integer orderId;

    private Integer userId;

    private Integer price;

    private Integer status;
}
