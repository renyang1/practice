package com.ryang.lambda;

/**
 * Description: 请描述你的文件
 *
 * @author renyang
 * @date 2020-12-31
 * <p>
 * All rights Reserved, Designed www.xiao100.com
 */
@FunctionalInterface
public interface UserFactory<R, T, E, V> {

    R get(T t, E e, V v);
}
