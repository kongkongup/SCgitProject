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
						System.out.println("ºñÁ¤»óÁ¾·á.");
						break;
					}
					String command = (String) oa[0];
					Object request = oa[1];
					switch (command) {
					case "insertUser":
						oos.writeObject(sm.insertClient((Users) request));
						break;
					case "deleteUser":
						oos.writeObject(sm.deleteClient((String) request));
						break;
					case "updateUser":
						oos.writeObject(sm.updateClient((Users) request));
						break;
					case "updateSpace":
						oos.writeObject(sm.updateSpace((Space) request));
						break;
					case "getAllUsers":
						oos.writeObject(sm.selectAllClient());
						break;
					case "getOneUser":
						oos.writeObject(sm.selectOneClient((String) request));
						break;
					case "login":
						oos.writeObject(sm.login((String)request, (String)oa[2]));
						break;
					case "deleteLog":
						oos.writeObject(sm.deleteLog((String) request));
						break;
					case "getAllLogs":
						oos.writeObject(sm.selectAllLogs());
						break;
					case "getOneUserAllLogs":
						oos.writeObject(sm.selectOneUserAllLogs((String) request));
						break;
					case "getDayAllLogs":
						oos.writeObject(sm.selectDayAllLogs((String) request));
						break;
					case "reservation":
						oos.writeObject(sm.reservation((Reservation_Log) request));
						break;
					case "getEqualJumin":
						oos.writeObject(sm.equalJumin((String) request));
						break;
					default:
						System.out.println("invalid message: "+ command);
						break;					
					}
				}
			} catch (ClassNotFoundException e) {
				exit = true;
				e.printStackTrace();
			} catch (IOException e) {
				exit = true;
				e.printStackTrace();
			} finally {
				try{
					ois.close();
					oos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
	}
	
}
