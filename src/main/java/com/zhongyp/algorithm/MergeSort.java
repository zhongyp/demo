package com.zhongyp.algorithm;

/**
 * Created by zhongyp on 2017/10/15.
 */
public class MergeSort {


    public static void main(String[] args){
        int[] array = {7,5,2,4,1,3,9,0,6,8,1};
        int[] a = sort(array, 0, array.length-1);
        for (int b:a){
            System.out.print(b + " ");
        }
    }


    static int[] sort(int[] a, int start, int end){

        int mid ;
        if(start<end){
            mid = (start + end)/2;
            a = sort(a, start, mid);
            a = sort(a, mid+1, end);
            a = merge(a, start, mid, end);
        }
        return a;
    }

    static int[] merge(int[] a, int start, int mid, int end){
        int i = 0;
        int j = 0;
        int[] c = new int[a.length];
        while((start+i)<=mid&&(mid+1+j)<=end){
            if(a[start+i]>a[mid+1+j]){
                c[i+j] = a[mid+1+j];
                j++;
            }else{
                c[i+j] = a[start+i];
                i++;
            }

        }
        while((start+i)<=mid){
            c[i+j] = a[start+i];
            i++;
        }
        while((mid+1+j)<=end){
            c[i+j] = a[mid+1+j];
            j++;
        }
        for(int k=0;k<=(i+j-1);k++){
            a[start+k] = c[k];
        }
        return a;
    }
}
