-- ADMLTest
# 如果存在 tb_ch11_user 表則刪除
DROP TABLE  IF EXISTS tb_ch11_user;
# 創建一個 tb_user 表, 有 id,name,sex,age 列
CREATE TABLE  tb_ch11_user(
  ID INT(11) PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(18) DEFAULT NULL,
  SEX CHAR(2) DEFAULT NULL,
  AGE INT(11) DEFAULT NULL
);

-- OneToOne
# 如果存在 tb_ch11_card 表則刪除
DROP TABLE  IF EXISTS tb_ch11_card;
CREATE TABLE  tb_ch11_card(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CODE VARCHAR(18)
);

# 如果存在 tb_ch11_person 表則刪除
DROP TABLE  IF EXISTS tb_ch11_person;
CREATE TABLE  tb_ch11_person(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(18),
  SEX VARCHAR(18) ,
  AGE INT,
  CARD_ID INT UNIQUE,
  FOREIGN  KEY (CARD_ID) REFERENCES tb_card(ID)
);

-- OneToMany

# 如果存在 tb_ch11_clazz 表則刪除
DROP TABLE  IF EXISTS tb_ch11_clazz;
# 創建一個 tb_ch11_clazz 表
CREATE TABLE  tb_ch11_clazz(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CODE VARCHAR(18),
  NAME VARCHAR(18)
);

# 如果存在 tb_ch11_student 表則刪除
DROP TABLE  IF EXISTS tb_ch11_student;
# 創建一個 tb_ch11_student 表
CREATE TABLE  tb_ch11_student(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(18),
  SEX CHAR(3),
  AGE INT,
  CLAZZ_ID INT,
  FOREIGN  KEY (CLAZZ_ID) REFERENCES tb_ch11_clazz(ID)
);


-- ManyToMany

# 如果存在 tb_ch11_ManyToMany_user 表則刪除
DROP TABLE  IF EXISTS tb_ch11_ManyToMany_user;
# 創建一個 tb_ch11_ManyToMany_user 表, 有 id,name,sex,age 列
CREATE TABLE  tb_ch11_ManyToMany_user(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  USERNAME VARCHAR (18),
  LOGINNAME VARCHAR (18),
  PASSWORD VARCHAR (18),
  PHONE VARCHAR (18),
  ADDRESS VARCHAR (18)
);

# 如果存在 tb_ch11_article 表則刪除
DROP TABLE  IF EXISTS tb_ch11_article;
CREATE TABLE  tb_ch11_article(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR (18),
  PRICE DOUBLE,
  REMARK VARCHAR (18)
);


# 如果存在 tb_ch11_order 表則刪除
DROP TABLE  IF EXISTS tb_ch11_order;
CREATE TABLE  tb_ch11_order(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CODE VARCHAR (32),
  TOTAL DOUBLE,
  USER_ID INT,
  FOREIGN  KEY (USER_ID) REFERENCES tb_user(ID)
);


# 如果存在 tb_ch11_item 表則刪除
DROP TABLE  IF EXISTS tb_ch11_item;
CREATE TABLE  tb_ch11_item(
  ORDER_ID INT,
  ARTICLE_ID INT,
  AMOUNT INT,
  PRIMARY KEY (ORDER_ID,ARTICLE_ID),
  FOREIGN  KEY (ORDER_ID) REFERENCES tb_order(ID),
  FOREIGN  KEY (ARTICLE_ID) REFERENCES tb_article(ID)
);

-- DynamicSQL

# 如果存在 tb_employee 表則刪除
DROP TABLE  IF EXISTS tb_ch11_employee;
CREATE TABLE  tb_ch11_employee(
  ID INT(11) PRIMARY KEY AUTO_INCREMENT,
  LOGINNAME VARCHAR (18),
  PASSWORD VARCHAR (18),
  NAME VARCHAR (18),
  SEX CHAR(2) DEFAULT NULL,
  AGE INT(11) DEFAULT NULL,
  PHONE VARCHAR (21),
  SAL DOUBLE ,
  STATE VARCHAR (18)
);

-- Procedure

DROP TABLE  IF EXISTS tb_ch11_user_pro;
# 創建一個 tb_ch11_user_pro 表, 有 id,name,sex,age 列
CREATE TABLE  tb_ch11_user_pro(
  ID INT(11) PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(18) DEFAULT NULL,
  SEX CHAR(2) DEFAULT NULL,
  AGE INT(11) DEFAULT NULL
);


# 插入數據的存儲過程
DROP PROCEDURE IF EXISTS insert_ch11_user;
DELIMITER//
CREATE  PROCEDURE insert_ch11_user (OUT V_ID INTEGER , IN V_NAME VARCHAR (18),IN V_SEX VARCHAR (19),IN V_AGE INTEGER )
BEGIN
INSERT INTO tb_ch11_user_pro (NAME,SEX,AGE) VALUES (V_NAME,V_SEX,V_AGE);
SET V_ID = LAST_INSERT_ID();
END

# 查詢所有數據的存儲過程
DROP PROCEDURE IF EXISTS select_ch11_user;
CREATE PROCEDURE select_ch11_user()
BEGIN
SELECT id,NAME,sex,age FROM tb_user_pro;
END

# 根據id查詢數據的存儲過程
DROP PROCEDURE IF EXISTS select_ch11_user_by_id;

CREATE PROCEDURE select_ch11_user_by_id(IN v_id INTEGER)
BEGIN
SELECT id,NAME,sex,age FROM tb_ch11_user_pro WHERE id = v_id;
END

# 修改數據的存儲過程
DROP PROCEDURE IF EXISTS update_ch11_user;

CREATE PROCEDURE update_ch11_user
(IN v_id INTEGER,IN v_name VARCHAR(18),IN v_sex VARCHAR(19),IN v_age INTEGER)
BEGIN
UPDATE tb_ch11_user_pro SET NAME = v_name,sex = v_sex,age = v_age
WHERE id = v_id;
END

# 刪除數據的存儲過程
DROP PROCEDURE IF EXISTS delete_ch11_user_by_id;

CREATE PROCEDURE delete_ch11_user_by_id(IN v_id INTEGER)
BEGIN
DELETE FROM tb_ch11_user_pro WHERE id = v_id;
END

--Database : mybatis
--UserName: Enoxs
--Password: Rhz0908100!