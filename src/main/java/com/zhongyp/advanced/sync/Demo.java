package com.zhongyp.advanced.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/20
 * mail: zhongyp001@163.com
 */
public class Demo {


    public synchronized void objectLock(){

    }

    public static synchronized void classLock(){

    }

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition1 = lock.newCondition();
    Boolean flag = false;
    public void objectLockSail(){
        try {
            lock.lock();

            while (!flag){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "卖");
            flag=false;
            condition1.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void objectLockProduct(){
        try {
            lock.lock();

            while (flag){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "买");
            flag=true;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
