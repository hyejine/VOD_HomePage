package com.tp.ticket;

public class regTicketBeforeRegSeatDTO {
	private String t_theater_no;
	private String t_movie;
	private String t_start;
	private String t_end;
	
	public regTicketBeforeRegSeatDTO() {
		// TODO Auto-generated constructor stub
	}

	public regTicketBeforeRegSeatDTO(String t_theater_no, String t_movie, String t_start, String t_end) {
		super();
		this.t_theater_no = t_theater_no;
		this.t_movie = t_movie;
		this.t_start = t_start;
		this.t_end = t_end;
	}

	public String getT_theater_no() {
		return t_theater_no;
	}

	public void setT_theater_no(String t_theater_no) {
		this.t_theater_no = t_theater_no;
	}

	public String getT_movie() {
		return t_movie;
	}

	public void setT_movie(String t_movie) {
		this.t_movie = t_movie;
	}

	public String getT_start() {
		return t_start;
	}

	public void setT_start(String t_start) {
		this.t_start = t_start;
	}

	public String getT_end() {
		return t_end;
	}

	public void setT_end(String t_end) {
		this.t_end = t_end;
	}
	
	
	
}
