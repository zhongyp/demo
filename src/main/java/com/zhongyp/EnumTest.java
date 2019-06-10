package com.zhongyp;

import java.math.RoundingMode;

public class EnumTest {
    public static final int STYLE_BOLD =1 << 0;
    public static final int STYLE_ITALIC =1 << 1;

    public void applyStyles(int styles){
        System.out.println(styles);
    }
}
class TestABC{
    public static void main(String[] args) {
        EnumTest enumTest = new EnumTest();
        System.out.println(EnumTest.STYLE_BOLD);
        System.out.println(EnumTest.STYLE_ITALIC);
        enumTest.applyStyles(EnumTest.STYLE_BOLD|EnumTest.STYLE_ITALIC);
    }
}
