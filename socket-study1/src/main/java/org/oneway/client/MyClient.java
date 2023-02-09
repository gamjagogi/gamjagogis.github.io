package org.oneway.client;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MyClient {
    public MyClient() throws Exception { //throws로 예외발생시 떠넘김.
        //1.서버연결
        Socket socket = new Socket("localhost",10000); //서버의 IP와 포트를 알아야 서버와 연결가능

        //2. 메시지 전송                                                                             프로토콜
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
        writer.write("Hello World");                                        //socket.getOutputStream으로 서버측 소켓과 연결
        writer.write("\n"); // 버퍼에 끝을 알려주는 프로토콜
        writer.flush(); // 버퍼에 담긴 메시지를 전송
    }
    public static void maim(String[] args){
        try {
            new MyClient();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
