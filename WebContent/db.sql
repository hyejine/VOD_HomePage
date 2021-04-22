create table member_db(
	m_id varchar2 (20 char) primary key,
	m_pw varchar2 (20 char) not null,
	m_name varchar2 (20 char) not null,
	m_phone varchar2 (20 char) not null,
	m_mail varchar2 (30 char) not null
);
select*from member_db;

drop table member_db cascade constraint purge;
insert into member_db values('admin', '0000', '관리자', '0000', 0000);

create table movie_db(
	mo_no number(6) primary key,
	mo_name varchar2 (100 char) not null,
	mo_release date not null,
	mo_director varchar2(100 char) not null,
	mo_actor varchar2(100 char),
	mo_rating number(3,2) not null,
	mo_img varchar2 (400 char),
	mo_price number(5),
	mo_time varchar2(5)
);
create sequence movie_db_seq;

drop table movie_db cascade constraint purge;

DROP SEQUENCE movie_db_seq ;
delete MOVIE_DB;

select*from movie_db;



create table review_db(
	r_no number(3) primary key,
	r_mo_no number(10) not null,
	r_uId varchar2 (20 char) not null,
	r_review varchar2 (300 char) not null,
	r_rating number(3) not null
);
DROP SEQUENCE review_db_seq ;
drop table review_db cascade constraint purge;
create sequence review_db_seq;
select*from review_db;

	--select * from review_db,movie_db,member_db where r_mo_no = #{r_mo_no} and mo_no=#{r_mo_no}



create table theater_db(
	th_no number(6) primary key,           
	th_place varchar2(30 char) not null,
	th_room number(4) not null,          --영화의 시퀀스와 같아야 함 
	th_seat varchar2(5 char) not null
);
create sequence theater_db_seq;
select*from theater_db;

drop sequence theater_db;

drop table theater_db cascade constraint purge;


create table product_db(
	p_no number(3) primary key,
	p_name varchar2(20 char) not null,
	p_info varchar2(300 char) not null,
	p_price number(10) not null,
	p_quantity number(3) not null,
	p_img varchar2 (300 char) not null
);
DROP SEQUENCE product_db_seq ;
drop table product_db cascade constraint purge;
create sequence product_db_seq;
select*from product_db;

delete PRODUCT_DB where p_no = 145;
delete PRODUCT_DB;

select * from cart, product_db where c_p_no=#{p_no} and p_no=#{p_no};
drop table product_db CASCADE CONSTRAINT;


create table cart(
	c_no number(6) primary key,
	c_u_id varchar2 (20 char) not null,
	c_date date not null,
	c_p_no number(6) not null, --상품번호 or 티켓번호 if getparameter(특정값 ex) a가 존재하면 상품/ else 티켓 )
	c_p_quantity number(3) not null,
	c_price number(10) not null,
	c_img varchar2 (300 char) not null,
	c_type varchar2 (5 char) not null --t면 ticket , p면 product
);

create sequence cart_seq;
select * from cart;
DROP SEQUENCE cart_seq ;
drop table cart CASCADE CONSTRAINT;

create table purchase(
	pu_no number(6) primary key,
	pu_c_no  number(6) ,
	pu_u_id varchar2 (20 char) not null,
	pu_date date not null,
	pu_p_no number(6) not null, --상품번호 or 티켓번호 if getparameter(특정값 ex) a가 존재하면 상품/ else 티켓 )
	pu_p_quantity number(3) not null,
	pu_price number(10) not null,
	pu_img varchar2 (300 char) not null,
	pu_type varchar2 (5 char) not null --product면 p / ticket이면 t로 셋팅
);
drop table purchase CASCADE CONSTRAINT;
DROP SEQUENCE purchase_seq ;
create sequence purchase_seq;
select * from purchase;
delete purchase;
select * from theater_db;
select * from MOVIE_DB;

delete purchase where pu_no = 21;

create table dvd(
	d_no number(6) primary key,
	d_name varchar2 (500 char) not null,
	d_release date not null,
	d_director varchar2(100 char) not null,
	d_actor varchar2(100 char),
	d_img varchar2 (400 char),  --영화 등록할 때 받아옴
	d_price number(10) not null, --만원으로 통일
	d_runningTime number(6) not null -- 상영시간 (2시간 고정)
);
create sequence dvd_seq;

DROP SEQUENCE dvd_seq ;
drop table dvd CASCADE CONSTRAINT;
select * from dvd;
delete dvd ;

