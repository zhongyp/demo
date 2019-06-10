package com.zhongyp.concurrency.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadBlockingIO {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            // 阻塞直到有客户端连接上
            Socket clientSocket = serverSocket.accept();
            try {
                process(clientSocket);
            } catch (Exception e) {
                e.printStackTrace();
                clientSocket.close();
            }
        }
    }

    private static void process(Socket clientSocket) throws Exception {
        System.out.println("client socket连接:" + clientSocket.getRemoteSocketAddress());
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        while (true) {
            // 阻塞直到客户端发送数据
            String readLine = in.readLine();
            System.out.println("来自客户端的消息:" + readLine);
            if ("end".equals(readLine)) {
                break;
            } else {
                out.write("welcome from server.");
                out.newLine();
                out.flush();
            }
        }
    }
}