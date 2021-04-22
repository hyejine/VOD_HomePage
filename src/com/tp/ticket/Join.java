package com.tp.ticket;

import java.math.BigDecimal;

public class Join {
	private BigDecimal t_theater_no;
	private BigDecimal mo_no;
	private BigDecimal th_mo_no;
	
	public Join() {

	}

	public Join(BigDecimal t_theater_no, BigDecimal mo_no, BigDecimal th_mo_no) {
		super();
		this.t_theater_no = t_theater_no;
		this.mo_no = mo_no;
		this.th_mo_no = th_mo_no;
	}

	public BigDecimal getT_theater_no() {
		return t_theater_no;
	}

	public void setT_theater_no(BigDecimal t_theater_no) {
		this.t_theater_no = t_theater_no;
	}

	public BigDecimal getMo_no() {
		return mo_no;
	}

	public void setMo_no(BigDecimal mo_no) {
		this.mo_no = mo_no;
	}

	public BigDecimal getTh_mo_no() {
		return th_mo_no;
	}

	public void setTh_mo_no(BigDecimal th_mo_no) {
		this.th_mo_no = th_mo_no;
	}
	
	
}
