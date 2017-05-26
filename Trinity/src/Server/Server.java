package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket sso = new ServerSocket(7777);
			while (true) {
				System.out.println("hi");
				Socket soc = sso.accept();
				System.out.println("wait");
				ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
				Thread t= new Thread(new ServerThread(oos,ois));
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
