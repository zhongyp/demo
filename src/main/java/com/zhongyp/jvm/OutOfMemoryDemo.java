package com.zhongyp.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongyp.
 * @date 2019/8/11
 */
public class OutOfMemoryDemo {
//    public static void main(String[] args){
//        oom();
//    }
//
//    private static void oom(){
//        Map<String, Pilot> map = new HashMap<String, Pilot>();
//        Object[] array = new Object[1000000000];
//        for(int i=0; i<1000000000; i++){
//            String d = new Date().toString();
//            Pilot p = new Pilot(d, i);
//            map.put(i+"rosen jiang", p);
//            array[i]=p;
//        }
//    }

    private final static int NB_ITERATIONS = 500000000;

    // ~1 KB data footprint

    private final static String LEAKING_DATA_PREFIX = "datadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadatadata";

    // Map used to stored our leaking String instances

    private static Map<String, String> leakingMap;

    static {

        leakingMap = new HashMap<String, String>();

    }


    public static void main(String[] args) {


        try {
            for (int i = 0; i < NB_ITERATIONS; i++) {
                String data = LEAKING_DATA_PREFIX + i;

                // Add data to our leaking Map data structure...

                leakingMap.put(data, data);
            }

        } catch (Throwable any) {

            if (any instanceof java.lang.OutOfMemoryError) {

                System.out.println("OutOfMemoryError triggered! "

                        + any.getMessage() + " [" + any + "]");
            } else {

                System.out.println("Unexpected Exception! " + any.getMessage()

                        + " [" + any + "]");
            }
        }
        System.out.println("simulator done!");

    }


}

