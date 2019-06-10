package com.zhongyp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        File file = new File("/Users/zhongyp/Downloads/关键字.txt");
        String txt = "";
        try {
            Scanner in=new Scanner(file);
            while(in.hasNext()){
                String str=in.nextLine();
                txt += str;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] words = txt.split(" ");
        List<String> processList = new ArrayList<String>();

        String shpath="/Users/zhongyp/Downloads/test.sh";//.sh文件的绝对路径
        String command = "/bin/sh " + shpath;
            try {
                Process process = Runtime.getRuntime().exec(command);
                BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = "";
                while ((line = input.readLine()) != null) {
                    processList.add(line);
                }
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        for (String line:processList){
            System.out.println(line);
        }
    }

}
