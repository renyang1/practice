package com.ryang.optional;

import com.ryang.vo.Car;
import com.ryang.vo.Insurance;
import com.ryang.vo.User;

import java.util.Optional;

/**
 * @author renyang
 * @date: 2020/1/1 13:11
 */
public class OptionalDemo {

    /**
     * 1.创建Optional对象
     */
    public void create() {

        User user = null;

        // 1.声明一个空的Optional对象
        Optional<User> optionalUser = Optional.empty();
        User user1 = optionalUser.orElse(new User().setName("Unknown").setAge(0));
        System.out.println(user1.toString());

        // 2.根据一个非空值创建Optional，若值为null则立即抛出NullPointerException
//        Optional<User> optionalUser1 = Optional.of(user);

        // 3.可接收null的Optional,如果user为null,则得到的Optional为空对象
        Optional<User> optionalUser2 = Optional.ofNullable(user);
        user = new User();
        user.setName("任洋爱吃肉")
                .setAge(18);
        optionalUser2 = Optional.ofNullable(user);
    }

    /**
     * 2.使用map从Optional对象中提取和转换值
     */
    public void optionalMap() {

        User user = new User();
        user.setName("任洋爱吃肉").setAge(18);

        Car car = new Car();
        car.setName("BMW").setColor("red");
        Optional<Car> optionalCar = Optional.ofNullable(car);
        user.setCar(optionalCar);

        Insurance insurance = new Insurance();
        insurance.setName("平安");
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        car.setInsurance(optionalInsurance);

        // map方法返回值也为Optional对象
        Optional<String> carNameOptional = user.getCar().map(Car::getName);
        System.out.println(carNameOptional.orElse("Unknown"));

        optionalCar = Optional.empty();
        user.setCar(optionalCar);
        carNameOptional = user.getCar().map(Car::getName);
        System.out.println(carNameOptional.orElse("Unknown"));
    }

    /**
     * 3.使用flatMap链接Optional对象，在流中，flatMap会用流的内容替换每个新生成的流，
     * 换句话说，由方法生成的各个流会被合并或者扁平化为一个单一的流。
     * 在Optional中也是如此，会将两层的Optional合并为一个，
     * 也就是会将Optionan<Optional<T>>合并为Option<T>
     */
    public void optionalFlatMap() {

        Insurance insurance = new Insurance();
        insurance.setName("平安");
        Optional<Insurance> insuranceOptional = Optional.ofNullable(insurance);

        Car car = new Car();
        car.setName("奔驰").setColor("black");
        car.setInsurance(insuranceOptional);
        Optional<Car> optionalCar = Optional.ofNullable(car);

        User user = new User();
        user.setName("任洋爱吃肉").setAge(18);
        user.setCar(optionalCar);

        String insuranceName = user.getCar().flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
        System.out.println(insuranceName);
    }


}
