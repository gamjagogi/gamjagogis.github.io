package main.java.org.ex02;
//자바가 클래스가 필요한 이유.
//객체지향언어는 전부 class로 되어있다.
class SubThread implements Runnable{
    // 서브 쓰레드 (실) (길이는 마찬가지로 run()메서드의 코드 길이)
    @Override
    public void run() {
        System.out.println("실 실행됨");
        try {
            Thread.sleep(100);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}


public class ThreadEx01 {

    //메인 쓰레드 (메인스레드 길이는 메인 코드의 길이이다)
    //메인에 while(true){}가 있다면, 무한 스레드(데몬스레드)가 된다.
    //while(true)에 경우 코드에 Thread.sleep(100) 이런식으로 슬립을 주어야만 한다.
    public static void main(String[] args){
        Thread t1 = new Thread(new SubThread()); //OS야 쓰레드(subthread에있는 run으로 실 하나 만들어줄래?)
                            //new를 해야 class(객체)를 사용할수있기에 new를 해야되는거다.
        t1.start(); // OS가 만들어진 쓰레드로 run()실행

        for(int i = 0; i<6; i++){
            System.out.println("메인 쓰레드 :" +i); //멀티스레드(main,SubThread)이기에 sleep필요
            try {
                Thread.sleep(100); //try catch는 스레드 등 이런 상황일때 사용한다. 스레드 sleep일때 try_catch사용
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }
}
