package com.tp.showingmovie;

import java.math.BigDecimal;

public class ShowingMovie {
	private BigDecimal sm_no;					
	private BigDecimal sm_mo_no;					
	private BigDecimal sm_th_no;				
	private BigDecimal sm_t_start;					
	private BigDecimal sm_t_end;	
	public ShowingMovie() {
		// TODO Auto-generated constructor stub
	}
	public ShowingMovie(BigDecimal sm_no, BigDecimal sm_mo_no, BigDecimal sm_th_no, BigDecimal sm_t_start,
			BigDecimal sm_t_end) {
		super();
		this.sm_no = sm_no;
		this.sm_mo_no = sm_mo_no;
		this.sm_th_no = sm_th_no;
		this.sm_t_start = sm_t_start;
		this.sm_t_end = sm_t_end;
	}
	public BigDecimal getSm_no() {
		return sm_no;
	}
	public void setSm_no(BigDecimal sm_no) {
		this.sm_no = sm_no;
	}
	public BigDecimal getSm_mo_no() {
		return sm_mo_no;
	}
	public void setSm_mo_no(BigDecimal sm_mo_no) {
		this.sm_mo_no = sm_mo_no;
	}
	public BigDecimal getSm_th_no() {
		return sm_th_no;
	}
	public void setSm_th_no(BigDecimal sm_th_no) {
		this.sm_th_no = sm_th_no;
	}
	public BigDecimal getSm_t_start() {
		return sm_t_start;
	}
	public void setSm_t_start(BigDecimal sm_t_start) {
		this.sm_t_start = sm_t_start;
	}
	public BigDecimal getSm_t_end() {
		return sm_t_end;
	}
	public void setSm_t_end(BigDecimal sm_t_end) {
		this.sm_t_end = sm_t_end;
	}
	
	
}
