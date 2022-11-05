drop table member;
drop table member cascade constraint;
drop table car;
drop table review;
drop table charge;
drop table report;
drop table reportreply;
drop table reserve;
drop table question;
drop table questionreply;
drop table notice;
drop table story;
drop table storyreply;
drop table faq;
drop table ways;

CREATE TABLE member (
	id VARCHAR2(20) NOT NULL,
	password VARCHAR2(100) NULL,
	name VARCHAR2(10) NULL,
	address VARCHAR2(40) NULL,
	tel VARCHAR2(20) NULL,
	email VARCHAR2(30) NULL,
	birth VARCHAR2(30) NULL,
	gender CHAR(1) NULL,
	del CHAR(1) NULL,
	regdate DATE NULL,
	mfileName	VARCHAR2(50) NULL,
	ad CHAR(1) NULL
);
alter table member modify (ad default 'n');
alter table member modify (del default 'n');

CREATE TABLE car (
	carNo	VARCHAR2(10)	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	carName	VARCHAR2(10)	NULL,
	carRank	VARCHAR2(10)	NULL,
	carKind	VARCHAR2(20)	NULL,
	carType	VARCHAR2(5)	NULL,
	carYear	VARCHAR2(10)	NULL,
	fee	NUMBER	NULL,
	carColor	VARCHAR2(10)	NULL,
	carRegion	VARCHAR2(30)	NULL,
	del	CHAR(1)	NULL,
	cfileName	VARCHAR2(50)	NULL,
	carRes	char(1)	NULL 
);

alter table car modify (carRes default 'n');

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
	rpRead	CHAR(1)	NULL,
	del	CHAR(1)	NULL,
	regdate	DATE	NULL,
	rpfileName	VARCHAR2(50)	NULL
);

CREATE TABLE reportreply (
	rprContent	VARCHAR2(500)	NOT NULL,
	rpNo	NUMBER	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	regdate	DATE	NULL,
	del	CHAR(1)	NULL
);

CREATE TABLE reserve (
	rsNo	NUMBER	NOT NULL,
	carNo	VARCHAR2(10)	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	regdate	DATE	NULL,
	cancel	CHAR(1)	NULL,
	del	CHAR(1)	NULL
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
	qfileName	VARCHAR2(50)	NULL
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
	regdate	DATE	NULL
);
alter table notice add del char(1);
select * from notice;

CREATE TABLE story (
	stNo	NUMBER	NOT NULL,
	id	VARCHAR2(20)	NOT NULL,
	stTitle	VARCHAR2(100)	NULL,
	stContent	VARCHAR2(1000)	NULL,
	stReadcount	NUMBER	NULL,
	stRef	NUMBER	NULL,
	stRe_level	NUMBER	NULL,
	stRe_step	NUMBER	NULL,
	regdate	DATE	NULL,
	sfileName	VARCHAR2(50)	NULL,
	stLike	NUMBER	NULL,
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
	faqTitle	VARCHAR2(20)	NOT NULL,
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
alter table ways modify (ad default 'n');
select*from ways;

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
	rprContent
);

ALTER TABLE reserve ADD CONSTRAINT PK_RESERVE PRIMARY KEY (
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

ALTER TABLE charge ADD CONSTRAINT FK_reserve_TO_charge_1 FOREIGN KEY (
	carNo
)
REFERENCES car (
	carNo
);

ALTER TABLE charge ADD CONSTRAINT FK_reserve_TO_charge_2 FOREIGN KEY (
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

ALTER TABLE reserve ADD CONSTRAINT FK_car_TO_reserve_1 FOREIGN KEY (
	carNo
)
REFERENCES car (
	carNo
);

ALTER TABLE reserve ADD CONSTRAINT FK_car_TO_reserve_2 FOREIGN KEY (
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


