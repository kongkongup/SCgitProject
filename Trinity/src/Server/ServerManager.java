package Server;


import DAO.SpaceDAO;
import DAO.UsersDAO;
import VO.Space;
import VO.Users;

public class ServerManager {
	
	private SpaceDAO sDAO = new SpaceDAO();
	private UsersDAO uDAO = new UsersDAO();

	public int insertClient(Users user){
		int result = 0;
		uDAO.insertUser(user);
		return result;
	}
	
	public int insertRoom(Space room){
		int result = 0;
		sDAO.updateSpace(room);
		return result;
	}

}
