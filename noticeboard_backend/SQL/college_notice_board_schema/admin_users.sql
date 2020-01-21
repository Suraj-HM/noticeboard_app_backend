create table if not exists admin_users
(
	admin_id int(10) auto_increment
		primary key,
	admin_name varchar(45) not null,
	admin_pwd varchar(45) not null
);

