package Server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketException;
import VO.Reservation_Log;
import VO.Space;
import VO.Users;

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
			try {
				Object[] oa = null;
				while(!exit){
					try{
						oa = (Object[]) ois.readObject();						
					}catch (SocketException e) {
						System.out.println("¿¬°á ²÷±è.");
						break;
					}catch (EOFException e) {
						e.printStackTrace();
						ois.close();
					}
					Object response = null;
					String command = (String) oa[0];
					Object request = oa[1];
					switch (command) {
					case "insertUser":
						response = sm.insertClient((Users) request);
						break;
					case "deleteUser":
						response = sm.deleteClient((String) request);
						break;
					case "updateUser":
						response = sm.updateClient((Users) request);
						break;
					case "updateSpace":
						response = sm.updateSpace((Space) request);
						break;
					case "getAllUsers":
						response = sm.selectAllClient();
						break;
					case "getOneUser":
						response = sm.selectOneClient((String) request);
						break;
					case "login":
						response = sm.login((String)request, (String)oa[2]);
						break;
					case "deleteLog":
						response = sm.deleteLog((String) request);
						break;
					case "getAllLogs":
						response = sm.selectAllLogs();
						break;
					case "getOneUserAllLogs":
						response = sm.selectOneUserAllLogs((String) request);
						break;
					case "getDayAllLogs":
						response = sm.selectDayAllLogs((String) request);
						break;
					case "reservation":
						response = sm.reservation((Reservation_Log) request);
						break;
					case "getEqualJumin":
						response = sm.equalJumin((String) request);
						break;
					default:
						System.out.println("invalid message: "+ command);
						break;					
					}
					oos.writeObject(response);
					oos.reset();
				}
				
			} catch (ClassNotFoundException e) {
				exit = true;
				e.printStackTrace();
			} catch (IOException e) {
				exit = true;
				e.printStackTrace();
			} 
	}
	
}
