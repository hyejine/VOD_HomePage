package com.tp.cart;

import java.math.BigDecimal;
import java.util.Date;

public class Purchase {
	private BigDecimal pu_no;
	private BigDecimal pu_c_no;
	private String pu_u_id;
	private Date pu_date;
	
	private BigDecimal pu_p_no;
	private BigDecimal pu_p_quantity;
	private BigDecimal pu_price;
	private String pu_img;
	private String pu_type;
	

	public Purchase() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getPu_no() {
		return pu_no;
	}

	public void setPu_no(BigDecimal pu_no) {
		this.pu_no = pu_no;
	}

	public BigDecimal getPu_c_no() {
		return pu_c_no;
	}

	public void setPu_c_no(BigDecimal pu_c_no) {
		this.pu_c_no = pu_c_no;
	}

	public String getPu_u_id() {
		return pu_u_id;
	}

	public void setPu_u_id(String pu_u_id) {
		this.pu_u_id = pu_u_id;
	}

	public Date getPu_date() {
		return pu_date;
	}

	public void setPu_date(Date pu_date) {
		this.pu_date = pu_date;
	}

	public BigDecimal getPu_p_no() {
		return pu_p_no;
	}

	public void setPu_p_no(BigDecimal pu_p_no) {
		this.pu_p_no = pu_p_no;
	}

	public BigDecimal getPu_p_quantity() {
		return pu_p_quantity;
	}

	public void setPu_p_quantity(BigDecimal pu_p_quantity) {
		this.pu_p_quantity = pu_p_quantity;
	}

	public BigDecimal getPu_price() {
		return pu_price;
	}

	public void setPu_price(BigDecimal pu_price) {
		this.pu_price = pu_price;
	}

	public String getPu_img() {
		return pu_img;
	}

	public void setPu_img(String pu_img) {
		this.pu_img = pu_img;
	}

	public Purchase(BigDecimal pu_no, BigDecimal pu_c_no, String pu_u_id, Date pu_date, BigDecimal pu_p_no,
			BigDecimal pu_p_quantity, BigDecimal pu_price, String pu_img, String pu_type) {
		super();
		this.pu_no = pu_no;
		this.pu_c_no = pu_c_no;
		this.pu_u_id = pu_u_id;
		this.pu_date = pu_date;
		this.pu_p_no = pu_p_no;
		this.pu_p_quantity = pu_p_quantity;
		this.pu_price = pu_price;
		this.pu_img = pu_img;
		this.pu_type = pu_type;
	}

	public String getPu_type() {
		return pu_type;
	}

	public void setPu_type(String pu_type) {
		this.pu_type = pu_type;
	}
	
	
	
}
