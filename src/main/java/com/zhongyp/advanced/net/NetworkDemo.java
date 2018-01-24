package com.zhongyp.advanced.net;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Created by camda on 2017/6/21.
 */
public class NetworkDemo {

    public static void main(String args[]){
        try {
            //获取网络接口信息
            Enumeration<NetworkInterface> facelist = NetworkInterface.getNetworkInterfaces();
            if(facelist == null){
                System.out.println("there is no networks");
            }else{
                while(facelist.hasMoreElements()){
                    NetworkInterface work = facelist.nextElement();
                    System.out.println(work.getName());
                    Enumeration<InetAddress> list = work.getInetAddresses();
                    if(!list.hasMoreElements()){
                        System.out.println("no inetaddress");
                    }
                    while (list.hasMoreElements()){
//                        System.out.println(list.nextElement());
                        InetAddress address = list.nextElement();
                        System.out.println((address instanceof Inet4Address?"(v4)":(address instanceof Inet6Address ? "v6" : "?")));
                        System.out.println(address.getHostAddress());
                    }
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        for(String host:args){
            try {
                System.out.println(host);
                InetAddress[] addressList = InetAddress.getAllByName(host);
                for(InetAddress address:addressList){
                    System.out.println(address.getHostName()+address.getHostAddress());
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }



}
