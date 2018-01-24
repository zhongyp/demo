package com.zhongyp.advanced.pattern.agent;

/**
 * Created by Administrator on 2017/7/4.
 */
public class XiaoMing implements Student {

    public XiaoMing(){
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void study() {
        System.out.println("day day up");
    }

    @Override
    public void play(String str) {
        System.out.println("we are playing" + str);
    }
}
