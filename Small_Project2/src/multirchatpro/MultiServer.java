package multirchatpro;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {
    static ArrayList<Socket> list = new ArrayList<>();
     
    public static void main(String[] args) throws IOException {
         
        ServerManager manager;
        Socket socket;
        ServerSocket server = new ServerSocket(5252);
        System.out.println("서버 실행 중");
         
        while(true) {
            socket = server.accept(); // 소켓을 기다림
            list.add(socket); // 추가
            manager = new ServerManager(socket);
            manager.start();
        }
    }
 
}

