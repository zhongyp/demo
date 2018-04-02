package com.zhongyp.algorithm;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/2/28
 * mail: zhongyp001@163.com
 */
public class RadixSort {

    /**
     *
     * 基数排序
     * @param A
     * @param n
     * @return
     *
     * 基数排序思想：求出最大的数是几位的，建10个桶，一个计数器，从个位开始排序，按照数值存入桶中，然后按照顺序取出，置空计数器。接着从十位开始排序，操作和个位一样，直到最大位数。
     *
     */
    public int[] radixSort(int[] A, int n) {
        int length = n;
        int divisor = 1;// 定义每一轮的除数，1,10,100...
        int[][] bucket = new int[10][length];// 定义了10个桶，以防每一位都一样全部放入一个桶中
        int[] count = new int[10];// 统计每个桶中实际存放的元素个数
        int digit;// 获取元素中对应位上的数字，即装入那个桶
        for (int i = 1; i <= 3; i++) {// 经过4次装通操作，排序完成
            for (int temp : A) {// 计算入桶
                digit = (temp / divisor) % 10;
                bucket[digit][count[digit]++] = temp;
            }
            int k = 0;// 被排序数组的下标
            for (int b = 0; b < 10; b++) {// 从0到9号桶按照顺序取出
                if (count[b] == 0)// 如果这个桶中没有元素放入，那么跳过
                {continue;}
                for (int w = 0; w < count[b]; w++) {
                    A[k++] = bucket[b][w];
                }
                count[b] = 0;// 桶中的元素已经全部取出，计数器归零
            }
            divisor *= 10;
        }
        return A;
    }







}
