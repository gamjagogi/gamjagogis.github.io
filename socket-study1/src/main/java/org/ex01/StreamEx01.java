package org.ex01;

import java.io.InputStream;

/***
 * Socket - 소켓으로 데이터가 흘러가야 하는 길 (Byte Stream)
 */
public class StreamEx01 {
    public static void main(String[] args){
        InputStream in = System.in; // 키보드를 의미: args배열

        try{
            int inDate = in.read(); //in에 들어온걸 읽는 메서도
            System.out.println(inDate);  //A=65(아스키코드)
        }catch(Exception e){ //AB : 하나씩만 받을수있어서 A만 들어옴 65

        }
    }
}
