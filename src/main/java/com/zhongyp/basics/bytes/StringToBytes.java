package com.zhongyp.basics.bytes;

import java.io.UnsupportedEncodingException;

/**
 * @author zhongyp.
 * @date 2019/8/14
 *
 * String, byte相互转换编码设置问题
 *
 * 结论：进行转换时需要指定编码类型，防止因不同系统的编码不一致导致编码问题
 *
 * 前提小知识：UTF-8编码的汉字是3个字节，GBK是2个字节
 *
 * byte是无编码类型的，getByte(charsetName)是以charsetName类型获取字节流
 *
 * String也是无编码类型的，底层是unicode，new String(str.getBytes("GBK"), "GBK")， 第一个GBK时指GBK类型的字节流，第二个GBK指的是前面的字节流是GBK编码类型
 *
 */
public class StringToBytes {

    public static void main(String[] args) {
        String str = new String("我是中国人！");
        try {
            // 读取byte时，需要制定编码，不指定则使用默认编码（System.out.println(System.getProperty("file.encoding"))）
            String gbkStr = new String(str.getBytes("GBK"), "GBK");
            System.out.println(gbkStr);
            String gbkSs = new String(gbkStr.getBytes("UTF-8"), "UTF-8");
            System.out.println(gbkSs);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
