DROP TABLE guest02;
DROP TABLE user02;
DROP SEQUENCE guest02_seq;
DROP SEQUENCE user02_seq;

CREATE TABLE user02(
	num NUMBER PRIMARY KEY,
	id VARCHAR2(30) unique,
	pw VARCHAR2(30) not null,
	name VARCHAR2(30)
);
CREATE TABLE guest02(
	num NUMBER PRIMARY KEY,
	sub VARCHAR2(30),
	unum NUMBER,
	nalja DATE,
	pay NUMBER,
	FOREIGN KEY(unum) REFERENCES user02(num)
);


CREATE SEQUENCE guest02_seq;
CREATE SEQUENCE user02_seq;

commit

--dummy
INSERT INTO user02 values(user02_seq.nextval,'master', '1234','包府磊');
INSERT INTO user02 values(user02_seq.nextval,'user01', '1234','蜡历1');
INSERT INTO user02 values(user02_seq.nextval,'user02', '1234','蜡历2');

INSERT INTO guest02 values(guest02_seq.nextval,'sub1', 1,SYSDATE, 1111);
INSERT INTO guest02 values(guest02_seq.nextval,'sub2', 3,SYSDATE, 2222);
INSERT INTO guest02 values(guest02_seq.nextval,'sub3', 2,SYSDATE, 3333);
INSERT INTO guest02 values(guest02_seq.nextval,'sub4', 3,SYSDATE, 4444);
