package com.zhongyp;

import com.zhongyp.test.A;

import java.io.Serializable;
import java.util.List;

public class Test3 extends A{
    public static void main(String[] args) {

        System.out.println(Day.MONDAY);
//     s   test1(Day.MONDAY);
        System.out.println(Day.MONDAY.toString());
        System.out.println(Day.MONDAY.compareTo(Day.TUESDAY));
        System.out.println(Day.MONDAY.name());
        System.out.println(Day.MONDAY.ordinal());
        System.out.println(Day.valueOf(Day.class, "TUESDAY"));
    }
    public static void test1(Day day){
        System.out.println(day);
    }
    public static void test(List<?> list){
        String str = (String) list.get(1);
    }

    class Test4 implements Serializable {

    }

    static class Test5{

    }
    public enum Day{
        MONDAY,TUESDAY;
    }
    public enum Month{
        ONE,TWO,THREE;
    }
}
