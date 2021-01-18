package com.ryang.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.function.Supplier;


/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-12-31
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
public class Constructor {

    public static void main(String[] args) {
        Supplier<LambdaUser> supplierUser1 = () -> new LambdaUser();
        Supplier<LambdaUser> supplierUser2 = LambdaUser::new;
        UserFactory<LambdaUser, String, Integer, LocalDate> supplierUser3 = LambdaUser::new;
        System.out.println(supplierUser1.get());
        System.out.println(supplierUser2.get());
        System.out.println(supplierUser3.get("ry", 20, LocalDate.now()));
    }

}


@Data
@AllArgsConstructor
@NoArgsConstructor
class LambdaUser {

    private String name;
    private Integer age;
    private LocalDate birthDay;
}