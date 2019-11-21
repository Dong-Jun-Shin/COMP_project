--입고테이블 추가 시, 제품 수량 증가
CREATE OR REPLACE TRIGGER  w_plus_trg
    AFTER INSERT ON warehouse
    FOR EACH ROW
BEGIN
    UPDATE product SET p_qty = (p_qty + :NEW.wh_qty) WHERE p_num =:NEW.p_num;
END;
/

--입고테이블 삭제 시, 제품 수량 감소
CREATE OR REPLACE TRIGGER  w_minus_trg
    AFTER DELETE ON warehouse
    FOR EACH ROW
BEGIN
    UPDATE product SET p_qty = (p_qty - :OLD.wh_qty) WHERE  p_num =:OLD.p_num;
END;
/

--주문내역테이블 추가 시, 제품 수량 감소
CREATE OR REPLACE TRIGGER  oc_minus_trg
    AFTER INSERT ON order_chart
    FOR EACH ROW
BEGIN
    UPDATE product SET p_qty = (p_qty - :NEW.ch_qty) WHERE p_num =:NEW.p_num;
END;
/

--주문내역테이블 삭제 시, 제품 수량 증가
CREATE OR REPLACE TRIGGER  oc_plus_trg
    AFTER DELETE ON order_chart
    FOR EACH ROW
BEGIN
    UPDATE product SET p_qty = (p_qty + :OLD.ch_qty) WHERE p_num =:old.p_num;
END;
/

--트리거 삭제문
DROP TRIGGER w_plus_trg;
DROP TRIGGER w_minus_trg;
DROP TRIGGER oc_minus_trg;
DROP TRIGGER oc_plus_trg;


-----------------------------------------------------------------------------------------------------------------
--시퀀스 초기화 프로시저
CREATE OR REPLACE PROCEDURE reset_seq(
                p_seq_name IN VARCHAR2 )
IS
        l_val NUMBER;
BEGIN
        EXECUTE immediate 'select ' || p_seq_name || '.nextval from dual' INTO l_val;
        EXECUTE immediate 'alter sequence ' || p_seq_name || ' increment by -' || l_val || ' minvalue 0';
        EXECUTE immediate 'select ' || p_seq_name || '.nextval from dual' INTO l_val;
        EXECUTE immediate 'alter sequence ' || p_seq_name || ' increment by 1 minvalue 0';
END;
/

--CD_ORDER 날짜 '일'(주문 등록일 기준) 기준으로 날(SYSDATE)이 변경되면 주문시퀀스 초기화
CREATE OR REPLACE TRIGGER  cd_num_trg
    BEFORE INSERT ON CD_ORDER    
DECLARE 
    sys_day VARCHAR2(6);
    tbl_day VARCHAR2(6);
BEGIN  
    SELECT TO_CHAR(SYSDATE, 'YYMMDD') INTO sys_day FROM DUAL;
    SELECT TO_CHAR(cd_reg, 'YYMMDD') INTO tbl_day FROM cd_order WHERE rownum = 1 ORDER BY cd_reg;
    
    IF sys_day <> tbl_day THEN
        reset_seq('cd_num_seq');
    END IF;
END;
/

--CD_ORDER 행 생성 시, ORDER_CHART 내역시퀀스 초기화 (트리거)
CREATE OR REPLACE TRIGGER  oc_num_trg
    AFTER INSERT ON CD_ORDER 
BEGIN  
    reset_seq('ch_num_seq');
END;
/
---------------------------------------------------------------------------------------------------------------