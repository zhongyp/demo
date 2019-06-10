package com.zhongyp;

public class Test8 {

    private int aa = 1;
    private transient String bb = "d";

    private String s;

    public String getS() {
        return s;
    }
    public Test8(){
        System.out.println("父类的无参构造器");
    }

    public Test8(String s){
        this.s = s;
        System.out.println("父类的有参构造器");
    }
}
