package com.ryang.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author renyang
 * @date: 2020/2/9 18:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private Integer age;
    private String name;
    private String sex;

    @Override
    public Object clone() {
        return new User(this.id, this.age, this.name, this.sex);
    }
}
