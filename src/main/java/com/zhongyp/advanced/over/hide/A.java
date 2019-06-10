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

    public static void main(String[] args) {
        A a = new B();
        System.out.println(((B) a).name);
        a.show();
        a.display();
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
}
