package org.ex01;

import java.io.InputStream;
import java.io.InputStreamReader;

/***
 * Socket - 소켓으로 데이터가 흘러가야 하는 길 (Byte Stream)
 */
public class StreamEx02 {
    public static void main(String[] args){
        InputStream in = System.in; // 키보드를 의미: args배열  //그냥 InpusStream은 A를 받으면 65로 출력.
        InputStreamReader reader = new InputStreamReader(in); // 키보드에 연결된 스트림으로 정수를 받는다.A를 받으면 A로 읽을수있다.
        try{                                    //정수를 char로 인코딩해준다(아스키코드를 바탕으로)
            char[] inData = new char[2]; // 4바이트의 크기의 버퍼를 만듬(고정길이):정해진 길이를 전송할때 사용
            reader.read(inData); //reader에 버퍼를 연결.
            //ABC 입력시 버퍼크기가 4바이트라(char[1] = a 가능) AB만 출력됨
            System.out.println(inData);
        }catch(Exception e){ //AB : 하나씩만 받을수있어서 A만 들어옴 65

        }
    }
}

