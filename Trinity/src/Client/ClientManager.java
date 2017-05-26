package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import Manager.CobenManager;
import VO.Reservation_Log;
import VO.Space;
import VO.Users;

public class ClientManager implements CobenManager {
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	
	public ClientManager(){
		try {
			Socket so = new Socket("localhost",7777);
			oos = new ObjectOutputStream(so.getOutputStream());
			ois = new ObjectInputStream(so.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Object sendRequest(Object[] request) {
		Object result = null;		
		try {
			oos.writeObject(request);
			result = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return result;
	}

	@Override
	public int insertClient(Users user) {
		int result = 0;
		Object[] request = {"insertUser",user};
		result = (int)sendRequest(request);
		return result;
	}

	@Override
	public int deleteClient(String id) {
		int result = 0;
		Object[] request = {"deleteUser",id};
		result = (int)sendRequest(request);
		return result;
	}

	@Override
	public int updateClient(Users user) {
		int result = 0;
		Object[] request = {"updateUser",user};
		result = (int)sendRequest(request);
		return result;
	}

	@Override
	public int updateSpace(Space space) {
		int result = 0;
		Object[] request = {"updateSpace",space};
		result = (int)sendRequest(request);
		return result;
	}

	@Override
	public ArrayList<Users> selectAllClient() {
		ArrayList<Users> result = null;
		Object[] request = {"getAllUsers",null};
		result = (ArrayList<Users>) sendRequest(request);
		return result;
	}

	@Override
	public Users selectOneClient(String id) {
		Users result = null;
		Object[] request = {"getOneUser",id};
		result = (Users) sendRequest(request);
		return result;
	}

	@Override
	public int login(String id, String password) {
		int result = 0;
		Object[] request = {"login",id,password};
		result = (int) sendRequest(request);
		return result;
	}

	@Override
	public boolean reservation(Reservation_Log log) {
		boolean result = false;
		Object[] request = {"reservation",log};
		result = (boolean) sendRequest(request);
		return result;
	}

	@Override
	public int deleteLog(String log_seq) {
		int result = 0;
		Object[] request = {"deleteLog",log_seq};
		result = (int)sendRequest(request);
		return result;
	}

	@Override
	public ArrayList<Reservation_Log> selectOneUserAllLogs(String id) {
		ArrayList<Reservation_Log> result = null;
		Object[] request = {"getOneUserAllLogs",id};
		result = (ArrayList<Reservation_Log>) sendRequest(request);
		return result;
	}

	@Override
	public ArrayList<Reservation_Log> selectAllLogs() {
		ArrayList<Reservation_Log> result = null;
		Object[] request = {"getAllLogs",null};
		result = (ArrayList<Reservation_Log>) sendRequest(request);
		return result;
	}

	@Override
	public ArrayList<Reservation_Log> selectDayAllLogs(String date) {
		ArrayList<Reservation_Log> result = null;
		Object[] request = {"getDayAllLogs",date};
		result = (ArrayList<Reservation_Log>) sendRequest(request);
		return result;
	}

	@Override
	public Users equalJumin(String jumin) {
		Users result = null;
		Object[] request = {"getEqualJumin",jumin};
		result = (Users) sendRequest(request);
		return result;
	}
	
	
}
