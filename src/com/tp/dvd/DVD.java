package com.tp.dvd;

import java.math.BigDecimal;
import java.util.Date;

public class DVD {
	private BigDecimal d_no;
	private String d_name;
	private Date d_release;
	private String d_director;
	private String d_actor;
	private String d_img;
	private BigDecimal d_price;
	private BigDecimal d_runningTime;
	
	
	public DVD(BigDecimal d_no, String d_name, Date d_release, String d_director, String d_actor, String d_img,
			BigDecimal d_price, BigDecimal d_runningTime) {
		super();
		this.d_no = d_no;
		this.d_name = d_name;
		this.d_release = d_release;
		this.d_director = d_director;
		this.d_actor = d_actor;
		this.d_img = d_img;
		this.d_price = d_price;
		this.d_runningTime = d_runningTime;
	}
	
	public DVD() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getD_no() {
		return d_no;
	}

	public void setD_no(BigDecimal d_no) {
		this.d_no = d_no;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public Date getD_release() {
		return d_release;
	}

	public void setD_release(Date d_release) {
		this.d_release = d_release;
	}

	public String getD_director() {
		return d_director;
	}

	public void setD_director(String d_director) {
		this.d_director = d_director;
	}

	public String getD_actor() {
		return d_actor;
	}

	public void setD_actor(String d_actor) {
		this.d_actor = d_actor;
	}

	public String getD_img() {
		return d_img;
	}

	public void setD_img(String d_img) {
		this.d_img = d_img;
	}

	public BigDecimal getD_price() {
		return d_price;
	}

	public void setD_price(BigDecimal d_price) {
		this.d_price = d_price;
	}

	public BigDecimal getD_runningTime() {
		return d_runningTime;
	}

	public void setD_runningTime(BigDecimal d_runningTime) {
		this.d_runningTime = d_runningTime;
	}
	
	
	
}
