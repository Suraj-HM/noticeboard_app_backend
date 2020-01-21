create table if not exists head_of_dept
(
	hod_id int auto_increment
		primary key,
	hod_name varchar(45) not null,
	hod_pwd varchar(45) not null,
	hod_email varchar(45) null,
	hod_dept_id int not null,
	constraint dept_id
		foreign key (hod_dept_id) references departments (dept_id)
);

create index dept_id_idx
	on head_of_dept (hod_dept_id);

