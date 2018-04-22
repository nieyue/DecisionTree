# 数据库 
#创建数据库
DROP DATABASE IF EXISTS decision_tree_db;
CREATE DATABASE decision_tree_db;

#使用数据库 
use decision_tree_db;

#设置初始角色
INSERT  INTO role_tb (name,duty,update_date) 
VALUES ('超级管理员','超级管理员',getDATE());
INSERT  INTO role_tb (name,duty,update_date) 
VALUES ('教师','教师',getDATE());
INSERT  INTO role_tb (name,duty,update_date) 
VALUES ('学生','学生',getDATE());

#设置初始账户
INSERT  INTO account_tb (phone,password,realname,create_date,login_date,role_id) 
VALUES ('15111336587','11874bb6149dd45428da628c9766b252','聂跃',getDATE(),getDATE(),5);

