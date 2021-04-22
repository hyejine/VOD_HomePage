package com.tp.ticket;

import java.math.BigDecimal;

public class JoinGetAllTicketByIdDTO {

	private String m_id;
	private BigDecimal mo_no;
	private BigDecimal th_no;
	
public JoinGetAllTicketByIdDTO() {
	// TODO Auto-generated constructor stub
}

public JoinGetAllTicketByIdDTO(String m_id, BigDecimal mo_no, BigDecimal th_no) {
	super();
	this.m_id = m_id;
	this.mo_no = mo_no;
	this.th_no = th_no;
}

public String getM_id() {
	return m_id;
}

public void setM_id(String m_id) {
	this.m_id = m_id;
}

public BigDecimal getMo_no() {
	return mo_no;
}

public void setMo_no(BigDecimal mo_no) {
	this.mo_no = mo_no;
}

public BigDecimal getTh_no() {
	return th_no;
}

public void setTh_no(BigDecimal th_no) {
	this.th_no = th_no;
}
	

	
}
