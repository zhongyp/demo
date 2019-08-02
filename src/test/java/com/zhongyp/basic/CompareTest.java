package com.zhongyp.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhongyp.
 * @date 2019/7/28
 */
public class CompareTest {

    @Test
    public void test(){
        List<People> peopleList = new ArrayList<People>();
        peopleList.add(new People(8));
        peopleList.add(new People(7));
        peopleList.add(new People(6));
        peopleList.add(new People(5));
        peopleList.add(new People(5));
        peopleList.add(new People(3));
        peopleList.add(new People(5));
        peopleList.add(new People(6));
//        Collections.sort(peopleList);
//        Collections.sort(peopleList, new MyComparator());
//        peopleList.sort(new MyComparator());
        for(People people:peopleList){
            System.out.println(people.age);
        }
    }
}

class People implements Comparable<People>{
    int age;
    public People(int age){
        this.age = age;
    }

    @Override
    public int compareTo(People people) {
        if(this.age > people.age){
            return 1;
        }else if(this.age < people.age){
            return -1;
        }
        return 0;
    }
}

class MyComparator implements Comparator<People>{

    @Override
    public int compare(People o1, People o2) {
        if(o1.age > o2.age){
            return 1;
        }else if(o1.age < o2.age){
            return -1;
        }
        return 0;
    }
}
