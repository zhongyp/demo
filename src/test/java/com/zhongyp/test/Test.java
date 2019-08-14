package com.zhongyp.test;

import java.util.Comparator;

/**
 * @author zhongyp.
 * @date 2019/7/25
 */
public class Test {

//    static int a = 1;
//    int b = 2;
//
//    public Test (){
//        System.out.println("构造" + a + b);
//    }
//    {
//        System.out.println("普通方法块" + a + b);
//    }
//    static {
//        System.out.println("静态方法块" + a);
//        Test test = new Test();
//        System.out.println(test.b);
//        Arrays.asList();
//    }

//    public static void get(int i){
//        List list =  new ArrayList();
//
//    }
//
//    public static void get(Integer i){
//        List list =  new ArrayList();
//
//    }

//    String a = "b";
//
//    int b = 1;
//
//    Integer c = 2;

//    String a = new String("abc");
//    String b = new String("abc");
//    String c = "abc";
//    String d = new String("abc");

    public static void main(String[] args) {

        Object obj = "something";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            String a = (String)obj;
        }
        System.out.println(System.currentTimeMillis()-start);

//        ClassStructureDemo classStructureDemo = new ClassStructureDemo();
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);
//        Test test = new Test();
//        test.a.intern();
//        System.out.println(test.a==test.b);
//        System.out.println(test.a==test.c);
//        test.d.intern();
//        System.out.println(test.a==test.d);
//        JavaBean javaBean = new JavaBean();
//        Integer i = new Integer(3);
//        get(i);
//        get(3);

//        ReentrantLock reentrantLock;
//
//        new HashMap();

//        List<String> list = new ArrayList<>(10);
//        System.out.println(list.size());
//        list.add(null);
//        list.add(null);
//        System.out.println(list.size());
//        System.out.println(list.get(0));
//        list.add("1");
//        list.add("2");
//        Iterator iterator = list.iterator();
//        HashMap map = new HashMap();
//        map.put("abcdkd", "ddad8");
//        map.put("abcdkd3", "ddad6");
//        map.put("abcdkd2", "ddad7");
//        map.put("abcdkd1", "ddad9");
//        map.put("abcdkd5", "ddad1");
//        List<String> list = new ArrayList<>(map.values());
//        Collections.sort(list, new MyComparator());
//        for(String key:list){
//            System.out.println(key);
//        }
//        int i=0;
//        if(i==0){
//            i=1;
//        }else if(i==1){
//            System.out.println("good");
//        }else{
//            System.out.println("bad");
//        }
//


//        while (iterator.hasNext()){
//            String item = (String) iterator.next();
//            if("1".equals(item)){
//                iterator.remove();
//            }
//        }
//        for(String it:list){
//            if("1".equals(it)){
//                list.remove(it);
//            }
//        }

//        StringBuffer sql = new StringBuffer();
//        sql.append(" select distinct d.chr_code1 vtcode, d.chr_name addr, c.chr_code stamp ");
//        sql.append("   from epay_conf_addr_action a, ");
//        sql.append("      epay_conf_addr_stamp    b, ");
//        sql.append("      epay_stamp              c, ");
//        sql.append("      epay_billtypeaddr       d  ");
//        sql.append("  where a.action_id = ? ");
//        sql.append("   and d.chr_code1 = ? ");
//        sql.append("   and a.addr_id = b.addr_id ");
//        sql.append("   and b.stamp_id = c.chr_id ");
//        sql.append("   and a.addr_id = d.chr_id ");
//        sql.append("   and a.rg_code = b.rg_code " +
//                "   and a.rg_code = c.rg_code " +
//                "   and a.rg_code = d.rg_code  " +
//                "   and a.set_year = b.set_year " +
//                "   and a.set_year = c.set_year " +
//                "   and a.set_year = d.set_year ");
//        sql.append(" and a.rg_code = ? and a.set_year = ? ");
//        sql.append("    and exists (select 1 from epay_conf_stamp_user e ");
//        sql.append("         where c.chr_id = e.stamp_id and e.user_id = ? and e.rg_code = ? and e.set_year = ? ) ");
//        sql.append("    and exists (select 1 from epay_conf_sn_stamp f,epay_sn g  ");
//        sql.append("     where c.chr_id = f.stamp_id and g.chr_id = f.sn_id and f.rg_code = g.rg_code and f.set_year = g.set_year and f.rg_code = ? and f.set_year = ? and g.chr_code = ? ) ");
//
//        System.out.println(sql.toString());
    }
}
class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
class A{
    public void test(){}
}
class B extends A{
    public void test(){}
}