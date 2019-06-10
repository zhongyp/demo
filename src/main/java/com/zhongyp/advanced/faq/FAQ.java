package com.zhongyp.advanced.faq;

import org.aspectj.weaver.ast.Instanceof;

/**
 * @author zhongyp.
 * @date 2019/6/10
 */
public class FAQ {
    public static void main(String[] args) {
        /**
         * 变量名称永远不要用l
         * 数字结尾永远不要用l，Long类型使用L
         */
        System.out.println(12345 + 5432l);

        /**
         * byte与int类型比较时，会进行有符号的扩展
         * 窄类型与宽类型比较时特别需要注意符号扩展
         */
        for(byte b = Byte.MIN_VALUE; b<Byte.MAX_VALUE;b++){
            // 如果不加（byte）,则不会输出
            if(b==(byte)0x99){
                System.out.println("Find it");
            }
        }
        /**
         * 宽类型向低类型赋值一定不要用复合操作
         * 复合复制只能是基本类型，基本类型的包装类型以及String，String的复合操作左侧必须是String类型
         * byte<short<char<int<long<float<double
         *
         */
        byte x = 10;
        //byte, char, short 类型的数据在参与运算时会自动转换为int类型,但当使用''+=" 运算符时就不会产生类型转换
        x += 1234;// 此处x不产生类型转换
//        x = x + 1234; // 此处编译错误

        Object taobao = "taobao";
        System.out.println(taobao.getClass().getName());
        String ali = "ali";
        taobao = taobao + ali;
        taobao += ali; //
        System.out.println(taobao.getClass().getName());

        /**
         * 不要指望==
         * 不要指望常量池，尽量不用intern()
         * 不要往常量池扔过多东西，会导致持久代OOM
         */

        StringBuffer s1 = new StringBuffer().append('A').append('B');
        StringBuffer s2 = new StringBuffer('A').append('B');
        StringBuffer s3 = new StringBuffer("A").append("B");
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//false
        System.out.println(s2 == s3);//false

        String s = "who";
        System.out.println("who" == s);// true
        System.out.println("who" == "who"); // true
        System.out.println("who" == new String("who")); // false
        System.out.println("who" == new String("who").intern()); // true
        /**
         * 永远不要命名为java.lang下的类名
         * 包名不能命名为java/javax/java.lang/java.util/javax.sql等开头
         * 永远不能类命名完全一致而实现不一致
         * 尽可能的避免相同名称，尽量不使用默认包
         */

        /**
         * 永远不要用Lable特性
         */
        System.out.print("I love ");
        // Lable标签
        http://www.taobao.com
        System.out.println("taobao!");


        ((FAQ)null).test();
    }

    public static void test(){
        System.out.println("test");
    }

    /**
     * override and hidden
     * hidden:com.zhongyp.over.hide
     *
     */


}
//class String{
//    private final java.lang.String s;
//    public String(java.lang.String s){
//        this.s = s;
//    }
//    public java.lang.String toString(){
//        return s;
//    }
//}