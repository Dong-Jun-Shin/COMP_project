INSERT INTO trader
(tr_num, tr_name, tr_phone, tr_add, tr_bowner, tr_bnum, tr_bname)
VALUES('TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0')
,'더나와','02-7845-2236','서울특별시 용산구','이재민','213-224321-07563','하나은행');


INSERT INTO customer
(c_num, c_name, c_id, c_pw, c_phone, c_add, c_birth, c_email)
VALUES('C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
'이진형','jinYLee123','5322qwwe','010-3358-4532','경기도 광주시','1987/08/30','jinYLee123@naver.com');


INSERT INTO product
(p_name, p_price, p_size, p_grt, p_date, p_img, p_qty, p_num)
VALUES('Microsoft Office 365 Personal (PKC 한글)',54660
,NULL,'1년','2014/04/01','SW_001',1,'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0'));


INSERT INTO cd_order
(cd_num, cd_price, c_num)
VALUES(TO_CHAR(SYSDATE, 'yymmdd')||LPAD(TO_CHAR(cd_num_seq.NEXTVAL),4,'0')
,2120000,'C_003');


INSERT INTO order_chart
(ch_num, cd_num, ch_qty, p_num)
VALUES('O_'||LPAD(TO_CHAR(ch_num_seq.NEXTVAL),4,'0'),
'1911130009',1,'SW_004');


INSERT INTO warehouse
(wh_num, wh_qty, tr_num, p_num)
VALUES('WH_'||LPAD(TO_CHAR(wh_num_seq.NEXTVAL),4,'0'),
3,'TR_003','SW_004');






---------------------------- 값 입력 확인 -----------------------------

SELECT tr_num ,tr_name ,tr_phone ,tr_add ,tr_bowner ,tr_bnum ,tr_bname ,tr_reg 
FROM trader;

SELECT c_num ,c_name ,c_id ,c_pw ,c_phone ,c_add ,c_birth ,c_email ,c_reg 
FROM customer;

SELECT p_name ,p_price ,p_size ,p_grt ,p_date ,p_img ,p_qty ,p_num ,p_reg 
FROM product;

SELECT cd_num ,cd_sort ,cd_reg ,cd_price ,c_num 
FROM cd_order;

SELECT ch_num ,cd_num ,Ch_qty ,p_num 
FROM order_chart;

SELECT wh_num ,wh_qty ,tr_num ,p_num ,wh_reg 
FROM warehouse;
