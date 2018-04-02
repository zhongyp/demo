package com.zhongyp.algorithm;

/**
 * Created by Administrator on 2017/8/13.
 */
public class ExchangeSort {

    /**
     *
     * 冒泡排序，这个就不说啦，应该都会
     */
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

    /**
     * 快速排序
     * 1.在数组中选取一个数作为基数
     * 2.将大于这个数的书放在这个数的右边，小于的放在左边
     * 3.然后对左右子区间重复步骤1,2，直到子区间就一个数
     *
     * @param num
     * @param start
     * @param end
     */
    public static void quickSort(int[] num,int start, int end){
            int sys = num[start];// 选取基数
            int left = start;
            int right = end;
            while(start<end){
                while(sys<num[end]&end>left){// 从右端开始，找到一个比基数小的
                   end--;
                }
                if(sys>num[end]){// 找到后替换
                    num[start] = num[end];
                    start++;
                }

                while(sys>num[start]&&start<right){// 然后再从左端开始，找到一个比基数大的
                    start++;
                }
                if(sys<num[start]){// 判断比基数大，替换
                    num[end] = num[start];
                    end--;
                }

            }

            num[start] = sys;// 当start==end时，说明已经给替换完了，把基数放到中间。

            if(left<start-1){// 递归左边的
                quickSort(num,left,start-1);
            }
            if(right>start+1){// 递归右边的
                quickSort(num,start+1,right);
            }

    }
    public static void main(String[] args){
        int[] arr = {3,5,7,1,4,2,8,6,9};
        quickSort(arr,0,arr.length-1);
        for(int a:arr){
            System.out.print(a + " ");
        }
    }
}
