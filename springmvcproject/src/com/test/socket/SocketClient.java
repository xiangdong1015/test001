package com.test.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        while (true){
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.next();
            if ("break".equals(msg)){
                break;
            }
            Socket socket = new Socket("localhost", 8888);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("我是客户端："+msg);
            printWriter.flush();

            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String info = null;
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("我是客户端，服务器返回的消息是："+info);
            }
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        }

    }
}
