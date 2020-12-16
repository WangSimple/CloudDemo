package org.simple.demo.test.reflect;

import java.lang.annotation.*;

/**
 * @description:
 * @author: xpwang
 * @date: 2020-12-16 3:12 下午
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnno {
}
