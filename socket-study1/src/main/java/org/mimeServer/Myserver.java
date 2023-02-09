package main.java.org.mimeServer;

import main.java.org.mimeServer.model.Data;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import com.google.gson.Gson;

public class Myserver {

    static int clientCount = 0;
    public Myserver() throws Exception {
        //1. 서버대기중 (메인스레드)
        ServerSocket serverSocket = new ServerSocket(10000); //0번 서버소켓만들고
        while (true) { //while(1)로 리스너를 데몬식으로 사용
            Socket socket = serverSocket.accept(); //1번 메인스레드 대기(리스닝) -> 연결되면 소켓까지 메인스레드가 만듬
            clientCount++;
            System.out.println("클라이언트가 연결되었습니다."); //2번 출력

            //읽고 쓰는 스레드 (서브스레드)    Thread(()->{})잘활용해라. 스레드안에 소스를 작성해야 스레드가 그 소스 기능만 동작
            new Thread(()->{ //3번 새로운 스레드 실행 --> 4번 리스너로 복귀

                try {                      //소스가 동작하는구간에서는, try_catch로 묶어주는게 좋다.
                    //2. 서버요청받음
                    BufferedReader request = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
                    String mimeType = request.readLine();
                    String responseData = parser(mimeType);

                    //3. 테스트를 위해 5초대기
                    Thread.sleep(5000);

                    //4. 서버 응단(반이중)

                    BufferedWriter response = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
                    response.write(responseData); //write로 바이트스트림에 입력할때는, println안된다!
                    response.write("\n");
                    response.flush();
                    System.out.println("클라이언트에게 응답합니다.");
                    socket.close();
                    request.close();
                    response.close();
                    //리드,라이트,소켓을 응답 한번하면 닫히게끔 설정한 것이다.
                }catch (Exception e){
                    e.printStackTrace(); //stack에 쌓인 연달아 찍힌 소스발자취를 출력해서 예외분석하려는 목적
                }
            }).start();

        }
    }
    private String parser(String mimeType){
     Data data = new Data("SocketStudy1","portAndIp");
     if(mimeType.equals(MimeType.TEXT_HTML)){
         return "<body>title: "+data.getTitle()+"<br/> content : "+data.getContent()+"</body>"; //text/html
     }else if(mimeType.equals(MimeType.APPLICATION_JSON)){ //application/json
         Gson gson = new Gson();
         return gson.toJson(data);
     } else if (mimeType.equals(MimeType.FORM_URLENCODED)) { //application/x-www-form=urlencoded
         return "title="+data.getTitle()+"&content="+data.getContent();//웹주소 뒤에 달수있는 형식
     }
        return "badRequest";
    }
    public static void main(String[] args) {
        try {
            new Myserver();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
