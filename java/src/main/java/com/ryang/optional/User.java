package com.ryang.optional;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author renyang
 * @date: 2020/1/1 13:13
 */
@Data
@Accessors(chain = true)
public class User {

    private String name;

    private Integer age;

    private Optional<Car> car;


    public static void main(String[] args) {
        System.out.println(new Date(1632731238082L));
        System.out.println(new Date().compareTo(new Date(1632731238082L)));

    }
}
