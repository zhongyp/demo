package com.zhongyp.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class CQueue {

    Deque deque = new ArrayDeque();

    Stack<Integer> tail;
    Stack<Integer> head;

    public CQueue() {
        tail = new Stack<>();
        head = new Stack<>();
    }

    public void appendTail(int value) {
        deque.add(value);
        tail.add(value);
    }

    public int deleteHead() {
        if(head.size()<=0){
            if(tail.size()<=0){
                return -1;
            }else{
                while(tail.size()>0){
                    head.add(tail.pop());
                }
                return head.pop();
            }
        }else{
            return head.pop();
        }
    }
}
