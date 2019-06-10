package com.zhongyp;

/**
 * @author zhongyp
 */

public enum Operation{
    /**
     * 测试
     */
    PLUS{
        @Override
        public double eval(double x, double y){
            return x+y;
        }
    },
    MINUS{
        @Override
        public double eval(double x, double y){
            return x-y;
        }
    },
    TIMES{
        @Override
        public double eval(double x, double y){
            return x*y;
        }
    },
    DIVIDE{
        @Override
        public double eval(double x, double y){
            return x/y;
        }
    };

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public abstract double eval(double x, double y);

    public static void main(String[] args) {
        System.out.println(Operation.PLUS.eval(4,2));
        System.out.println(Operation.MINUS.eval(4,2));
        System.out.println(Operation.TIMES.eval(4,2));
        System.out.println(Operation.DIVIDE.eval(4,2));
    }
}

