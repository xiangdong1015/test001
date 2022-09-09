package com.test.socket;

import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable {
    private Socket socket = null;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintWriter printWriter = null;
        OutputStream outputStream = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("我是服务器，接收到的信息是："+info);
            }
            socket.shutdownInput();
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.next();
            printWriter.write("我是服务器:"+msg);
            printWriter.flush();
        } catch (Exception e){

        } finally {
            try {
                if (null != printWriter){
                    printWriter.close();
                }
                if (null != outputStream){
                    outputStream.close();
                }
                if (null != outputStream){
                    bufferedReader.close();
                }
                if (null != outputStream){
                    inputStreamReader.close();
                }
                if (null != outputStream){
                    inputStream.close();
                }
                if (null != outputStream){
                    socket.close();
                }
            } catch (Exception e){

            }
        }
    }
}
