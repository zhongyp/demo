package com.zhongyp.spring.demo.annotation;

import org.junit.Test;

/**
 * @author zhongyp.
 * @date 2019/7/4
 */
public class TestAnnotation {

    @Test
    public void testNotNull(){
        NullAnnotation.internalNullable(null);
        NullAnnotation.nullable(null);
        NullAnnotation.nonNull(null);
        NullAnnotation.notNull(null);
    }
}
