drop table member;
drop table member cascade constraint;
drop table car;
drop table review;
drop table charge;
drop table report;
drop table reportreply;
drop table reservation;
drop table question;
drop table questionreply;
drop table notice;
drop table story;
drop table storyreply;
drop table faq;
drop table ways;
select * from reportreply;

CREATE TABLE member (
	id VARCHAR2(20) NOT NULL,
	password VARCHAR2(100) NULL,
	name VARCHAR2(10) NULL,
	address VARCHAR2(40) NULL,
	tel VARCHAR2(20) NULL,
	email VARCHAR2(30) NULL,
	birth Date NULL,
	gender CHAR(6) NULL,
	del CHAR(1) default 'n' NULL,
	regdate DATE NULL,
	mfileName	VARCHAR2(50) NULL,
	ad CHAR(1) default 'n' NULL
);
alter table member modify (ad default 'n');
alter table member modify (del default 'n');
select * from member;

create table car (
	carNo VARCHAR2(30) NOT NULL,
	carName VARCHAR2(50) NOT NULL,
	carRank VARCHAR2(30) NOT NULL,
	carKind VARCHAR2(30) NOT NULL,
	carType VARCHAR2(30) NOT NULL,
	carYear VARCHAR2(30) NOT NULL,
	fee NUMBER NOT NULL,
	carColor VARCHAR2(30) NOT NULL,
	carRegion VARCHAR2(50) NOT NULL, 
	del CHAR(1) default 'n',
	filename VARCHAR2(50) NOT NULL, 
	carRes CHAR(1) default 'n',
	id VARCHAR2(20)
);

CREATE TABLE review (
	rvNo	NUMBER	NOT NULL,
	carNo	VARCHAR2(10)	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	star	VARCHAR2(5)	NULL,
	rvContent	VARCHAR2(500)	NULL,
	rvReadcount	NUMBER	NULL,
	regdate	DATE	NULL
);

CREATE TABLE charge (
	pay	NUMBER	NOT NULL,
	carNo	VARCHAR2(10)	NOT NULL,
	id	VARCHAR2(20)	NOT NULL
);

CREATE TABLE report (
	rpNo	NUMBER	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	rpTitle	VARCHAR2(100)	NULL,
	rpContent	VARCHAR2(1000)	NULL,
	rpRead	NUMBER	NULL,
	del	CHAR(1)	NULL,
	regdate	DATE NULL,
	rpfileName	VARCHAR2(50) NULL,
	rType VARCHAR2(20)
);

CREATE TABLE reportreply (
	rrNo VARCHAR2(1000) NOT NULL,	
	rpNo	NUMBER	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	rprContent	VARCHAR2(1000)	NOT NULL,
	regdate	DATE	NULL,
	del	CHAR(1)	NULL
);

create table reservation(
	rsNo NUMBER NOT NULL,
	regdate DATE,
	startDate DATE,
	endDate DATE,
	cancel CHAR(1) default 'n',
	amount NUMBER NOT NULL,
	del CHAR(1) default 'n',
	carNo VARCHAR2(30),
	id VARCHAR2(20)
);

CREATE TABLE question (
	qNo	NUMBER	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	qTitle	VARCHAR2(100)	NULL,
	qContent	VARCHAR2(1000)	NULL,
	regdate	DATE	NULL,
	qRef	NUMBER	NULL,
	qRe_level	NUMBER	NULL,
	qRe_step	NUMBER	NULL,
	qfileName	VARCHAR2(50)	NULL,
	del char(1)
);

CREATE TABLE questionreply (
	qrNo	NUMBER	NOT NULL,
	qNo	NUMBER	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	qrContent	VARCHAR2(500)	NULL,
	regdate	DATE	NULL,
	del	CHAR(1)	NULL
);

CREATE TABLE notice (
	noNo	NUMBER	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	noTitle	VARCHAR2(100)	NULL,
	noContent	VARCHAR2(1000)	NULL,
	regdate	DATE	NULL,
	del char(1)
);

CREATE TABLE story (
	stNo NUMBER	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	stTitle	VARCHAR2(100)	NULL,
	stContent	VARCHAR2(1000)	NULL,
	stReadcount	NUMBER	NULL,
	regdate	DATE	NULL,
	sfileName	VARCHAR2(50)	NULL,
	del	CHAR(1)	NULL
);

