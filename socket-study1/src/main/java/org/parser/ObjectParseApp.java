package main.java.org.parser;

import com.google.gson.Gson;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ObjectParseApp {
    public static void main(String[] args) {
        //{복붙} String json이 통신역할을 대신 해주는것이다. jsonParseApp에 출력 문장이 ObjectParseApp으로 갔다고 가정.
        String json = "{\"id\":6,\"gubun\":\"입금\",\"sender\":\"ATM\",\"reciver\":\"1111\",\"amount\":100}";
        Gson gson = new Gson();
        Transaction transaction = gson.fromJson(json, Transaction.class); //(파싱할 String, 프로토콜 클래스.class)
        System.out.println("id : "+transaction.getId());
        System.out.println("gubun : "+transaction.getGugun());
        System.out.println("sender : "+transaction.getSender());
        System.out.println("reciver : "+transaction.getReceiver());
        System.out.println("amount : "+transaction.getAmount());
    }
}
