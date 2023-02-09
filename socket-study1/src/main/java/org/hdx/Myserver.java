package main.java.org.hdx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Myserver {
    public Myserver() throws Exception {
        //1. 서버대기중
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket socket = serverSocket.accept(); //리스너
        System.out.println("클라이언트가 연결되었습니다.");

        //2. 서버요청받음
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
        String msg = br.readLine();
        System.out.println("클라이언트에게서 요청이 왔습니다 :" + msg);

        //3. 서버 응단(반이중)
        //BufferdWriter , new OutputStreamWriter
        PrintWriter response = new PrintWriter(socket.getOutputStream(), true);//오토 플러쉬사용
        response.println("<html><h1>hello</h1></html>");
        response.write("<html><h1>hello</h1></html>");
        System.out.println("클라이언트에게 응답합니다.");
    }

    public static void main(String[] args) {
        try {

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
