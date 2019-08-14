package com.zhongyp.advanced.over.hide;

/**
 * @author zhongyp.
 * @date 2019/8/14
 */
public class Test {


    public static void main(String[] args) {
        // 向上强制类型转换
        A a = new B();
        // 此时输出的是A中的name
        System.out.println(a.name);
        // 因为强制类型转换到了B，所以此时输出的是B的name
        System.out.println(((B)a).name);
        // 输出是A的show方法
        a.show();
        // 此时输出的是B的show方法
        ((B)a).show();

        a.testAccess();
    }
}



