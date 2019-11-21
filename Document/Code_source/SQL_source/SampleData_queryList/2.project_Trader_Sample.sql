-- 1 에서  25  행에 대한 삽입 실패
--ORA-12899: "COMPADMIN"."TRADER"."TR_NUM" 열에 대한 값이 너무 큼(실제: 45, 최대값: 6)
--행 1
INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '더나와',
    '02-7845-2236',
    '서울특별시 용산구',
    '이재민',
    '213-224321-07563',
    '하나은행'
);
--행 2

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '컴용사',
    '02-6698-3364',
    '서울특별시 용산구',
    '김철수',
    '0021-035-253426',
    '우리은행'
);
--행 3

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '컴마스터',
    '02-9986-7698',
    '서울특별시 용산구',
    '박영호',
    '226325-01-253667',
    '국민은행'
);
--행 4

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '컴과장',
    '02-4587-5456',
    '서울특별시 용산구',
    '정동진',
    '045-1231-4464-31',
    'NH농협은행'
);
--행 5

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '앗RAM 신발보다 싸다',
    '02-6987-5460',
    '서울특별시 용산구',
    '한정하',
    '453-212-456741',
    '신한은행'
);
--행 6

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '트레비PC',
    '02-6421-1561',
    '서울특별시 용산구',
    '김정민',
    '231246-04-126887',
    '국민은행'
);
--행 7

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '금성컴퓨터',
    '02-1246-8956',
    '서울특별시 용산구',
    '이금성',
    '063-3231-4564-32',
    'NH농협은행'
);
--행 8

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '케이스메이커',
    '02-3167-3572',
    '서울특별시 용산구',
    '조진영',
    '213162-05-231663',
    '국민은행'
);
--행 9

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '삼별모니터',
    '02-7934-7525',
    '서울특별시 용산구',
    '이지호',
    '654-6345-3322-11',
    'NH농협은행'
);
--행 10

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '한전파워서플라이',
    '02-5715-7563',
    '서울특별시 용산구',
    '박재원',
    '413-225132-16741',
    '하나은행'
);
--행 11

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    'nanoSoft',
    '02-8533-8841',
    '서울특별시 용산구',
    '광정호',
    '0021-315-256421',
    '우리은행'
);
--행 12

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    'PvidiaKorea',
    '02-4567-1237',
    '서울특별시 용산구',
    '라일성',
    '0022-415-322100',
    '우리은행'
);
--행 13

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '보드갤러리',
    '02-8547-6890',
    '서울특별시 용산구',
    '이성주',
    '112363-06-234511',
    '국민은행'
);
--행 14

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '설빙Cooler',
    '02-3597-2020',
    '서울특별시 용산구',
    '김영재',
    '553-8659-9932-12',
    'NH농협은행'
);
--행 15

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    'rugitecMouse',
    '02-1005-3024',
    '서울특별시 용산구',
    '황정원',
    '321101-45-662123',
    '국민은행'
);
--행 16

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '로컬SSD/HDD',
    '02-8024-4302',
    '서울특별시 용산구',
    '류재원',
    '552-653225-23421',
    '신한은행'
);
--행 17

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '샷건키보드',
    '02-1254-9562',
    '서울특별시 용산구',
    '김지석',
    '0132-114-556357',
    '우리은행'
);
--행 18

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    'AMonD',
    '02-4634-1379',
    '서울특별시 용산구',
    '배철수',
    '221204-06-641005',
    '국민은행'
);
--행 19

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '금성모니터',
    '02-5621-8643',
    '서울특별시 용산구',
    '이재영',
    '1231-653-631238',
    '우리은행'
);
--행 20

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '스피커맥스',
    '02-7894-8478',
    '서울특별시 용산구',
    '정주형',
    '532-621231-27531',
    '하나은행'
);
--행 21

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    'AdoGenCreaterSW',
    '02-2108-0013',
    '서울특별시 용산구',
    '박광열',
    '561-252234-23543',
    '신한은행'
);
--행 22

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    'MegaByte',
    '02-1785-7534',
    '서울특별시 용산구',
    '최철웅',
    '562-242113-45632',
    '신한은행'
);
--행 23

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    'mountinGate',
    '02-3563-6443',
    '서울특별시 용산구',
    '홍민기',
    '021-766671-52500',
    '신한은행'
);
--행 24

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    'RADEOFF',
    '02-6533-5532',
    '서울특별시 용산구',
    '황재성',
    '768-8436-1743-86',
    'NH농협은행'
);
--행 25

INSERT INTO trader (
    tr_num,
    tr_name,
    tr_phone,
    tr_add,
    tr_bowner,
    tr_bnum,
    tr_bname
) VALUES (
    'TR_'||LPAD(TO_CHAR(tr_num_seq.NEXTVAL),3,'0'),
    '11번컴퓨터',
    '02-1236-7411',
    '서울특별시 용산구',
    '박경원',
    '1303-451-441325',
    '우리은행'
);