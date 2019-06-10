package com.zhongyp.concurrency.thread;

import java.util.Vector;

public class MultiClass {

    public static  Vector getVector() {
        return vector;
    }

    public static void setVector(Vector vector) {
        MultiClass.vector = vector;
    }

    private static Vector vector = new Vector();

    public static void main(String[] args) {
        while(true){
            for (int i=0; i<10; i++){
                vector.add(i);
            }
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getVector().size(); i++){
//                        synchronized (vector){
                        (getVector()).remove(i);
//                        setVector(getVector());
//                    }
                    }

                }
            });
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<getVector().size(); i++){
                        (getVector()).get(i);
                    }

                }
            });
            thread.start();
            thread1.start();
            while(Thread.activeCount() > 20) ;

        }
    }
}
