package com.ryang.base.extend;

import lombok.Data;

/**
 * describe:货位库存信息
 * @author : gengxiang
 * creat_time: 2018/12/7 23:01
 * version V1.0
 **/
@Data
public class LocationInventory {

    /**
     * 商品编码
     */
    private String goodsSn;

    /**
     * 尺码
     */
    private String size;

    /**
     * 库区id
     */
    private Integer areaId;

    /**
     * 货位id
     */
    private Integer locationId;

    /**
     * 货位
     */
    private String location;

    /**
     * 货位拣货顺序
     */
    private String pickOrder;

    /**
     * 货位类型
     */
    private Byte locationType;

    /**
     * 库存数量
     */
    private Integer inventoryNum;

    /**
     * 子仓id
     */
    private Integer subWarehouseId;

    /**
     * 是否是中心仓
     */
    private Byte subWarehouseType;

    /**
     * 补货优先级
     */
    private int replenishPriority;

    /**
     * skuCode
     */
    private String skuCode;
}
