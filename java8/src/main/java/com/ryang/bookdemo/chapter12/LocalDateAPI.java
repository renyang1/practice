package com.ryang.bookdemo.chapter12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @Auther: renyang
 * @Date: 2018/9/15 15:59
 * @Description: java8中时间API类LocalDate类相关用法
 */
public class LocalDateAPI {

    /**
     * LocalDate常用API的使用
     * */
    public void regularlyApi(){

        String dataString = "2018-09-15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(dataString, df);
        date1 = date1.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(date1);
    }
}
