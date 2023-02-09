package main.java.org.hdx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class MyClient {
    //GET 요청( 자원을 주세요)
    public MyClient() throws Exception{
        //1. 서버 연결
        Socket socket = new Socket("localhost",10000);
        // 2. 클라이언트가 요청함
        PrintWriter request = new PrintWriter(socket.getOutputStream(),true);
        request.println("html페이지 주세요");

        //3. 클라이언트가 응답을 받음( 반이중)
        BufferedReader reasponse = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
        String msg = reasponse.readLine();
        System.out.println("서버에 요청합니다.");
    }


    public static void main(String[] args){
        try {
            new MyClient();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
