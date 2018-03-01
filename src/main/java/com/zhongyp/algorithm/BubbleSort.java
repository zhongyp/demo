package com.zhongyp.algorithm;

/**
 * Created by Administrator on 2017/8/13.
 */
public class BubbleSort {

    public static void bubbleSort(){
//        int[] arr = {3,5,7,1,4};
        int[] arr = {1,2,3,4,5};
        int i,j,temp,len=arr.length;
        //是否已经完成排序的标志
        boolean flag;
        //排序
        for(i=0;i<arr.length-1;i++){
            flag = true;
            for(j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if(flag){
                System.out.println("第" + (i+1) + "趟结束了");
                break;
            }
        }
        //遍历输出数组
        for(int o:arr){
            System.out.print(" " + o);
        }
    }

    public static void quickSort(int[] num,int start, int end){
            int sys = num[start];
            int left = start;
            int right = end;

            while(start<end){
                if(num[end]<sys){
                    num[start] = num[end];
                    start++;
                }else{
                    end--;
                    continue;
                }
                if(sys<num[start]){
                    num[end] = num[start];
                    end--;
                }else{
                    start++;
                    continue;
                }
            }
            num[start] = sys;
            if(left<start-1){
                quickSort(num,left,start-1);
            }
            if(right>end+1){
                quickSort(num,end+1,right);
            }

    }
    public static void main(String[] args){
//        bubbleSort();
        int[] arr = {3,5,7,1,4};
        quickSort(arr,0,arr.length-1);
        for(int a:arr){
            System.out.print(a + " ");
        }
    }
}
