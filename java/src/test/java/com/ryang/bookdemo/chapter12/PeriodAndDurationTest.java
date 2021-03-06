package com.ryang.bookdemo.chapter12;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @Auther: renyang
 * @Date: 2019/7/3 20:43
 * @Description:
 */
public class PeriodAndDurationTest {

    @Test
    public void duration(){
        // Duration类主要用于以秒和纳秒衡量时间的长短，你不能仅向between方法传递一个LocalDate对象做参数
        LocalDateTime dateTime1 = LocalDateTime.now();
        LocalDateTime dateTime2 = dateTime1.plus(1, ChronoUnit.DAYS);
        Duration duration = Duration.between(dateTime1, dateTime2);// 后面-前面
        System.out.println(duration.toHours());
    }

    @Test
    public void localTime() {
        String localTime = "17:00:00";
        LocalTime localTime1 = LocalTime.parse(localTime);
        System.out.println(localTime1);

        Integer i1 = 300;
        Integer i2 = 300;
        Integer i3 = 200;
        System.out.println(i1 == i2);
        System.out.println(i1 > i3);
    }
}
