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
    'GeIL DDR4 8G PC4-21300 CL19 SUPER LUCE RGB Sync 화이트',
    52000,
    '단종시 만료',
    '2018년 5월',
    '140mm x 50mm ',
    'R/001.jpg',
    'R_'|| lpad(to_char(p_r_num_seq.NEXTVAL), 3, '0')
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
    'G.SKILL DDR4 16G PC4-25600 CL16 TRIDENT Z NEO (8Gx2)',
    16000,
    '단종시 만료',
    '2019년 9월',
    '140mm x 44mm',
    'R/002.jpg',
    'R_'|| lpad(to_char(p_r_num_seq.NEXTVAL), 3, '0')
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
    'G.SKILL DDR4 16G PC4-25600 CL16 TRIDENT Z ROYAL 실버 (8Gx2)',
    189990,
    '단종시 만료',
    '2019년 1월',
    '140mm x 44mm',
    'R/003.jpg',
    'R_'|| lpad(to_char(p_r_num_seq.NEXTVAL), 3, '0')
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
    'eamGroup T-Force DDR4 16G PC4-25600 CL16 Delta RGB 화이트 (8Gx2) 서린',
    103060,
    '단종시 만료',
    '2018년 12월',
    '146.8mm x 49mm',
    'R/004.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'G.SKILL DDR4 16G PC4-25600 CL16 TRIDENT Z RGB (8Gx2)',
    149990,
    '단종시 만료',
    '2017년 2월',
    '140mm x 44mm',
    'R/005.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'PATRIOT DDR4 16G PC4-21300 CL15 VIPER RGB (8Gx2)',
    104460,
    '단종시 만료',
    '2019년 05월',
    '135.7mm x 45.4mm',
    'R/006.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'ADATA XPG DDR4 16G PC4-25600 CL16 SPECTRIX D60G RGB (8Gx2)',
    151070,
    '단종시 만료',
    '2019년 08월',
    '133.3mm x 45.9mm',
    'R/007.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'G.SKILL DDR4 8G PC4-25600 CL16 AEGIS',
    44000,
    '단종시 만료',
    '2019년 9월',
    '140mm x 31.2mm',
    'R/008.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'ADATA XPG DDR4 16G PC4-21300 CL16 SPECTRIX D41 크림슨 레드 (8Gx2)',
    96780,
    '단종시 만료',
    '2018년 5월',
    '140mm x 44mm',
    'R/009.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'G.SKILL DDR4 64G PC4-25600 CL16 TRIDENT Z ROYAL 골드 (16Gx4)',
    600000,
    '단종시 만료',
    '2019년 5월',
    '140mm x 44mm',
    'R/010.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'TeamGroup T-Force DDR4 16G PC4-32000 CL18 Night Hawk RGB 화이트 (8Gx2) 서린',
    297700,
    '단종시 만료',
    '2018년 4월',
    '146.4mm x 52mm',
    'R/011.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'CORSAIR DDR4 32G PC4-25600 CL16 VENGEANCE PRO RGB BLACK INTEL (16Gx2)',
    259990,
    '단종시 만료',
    '2018년 9월',
    '138.3mm x 51.mm',
    'R/012.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'G.SKILL DDR4 32G PC4-25600 CL14 TRIDENT Z ROYAL 실버 (8Gx4)',
    650000,
    '단종시 만료',
    '2019년 2월',
    '140mm x 44mm',
    'R/013.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'PATRIOT DDR4 8G PC4-25600 CL16 VIPER STEEL',
    44000,
    '단종시 만료',
    '2019년 5월',
    '135.7mm x 44.4mm',
    'R/014.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    '삼성전자 DDR3 16G PC3-12800 ECC/REG LP (정품)',
    44950,
    '단종시 만료',
    '2012년 5월',
    NULL,
    'R/015.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'GeIL DDR4 32G PC4-21300 CL19 EVO X II AMD Gray RGB (16Gx2)',
    196000,
    '단종시 만료',
    '2019년 9월',
    '140mm x 60mm',
    'R/016.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'G.SKILL DDR4 32G PC4-25600 CL14 TRIDENT Z (16Gx2)',
    400000,
    '단종시 만료',
    '2018년 8월',
    '140mm x 44mm',
    'R/017.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'TeamGroup T-Force DDR4 16G PC4-28800 CL18 XTREEM 블랙 (8Gx2)',
    142000,
    '단종시 만료',
    '2019년 3월',
    '140mm x 44mm ',
    'R/018.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'Apacer DDR4 8G PC4-21300 CL16 PANTHER RAGE RGB 골드',
    51490,
    '단종시 만료',
    '2018년 10월',
    '132mm x 45mm',
    'R/019.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
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
    'Apacer DDR4 8G PC4-21300 CL16 PANTHER RAGE RGB 블랙',
    51500,
    '단종시 만료',
    '2018년 10월',
    '132mm x 45mm',
    'R/020.jpg',
    'R_'||LPAD(TO_CHAR(p_r_num_seq.NEXTVAL),3,'0')
);
