-- OneToOne
# 如果存在 tb_card 表則刪除
DROP TABLE  IF EXISTS tb_card;
CREATE TABLE  tb_card(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CODE VARCHAR(18)
);

# 如果存在 tb_card 表則刪除
DROP TABLE  IF EXISTS tb_person;
CREATE TABLE  tb_person(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(18),
  SEX VARCHAR(18) ,
  AGE INT,
  CARD_ID INT UNIQUE,
  FOREIGN  KEY (CARD_ID) REFERENCES tb_card(ID)
);

-- OneToMany

# 如果存在 tb_clazz 表則刪除
DROP TABLE  IF EXISTS tb_clazz;
# 創建一個 tb_clazz 表
CREATE TABLE  tb_clazz(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CODE VARCHAR(18),
  NAME VARCHAR(18)
);

# 如果存在 tb_student 表則刪除
DROP TABLE  IF EXISTS tb_student;
# 創建一個 tb_student 表
CREATE TABLE  tb_student(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(18),
  SEX CHAR(3),
  AGE INT,
  CLAZZ_ID INT,
  FOREIGN  KEY (CLAZZ_ID) REFERENCES tb_clazz(ID)
);

-- ManyToMany

# 如果存在 tb_user 表則刪除
DROP TABLE  IF EXISTS tb_user;
# 創建一個 tb_user 表, 有 id,name,sex,age 列
CREATE TABLE  tb_user(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  USERNAME VARCHAR (18),
  LOGINNAME VARCHAR (18),
  PASSWORD VARCHAR (18),
  PHONE VARCHAR (18),
  ADDRESS VARCHAR (18)
);

# 如果存在 tb_article 表則刪除
DROP TABLE  IF EXISTS tb_article;
CREATE TABLE  tb_article(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR (18),
  PRICE DOUBLE,
  REMARK VARCHAR (18)
);


# 如果存在 tb_order 表則刪除
DROP TABLE  IF EXISTS tb_order;
CREATE TABLE  tb_order(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CODE VARCHAR (32),
  TOTAL DOUBLE,
  USER_ID INT,
  FOREIGN  KEY (USER_ID) REFERENCES tb_user(ID)
);


# 如果存在 tb_item 表則刪除
DROP TABLE  IF EXISTS tb_item;
CREATE TABLE  tb_item(
  ORDER_ID INT,
  ARTICLE_ID INT,
  AMOUNT INT,
  PRIMARY KEY (ORDER_ID,ARTICLE_ID),
  FOREIGN  KEY (ORDER_ID) REFERENCES tb_order(ID),
  FOREIGN  KEY (ARTICLE_ID) REFERENCES tb_article(ID)
);

-- DynamicSQL

# 如果存在 tb_employee 表則刪除
DROP TABLE  IF EXISTS tb_employee;
CREATE TABLE  tb_employee(
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



