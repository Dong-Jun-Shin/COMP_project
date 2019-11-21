CREATE OR REPLACE TRIGGER  w_plus_trg
    AFTER INSERT ON warehouse
BEGIN
    UPDATE product SET p_qty = (p_qty + :NEW.wh_qty) WHERE p_qty = :NEW.p_qty;
END;
/

CREATE OR REPLACE TRIGGER  w_minus_trg
    AFTER DELETE ON warehouse
BEGIN
    UPDATE product SET p_qty = (p_qty - :OLD.wh_qty) WHERE  p_qty = :OLD.p_qty;
END;
/
CREATE OR REPLACE TRIGGER  oc_plus_trg
    AFTER INSERT ON ORDER_CHAR
BEGIN
    UPDATE product SET p_qty = (p_qty + :NEW.ch_qty) WHERE p_qty = :NEW.p_qty;
END;
/

CREATE OR REPLACE TRIGGER  oc_minus_trg
    AFTER DELETE ON ORDER_CHAR
BEGIN
    UPDATE product SET p_qty = (p_qty - :OLD.ch_qty) WHERE p_qty = :old.p_qty;
END;
/