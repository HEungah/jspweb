drop database if exists JSPWEB;
create database JSPWEB;
use JSPWEB;

drop table if exists visitlog;
create table visitlog(
	vno int auto_increment,		-- 식별번호(방문록번호), 자동번호 부여
    vwriter varchar(30) not null,	-- (방문록작성자명), 공백불가능
    vpw varchar(10) not null,		-- (방문록작성자명), 공백불가능
    vcontent text,			-- (방문록 내용)
    vdate datetime default now(),	-- (방문록 작성일/시간), 생략시 자동날짜/시간 등록
    primary key(vno)
);

select*from visitlog order by vdate desc;
insert visitlog(vwriter, vpw, vcontent) values('dd', '1234', 'ddd');

# 수정 [ 조건 있음 ]
update visitlog set vcontent = '수정방문록' where vno = 3 and vpw = 1234;		-- 방문록 번호가 3번이고 패스워드가 1234이면 방문록내용을 수정(업데이트)

# 삭제 [ 조건 있음 ]
delete from visitlog where vno = 3;			-- vno가 3번이면 삭제
delete from visitlog where vno = 3 and vpw = 1234;		-- 방문록 번호가 3번이고 패스워드가 1234이면 삭제(번호와 패스워드 일치하면 방문록 삭제)

drop table if exists accountbook;
create table accountbook(
	cno int auto_increment,
    citem text,
    cpayment text,
    cdate date,
    primary key(cno)
);
insert accountbook(citem, cpayment, cdate) values('과자', '3000', '2023-08-23');
select*from accountbook order by cno desc;

update accountbook set citem = '생활용품', cpayment = '6000', cdate = '2023-08-08' where cno = 1;
delete from accountbook where cno = 1;

drop table if exists member;
create table member(
	mno int auto_increment,
    mid varchar(30) not null unique,
    mpwd varchar(20) not null,
    memail varchar(40) not null unique,
    mimg longtext,			# 만약에 프로필 미등록시 기본 프로필 사용
    primary key(mno)
);

select*from member;
select*from member where mid = 'ccord';
insert into member(mid, mpwd, memail, mimg) values('유재석', '1234', 'qwe@qwe.com', 'default.jpg');

# 회원탈퇴[ 회원번호(mno)확인, 비밀번호 검증(mpwd) ]
delete from member where mno = 2 and mpwd = '123123';

# 회원정보수정[ 회원번호(mno)확인, 비밀번호 검증(mpwd), 이미지수정(mimg), 비밀번호수정(mpwd) ]
update member set mimg = 'default.jpg', mpwd = '123456' where mno = 1 and mpwd = '1234';

# 로그인 [아이디와 비밀번호가 일치한 레코드 존재여부 판단 ]
select*from member where mid = 'ccord' and mpwd = '123123';		# 레코드가 검색되면 로그인성공/ 없으면 로그인 실패

# 회원정보 호출[ 아이디를 이용하여 패스워드를 제외하고 모든 회원정보를 호출]
select mno, mid, memail, mimg from member where mid = 'ccord';


# 인사관리테이블(과제)
drop table if exists hrm;
create table hrm(
	hno int auto_increment,
    himg longtext,
    hname varchar(15) not null,
    hphone varchar(20) not null unique,
    hposition varchar(5) not null,
    hdate datetime default now(),
    primary key(hno)
);

select*from hrm order by hdate desc;
insert into hrm(himg, hname, hphone, hposition) values(null, '최의선', '010-9999-8888', '대리');
delete from hrm where hno = 14;

# 게시판 카테고리
drop table if exists bcategory;
create table bcategory(
	bcno int auto_increment,
    bcname varchar(30) not null,
    primary key(bcno)
);

# 게시판 카테고리 샘플[ 게시판 테이플을 만들기위해 필요함 ]
insert into bcategory value(1, '공지사항');
insert into bcategory value(2, '자유게시판');
insert into bcategory value(3, '노하우');

select*from bcategory;

#게시판
drop table if exists board;
create table board(
	bno int auto_increment,
    btitle varchar(30) not null,
    bcontent longtext,
    bfile longtext,
    bdate datetime default now(),
    bview int default 0,
    mno int,
    bcno int,
    primary key(bno),
    foreign key(mno) references member(mno) on delete cascade,		-- 회원탈퇴시 게시물도 같이 삭제[제약조건]
    foreign key(bcno) references bcategory(bcno) on delete cascade on update cascade		-- 카테고리 삭제시 게시물삭제, 카테고리 변경시 게시물도 변경
);

select*from board;





























