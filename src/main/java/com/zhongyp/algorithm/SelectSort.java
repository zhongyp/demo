package com.zhongyp.algorithm;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/25
 * mail: zhongyp001@163.com
 */
public class SelectSort {

    /**
     * 选择排序
     * @param num
     */
    public void simpleSort(int[] num){
        for(int i=0;i<num.length;i++){
            int index = i;
            for(int j=i;j<num.length-1;j++){
                if(num[index]>num[j+1]){
                    index = j+1;
                }
            }
            int a = num[i];
            num[i] = num[index];
            num[index] = a;
        }
        for(int val:num){
            System.out.print(val + " ");
        }
    }

    /**
     * 堆排序
     *
     * 堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。
     *
     * 本算法的思想是这样的，通过大顶堆方式，使得在for循环结束时，顶点是最大的，然后把最大的放到最后，数组索引（最长时为length-1）-1，继续执行大顶堆，知道index=1。
     *
     * @param num
     * @param index
     */
    public void heapSort(int[] num, int index){


        for(int i=index/2;i>-1;i--){
            if((2*i)<index&&num[i]<num[2*i]){
                int a = num[i];
                num[i] = num[2*i];
                num[2*i] = a;
            }
            if((2*i+1)<index&&num[i]<num[2*i+1]){
                int a = num[i];
                num[i] = num[2*i+1];
                num[2*i+1] = a;
            }
        }

        int a = num[index];
        num[index] = num[0];
        num[0] = a;
        index = index-1;
        if(index>0){
            heapSort(num,index);
        }

    }





    public static void main(String[] args){
        int[] num = {4,5,1,2,8,6,7,3,10,9};
        new SelectSort().heapSort(num,num.length-1);
        for(int val:num){
            System.out.print(val + " ");
        }
    }
}
