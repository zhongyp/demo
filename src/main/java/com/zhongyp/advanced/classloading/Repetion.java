package com.zhongyp.advanced.classloading;
import java.util.*;
/**
 * Created by zhongyp on 2017/6/29.
 *
 * 外部类调用getInstance方法，系统加载Example
 * 类加载完成后，会初始化静态变量
 * 初始化Example时，调用构造函数，构造函数内调用静态变量test，而此时静态变量未被赋值，因此会报错ExceptionInInitializerError
 */
public class Repetion {

    private static Repetion example = new Repetion();

    private static Map<Integer,Boolean> test =
            new HashMap<>();

    private Repetion()
    {
        test.put(1, true);//throw Exception
    }

    public static Repetion getInstance()
    {
        return example;
    }
}
class Main {
    public static void main(String[] args){
        Repetion e = Repetion.getInstance();
    }
}