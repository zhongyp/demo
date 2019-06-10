package com.zhongyp;

import java.util.ArrayList;
import java.util.List;

public class Test10<T> {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<?> lb = (List<?>) integerList;
    }
    <E> void changePosition(E[] t){

    }

    <E> void test(List<? extends T> list, E a ){

    }
}
