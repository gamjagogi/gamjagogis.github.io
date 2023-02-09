package main.java.org.mimeServer;
//가장 많이쓰는 json
public interface MimeType {
    String APPLICATION_JSON = "application/json"; //{"title":"제목","content":"내용"}
    String TEXT_HTML = "text/html"; //<html>title : 제목 <br/>content : 내용 </html>
    String FORM_URLENCODED = "application/x-www-form-urlencoded"; //title=제목&content=내용
                                                                    //웹주소 뒤에 붙일수있는 쿼리스쿼리라고 한다.
    //이렇게 만들어줘야지 반복해서 쓰기 편함
    //열거형으로 보통 만들기도한다.
}
