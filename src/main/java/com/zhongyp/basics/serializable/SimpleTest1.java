package com.zhongyp.basics.serializable;

import java.io.*;

/**
 * @author zhongyp.
 * @date 2019/5/22
 */
public class SimpleTest1 {
    public static void main(String[] args) {
        Son son = new Son();
        son.setB("b");
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("serializable.txt")));
            outputStream.writeObject(son);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("serializable.txt")));
            Son son1 = (Son)inputStream.readObject();
            System.out.println(son1.getB());
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
