DROP SCHEMA nutmeg_database;

CREATE SCHEMA nutmeg_database;

USE nutmeg_database;

CREATE TABLE address ( 
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	street_number VARCHAR(10) NOT NULL,
	street_name_1 VARCHAR(30) NOT NULL,
	street_name_2 VARCHAR(30) ,
	city VARCHAR(30) NOT NULL,
	province VARCHAR(2) NOT NULL,
	country VARCHAR(2) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE player (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	gender VARCHAR(1) NOT NULL,
	birthday DATETIME NOT NULL,
	address_id INT UNSIGNED,
	PRIMARY KEY(id),
	FOREIGN KEY(address_id) REFERENCES address(id)
);

CREATE TABLE phone (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    phone_type VARCHAR(30) NOT NULL,
	phone_number INT UNSIGNED,
	player_id INT UNSIGNED NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(player_id) REFERENCES player(id)
);

CREATE TABLE staff (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	address_id INT UNSIGNED NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(address_id) REFERENCES address(id)
);
	
CREATE TABLE program (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	program_start DATETIME NOT NULL,
	program_end DATETIME NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE program_schedule (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	program_id INT UNSIGNED NOT NULL,
	start_time DATETIME NOT NULL,
	end_time DATETIME NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(program_id) REFERENCES program(id)
);

CREATE TABLE program_staff (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	program_id INT UNSIGNED NOT NULL,
	staff_id INT UNSIGNED NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(program_id) REFERENCES program(id),
	FOREIGN KEY(staff_id) REFERENCES staff(id)
);