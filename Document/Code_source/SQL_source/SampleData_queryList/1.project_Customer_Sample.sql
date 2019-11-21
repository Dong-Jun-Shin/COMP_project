
--행 1
INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||Lpad(To_Char(C_Num_Seq.Nextval),3,'0'),
    '이진형',
    'jinYLee123',
    '5322qwwe',
    '010-3358-4532',
    '경기도 광주시',
    TO_DATE('1987/08/30'),
    'jinYLee123@naver.com'
);
--행 2

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '김대길',
    'BigLoad88',
    '8856aski75',
    '010-2254-4532',
    '경기도 남양주시',
    TO_DATE('1990/12/04'),
    'BigLoad88@daum.net'
);
-- 3  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 3

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '정용진',
    'DGJgaa545',
    'Cverpo5512',
    '010-8874-9536',
    '서울특별시 중구',
    TO_DATE('1998/03/12'),
    'DGJgaa545@naver.com'
);
-- 4  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 4

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '조용필',
    'kilimanjaro',
    'M0na11za',
    '010-3356-3214',
    '부산광역시 중구',
    TO_DATE('1964/01/22'),
    'kilimanjaro@naver.com'
);
-- 5  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 5

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '박대한',
    'minkuck324',
    'kor7687k',
    '010-5523-7687',
    '서울특별시 서초구',
    TO_DATE('1976/03/10'),
    'minkuck324@daum.net'
);
-- 6  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 6

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '광정수',
    'wholenum479',
    '371113num',
    '010-4431-8364',
    '경기도 성남시',
    TO_DATE('1996/11/28'),
    'wholenum479@naver.com'
);
-- 7  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 7

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '유한진',
    'cleaner687',
    'beat9600',
    '010-5514-6428',
    '경기도 이천시',
    TO_DATE('1996/06/21'),
    'cleaner687@nate.com'
);
-- 8  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 8

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '강정재',
    'rkdwjdwo9807',
    '79130218cvx',
    '010-1214-7913',
    '경기도 수원시',
    TO_DATE('2001/02/18'),
    'rkdwjdwo9807@naver.com'
);
-- 9  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 9

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '류사무엘',
    'christian333',
    'LS999ML',
    '010-3347-0825',
    '서울특별시 서초구',
    TO_DATE('2000/06/20'),
    'christian333@naver.com'
);
-- 10  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 10

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '장철',
    'longsteel643',
    'longger1997',
    '010-6967-4316',
    '서울특별시 강남구',
    TO_DATE('1997/12/10'),
    'longsteel643@naver.com'
);
-- 11  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 11

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '이아름',
    'arumi070',
    '08269536Arum',
    '010-8857-9536',
    '경기도 동두천시',
    TO_DATE('1963/08/26'),
    'arumi070@naver.com'
);
-- 12  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 12

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '김채원',
    'kitkatkitkat',
    'chunky7541',
    '010-4863-7541',
    '경기도 화성시',
    TO_DATE('1991/10/23'),
    'kitkatkitkat@naver.com'
);
-- 13  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 13

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '홍광호',
    'flatfish88',
    'sdsuh22336212',
    '010-8645-2132',
    '부산광역시 사상구',
    TO_DATE('1986/01/21'),
    'flatfish88@daum.net'
);
-- 14  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 14

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '이정아',
    'LeeJA222',
    '54242362qwer',
    '010-2623-5424',
    '대구광역시 달서구',
    TO_DATE('1983/12/23'),
    'LeeJA222@nate.com'
);
-- 15  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 15

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '정요한',
    'christYoHanS2',
    '9255jjct7255',
    '010-7563-7255',
    '강원도 평창군',
    TO_DATE('1990/11/11'),
    'christYoHanS2@naver.com'
);
-- 16  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 16

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '황인하',
    'HaaaaInsertH',
    'ha1152asdf',
    '010-7968-1152',
    '경기도 양평군',
    TO_DATE('1994/6/30'),
    'HaaaaInsertH@naver.com'
);
-- 17  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 17

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '마광수',
    'MaSitGerng999',
    'pigeonTO999',
    '010-2431-1247',
    '경기도 용인시',
    TO_DATE('1963/04/21'),
    'MaSitGerng999@naver.com'
);
-- 18  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 18

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '김지원',
    'jiwonKim500',
    '583492761kim',
    '010-2148-7787',
    '경기도 광주시',
    TO_DATE('1997/09/01'),
    'jiwonKim500@google.com'
);
-- 19  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 19

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '조민하',
    'BakeryJMA567',
    '979bak5532',
    '010-7935-7935',
    '대구광역시 달서구',
    TO_DATE('1984/02/21'),
    'BakeryJMA567@naver.com'
);
-- 20  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 20

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '유정표',
    'SteakerLJP',
    'myHeart7080',
    '010-3424-4457',
    '경기도 이천시',
    TO_DATE('1979/05/04'),
    'SteakerLJP@naver.com'
);
-- 21  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 21

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '주치원',
    'jooCYon0674',
    'jooChajang8953',
    '010-3568-8953',
    '경기도 부천시',
    TO_DATE('1995/11/30'),
    'jooCYon0674@naver.com'
);
-- 22  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 22

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '이지영',
    'LJYThe88years',
    'buipemi9898',
    '010-6878-2421',
    '서울특별시 강남구',
    TO_DATE('1988/12/10'),
    'LJYThe88years@naver.com'
);
-- 23  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 23

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '배은정',
    'LernnerJung5',
    'studing9735',
    '010-9896-9735',
    '경기도 고양시',
    TO_DATE('2004/01/05'),
    'LernnerJung5@google.com'
);
-- 24  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 24

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '최지원',
    'CJWonCJ',
    '1208cjenm8647',
    '010-8647-1208',
    '부산광역시 중구',
    TO_DATE('1992/06/08'),
    'CJWonCJ@google.com'
);
-- 25  행에 대한 삽입 실패
--C_BIRTH GDK-05046: 지정한 요일이 부적합합니다.
--행 25

INSERT INTO customer (
    c_num,
    c_name,
    c_id,
    c_pw,
    c_phone,
    c_add,
    c_birth,
    c_email
) VALUES (
    'C_'||LPAD(TO_CHAR(c_num_seq.NEXTVAL),3,'0'),
    '정혜지',
    'HyeJInoYumi',
    'youandme0824',
    '010-4235-0830',
    '경기도 남양주시',
    TO_DATE('1980/08/24'),
    'HyeJInoYumi@naver.com'
);