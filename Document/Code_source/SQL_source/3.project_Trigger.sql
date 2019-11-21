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