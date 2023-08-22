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

select*from visitlog;






















