package com.ryang.optional;

import lombok.Data;
import lombok.experimental.Accessors;

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
}
