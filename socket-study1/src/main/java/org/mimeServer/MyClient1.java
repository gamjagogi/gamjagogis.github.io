package main.java.org.mimeServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyClient1 {
    private Socket socket;
    private BufferedReader response;
    private BufferedWriter request;
    //GET 요청( 자원을 주세요)
    public MyClient1() throws Exception{
        //1. 서버 연결
        Socket socket = new Socket("localhost",10000);
        Scanner scanner = new Scanner(System.in);
        String requestData = scanner.nextLine();
        // 2. 클라이언트가 요청함
        request = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
        request.write(requestData);
        request.write("\n");
        request.flush();

        //3. 클라이언트가 응답을 받음( 반이중)
        response = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
        String msg = response.readLine();
        System.out.println("서버에 요청합니다."+msg);
    }


    public static void main(String[] args){
        try {
            new MyClient1();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
