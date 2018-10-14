--Database : desktop
--UserName: Enoxs
--Password: Rhz0908100!
CREATE TABLE app_info(
	id int(11) primary key not null auto_increment,
	app_name varchar(50) not null,
	app_version varchar(20) character set UTF8 not null,
	app_date datetime NOT NULL,
	app_author varchar(10) character set UTF8 null,
	app_remark varchar(100) character set UTF8 null
)
