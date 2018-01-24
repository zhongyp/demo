package com.zhongyp.advanced.pattern.agent;

/**
 * Created by Administrator on 2017/7/4.
 */
public class StudentProxy implements Student{
    String type;
    Student stu;
    public StudentProxy(String type){
        this.type = type;
    }
    @Override
    public void study() {
        if(stu==null){
            try {
                stu = (Student)Class.forName(type).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        stu.study();
    }

    @Override
    public void play(String str) {
        if(stu==null){
            try {
                stu = (Student) Class.forName(type).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        stu.play(str);
    }
}
