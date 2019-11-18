CREATE TABLE trader
(
	tr_num               VARCHAR2(6) NOT NULL ,
	tr_name              VARCHAR2(30) NOT NULL ,
	tr_phone             VARCHAR2(13) NOT NULL ,
	tr_add               VARCHAR2(60) NOT NULL ,
	tr_bowner            VARCHAR2(12) NOT NULL ,
	tr_bnum              VARCHAR2(16) NOT NULL ,
	tr_bname             VARCHAR2(30) NOT NULL ,
	tr_reg               DATE DEFAULT  SYSDATE  NULL ,

	CONSTRAINT  TR_NUM_PK PRIMARY KEY (tr_num),
	CONSTRAINT  TR_BNUM_UK UNIQUE (tr_bnum)
);



CREATE TABLE product
(
	p_num                VARCHAR2(6) NOT NULL ,
	p_name               VARCHAR2(200) NOT NULL ,
	p_price              NUMBER DEFAULT  0  NOT NULL ,
	p_grt                VARCHAR2(30) NULL ,
	p_date               VARCHAR2(30) NULL ,
	p_size               VARCHAR2(120) NULL ,
	p_qty                NUMBER DEFAULT  0  NULL ,
	p_reg                DATE DEFAULT  SYSDATE  NULL ,
	p_img                VARCHAR2(150) NOT NULL ,

	CONSTRAINT  P_NUM_PK PRIMARY KEY (p_num)
);



CREATE TABLE warehouse
(
	wh_num               VARCHAR2(7) NOT NULL ,
	wh_qty               NUMBER NOT NULL ,
	wh_reg               DATE DEFAULT  SYSDATE  NULL ,
	p_num                VARCHAR2(6) NOT NULL ,
	tr_num               VARCHAR2(6) NOT NULL ,

	CONSTRAINT  WH_NUM_PK PRIMARY KEY (wh_num),
	CONSTRAINT R_19 FOREIGN KEY (tr_num) REFERENCES TRADER (tr_num),
	CONSTRAINT R_20 FOREIGN KEY (p_num) REFERENCES PRODUCT (p_num)
);



CREATE TABLE customer
(
	c_num                VARCHAR2(5) NOT NULL ,
	c_name               VARCHAR2(12) NOT NULL ,
	c_id                 VARCHAR2(30) NOT NULL ,
	c_pw                 VARCHAR2(30) NOT NULL ,
	c_phone              VARCHAR2(13) NOT NULL ,
	c_add                VARCHAR2(60) NOT NULL ,
	c_birth              DATE NOT NULL ,
	c_email              VARCHAR2(50) NOT NULL ,
	c_reg                DATE DEFAULT  SYSDATE  NULL ,

	CONSTRAINT  C_NUM_PK PRIMARY KEY (c_num),
	CONSTRAINT  C_ID_UK UNIQUE (c_id)
);



CREATE TABLE cd_order
(
	c_num                VARCHAR2(5) NOT NULL ,
	cd_num               VARCHAR2(10) NOT NULL ,
	cd_reg               DATE DEFAULT  SYSDATE  NULL ,
	cd_price             NUMBER DEFAULT  0  NOT NULL ,
	cd_sort              VARCHAR2(12) DEFAULT  '거래중'  NULL ,

	CONSTRAINT  CD_NUM_PK PRIMARY KEY (cd_num),
	CONSTRAINT R_12 FOREIGN KEY (c_num) REFERENCES CUSTOMER (c_num)
);



CREATE TABLE order_chart
(
	ch_num               VARCHAR2(6) NOT NULL ,
	p_num                VARCHAR2(6) NOT NULL ,
	ch_qty               NUMBER DEFAULT  0  NOT NULL ,
	cd_num               VARCHAR2(10) NOT NULL ,

	CONSTRAINT  CH_NUM_PK PRIMARY KEY (ch_num),
	CONSTRAINT R_16 FOREIGN KEY (cd_num) REFERENCES CD_ORDER (cd_num),
	CONSTRAINT R_18 FOREIGN KEY (p_num) REFERENCES PRODUCT (p_num)
);