package org.ex01;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class StreamEx04 {
    public static void main(String[] args){
        OutputStream out = System.out; //모니터에 연결된 스트림.
        OutputStreamWriter ow = new OutputStreamWriter(out); //내보내는 연결파이프
        BufferedWriter bw = new BufferedWriter(ow); //버퍼에 작성 -> 버퍼를 OutputStreamWrite에 연결.bw.flush()로 계속 내보냄
        try {
            bw.write("안녕하셈");               //bw에 작성한게 모니터에 출력
            bw.flush();
            //System.out.println(bw); 위에 모든코드가 이것과 같다.
        }catch (Exception e){

        }
    }
}
