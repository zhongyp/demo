package com.zhongyp.advanced.over.hide;

/**
 * @author zhongyp.
 * @date 2019/6/10
 */
public class A {
    String name = "A";
    static void show(){
        System.out.println("show in A");
    }
    void display(){
        System.out.println("display in A");
    }

    public void testAccess(){
        System.out.println("进A了");
    }

}

class B extends A{
    String name = "B";
    static void show(){
        System.out.println("show in B");
    }
    void display(){
        System.out.println("display in B");
    }
    public void testAccess(){
        System.out.println("进B了");
    }
}
/**
 A
 B
 show in A
 show in B
 display in B
 show in B
 show in B
 */

