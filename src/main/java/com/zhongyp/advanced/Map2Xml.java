package com.zhongyp.advanced;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongyp.
 * @date 2019/6/5
 */
public class Map2Xml {
    public static void main(String[] args) {



        Map map1 = new HashMap<>();
        Map map2 = new HashMap<>();
        Map map3 = new HashMap<>();
        map1.put("1","1");
        map2.put("2","2");
        map3.put("3","3");
        map1.put("11","11");
        map2.put("21","21");
        map3.put("31","31");
        List list = new ArrayList();
        list.add(map1);
        list.add(map2);
        list.add(map3);
        Map map4 = new HashMap();
        map4.put("map4", list);
        map4.put("map41", list);
        List list1 = new ArrayList();
        list1.add(map4);
        Map map5 = new HashMap();
        map5.put("map5", list1);
        System.out.println(map5);
        try {
            System.out.println(convertObjToXml(map5, "row"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String convertObjToXml(Map map, String rootName) throws Exception {
        rootName = rootName != null && !rootName.equalsIgnoreCase("") ? rootName : "data";
        if (map == null) {
            return "<" + rootName + "></" + rootName + ">";
        } else {
            Document doc = null;
            StringWriter stringwriter = null;
            XMLWriter writer = null;
            OutputFormat format = null;

            String var6;
            try {
                doc = DocumentHelper.createDocument();
                doc.add(constructElement(map, rootName));
                stringwriter = new StringWriter();
                format = OutputFormat.createPrettyPrint();
                format.setEncoding("GBK");
                writer = new XMLWriter(format);
                writer.setWriter(stringwriter);
                writer.write(doc);
                var6 = stringwriter.toString();
            } catch (Exception var10) {
                throw new Exception("传入的Map对象不符合要求,无法正常转换成xml串!");
            } finally {
                doc = null;
                stringwriter = null;
                writer = null;
                format = null;
            }

            return var6;
        }
    }
    protected static Element constructElement(Map map, String eleName) {
        Object[] object = map.keySet().toArray();
        Element element = DocumentHelper.createElement(eleName);

        for(int i = 0; i < object.length; ++i) {
            if (map.get(object[i]) instanceof String) {
                element.addAttribute((String)object[i], (String)map.get(object[i]));
            } else if (map.get(object[i]) instanceof Map) {
                element.add(constructElement((Map)map.get(object[i]), (String)object[i]));
            } else if (map.get(object[i]) instanceof List) {
                List ls = (List)map.get(object[i]);

                for(int j = 0; j < ls.size(); ++j) {
                    element.add(constructElement((Map)ls.get(j), (String)object[i]));
                }
            }
        }

        return element;
    }
}
