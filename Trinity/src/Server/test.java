package Server;


import java.util.ArrayList;

import DAO.LogDAO;
import VO.Reservation_Log;
import VO.Users;

public class test {
	public static void main(String[] args) {
		LogDAO ldao = new LogDAO();
		Users u = new Users("kongkongup", "1234", "김방구", "남", "1234", "kyh0975@naver.com", "33", "c-class");
		ServerManager sm = new ServerManager();
		sm.insertClient(u);
		System.out.println(sm.equalJumin("1234"));
		/*LocalTime lt = LocalTime.now();
		String hos = lt.getHour()+" : "+lt.getMinute();
		System.out.println(hos);*/
		/*ArrayList<Reservation_Log> l2 = ldao.selectAllLogs();
		Reservation_Log log = new Reservation_Log();
		log.setUser_id("hoho");
		log.setUser_name("kk");
		log.setRoom_name("studyroom3");
		log.setStart_time(23);
		log.setEnd_time(24);
		log.setUse("공부");
		log.setDate("33");
		System.out.println(l2);
		System.out.println(sm.reservation(log));*/
		
	}
}
