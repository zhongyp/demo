package com.zhongyp.basics.serializable;

import java.io.*;

/**
 * @author zhongyp.
 * @date 2019/5/22
 */
public class SimpleTest {
    public static void main(String[] args) {
        Family family = new Family();
        family.setId("1");
        People people = new People();
        people.setFamily(family);
        people.setName("li");
        people.setPassword("321");
        people.setAge(1);
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("serializable.txt")));
            outputStream.writeObject(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("serializable.txt")));
            People people1 = (People) inputStream.readObject();
            System.out.println(people1);
            System.out.println(people == people1);
            System.out.println(people1.getPassword());

        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
