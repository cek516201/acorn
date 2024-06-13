create table board_guest(
	num number primary key, -- 글번호
	writer varchar2(30), -- 작성자
	content varchar2(100) not null, -- 글내용
	pwd varchar2(30) not null, -- 비밀번호
	regdate date -- 글 등록일
);

create sequence board_guest_seq;