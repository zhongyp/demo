package com.zhongyp.algorithm;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/25
 * mail: zhongyp001@163.com
 */
public class InsertSort {


    /**
     * 直接插入排序算法的空间复杂度为O(1)。
     * 最好的情况，要比较的无序序列原本就是顺序有序的，那么要比较的次数是n-1，移动了0次，时间复杂度O(n)。
     * 最坏的情况，要比较的无序序列原本就是逆序有序的，那么要比较的次数是(n+2)(n-1)/2，移动的次数(n+4)(n-1)/2，时间复杂度O(n²)。
     * 直接插入排序的平均复杂度为O(n²)。
     * 直接插入排序是稳定的。
     * @param num
     */
    public void directInsert(int[] num){
        for(int i=1; i<num.length; i++){
            for(int j=0;j<i;j++){
                if(num[i]<num[j]){
                    int a = num[j];
                    num[j] = num[i];
                    num[i] = a;
                }
            }
        }
        for(int val:num){
            System.out.print(val + " ");
        }
    }

    /**
     * 希尔排序在最坏的情况下的运行时间是O(n²)，平均时间复杂度为O(n^1.3)。希尔排序对于多达几千个数据项的，中等大小规模的数组排序表现良好。希尔排序不像快速排序和其它时间复杂度为O(nlog2n)的排序算法那么快，因此对非常大的文件排序，它不是最优选择。但是，希尔排序比选择排序和插入排序这种时间复杂度为O(n²)的排序算法还是要快得多，并且它非常容易实现。它在最坏情况下的执行效率和在平均情况下的执行效率相比没有差很多。
     此外希尔排序是不稳定的。
     * @param num
     */
    public void hillSort(int[] num){
        int gap = 5;
        while(gap>0){
            for(int i=0; i<num.length-gap; i++){
                if(num[i]>num[i+gap]){
                    int a = num[i];
                    num[i] = num[i+gap];
                    num[i+gap] = a;
                }
            }
            gap = gap/2;
        }
        for(int val:num){
            System.out.print(val + " ");
        }

    }

    public static void main(String[] args){
        int[] num = {4,5,1,2,8,6,7,3,10,9};
        new InsertSort().directInsert(num);
        new InsertSort().hillSort(num);
    }

}
