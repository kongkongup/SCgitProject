package Client;

import VO.Users;

public class test {
	
	public static void main(String[] args) {
		ClientManager cl = new ClientManager();
		/*Users ho = new Users("hoho", "3312", "kk", "³²", "33-222"," kyh0975@naver.com", "22", "cc");
		int n = cl.insertClient(ho);
		System.out.println(n);*/
		System.out.println(cl.login("hoho","3312"));
	}
}
