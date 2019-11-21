--테이블
DROP TABLE order_chart;
DROP TABLE warehouse;

DROP TABLE cd_order;

DROP TABLE customer;
DROP TABLE product;
DROP TABLE trader;


--시퀀스
DROP SEQUENCE c_num_seq;
DROP SEQUENCE cd_num_seq;
DROP SEQUENCE ch_num_seq; 
DROP SEQUENCE p_ca_num_seq;
DROP SEQUENCE p_co_num_seq;
DROP SEQUENCE p_cp_num_seq;
DROP SEQUENCE p_g_num_seq;
DROP SEQUENCE p_h_num_seq;
DROP SEQUENCE p_k_num_seq;
DROP SEQUENCE p_mb_num_seq;
DROP SEQUENCE p_mn_num_seq;
DROP SEQUENCE p_mo_num_seq;
DROP SEQUENCE p_po_num_seq;
DROP SEQUENCE p_r_num_seq;
DROP SEQUENCE p_sp_num_seq;
DROP SEQUENCE p_ss_num_seq;
DROP SEQUENCE p_sw_num_seq;
DROP SEQUENCE tr_num_seq;
DROP SEQUENCE wh_num_seq;

--트리거
DROP TRIGGER w_plus_trg;
DROP TRIGGER w_minus_trg;
DROP TRIGGER oc_minus_trg;
DROP TRIGGER oc_plus_trg;

--프로시저
DROP PROCEDURE reset_seq;