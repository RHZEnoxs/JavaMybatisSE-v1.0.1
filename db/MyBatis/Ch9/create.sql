# 如果存在 tb_user2 表則刪除
DROP TABLE  IF EXISTS tb_user2;
# 創建一個 tb_user2 表, 有 id,name,sex,age 列
CREATE TABLE  tb_user2(
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(18) ,
  user_sex VARCHAR(18),
  user_age INT
);

# 如果存在 tb_clazz 表則刪除
DROP TABLE  IF EXISTS tb_clazz;
# 創建一個 tb_clazz 表
CREATE TABLE  tb_clazz(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CODE VARCHAR(18)
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