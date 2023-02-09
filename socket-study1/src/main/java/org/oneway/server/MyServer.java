package org.oneway.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {


    public MyServer() throws Exception {
        //1. 서버 대기중
        ServerSocket serverSocket = new ServerSocket(10000); //앱의 Ram번지 포트주소를 소켓에 연결(리스너 서버생성)
        Socket socket = serverSocket.accept();// 클라이언트 연결대기
        System.out.println("클라이언트가 연결되었습니다.");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
        String msg = reader.readLine(); //버퍼에서\n까지 리드라인을 통해 읽는다.
        System.out.println("받은메세지: "+ msg);
    }           //예외처리를 나를 호출한놈에게미룸(애플리케이션쪽 버퍼랑 연결된 파이프 <<< 소켓 >>>> 패킷을 받는 파이프  )

    public static void main(String[] args){
        try {
            new MyServer();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
