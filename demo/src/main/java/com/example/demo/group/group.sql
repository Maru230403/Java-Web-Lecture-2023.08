
/* Drop Tables */

DROP TABLE NEW_TABLE CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE NEW_TABLE
(
	gid number NOT NULL,
	ggname varchar2(20) NOT NULL,
	profile1 varchar2(4000),
	name varchar2(20) NOT NULL,
	age number NOT NULL,
	position varchar2(30),
	nationality varchar2(30) NOT NULL,
	entertainment varchar2(50) NOT NULL,
	PRIMARY KEY (gid)
);



