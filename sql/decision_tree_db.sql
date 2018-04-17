# 数据库 
#创建数据库
DROP DATABASE IF EXISTS activation_code_mall_db;
CREATE DATABASE activation_code_mall_db;

#使用数据库 
use activation_code_mall_db;

#创建角色表
CREATE TABLE role_tb(
role_id int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
name varchar(255) COMMENT '角色名',
duty varchar(255) COMMENT '角色职责',
update_date datetime COMMENT '更新时间',
PRIMARY KEY (role_id)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='角色表';

#创建账户表 
CREATE TABLE account_tb(
account_id int(11) NOT NULL AUTO_INCREMENT COMMENT '账户id',
phone varchar(255) COMMENT '手机号',
password varchar(255) COMMENT '密码',
realname varchar(255) COMMENT '真实姓名',
create_date datetime COMMENT '创建时间',
login_date datetime COMMENT '登陆时间',
role_id int(11) COMMENT '角色id外键',
PRIMARY KEY (account_id)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='账户表';


#设置初始角色
INSERT IGNORE INTO role_tb (name,duty,update_date) 
VALUES ("超级管理员","超级管理员",now());
INSERT IGNORE INTO role_tb (name,duty,update_date) 
VALUES ("教师","教师",now());
INSERT IGNORE INTO role_tb (name,duty,update_date) 
VALUES ("学生","学生",now());
