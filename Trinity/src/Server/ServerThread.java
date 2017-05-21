package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ServerThread implements Runnable {
	
	private ServerManager sm  = new ServerManager();
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private boolean exit = false;
	
	

	public ServerThread(ObjectOutputStream oos, ObjectInputStream ois) {
		super();
		this.oos = oos;
		this.ois = ois;
	}

	@Override
	public void run() {
		while(!exit){
			try {
				Object[] oa = (Object[]) ois.readObject();
				String command = (String) oa[0];
				Object request = oa[1];
				switch (command) {
				case "insertUser":					
					break;
				case "email":
					break;
				case "deleteUser":
					break;
				case "updateUser":
					break;
				case "getAllUsers":
					break;
				case "getOneUser":
					break;
				case "updateSpace":
					break;
				default:
					break;
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
}
