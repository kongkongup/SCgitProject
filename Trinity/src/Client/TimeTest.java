package Client;


import java.time.LocalDateTime;
import java.util.Calendar;

public class TimeTest implements Runnable {
	boolean b = false;
	
	public TimeTest() {
		Thread thread = new Thread(this);
		thread.start();
	}



	private void calenShow(){
		Calendar cal = Calendar.getInstance();
		LocalDateTime ldt = LocalDateTime.now();
		int y = cal.get(Calendar.YEAR);
		String month = ldt.getMonth().toString();
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		System.out.println(y+"/"+month+"/"+date+"/"
				+hour+":"+min+":"+sec);
	}

	@Override
	public void run() {
		while(true){
			if(b == true) break;
			;	// calenShow() 1�ʿ� �ѹ��� ��� ȣ��
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	
	public static void main(String[] args) {
		new TimeTest();
	}



}
