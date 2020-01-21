create table if not exists student
(
	student_id int auto_increment
		primary key,
	student_name varchar(45) not null,
	student_pwd varchar(45) not null,
	student_email varchar(45) not null,
	phone_no varchar(45) not null,
	student_dept_id int not null,
	constraint std_dept_id
		foreign key (student_dept_id) references departments (dept_id)
);

create index dept_id_idx
	on student (student_dept_id);

