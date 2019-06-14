DROP table bbs05;
DROP sequence bbs05_seq;
CREATE table bbs05(
	num NUMBER PRIMARY KEY,
	sub VARCHAR2(30),
	content VARCHAR2(2000),
	name VARCHAR2(15),
	nalja DATE
	
);
CREATE sequence bbs05_seq;

--dummy
INSERT INTO bbs05 VALUES(bbs05_seq.nextval, 'test1', 'test', 'tester',sysdate);
INSERT INTO bbs05 VALUES(bbs05_seq.nextval, 'test2', 'test', 'tester',sysdate);
INSERT INTO bbs05 VALUES(bbs05_seq.nextval, 'test3', 'test', 'tester',sysdate);
INSERT INTO bbs05 VALUES(bbs05_seq.nextval, 'test4', 'test', 'tester',sysdate);
INSERT INTO bbs05 VALUES(bbs05_seq.nextval, 'test5', 'test', 'tester',sysdate);
commit;

SELECT * FROM bbs05;
