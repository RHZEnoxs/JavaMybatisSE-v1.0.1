# 創建一個名稱為 mybatis 的數據庫
create database mybatis;
# 使用名稱為 mybatis 的數據庫
use mybatis;
# 如果存在 tb_user 表則刪除
DROP TABLE  IF EXISTS tb_user;
# 創建一個 tb_user 表, 有 id,name,sex,age 列
CREATE TABLE  tb_user(
  ID INT(11) PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(18) DEFAULT NULL,
  SEX CHAR(2) DEFAULT NULL,
  AGE INT(11) DEFAULT NULL
);



--Database : mybatis
--UserName: Enoxs
--Password: Rhz0908100!