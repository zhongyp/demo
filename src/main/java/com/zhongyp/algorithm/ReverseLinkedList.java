package com.zhongyp.algorithm;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/6
 * mail: zhongyp001@163.com
 */
public class ReverseLinkedList {

    public static void main(String[] args){
        int[] num = {2,3,4,5,6,7,8};
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Node node = reverseLinkedList.create(num, 0);
        reverseLinkedList.printNode(node);
//        Node node1 = reverseLinkedList.reverse(node);
//        reverseLinkedList.printNode(node1);
//        Node node2 = reverseLinkedList.reverseRecursive(node);
//        reverseLinkedList.printNode(node2);
//        reverseLinkedList.reverseRecursive(node, null);
//        reverseLinkedList.printNode(reverseLinkedList.node4);
    }
    public Node reverse(Node node){
        Node init = null;
        while(node != null){
            Node node1 = init;
            Node node2 = node;
            node = node.next;
            node2.next = node1;
            init = node2;
        }

        return init;
    }



    public Node create(int[] num, int index){
        if(index>=num.length){
            return null;
        }
        Node node = new Node();
        node.value = num[index];
        node.next = create(num, index+1);
        return node;
    }
    public void printNode(Node node){
        while(node != null){
            System.out.print(node.value);
            node = node.next;
        }
        System.out.print("\n");

    }
}
class Node{
    int value;
    Node next;
}