CREATE TABLE TRADER
(
	TR_NUM               VARCHAR2(6) NOT NULL ,
	TR_NAME              VARCHAR2(30) NOT NULL ,
	TR_PHONE             VARCHAR2(13) NOT NULL ,
	TR_ADD               VARCHAR2(60) NOT NULL ,
	TR_BOWNER            VARCHAR2(12) NOT NULL ,
	TR_BNUM              VARCHAR2(16) NOT NULL ,
	TR_BNAME             VARCHAR2(30) NOT NULL ,
	TR_REG               DATE DEFAULT  SYSDATE  NULL ,

	CONSTRAINT  TR_NUM_PK PRIMARY KEY (TR_NUM),
	CONSTRAINT  TR_BNUM_UK UNIQUE (TR_BNUM)
);



CREATE TABLE PRODUCT
(
	P_NAME               VARCHAR2(200) NOT NULL ,
	P_PRICE              NUMBER DEFAULT  0  NOT NULL ,
	P_SIZE               VARCHAR2(120) NULL ,
	P_GRT                VARCHAR2(30) NULL ,
	P_DATE               DATE NULL ,
	P_IMG                VARCHAR2(150) NOT NULL ,
	P_QTY                NUMBER DEFAULT  0  NULL ,
	P_NUM                VARCHAR2(6) NOT NULL ,
	P_REG                DATE DEFAULT  SYSDATE  NULL ,

	CONSTRAINT  P_NUM_PK PRIMARY KEY (P_NUM)
);



CREATE TABLE WAREHOUSE
(
	WH_NUM               VARCHAR2(7) NOT NULL ,
	WH_QTY               NUMBER NOT NULL ,
	TR_NUM               VARCHAR2(6) NOT NULL ,
	P_NUM                VARCHAR2(6) NOT NULL ,
	WH_REG               DATE DEFAULT  SYSDATE  NULL ,

	CONSTRAINT  WH_NUM_PK PRIMARY KEY (WH_NUM),
	CONSTRAINT R_19 FOREIGN KEY (TR_NUM) REFERENCES TRADER (TR_NUM),
	CONSTRAINT R_20 FOREIGN KEY (P_NUM) REFERENCES PRODUCT (P_NUM)
);



CREATE TABLE CUSTOMER
(
	C_NUM                VARCHAR2(5) NOT NULL ,
	C_NAME               VARCHAR2(12) NOT NULL ,
	C_ID                 VARCHAR2(30) NOT NULL ,
	C_PW                 VARCHAR2(30) NOT NULL ,
	C_PHONE              VARCHAR2(13) NOT NULL ,
	C_ADD                VARCHAR2(60) NOT NULL ,
	C_BIRTH              DATE NOT NULL ,
	C_EMAIL              VARCHAR2(50) NOT NULL ,
	C_REG                DATE DEFAULT  SYSDATE  NULL ,

	CONSTRAINT  C_NUM_PK PRIMARY KEY (C_NUM),
	CONSTRAINT  C_ID_UK UNIQUE (C_ID)
);



CREATE TABLE CD_ORDER
(
	CD_NUM               VARCHAR2(10) NOT NULL ,
	CD_SORT              VARCHAR2(12) DEFAULT  '�ŷ���'  NULL ,
	CD_REG               DATE DEFAULT  SYSDATE  NULL ,
	CD_PRICE             NUMBER DEFAULT  0  NOT NULL ,
	C_NUM                VARCHAR2(5) NOT NULL ,

	CONSTRAINT  CD_NUM_PK PRIMARY KEY (CD_NUM),
	CONSTRAINT R_12 FOREIGN KEY (C_NUM) REFERENCES CUSTOMER (C_NUM)
);



CREATE TABLE ORDER_CHART
(
	CH_NUM               VARCHAR2(6) NOT NULL ,
	CD_NUM               VARCHAR2(10) NOT NULL ,
	CH_QTY               NUMBER DEFAULT  0  NOT NULL ,
	P_NUM                VARCHAR2(6) NOT NULL ,

	CONSTRAINT  CH_NUM_PK PRIMARY KEY (CH_NUM),
	CONSTRAINT R_16 FOREIGN KEY (CD_NUM) REFERENCES CD_ORDER (CD_NUM),
	CONSTRAINT R_18 FOREIGN KEY (P_NUM) REFERENCES PRODUCT (P_NUM)
);