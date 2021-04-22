package com.tp.jsonTest;

import java.math.BigDecimal;
import java.util.Date;

public class Movie {
	
	private BigDecimal mo_no;
	private String mo_name;
	private Date mo_release;
	private String mo_director;
	private String mo_actor;
	private BigDecimal mo_rating;
	private String mo_img;
	private BigDecimal mo_price;
	private String mo_time;
	
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}


	public Movie(BigDecimal mo_no, String mo_name, Date mo_release, String mo_director, String mo_actor,
			BigDecimal mo_rating, String mo_img, BigDecimal mo_price, String mo_time) {
		super();
		this.mo_no = mo_no;
		this.mo_name = mo_name;
		this.mo_release = mo_release;
		this.mo_director = mo_director;
		this.mo_actor = mo_actor;
		this.mo_rating = mo_rating;
		this.mo_img = mo_img;
		this.mo_price = mo_price;
		this.mo_time = mo_time;
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


	public BigDecimal getMo_price() {
		return mo_price;
	}


	public void setMo_price(BigDecimal mo_price) {
		this.mo_price = mo_price;
	}


	public String getMo_time() {
		return mo_time;
	}


	public void setMo_time(String mo_time) {
		this.mo_time = mo_time;
	}



	

	
	
	
	
	
}
