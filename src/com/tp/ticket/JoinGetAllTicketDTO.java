package com.tp.ticket;

import java.math.BigDecimal;

public class JoinGetAllTicketDTO {
	private BigDecimal m_no;
	private BigDecimal th_no;
	
	public JoinGetAllTicketDTO() {
		// TODO Auto-generated constructor stub
	}


	public BigDecimal getM_no() {
		return m_no;
	}

	public void setM_no(BigDecimal m_no) {
		this.m_no = m_no;
	}

	public BigDecimal getTh_no() {
		return th_no;
	}

	public void setTh_no(BigDecimal th_no) {
		this.th_no = th_no;
	}


	public JoinGetAllTicketDTO(BigDecimal m_no, BigDecimal th_no) {
		super();
		this.m_no = m_no;
		this.th_no = th_no;
	}

}
