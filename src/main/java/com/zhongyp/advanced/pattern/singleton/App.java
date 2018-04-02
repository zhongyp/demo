package com.zhongyp.advanced.pattern.singleton;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/21
 * mail: zhongyp001@163.com
 */
public class App {
}
class Test1{

    /**
     *
     */
    private Test1 test;
    private Test1(){

    }

    public synchronized Test1 getInstance(){
        test  = new Test1();
        return test;
    }
}

class Test2{
    private static Test2 test= new Test2();

    private Test2() {

    }
    public Test2 getInstance(){
        return test;
    }
}

class Test3{

    private Test3(){}
    public Test3 getInstance(){
        return Test.test;
    }
    public static class Test{
        private static Test3 test = new Test3();
    }
}

class Test4{
    private static volatile Test4 test;

    private Test4(){}

    public Test4 getInstance(){
        if(test == null){
            synchronized (this){
                if (test == null){
                    test = new Test4();
                }
            }
        }
        return test;
    }
}
enum EnumTest {

    INSTANCE;
    private Test test;

    private EnumTest(){
        test = new Test();
    }
    public Test getInstance(){
        return test;
    }
}
class Test{

}