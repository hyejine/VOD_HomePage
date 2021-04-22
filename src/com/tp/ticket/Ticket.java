package com.tp.ticket;

import java.math.BigDecimal;
import java.util.Date;

public class Ticket {

	private BigDecimal t_no;
	private BigDecimal t_theater;
	private BigDecimal t_movie;
	private String t_uid;
	private String t_seat;
	private BigDecimal t_price;
	private BigDecimal t_start;
	private BigDecimal t_end;
	
	
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}



	public Ticket(BigDecimal t_no, BigDecimal t_theater, BigDecimal t_movie, String t_uid, String t_seat,
			BigDecimal t_price, BigDecimal t_start, BigDecimal t_end) {
		super();
		this.t_no = t_no;
		this.t_theater = t_theater;
		this.t_movie = t_movie;
		this.t_uid = t_uid;
		this.t_seat = t_seat;
		this.t_price = t_price;
		this.t_start = t_start;
		this.t_end = t_end;
	}



	public BigDecimal getT_no() {
		return t_no;
	}



	public void setT_no(BigDecimal t_no) {
		this.t_no = t_no;
	}



	public BigDecimal getT_theater() {
		return t_theater;
	}



	public void setT_theater(BigDecimal t_theater) {
		this.t_theater = t_theater;
	}



	public BigDecimal getT_movie() {
		return t_movie;
	}



	public void setT_movie(BigDecimal t_movie) {
		this.t_movie = t_movie;
	}



	public String getT_uid() {
		return t_uid;
	}



	public void setT_uid(String t_uid) {
		this.t_uid = t_uid;
	}



	public String getT_seat() {
		return t_seat;
	}



	public void setT_seat(String t_seat) {
		this.t_seat = t_seat;
	}



	public BigDecimal getT_price() {
		return t_price;
	}



	public void setT_price(BigDecimal t_price) {
		this.t_price = t_price;
	}



	public BigDecimal getT_start() {
		return t_start;
	}



	public void setT_start(BigDecimal t_start) {
		this.t_start = t_start;
	}



	public BigDecimal getT_end() {
		return t_end;
	}



	public void setT_end(BigDecimal t_end) {
		this.t_end = t_end;
	}










































	

	
	
	
}
