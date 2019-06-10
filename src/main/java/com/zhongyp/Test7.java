package com.zhongyp;

import java.io.*;

public class Test7 extends Test8 implements Serializable {

    public Test7(String a){
        super(a);
    }

    transient String a = "a";
    transient int b = 1;
    transient String c = new String();
    Test8 test8 = new Test8("a");
    public static void main(String[] args) {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("test.txt"));
            // 新建实例，并调用父类的有参构造器，设置父类成员变量s的值为77777
            Test7 test7 = new Test7("77777");
            System.out.println("s:" + test7.getS());
            outputStream.writeObject(test7);
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("test.txt"));
            Test7 test71 = (Test7) objectInputStream.readObject();
            // 读取反序列化的出来的test7实例
            System.out.println("s:" + test71.getS());
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
