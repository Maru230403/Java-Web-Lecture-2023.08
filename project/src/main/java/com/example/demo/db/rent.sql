
/* Drop Tables */

DROP TABLE rent CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE rent
(
	week number(10),
	sta_id number(10),
	addr varchar2(200),
	no_rent number(20)
);



