package com.tp.ticket;

import java.math.BigDecimal;
import java.util.Date;

public class TicketInfoDTO {
	
	private BigDecimal t_no;
	private BigDecimal t_theater;
	private BigDecimal t_movie;
	private String t_uid;
	private String t_seat;
	private BigDecimal t_price;
	private BigDecimal t_start;
	private BigDecimal t_end;
	
	private BigDecimal mo_no;
	private String mo_name;
	private String mo_style;
	private Date mo_release;
	private String mo_director;
	private String mo_actor;
	private String mo_plot;
	private BigDecimal mo_rating;
	private String mo_img;
	private BigDecimal mo_runningTime;
	
	private BigDecimal th_no;
	private String th_place;
	private BigDecimal th_room;
	private String th_seat;
	
	public TicketInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public TicketInfoDTO(BigDecimal t_no, BigDecimal t_theater, BigDecimal t_movie, String t_uid, String t_seat,
			BigDecimal t_price, BigDecimal t_start, BigDecimal t_end, BigDecimal mo_no, String mo_name, String mo_style,
			Date mo_release, String mo_director, String mo_actor, String mo_plot, BigDecimal mo_rating, String mo_img,
			BigDecimal mo_runningTime, BigDecimal th_no, String th_place, BigDecimal th_room, String th_seat) {
		super();
		this.t_no = t_no;
		this.t_theater = t_theater;
		this.t_movie = t_movie;
		this.t_uid = t_uid;
		this.t_seat = t_seat;
		this.t_price = t_price;
		this.t_start = t_start;
		this.t_end = t_end;
		this.mo_no = mo_no;
		this.mo_name = mo_name;
		this.mo_style = mo_style;
		this.mo_release = mo_release;
		this.mo_director = mo_director;
		this.mo_actor = mo_actor;
		this.mo_plot = mo_plot;
		this.mo_rating = mo_rating;
		this.mo_img = mo_img;
		this.mo_runningTime = mo_runningTime;
		this.th_no = th_no;
		this.th_place = th_place;
		this.th_room = th_room;
		this.th_seat = th_seat;
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

	public BigDecimal getMo_no() {
		return mo_no;
	}

	public void setMo_no(BigDecimal mo_no) {
		this.mo_no = mo_no;
	}

	public String getMo_name() {
		return mo_name;
	}

	public void setMo_name(String mo_name) {
		this.mo_name = mo_name;
	}

	public String getMo_style() {
		return mo_style;
	}

	public void setMo_style(String mo_style) {
		this.mo_style = mo_style;
	}

	public Date getMo_release() {
		return mo_release;
	}

	public void setMo_release(Date mo_release) {
		this.mo_release = mo_release;
	}

	public String getMo_director() {
		return mo_director;
	}

	public void setMo_director(String mo_director) {
		this.mo_director = mo_director;
	}

	public String getMo_actor() {
		return mo_actor;
	}

	public void setMo_actor(String mo_actor) {
		this.mo_actor = mo_actor;
	}

	public String getMo_plot() {
		return mo_plot;
	}

	public void setMo_plot(String mo_plot) {
		this.mo_plot = mo_plot;
	}

	public BigDecimal getMo_rating() {
		return mo_rating;
	}

	public void setMo_rating(BigDecimal mo_rating) {
		this.mo_rating = mo_rating;
	}

	public String getMo_img() {
		return mo_img;
	}

	public void setMo_img(String mo_img) {
		this.mo_img = mo_img;
	}

	public BigDecimal getMo_runningTime() {
		return mo_runningTime;
	}

	public void setMo_runningTime(BigDecimal mo_runningTime) {
		this.mo_runningTime = mo_runningTime;
	}

	public BigDecimal getTh_no() {
		return th_no;
	}

	public void setTh_no(BigDecimal th_no) {
		this.th_no = th_no;
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
	
	
	
	
	
	
	
}
