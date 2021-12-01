package multirchatpro;

import java.net.Socket;

public class MultiClient {
		 
	    public static void main(String[] args) throws Exception {
	        Socket socket = new Socket("192.168.0.92", 5252);
	        System.out.println("연결 성공");
	        ClientReceiver receiver = new ClientReceiver(socket);
	        ClientSender sender = new ClientSender(socket);
	         
	        receiver.start();
	        sender.start();
	    }
	 
	}


