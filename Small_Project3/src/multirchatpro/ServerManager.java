package multirchatpro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerManager extends Thread {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    // 서버이기에 in 먼저 일어남
     
    public ServerManager(Socket socket) throws IOException {
        this.socket = socket;
        in= new DataInputStream(socket.getInputStream());
        sendMsg(socket.getPort() + "님이 입장 하였습니다.");
    }
 
    @Override
    public void run() { // 서버는 메시지를 감지해야 하므로 in을 이용
        while(in != null) {
            try {
                sendMsg(socket.getPort()+"> " + in.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    public void sendMsg(String msg) throws IOException { // MultiServer의 List에서 소켓 리스트를 받아옴
        System.out.println(msg);
        for(Socket soc : MultiServer.list) {
            out = new DataOutputStream(soc.getOutputStream());
            out.writeUTF(msg);
            out.flush();
        }
    }
 
 
}

