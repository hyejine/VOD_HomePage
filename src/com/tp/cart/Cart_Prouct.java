package com.tp.cart;

import java.math.BigDecimal;
import java.util.Date;

public class Cart_Prouct {
	private BigDecimal c_no;
	private String c_u_id;
	private Date c_date;
	private BigDecimal c_p_no; //상품번호 or 티켓번호
	private BigDecimal c_p_quantity;
	private BigDecimal c_price;
	private String c_img;
	private String c_type;
	
	private BigDecimal p_no;
	private String p_name;
	private String p_info;
	private BigDecimal p_price;
	private BigDecimal p_quantity;
	private String p_img;
	
	public Cart_Prouct() {
		// TODO Auto-generated constructor stub
	}

	public Cart_Prouct(BigDecimal c_no, String c_u_id, Date c_date, BigDecimal c_p_no, BigDecimal c_p_quantity,
			BigDecimal c_price, String c_img, String c_type, BigDecimal p_no, String p_name, String p_info,
			BigDecimal p_price, BigDecimal p_quantity, String p_img) {
		super();
		this.c_no = c_no;
		this.c_u_id = c_u_id;
		this.c_date = c_date;
		this.c_p_no = c_p_no;
		this.c_p_quantity = c_p_quantity;
		this.c_price = c_price;
		this.c_img = c_img;
		this.c_type = c_type;
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_info = p_info;
		this.p_price = p_price;
		this.p_quantity = p_quantity;
		this.p_img = p_img;
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

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
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

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}

	public BigDecimal getP_no() {
		return p_no;
	}

	public void setP_no(BigDecimal p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_info() {
		return p_info;
	}

	public void setP_info(String p_info) {
		this.p_info = p_info;
	}

	public BigDecimal getP_price() {
		return p_price;
	}

	public void setP_price(BigDecimal p_price) {
		this.p_price = p_price;
	}

	public BigDecimal getP_quantity() {
		return p_quantity;
	}

	public void setP_quantity(BigDecimal p_quantity) {
		this.p_quantity = p_quantity;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}
	
	
	
}
