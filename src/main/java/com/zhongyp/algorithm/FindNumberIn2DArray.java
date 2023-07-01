package com.zhongyp.algorithm;

public class FindNumberIn2DArray {

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     *  
     *
     * 示例:
     *
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     *
     *  
     *
     * 限制：
     *
     * 0 <= n <= 1000
     *
     * 0 <= m <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /**
     *  解决方法很简单也很复杂，就看你能不能想到规律是啥，有点类似于树
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int dep = matrix.length;
        if(dep <=0){ return false;}
        int width = matrix[0].length;
        if(width<=0){ return false;}
        for(int i=width-1,j=0;i<width&&j<dep;){
            if(target==matrix[j][i]){
                return true;
            }else if(target<matrix[j][i]){
                if(i==0){
                    return false;
                }
                i--;
                continue;
            }else{
                if(j==(dep-1)){
                    return false;
                }
                j++;
            }
        }
        return false;
    }


}
