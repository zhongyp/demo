package com.zhongyp.algorithm;


import java.util.LinkedList;
import java.util.Stack;

/**
 * project: demo
 * author: zhongyp
 * date: 2018/3/27
 * mail: zhongyp001@163.com
 */

class Tree{
    int value;
    Tree left;
    Tree right;
}

public class BinaryTree {

    /**
     * 先序、中序遍历二叉树
     * 先序：根左右
     * 中序：左根右
     *
     */
    // 标记先序索引位置
    int count = 0;
    public Tree buildTreeByPreMid(int[] a, int s1, int e1, int[] b, int s2, int e2){

        if(s1>e1||s2>e2){
            return null;
        }
        Tree tree = new Tree();
        tree.value = a[count];
        // index为a[s1]在b中的索引
        int index = getIndex(b, a[count]);
        count++;
        // count标识左子树先序的起点，s1+index为左子树先序的终点，s2,index-1分别为左子树中序的起点和终点
        tree.left = buildTreeByPreMid(a, count, s1+index, b, s2, index-1);
        tree.right = buildTreeByPreMid(a, count, s1+e2-index, b, index+1, e2);

        return tree;
    }
    /**
     *
     * 中序、后序 构建二叉树
     *
     */
    int count1 = 7;
    public Tree buildTreeByMidLast(int[] a, int s1, int e1,int[] b, int s2, int e2){
        if(s1>e1||s2>e2){
            return null;
        }
        Tree tree = new Tree();
        tree.value = a[e1];
        int index = getIndex(b, a[e1]);
        count1--;
        tree.right = buildTreeByMidLast(a, count1+index-e2+1, count1, b, index+1, e2);
        tree.left = buildTreeByMidLast(a, s1, count1, b, s2, index-1);
        return tree;
    }
    private int getIndex(int[] b,int value){
        int count = 0;
        for(int tmp:b){
            if(tmp==value){
                return count;
            }
            count++;
        }
        return 0;
    }
    // 先序
    public void printPre(Tree tree){
        if(tree != null){
            System.out.print(tree.value);
        }
        if(tree.left != null){
            printPre(tree.left);
        }
        if(tree.right != null){
            printPre(tree.right);
        }

    }
    // 中序
    public void printMid(Tree tree){
        if(tree.left != null){
            printMid(tree.left);
        }
        if (tree != null){
            System.out.print(tree.value);
        }
        if(tree.right != null){
            printMid(tree.right);
        }

    }
    // 后序
    public void printLast(Tree tree){
        if(tree.left != null){
            printLast(tree.left);
        }
        if(tree.right != null){
            printLast(tree.right);
        }
        if (tree != null){
            System.out.print(tree.value);
        }

    }
    /**
     *
     * 1.将节点放入队列
     * 2.取出队列第一个节点
     * 3.将取出的节点的左右节点一次放入队列
     * 递归
     */
    public void printLevel(Tree tree){
        if(tree == null){
            return;
        }
        Tree current;
        LinkedList list = new LinkedList();
        list.offer(tree);
        while(!list.isEmpty()){
            current = (Tree)list.poll();
            System.out.print(current.value);
            if(current.left != null){
                list.offer(current.left);
            }
            if(current.right != null){
                list.offer(current.right);
            }

        }
    }
    // 二叉树叶子节点个数
    int count2 = 0;
    public void sumLeaf(Tree tree){
        if(tree.left == null&&tree.right == null){
            count2++;
        }
        if(tree.left != null){
            sumLeaf(tree.left);
        }
        if(tree.right != null){
            sumLeaf(tree.right);
        }
    }
    // 二叉树的高度
    public int hightTree(Tree tree){
        if(tree == null){
            return 0;
        }
        if(tree.left == null && tree.right == null){
            return 1;
        }
        int l_hight = hightTree(tree.left);
        int r_hight = hightTree(tree.right);
        return l_hight>r_hight?l_hight+1:r_hight+1;
    }

    // 求两个节点的最近公共祖先
    // 1. 二叉树搜索树
    public Tree lowestCommonAncestor(Tree root, Tree p, Tree q) {

        if(root.value > p.value && root.value > q.value) {
            return lowestCommonAncestor(root.left,p,q);
        }else if(root.value < p.value && root.value < q.value) {
            return lowestCommonAncestor(root.right,p,q);
        }else {
            return root;
        }
    }

    // 2.普通二叉树

    public Tree lowestCommonAncestor1(Tree root, Tree p, Tree q) {
        // 左右子树探索时发现目标节点，则通过返回值标记
        if(root == null || p == root || q == root) {
            return root;
        }

        // 查看左子树中是否有目标结点，没有为null
        Tree l = lowestCommonAncestor1(root.left,p,q);
        // 查看右子树中是否有目标结点，没有为null
        Tree r = lowestCommonAncestor1(root.right,p,q);

        //都不为空，说明做右子树都有目标结点，则公共祖先就是本身
        if(l!= null && r!= null) {
            return root;
        }
        // 其他情况，则要继续向上标记，显示此节点下边有目标节点
        return l != null?l:r;
    }

    // 路径值
    Stack<Integer> stack = new Stack();
    public void FindPath(Tree tree, int sum, int current){
        if(tree==null){
            return ;
        }

        current+=tree.value;
        stack.push(tree.value);
        if(current==sum){
            System.out.println("PATH:");
            for(int val : stack){
                System.out.print(val);
            }
        }
        if(current<sum){
            if(tree.left != null){
                FindPath(tree.left,sum,current);
            }
            if(tree.right != null){
                FindPath(tree.right,sum,current);
            }
        }

        current -= tree.value;
        stack.pop();
    }
}
