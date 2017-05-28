package Server;




import java.util.ArrayList;
import DAO.LogDAO;
import DAO.SpaceDAO;
import DAO.UsersDAO;
import Manager.CobenManager;
import VO.Reservation_Log;
import VO.Space;
import VO.Users;

/*2017.05.22 ±è¿µÇö*/
public class ServerManager implements CobenManager {
	
	private SpaceDAO sDAO = new SpaceDAO();
	private UsersDAO uDAO = new UsersDAO();
	private LogDAO lDao = new LogDAO();
	
	@Override
	public int insertClient(Users user){
		int result = 0;
		Users checkId = selectOneClient(user.getUser_ID());
		Users checkJumin = uDAO.equalJumin(user.getJumin());
		if(checkId==null && checkJumin==null){
			result = uDAO.insertUser(user);
			//Mail m = new Mail(user);
		}		
		return result;
	}

	@Override
	public int deleteClient(String id){
		int result = 0;
		uDAO.deleteUser(id);
		return result;
	}
	
	@Override
	public int updateClient(Users user){
		int result = 0;
		result = uDAO.updateUser(user);
		return result;
	}
	
	@Override
	public int updateSpace(Space space){
		int result = 0;
		result = sDAO.updateSpace(space);
		return result;
	}

	@Override
	public ArrayList<Users> selectAllClient(){
		ArrayList<Users> result = null;
		result = uDAO.selectAllUsers();		
		return result;
	}
	
	@Override
	public Users selectOneClient(String id){
		Users result = null;
		if(uDAO.selectOneUser(id)!=null){
			result = uDAO.selectOneUser(id);
		}
		return result;
	}
	
	@Override
	public int login(String id , String password){
		int result = 0;
		Users userInformation = uDAO.selectOneUser(id);
		if(userInformation!=null){
			if(userInformation.getPassword().equals(password)){
				result = 1;
			}else{
				result = 2;
			}			
		}
		return result;
	}
	
	@Override
	public boolean reservation(Reservation_Log log){
		boolean result = false;
		ArrayList<Reservation_Log> logList = lDao.selectAllLogs();
				
			
			if(!logList.isEmpty()){
				for (Reservation_Log reservation_Log : logList) {										
					if(reservation_Log.getRoom_name().equals(log.getRoom_name())){
						
						if(log.getDate().equals(reservation_Log.getDate()) &&
								log.getStart_time()==reservation_Log.getStart_time() ||
								log.getEnd_time()==reservation_Log.getEnd_time()){
							return result;
							
						}else if(reservation_Log.getEnd_time()<log.getStart_time()){
							return result;
							
						}else if(log.getUser_id().equals(reservation_Log.getUser_id()) &&
								log.getDate().equals(reservation_Log.getDate())){
							return result;
							
						}else if(log.getDate().equals(reservation_Log.getDate()) &&
								log.getStart_time()==reservation_Log.getStart_time()){
							return result;
							
						}					
					}
				}
				lDao.insertLog(log);
				result = true;
			}else{
				lDao.insertLog(log);
				result = true;
			}		
			
		return result;
	}

	@Override
	public int deleteLog(String log_seq) {
		int result = 0;
		result = lDao.DeleteLog(log_seq);
		return result;
	}

	@Override
	public ArrayList<Reservation_Log> selectOneUserAllLogs(String id) {
		ArrayList<Reservation_Log> result = null;
		result = lDao.selectOneUserAllLogs(id);
		return result;
	}

	@Override
	public ArrayList<Reservation_Log> selectAllLogs() {
		ArrayList<Reservation_Log> result = null;
		result = lDao.selectAllLogs();
		return result;
	}

	@Override
	public ArrayList<Reservation_Log> selectDayAllLogs(String date) {
		ArrayList<Reservation_Log> result = null;
		result = lDao.selectDayAllLogs(date);
		return result;
	}

	@Override
	public Users equalJumin(String jumin) {
		Users result  = null;
		if(uDAO.equalJumin(jumin)!=null){
			result = uDAO.equalJumin(jumin);
		}
		return result;
	}
	
	
	
}
