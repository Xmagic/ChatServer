

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {

	@Override
	public void run() {
		//1-65535
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			while (true) {
				//block
				Socket socket = serverSocket.accept();
				//寤虹珛杩炴帴
				JOptionPane.showMessageDialog(null, "A new client has been connected");
				//灏唖ocket浼犻�缁欐柊鐨勭嚎绋�				
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().add(cs);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
