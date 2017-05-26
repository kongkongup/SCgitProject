package VO;

import java.io.Serializable;

public class Space implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6810599011875463152L;
	private String room_name;
	private String assigned;
	private int occupancy;
	private String others;
	
	public Space(){
		super();
	}

	public Space(String room_name, String assigned, int occupancy, String others) {
		super();
		this.room_name = room_name;
		this.assigned = assigned;
		this.occupancy = occupancy;
		this.others = others;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}
	
	
	
	
	
}
