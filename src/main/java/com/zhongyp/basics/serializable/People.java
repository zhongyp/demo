package com.zhongyp.basics.serializable;

import java.io.Serializable;

/**
 * @author zhongyp.
 * @date 2019/5/22
 */
public class People implements Serializable {
    private static final long serialVersionUID = 6962865874928448432L;
    private String name;
    private transient String password;
    private int age;
    private Family family;
    private String sex;
    private String nation;


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
