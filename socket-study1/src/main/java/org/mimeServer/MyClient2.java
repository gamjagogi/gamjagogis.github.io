package main.java.org.mimeServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;


public class MyClient2 {
    private Socket socket;
    private BufferedWriter request;
    private BufferedReader response;
    //GET 요청( 자원을 주세요)
    public MyClient2() throws Exception{
        //1. 서버 연결
        socket = new Socket("localhost",10000);
        //2. 키보드 연결
        Scanner scanner = new Scanner(System.in);
        String requestData = scanner.nextLine();
        // 3 클라이언트가 요청함
        request = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
        request.write(requestData);
        request.write("\n");
        request.flush();
//        PrintWriter request = new PrintWriter(socket.getOutputStream(),true); //printrWrite를 오토flush하려면 이렇게써야함
//        request.println("클라이언트2의 요청 : html주세요");                                //보통은 println사용

        //4. 클라이언트가 응답을 받음( 반이중)
        BufferedReader reasponse = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
        String msg = reasponse.readLine();
        System.out.println("서버에 요청합니다."+msg);
    }


    public static void main(String[] args){
        try {
            new MyClient2();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
