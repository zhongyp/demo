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
        Node node1 = reverseLinkedList.reverse1(node);
        reverseLinkedList.printNode(node1);
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

    /**
     * 递归方式
     * @param node1
     * @return
     */
    public Node reverse1(Node node1){

        Node init = node1.next;
        if(init != null){
            Node node2= reverse1(init);
            Node tmp = getLastNode(node2);
            node1.next = null;
            tmp.next = node1;
            return node2;
        }else{
            return node1;
        }



    }

    public Node getLastNode(Node node){
        Node node1 = null;
        if(node == null){
            return null;
        }
        if(node.next == null){
            node1 = node;
        }else{
            node1 = getLastNode(node.next);
        }
        return node1;
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