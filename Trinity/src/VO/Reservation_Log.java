package VO;

import java.io.Serializable;

/*2017.05.22 ±è¿µÇö*/
public class Reservation_Log implements Serializable {
	
	private static final long serialVersionUID = 6398239156763446177L;
	private int rownum;
	private int log_seq;
	private String user_id;
	private String room_name;
	private int start_time;
	private int end_time;
	private String use;
	private String date;
	
	public Reservation_Log() {
		super();
	}
	
	public Reservation_Log(int log_seq, String user_id, String room_name, int start_time,
			int end_time, String use, String date) {
		super();
		this.log_seq = log_seq;
		this.user_id = user_id;		
		this.room_name = room_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.use = use;
		this.date = date;
	}	

	public Reservation_Log(String user_id, String room_name, int start_time, int end_time, String use, String date) {
		super();
		this.user_id = user_id;
		this.room_name = room_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.use = use;
		this.date = date;
	}

	public Reservation_Log(int rownum, int log_seq, String user_id, String room_name, int start_time,
			int end_time, String use, String date) {
		super();
		this.rownum = rownum;
		this.log_seq = log_seq;
		this.user_id = user_id;
		this.room_name = room_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.use = use;
		this.date = date;
	}

	public int getLog_seq() {
		return log_seq;
	}

	public void setLog_seq(int log_seq) {
		this.log_seq = log_seq;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}	

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getStart_time() {
		return start_time;
	}

	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}

	public int getEnd_time() {
		return end_time;
	}

	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Reservation_Log [rownum=" + rownum + ", log_seq=" + log_seq + ", user_id=" + user_id + ", room_name=" + room_name + ", start_time=" + start_time + ", end_time=" + end_time
				+ ", use=" + use + ", date=" + date + "]";
	}
	
	public Object[] toArray(){
		Object [] result = {rownum+"",user_id,date,start_time+"",end_time,room_name,use};
		return result;
	}
	
	
}
