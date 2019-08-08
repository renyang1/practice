package com.ryang.bookdemo.chapter12;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
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
}
