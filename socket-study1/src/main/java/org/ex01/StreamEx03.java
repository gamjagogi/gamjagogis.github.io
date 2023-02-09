package org.ex01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StreamEx03 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); //버퍼리더를 이렇게 간단하게 만들어둠.(초보자들을 위함)

        InputStream in = System.in; // 키보드를 의미: args배열  //그냥 InpusStream은 A를 받으면 65로 출력.
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);//가변길이의 데이터를 받을수있다.
        //FileReader 이런건 필요없다.
        //BufferedReader, BufferedWdrite 이 두가지가 제일 중요.

        try{
           String inData = br.readLine();
            System.out.println(inData);
        }catch(Exception e){ //AB : 하나씩만 받을수있어서 A만 들어옴 65

        }
    }
}
