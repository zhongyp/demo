package com.zhongyp.advanced.pattern.agent;

/**
 *
 */
public class StudentProxy implements Student{
    String type;
    Student stu;
    public StudentProxy(String type){
        this.type = type;
        stu = getInstance();
    }
    @Override
    public void study() {
        stu.study();
    }

    @Override
    public void play(String str) {
        stu.play(str);
    }

    private Student getInstance(){
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
        return stu;
    }
}
