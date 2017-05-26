package Manager;

import java.util.ArrayList;

import VO.Reservation_Log;
import VO.Space;
import VO.Users;

public interface CobenManager {
	
	public int insertClient(Users user);
	
	public int deleteClient(String id);
	
	public int updateClient(Users user);
	
	public int updateSpace(Space space);
	
	public ArrayList<Users> selectAllClient();
	
	public Users selectOneClient(String id);
	
	public int login(String id , String password);
	
	public boolean reservation(Reservation_Log log);
	
	public int deleteLog(String log_seq);
	
	public ArrayList<Reservation_Log> selectOneUserAllLogs(String id);
	
	public ArrayList<Reservation_Log> selectAllLogs();
	
	public ArrayList<Reservation_Log> selectDayAllLogs(String date);
	
	public Users equalJumin(String jumin);
	
}
