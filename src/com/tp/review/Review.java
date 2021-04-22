package com.tp.review;

import java.math.BigDecimal;

public class Review {
	private BigDecimal r_no;
	private BigDecimal r_mo_no;
	private String r_uId;
	private String r_review;
	private BigDecimal r_rating;
	
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getR_no() {
		return r_no;
	}

	public void setR_no(BigDecimal r_no) {
		this.r_no = r_no;
	}


	public String getR_uId() {
		return r_uId;
	}

	public void setR_uId(String r_uId) {
		this.r_uId = r_uId;
	}

	public String getR_review() {
		return r_review;
	}

	public void setR_review(String r_review) {
		this.r_review = r_review;
	}

	public BigDecimal getR_rating() {
		return r_rating;
	}

	public void setR_rating(BigDecimal r_rating) {
		this.r_rating = r_rating;
	}

	public BigDecimal getR_mo_no() {
		return r_mo_no;
	}

	public void setR_mo_no(BigDecimal r_mo_no) {
		this.r_mo_no = r_mo_no;
	}

	public Review(BigDecimal r_no, BigDecimal r_mo_no, String r_uId, String r_review, BigDecimal r_rating) {
		super();
		this.r_no = r_no;
		this.r_mo_no = r_mo_no;
		this.r_uId = r_uId;
		this.r_review = r_review;
		this.r_rating = r_rating;
	}

	
	
	
}
