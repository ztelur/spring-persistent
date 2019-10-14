-- 两个库 demo_ds_0、demo_ds_1, 包含两个表：t_order_0、t_order_1

-- 建库SQL如下：
DROP SCHEMA IF EXISTS demo_ds_0;
DROP SCHEMA IF EXISTS demo_ds_1;
CREATE SCHEMA IF NOT EXISTS demo_ds_0;
CREATE SCHEMA IF NOT EXISTS demo_ds_1;

-- 建表SQL如下：
CREATE TABLE IF NOT EXISTS t_order_0 (order_id BIGINT AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS t_order_item_0 (order_item_id BIGINT AUTO_INCREMENT, order_id BIGINT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));

CREATE TABLE IF NOT EXISTS t_order_1 (order_id BIGINT AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS t_order_item_1 (order_item_id BIGINT AUTO_INCREMENT, order_id BIGINT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_item_id));


CREATE TABLE t_order1
(
  order_id bigint PRIMARY KEY,
  role_id bigint,
  time timestamp,
  state int
);