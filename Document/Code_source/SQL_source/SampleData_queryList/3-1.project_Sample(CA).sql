-- 1 에서  20  행에 대한 삽입 실패
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
    '인텔 코어i7-9세대 9700K (커피레이크-R)(정품)',
    488710,
    '3년',
    '2018년10월',
    NULL,
    'CP/001.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 코어i9-9세대 9900KS (커피레이크-R)(정품)',
    922630,
    '1년',
    '2019년 10월',
    NULL,
    'CP/002.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    'AMD 라이젠 5 3600 (마티스)(정품)',
    291940,
    NULL,
    '2019년 7월',
    NULL,
    'CP/003.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 코어i5-9세대 9600KF (커피레이크-R)(정품)',
    254040,
    '3년',
    '2019년 3월',
    NULL,
    'CP/004.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    'AMD 애슬론 200GE (레이븐 릿지)(정품)',
    62500,
    NULL,
    '2018년 10월',
    NULL,
    'CP/005.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 코어i7-9세대 9700 (커피레이크-R)(정품)',
    462640,
    '3년',
    '2019년 7월',
    NULL,
    'CP/006.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 셀러론 G4900 (커피레이크)(정품)',
    78160,
    '3년',
    '2018년 4월',
    NULL,
    'CP/007.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    'AMD 라이젠 9 3900X (마티스)(멀티팩)',
    744290,
    '2년',
    '2019년 8월',
    NULL,
    'CP/008.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    'AMD 라이젠 스레드리퍼 2990WX (콜팩스)(정품)',
    2231740,
    '2년',
    '2018년 8월',
    NULL,
    'CP/009.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 코어i3-4세대 4160 (하스웰 리프레시)(병행수입 박스)',
    153660,
    '1년',
    '2014년 8월',
    NULL,
    'CP/010.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 펜티엄 G3260 (하스웰 리프레시)(벌크)',
    81110,
    NULL,
    '2015년 5월',
    NULL,
    'CP/011.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 제온 스케일러블 브론즈 3104 (스카이레이크)(정품)',
    356620,
    '2년',
    '2017년 9월',
    NULL,
    'CP/012.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 제온 스케일러블 실버 4208 (캐스케이드레이크)(정품)',
    675400,
    '2년',
    '2019년 8월',
    NULL,
    'CP/013.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    'AMD 라이젠 5 2600 (피나클 릿지) (스페셜팩)',
    194980,
    '3년',
    '2018년 12월',
    NULL,
    'CP/014.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 코어i5-9세대 9600KF (커피레이크-R)(병행수입 박스)',
    257390,
    '2년',
    '2019년 5월',
    NULL,
    'CP/015.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 코어i9-9세대 9900 (커피레이크-R)(벌크)',
    604970,
    NULL,
    '2019년 8월',
    NULL,
    'CP/016.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    'AMD 라이젠 5 1600X (서밋 릿지)(멀티팩)',
    221960,
    '1년',
    '2017년 4월',
    NULL,
    'CP/017.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 제온 스케일러블 골드 6130 (스카이레이크)(정품)',
    3031280,
    '2년',
    '2017년 9월',
    NULL,
    'CP/018.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 제온 E3-1230V6 (카비레이크)(정품)',
    416890,
    '2년',
    '2017년 5월',
    NULL,
    'CP/019.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
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
    '인텔 코어i5-7세대 7500 (카비레이크)(병행수입 박스)',
    268800,
    '2년',
    '2017년 1월',
    NULL,
    'CP/020.jpg',
    'CP_'||LPAD(TO_CHAR(p_cp_num_seq.NEXTVAL),3,'0')
);