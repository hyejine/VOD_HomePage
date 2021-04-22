package com.tp.product;

import java.math.BigDecimal;

public class Product {
	
	private BigDecimal p_no;
	private String p_name;
	private String p_info;
	private BigDecimal p_price;
	private BigDecimal p_quantity;
	private String p_img;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	
	public String getP_info() {
		return p_info;
	}


	public void setP_info(String p_info) {
		this.p_info = p_info;
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


	public Product(BigDecimal p_no, String p_name, String p_info, BigDecimal p_price, BigDecimal p_quantity,
			String p_img) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_info = p_info;
		this.p_price = p_price;
		this.p_quantity = p_quantity;
		this.p_img = p_img;
	}

	
	
}
