package com.zhongyp.advanced.pattern.observer.jdkobserver;


import java.util.Observable;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/26
 * mail: zhongyp001@163.com
 */
public class ObserverTest{

    public static void main(String[] args) {
        SpecialRepoter repoter = new SpecialRepoter();
        PeopleDaily n2 = new PeopleDaily(repoter);

        repoter.getNewNews("new news!");
        n2.remove();
        repoter.getNewNews("another new news!");
    }

}
