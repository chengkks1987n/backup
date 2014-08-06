create table src_table (
	text	varchar2(200),
	id		varchar2(50) not null
);
alter table src_table 
add constraint pk_src_table primary key (id);


create table des_table (
	src_text	varchar2(200),
	src_id		varchar2(50) not null,
	the_time	date,
	remark		varchar2(500)
);
alter table des_table 
add constraint pk_des_table primary key (src_id);