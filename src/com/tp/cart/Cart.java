package com.tp.cart;

import java.math.BigDecimal;
import java.util.Date;

public class Cart {

	private BigDecimal c_no;
	private String c_u_id;
	private Date c_date;
	private BigDecimal c_p_no; //상품번호 or 티켓번호
	private BigDecimal c_p_quantity;
	private BigDecimal c_price;
	private String c_img;
	private String c_type;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getC_no() {
		return c_no;
	}

	public void setC_no(BigDecimal c_no) {
		this.c_no = c_no;
	}

	public String getC_u_id() {
		return c_u_id;
	}

	public void setC_u_id(String c_u_id) {
		this.c_u_id = c_u_id;
	}


	public BigDecimal getC_p_no() {
		return c_p_no;
	}

	public void setC_p_no(BigDecimal c_p_no) {
		this.c_p_no = c_p_no;
	}

	public BigDecimal getC_p_quantity() {
		return c_p_quantity;
	}

	public void setC_p_quantity(BigDecimal c_p_quantity) {
		this.c_p_quantity = c_p_quantity;
	}

	public BigDecimal getC_price() {
		return c_price;
	}

	public void setC_price(BigDecimal c_price) {
		this.c_price = c_price;
	}

	public String getC_img() {
		return c_img;
	}

	public void setC_img(String c_img) {
		this.c_img = c_img;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public Cart(BigDecimal c_no, String c_u_id, Date c_date, BigDecimal c_p_no, BigDecimal c_p_quantity,
			BigDecimal c_price, String c_img, String c_type) {
		super();
		this.c_no = c_no;
		this.c_u_id = c_u_id;
		this.c_date = c_date;
		this.c_p_no = c_p_no;
		this.c_p_quantity = c_p_quantity;
		this.c_price = c_price;
		this.c_img = c_img;
		this.c_type = c_type;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}




	
	
}
