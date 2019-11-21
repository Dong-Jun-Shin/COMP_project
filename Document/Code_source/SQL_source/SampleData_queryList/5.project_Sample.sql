
--고객번호.시퀀스 변경값에 맞춰서 넣기
INSERT INTO cd_order
(cd_num, cd_price, c_num)
VALUES(TO_CHAR(SYSDATE, 'yymmdd')||LPAD(TO_CHAR(cd_num_seq.NEXTVAL),4,'0')
,2120000,'C_003');

--주문번호.날짜와 시퀀스에 따라 생성된 값에 맞춰서 넣기
--제품번호.시퀀스 값에 따라 생성된 값에 맞춰서 넣기
INSERT INTO order_chart
(ch_num, cd_num, ch_qty, p_num)
VALUES('O_'||LPAD(TO_CHAR(ch_num_seq.NEXTVAL),4,'0'),
'1911180006',1,'SW_003');

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
