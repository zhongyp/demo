package com.zhongyp.spring.demo.annotation;


import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import lombok.NonNull;

/**
 * @author zhongyp.
 * @date 2019/7/4
 */
public class NullAnnotation {


//    @Nullable
    public static String nullable(@Nullable String b){
        System.out.println(b);
        return b;
    }

//    @NotNull
    public static String notNull(@NotNull String b){
        System.out.println(b);
        return b;
    }

//    @com.sun.istack.internal.Nullable
    public static String internalNullable(@com.sun.istack.internal.Nullable String b){
        System.out.println(b);
        return b;
    }
    @NonNull
    public static String nonNull(@NonNull String b){
        System.out.println(b);
        return b;
    }

    public static void main(String[] args) {
        NullAnnotation.notNull(null);
        NullAnnotation.nonNull(null);
        NullAnnotation.nullable(null);
    }
}
