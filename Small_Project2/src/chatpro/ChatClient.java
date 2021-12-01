package chatpro;

import java.net.Socket;

public class ChatClient {

		 
	    public static void main(String[] args) {
	        try {
	            // 1. 소켓 생성
	            Socket socket = new Socket("192.168.56.1", 5001); // 2. 연결 요청
	            // 3. 받기 전용 스레드 실행
	            Receiver receiver = new Receiver(socket);
	            receiver.start();
	            // 4. 전송 전용 스레드 실행
	            Sender sender = new Sender(socket);
	            sender.start();
	        } catch (Exception e) {
	            System.out.println(e.toString());
	        }
	    }
	 
	}


