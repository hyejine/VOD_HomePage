package com.tp.manager;

import java.math.BigDecimal;

public class Theater {
	private BigDecimal th_no;
	private String th_place;
	private BigDecimal th_room;
	private String th_seat;
	
	
	public Theater() {
		// TODO Auto-generated constructor stub
	}




	public BigDecimal getTh_no() {
		return th_no;
	}




	public Theater(BigDecimal th_no, String th_place, BigDecimal th_room, String th_seat) {
		super();
		this.th_no = th_no;
		this.th_place = th_place;
		this.th_room = th_room;
		this.th_seat = th_seat;
	}




	public String getTh_place() {
		return th_place;
	}




	public void setTh_place(String th_place) {
		this.th_place = th_place;
	}




	public BigDecimal getTh_room() {
		return th_room;
	}




	public void setTh_room(BigDecimal th_room) {
		this.th_room = th_room;
	}




	public String getTh_seat() {
		return th_seat;
	}




	public void setTh_seat(String th_seat) {
		this.th_seat = th_seat;
	}




	public void setTh_no(BigDecimal th_no) {
		this.th_no = th_no;
	}

	
		
	
	
	


	
}