CREATE TABLE storyreply (
	strNo	NUMBER	NOT NULL,
	stNo	NUMBER	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	strContent	VARCHAR2(500)	NULL,
	regdate	DATE	NULL,
	del	CHAR(1)	NULL
);

CREATE TABLE faq (
	faqTitle	VARCHAR2(100)	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	faqContents	VARCHAR2(1000)	NULL,
	del	CHAR(1)	NULL
);

CREATE TABLE ways (
	waysTitle	VARCHAR2(20)	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	waysContents	VARCHAR2(1000)	NULL,
	del	CHAR(1)	NULL
);
alter table ways modify (del default 'n');

ALTER TABLE member ADD CONSTRAINT PK_MEMBER PRIMARY KEY (
	id
);

ALTER TABLE car ADD CONSTRAINT PK_CAR PRIMARY KEY (
	carNo
);

ALTER TABLE review ADD CONSTRAINT PK_REVIEW PRIMARY KEY (
	rvNo	
);

ALTER TABLE charge ADD CONSTRAINT PK_CHARGE PRIMARY KEY (
	pay
);

ALTER TABLE report ADD CONSTRAINT PK_REPORT PRIMARY KEY (
	rpNo
);

ALTER TABLE reportreply ADD CONSTRAINT PK_REPORTREPLY PRIMARY KEY (
	rrNo
);

ALTER TABLE reservation ADD CONSTRAINT PK_reservation PRIMARY KEY (
	rsNo
);

ALTER TABLE question ADD CONSTRAINT PK_QUESTION PRIMARY KEY (
	qNo
);

ALTER TABLE questionreply ADD CONSTRAINT PK_QUESTIONREPLY PRIMARY KEY (
	qrNo
);

ALTER TABLE notice ADD CONSTRAINT PK_NOTICE PRIMARY KEY (
	noNo
);

ALTER TABLE story ADD CONSTRAINT PK_STORY PRIMARY KEY (
	stNo
);

ALTER TABLE storyreply ADD CONSTRAINT PK_STORYREPLY PRIMARY KEY (
	strNo
);

ALTER TABLE faq ADD CONSTRAINT PK_FAQ PRIMARY KEY (
	faqTitle
);

ALTER TABLE ways ADD CONSTRAINT PK_WAYS PRIMARY KEY (
	waysTitle
);

ALTER TABLE car ADD CONSTRAINT FK_member_TO_car_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE review ADD CONSTRAINT FK_car_TO_review_1 FOREIGN KEY (
	carNo
)
REFERENCES car (
	carNo
);

ALTER TABLE review ADD CONSTRAINT FK_car_TO_review_2 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE charge ADD CONSTRAINT FK_reservation_TO_charge_1 FOREIGN KEY (
	carNo
)
REFERENCES car (
	carNo
);

ALTER TABLE charge ADD CONSTRAINT FK_reservation_TO_charge_2 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE report ADD CONSTRAINT FK_member_TO_report_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE reportreply ADD CONSTRAINT FK_report_TO_reportreply_1 FOREIGN KEY (
	rpNo
)
REFERENCES report (
	rpNo
);

ALTER TABLE reportreply ADD CONSTRAINT FK_report_TO_reportreply_2 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE reservation ADD CONSTRAINT FK_car_TO_reservation_1 FOREIGN KEY (
	carNo
)
REFERENCES car (
	carNo
);

ALTER TABLE reservation ADD CONSTRAINT FK_car_TO_reservation_2 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE question ADD CONSTRAINT FK_member_TO_question_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE questionreply ADD CONSTRAINT FK_question_TO_questionreply_1 FOREIGN KEY (
	qNo
)
REFERENCES question (
	qNo
);

ALTER TABLE questionreply ADD CONSTRAINT FK_question_TO_questionreply_2 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE notice ADD CONSTRAINT FK_member_TO_notice_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE story ADD CONSTRAINT FK_member_TO_story_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE storyreply ADD CONSTRAINT FK_story_TO_storyreply_1 FOREIGN KEY (
	stNo
)
REFERENCES story (
	stNo
);

ALTER TABLE storyreply ADD CONSTRAINT FK_story_TO_storyreply_2 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE faq ADD CONSTRAINT FK_member_TO_faq_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE ways ADD CONSTRAINT FK_member_TO_ways_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);
