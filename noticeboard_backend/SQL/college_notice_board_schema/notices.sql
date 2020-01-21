create table if not exists notices
(
	id int auto_increment
		primary key,
	message varchar(45) not null,
	notice_dept_id int not null,
	constraint notice_dept_id
		foreign key (notice_dept_id) references departments (dept_id)
);

create index notice_dept_id_idx
	on notices (notice_dept_id);

