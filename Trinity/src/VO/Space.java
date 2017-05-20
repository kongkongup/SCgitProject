package VO;

public class Space {
	
	private int room_id;
	private String room_Name;
	private int desk;
	private int chair;
	
	public Space(int room_No, String room_Name,int desk, int chair) {
		super();
		this.room_id = room_No;
		this.room_Name = room_Name;
		this.desk = desk;
		this.chair = chair;
	}
		
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_No) {
		this.room_id = room_No;
	}
	public String getRoom_Name() {
		return room_Name;
	}
	public void setRoom_Name(String room_Name) {
		this.room_Name = room_Name;
	}
	public int getDesk() {
		return desk;
	}
	public void setDesk(int desk) {
		this.desk = desk;
	}
	public int getChair() {
		return chair;
	}
	public void setChair(int chair) {
		this.chair = chair;
	}
	
	@Override
	public String toString() {
		return "Space [room_id="+ room_id +", room_Name=" + room_Name + ", desk=" + desk + ", chair=" + chair + "]";
	}
	
	
}
