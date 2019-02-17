-- ADMLTest

INSERT INTO TB_CH11_USER(name,sex,age) values('jack','男',22);
INSERT INTO TB_CH11_USER(name,sex,age) values('rose','女',18);
INSERT INTO TB_CH11_USER(name,sex,age) values('tom','男',25);
INSERT INTO TB_CH11_USER(name,sex,age) values('mary','女',20);


-- OneToOne
INSERT INTO tb_ch11_card(CODE) values('432801198009191038');
INSERT INTO tb_ch11_person(NAME,SEX,AGE,CARD_ID) values('jack','男',23,1);

-- OneToMany

INSERT INTO TB_CH11_CLAZZ(CODE,NAME) values('j1601','Java Spring MVC');
INSERT INTO TB_CH11_CLAZZ(CODE,NAME) values('j1602','MyBatis');

INSERT INTO TB_CH11_STUDENT(name,sex,age,clazz_id) values('jack','男',22,1);
INSERT INTO TB_CH11_STUDENT(name,sex,age,clazz_id) values('rose','女',18,1);
INSERT INTO TB_CH11_STUDENT(name,sex,age,clazz_id) values('tom','男',25,2);
INSERT INTO TB_CH11_STUDENT(name,sex,age,clazz_id) values('mary','女',20,2);

-- ManyToMany
INSERT INTO tb_ch11_ManyToMany_user(USERNAME,LOGINNAME,PASSWORD,PHONE,ADDRESS) VALUES ('捷克','jack','00000000','139+20001616','台灣');

INSERT INTO tb_ch11_article(NAME,PRICE,REMARK) VALUES ('OwO#1','99.5','##1');
INSERT INTO tb_ch11_article(NAME,PRICE,REMARK) VALUES ('OwO#2','85.5','##2');
INSERT INTO tb_ch11_article(NAME,PRICE,REMARK) VALUES ('OwO#3','72.3','##3');
INSERT INTO tb_ch11_article(NAME,PRICE,REMARK) VALUES ('OwO#4','70','##4');
INSERT INTO tb_ch11_article(NAME,PRICE,REMARK) VALUES ('OwO#5','123.5','##5');

INSERT INTO tb_ch11_order(CODE,TOTAL,USER_ID) VALUES ('6aa3fa359ff14619b77fab5990940a2d',388.6,1);
INSERT INTO tb_ch11_order(CODE,TOTAL,USER_ID) VALUES ('6aa3fa359ff14619b77fab5990940b3c',217.8,1);

INSERT INTO tb_ch11_item(ORDER_ID,ARTICLE_ID,AMOUNT) VALUES (1,1,1);
INSERT INTO tb_ch11_item(ORDER_ID,ARTICLE_ID,AMOUNT) VALUES (1,2,1);
INSERT INTO tb_ch11_item(ORDER_ID,ARTICLE_ID,AMOUNT) VALUES (1,3,2);
INSERT INTO tb_ch11_item(ORDER_ID,ARTICLE_ID,AMOUNT) VALUES (2,4,2);
INSERT INTO tb_ch11_item(ORDER_ID,ARTICLE_ID,AMOUNT) VALUES (2,1,1);
