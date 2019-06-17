DROP TABLE guest01;
DROP SEQUENCE guest01_seq;

CREATE TABLE guest01(
	num NUMBER PRIMARY KEY,
	sub VARCHAR2(30),
	nalja DATE,
	pay NUMBER
);
CREATE SEQUENCE guest01_seq;

INSERT INTO guest01 values(guest01_seq.nextval, 'test1', SYSDATE, 1111);
INSERT INTO guest01 values(guest01_seq.nextval, 'test2', SYSDATE, 2222);
INSERT INTO guest01 values(guest01_seq.nextval, 'test3', SYSDATE, 3333);
INSERT INTO guest01 values(guest01_seq.nextval, 'test4', SYSDATE, 4444);
commit;