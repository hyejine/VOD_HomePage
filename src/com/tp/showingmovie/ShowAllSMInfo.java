package com.tp.showingmovie;

import java.math.BigDecimal;
import java.util.Date;

public class ShowAllSMInfo {
	private BigDecimal sm_no;
	private BigDecimal sm_mo_no;
	private BigDecimal sm_th_no;
	private BigDecimal sm_t_start;
	private BigDecimal sm_t_end;
	private BigDecimal th_no;
	private String th_place;
	private BigDecimal th_room;
	private String th_seat;
	private BigDecimal mo_no;
	private String mo_name;
	private Date mo_release;
	private String mo_director;
	private String mo_actor;
	private BigDecimal mo_rating;
	private String mo_img;

	public ShowAllSMInfo() {
		// TODO Auto-generated constructor stub
	}

	public ShowAllSMInfo(BigDecimal sm_no, BigDecimal sm_mo_no, BigDecimal sm_th_no, BigDecimal sm_t_start,
			BigDecimal sm_t_end, BigDecimal th_no, String th_place, BigDecimal th_room, String th_seat,
			BigDecimal mo_no, String mo_name, Date mo_release, String mo_director, String mo_actor,
			BigDecimal mo_rating, String mo_img) {
		super();
		this.sm_no = sm_no;
		this.sm_mo_no = sm_mo_no;
		this.sm_th_no = sm_th_no;
		this.sm_t_start = sm_t_start;
		this.sm_t_end = sm_t_end;
		this.th_no = th_no;
		this.th_place = th_place;
		this.th_room = th_room;
		this.th_seat = th_seat;
		this.mo_no = mo_no;
		this.mo_name = mo_name;
		this.mo_release = mo_release;
		this.mo_director = mo_director;
		this.mo_actor = mo_actor;
		this.mo_rating = mo_rating;
		this.mo_img = mo_img;
	}

	public BigDecimal getSm_no() {
		return sm_no;
	}

	public void setSm_no(BigDecimal sm_no) {
		this.sm_no = sm_no;
	}

	public BigDecimal getSm_mo_no() {
		return sm_mo_no;
	}

	public void setSm_mo_no(BigDecimal sm_mo_no) {
		this.sm_mo_no = sm_mo_no;
	}

	public BigDecimal getSm_th_no() {
		return sm_th_no;
	}

	public void setSm_th_no(BigDecimal sm_th_no) {
		this.sm_th_no = sm_th_no;
	}

	public BigDecimal getSm_t_start() {
		return sm_t_start;
	}

	public void setSm_t_start(BigDecimal sm_t_start) {
		this.sm_t_start = sm_t_start;
	}

	public BigDecimal getSm_t_end() {
		return sm_t_end;
	}

	public void setSm_t_end(BigDecimal sm_t_end) {
		this.sm_t_end = sm_t_end;
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

	
	
}
