--행 1
INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'APPLE 애플케어 플러스 아이패드 프로 S6540ZX/A',
    136250,
    '2년',
    '2019년 10월',
    '아이패드',
    'SW/001.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 2

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Microsoft Visual Studio 2019 Professional 기업용 (라이선스)',
    594240,
    '기간없음',
    '2019년 4월',
    '윈도우',
    'SW/002.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 3

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Microsoft Office 365 Personal (PKC 한글)',
    54660,
    '1년',
    '2014년 4월',
    '윈도우/맥',
    'SW/003.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 4

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    '맥아피 McAfee AntiVirus Plus (1년 처음사용자용)',
    7900,
    '1년',
    '2015년 1월',
    NULL,
    'SW/004.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 5

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Microsoft Office 365 Home (PKC 한글)',
    94390,
    '1년',
    '2013년 10월',
    '윈도우/맥',
    'SW/005.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 6

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Microsoft Windows 7 Professional (DSP 64bit 한글)',
    167500,
    '기간없음',
    '2009년 10월',
    NULL,
    'SW/006.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 7

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    '한글과컴퓨터 한컴 오피스 2018 기업용 (MLP COEM)',
    288990,
    '기간없음',
    '2018년 8월',
    NULL,
    'SW/007.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 8

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    '한글과컴퓨터 한컴 한글 2018 기업용 (처음사용자용)',
    352800,
    '기간없음',
    '2017년 11월',
    NULL,
    'SW/008.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 9

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Adobe Photoshop CC (1년 라이선스 기업용)',
    519390,
    '1년',
    '2014년 3월',
    '윈도우/맥',
    'SW/009.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 10

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Microsoft Office 2016 Home & Business (ESD 다운로드용)',
    267530,
    '기간없음',
    '2015년 9월',
    '윈도우',
    'SW/010.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 11

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Microsoft Windows 7 Home Premium (DSP 32bit 한글)',
    97200,
    '기간없음',
    '2009년 10월',
    NULL,
    'SW/011.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 12

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'IRIS Readiris Corporate 17 (처음사용자용)',
    212580,
    NULL,
    '2019년 5월',
    '윈도우',
    'SW/012.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 13

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    '오토데스크 AutoCAD LT (1년 라이선스)',
    537950,
    '1년',
    '2017년 8월',
    '윈도우',
    'SW/013.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 14

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Microsoft Office 2019 Home & Student (PKC 한글)',
    110580,
    '기간없음',
    '2018년 10월',
    '윈도우/맥',
    'SW/014.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 15

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Microsoft Windows 10 Home (처음사용자용 한글)',
    170230,
    NULL,
    '2015년 8월',
    NULL,
    'SW/015.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 16

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Parallels Desktop 15 for Mac (처음사용자용)',
    108940,
    NULL,
    '2019년 8월',
    '맥',
    'SW/016.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 17

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Trimble SketchUp Pro 2019 학생용 (1년 라이선스)',
    58530,
    '1년',
    '2019년 2월',
    NULL,
    'SW/017.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 18

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'MAGIX Vegas Pro 17 Edit 기업용 (ESD)',
    355790,
    NULL,
    '2019년 8월',
    '윈도우',
    'SW/018.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 19

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    '스토리맵 판매 재고관리 GOLD 프로그램',
    76820,
    NULL,
    '2018년 3월',
    '윈도우',
    'SW/019.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);
--행 20

INSERT INTO product (
    p_name,
    p_price,
    p_grt,
    p_date,
    p_size,
    p_img,
    p_num
) VALUES (
    'Corel CorelDRAW Graphics Suite X5 기업용 (라이선스 한글)',
    631910,
    NULL,
    '2016년 4월',
    '윈도우',
    'SW/020.jpg',
    'SW_'||LPAD(TO_CHAR(p_sw_num_seq.NEXTVAL),3,'0')
);