CREATE TABLE user_table(
	id NUMBER PRIMARY KEY,
  	userName VARCHAR2(20) UNIQUE,
  	password VARCHAR2(100) NOT NULL,
   	email VARCHAR2(100),
   	role VARCHAR2(20) NOT NULL,
   	profile VARCHAR2(100),
   	regdate DATE
);
CREATE SEQUENCE user_table_seq;