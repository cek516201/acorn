CREATE TABLE user_info(
	id VARCHAR2(100) CONSTRAINT user_info_id_pk PRIMARY KEY,
	pwd VARCHAR2(100) CONSTRAINT user_info_pwd_nn NOT NULL,
	email VARCHAR2(100),
	profile VARCHAR2(100), -- 프로필 이미지
	regdate DATE
);

CREATE TABLE board_file(
	num NUMBER PRIMARY KEY,
	writer VARCHAR2(100) NOT NULL,
	title VARCHAR2(100) NOT NULL,
	orgFileName VARCHAR2(100) NOT NULL, -- 원본 파일명
	saveFileName VARCHAR2(100) NOT NULL, -- 서버에 실제로 저장된 파일명
	fileSize NUMBER NOT NULL, -- 파일의 크기
	regdate DATE
);
CREATE SEQUENCE board_file_seq;

CREATE TABLE board_cafe(
	num NUMBER PRIMARY KEY, -- 글번호
	writer VARCHAR2(100) NOT NULL, -- 작성자
	title VARCHAR2(100) NOT NULL, -- 제목
	content CLOB, -- 글 내용
	viewCount NUMBER, -- 조회수
	regdate DATE -- 작성일
);
CREATE SEQUENCE board_cafe_seq;

CREATE TABLE readed_data(
	num NUMBER REFERENCES board_cafe(num),
	session_id VARCHAR2(50)
);