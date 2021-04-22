package com.tp.review;

import java.math.BigDecimal;
import java.sql.Date;

public class ReviewInfo {
	private BigDecimal mo_no;
	private String mo_name;
	private String mo_style;
	private Date mo_release;
	private String mo_director;
	private String mo_actor;
	private String mo_plot;
	private BigDecimal mo_rating;
	private String mo_img;


	private BigDecimal r_no;
	private BigDecimal r_mo_no;
	private String r_uId;
	private String r_review;
	private BigDecimal r_rating;

	private String m_id;
	private String m_name;
	private String m_pw;
	private String m_phone;
	private String m_mail;
			
			public ReviewInfo() {
				// TODO Auto-generated constructor stub
			}

			public ReviewInfo(BigDecimal mo_no, String mo_name, String mo_style, Date mo_release, String mo_director,
					String mo_actor, String mo_plot, BigDecimal mo_rating, String mo_img, BigDecimal r_no,
					BigDecimal r_mo_no, String r_uId, String r_review, BigDecimal r_rating, String m_id, String m_name,
					String m_pw, String m_phone, String m_mail) {
				super();
				this.mo_no = mo_no;
				this.mo_name = mo_name;
				this.mo_style = mo_style;
				this.mo_release = mo_release;
				this.mo_director = mo_director;
				this.mo_actor = mo_actor;
				this.mo_plot = mo_plot;
				this.mo_rating = mo_rating;
				this.mo_img = mo_img;
				this.r_no = r_no;
				this.r_mo_no = r_mo_no;
				this.r_uId = r_uId;
				this.r_review = r_review;
				this.r_rating = r_rating;
				this.m_id = m_id;
				this.m_name = m_name;
				this.m_pw = m_pw;
				this.m_phone = m_phone;
				this.m_mail = m_mail;
			}

			public BigDecimal getMo_no() {
				return mo_no;
			}

			public void setMo_no(BigDecimal mo_no) {
				this.mo_no = mo_no;
			}

			public String getMo_name() {
				return mo_name;
			}

			public void setMo_name(String mo_name) {
				this.mo_name = mo_name;
			}

			public String getMo_style() {
				return mo_style;
			}

			public void setMo_style(String mo_style) {
				this.mo_style = mo_style;
			}

			public Date getMo_release() {
				return mo_release;
			}

			public void setMo_release(Date mo_release) {
				this.mo_release = mo_release;
			}

			public String getMo_director() {
				return mo_director;
			}

			public void setMo_director(String mo_director) {
				this.mo_director = mo_director;
			}

			public String getMo_actor() {
				return mo_actor;
			}

			public void setMo_actor(String mo_actor) {
				this.mo_actor = mo_actor;
			}

			public String getMo_plot() {
				return mo_plot;
			}

			public void setMo_plot(String mo_plot) {
				this.mo_plot = mo_plot;
			}

			public BigDecimal getMo_rating() {
				return mo_rating;
			}

			public void setMo_rating(BigDecimal mo_rating) {
				this.mo_rating = mo_rating;
			}

			public String getMo_img() {
				return mo_img;
			}

			public void setMo_img(String mo_img) {
				this.mo_img = mo_img;
			}

			public BigDecimal getR_no() {
				return r_no;
			}

			public void setR_no(BigDecimal r_no) {
				this.r_no = r_no;
			}

			public BigDecimal getR_mo_no() {
				return r_mo_no;
			}

			public void setR_mo_no(BigDecimal r_mo_no) {
				this.r_mo_no = r_mo_no;
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

			public String getM_id() {
				return m_id;
			}

			public void setM_id(String m_id) {
				this.m_id = m_id;
			}

			public String getM_name() {
				return m_name;
			}

			public void setM_name(String m_name) {
				this.m_name = m_name;
			}

			public String getM_pw() {
				return m_pw;
			}

			public void setM_pw(String m_pw) {
				this.m_pw = m_pw;
			}

			public String getM_phone() {
				return m_phone;
			}

			public void setM_phone(String m_phone) {
				this.m_phone = m_phone;
			}

			public String getM_mail() {
				return m_mail;
			}

			public void setM_mail(String m_mail) {
				this.m_mail = m_mail;
			}
			
		
}
