CREATE TABLE user_info(
	id VARCHAR2(100) CONSTRAINT user_info_id_pk PRIMARY KEY,
	pwd VARCHAR2(100) CONSTRAINT user_info_pwd_nn NOT NULL,
	email VARCHAR2(100),
	profile VARCHAR2(100), -- 프로필 이미지
	regdate DATE
);