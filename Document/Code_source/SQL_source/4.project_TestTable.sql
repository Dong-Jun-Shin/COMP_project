
CREATE TABLE order_chart_test
AS SELECT * FROM order_chart;

CREATE TABLE product_test
AS SELECT * FROM product;

CREATE TABLE warehouse_test
AS SELECT * FROM warehouse;

CREATE TABLE customer_test
AS SELECT * FROM customer;

CREATE TABLE cd_order_test
AS SELECT * FROM cd_order;

CREATE TABLE trader_test
AS SELECT * FROM trader;

DROP TABLE customer_test;
DROP TABLE cd_order_test;
DROP TABLE trader_test;
DROP TABLE warehouse_test;
DROP TABLE product_test;
DROP TABLE order_chart_test;

