package com.zhongyp;
public class NNode<T> {

    public T data;

    public NNode(T data) { this.data = data; }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }


}

