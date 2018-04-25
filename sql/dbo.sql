/*
 Navicat SQL Server Data Transfer

 Source Server         : 本地1
 Source Server Type    : SQL Server
 Source Server Version : 10001600
 Source Host           : localhost:1433
 Source Catalog        : decision_tree_db
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 10001600
 File Encoding         : 65001

 Date: 25/04/2018 18:39:25
*/


-- ----------------------------
-- Table structure for account_tb
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[account_tb]') AND type IN ('U'))
	DROP TABLE [dbo].[account_tb]
GO

CREATE TABLE [dbo].[account_tb] (
  [account_id] int  IDENTITY(1,1) NOT NULL,
  [create_date] datetime  NULL,
  [login_date] datetime  NULL,
  [password] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [phone] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [realname] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [role_id] int  NULL
)
GO

ALTER TABLE [dbo].[account_tb] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of account_tb
-- ----------------------------
SET IDENTITY_INSERT [dbo].[account_tb] ON
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'1', N'2018-04-19 17:38:02.363', N'2018-04-19 17:38:02.363', N'11874bb6149dd45428da628c9766b252', N'15111336587', N'聂跃', N'5')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'3', N'2018-04-21 17:40:40.000', N'2018-04-25 17:49:03.000', N'11874bb6149dd45428da628c9766b252', N'15111336589', N'低分学生', N'7')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'4', N'2018-04-21 19:07:10.000', N'2018-04-21 19:07:10.000', N'11874bb6149dd45428da628c9766b252', N'15111336500', N'教师2', N'6')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'5', N'2018-04-21 19:08:28.797', N'2018-04-21 19:08:28.797', N'11874bb6149dd45428da628c9766b252', N'15111336501', N'教师3', N'6')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'6', N'2018-04-21 19:16:35.457', N'2018-04-21 19:16:35.457', N'11874bb6149dd45428da628c9766b252', N'15111336502', N'教师4', N'6')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'9', N'2018-04-21 19:20:52.097', N'2018-04-21 19:20:52.097', N'11874bb6149dd45428da628c9766b252', N'15111336503', N'教师5', N'6')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'10', N'2018-04-21 19:21:24.227', N'2018-04-21 19:21:24.227', N'11874bb6149dd45428da628c9766b252', N'15111336504', N'教师6', N'6')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'11', N'2018-04-21 19:22:34.570', N'2018-04-21 19:22:34.570', N'11874bb6149dd45428da628c9766b252', N'15111336505', N'教师7', N'6')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'13', N'2018-04-21 19:59:33.600', N'2018-04-21 19:59:33.600', N'f44f3dd2f74ea4667947fed6b979200d', N'15111336507', N'教师9', N'6')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'14', N'2018-04-21 20:00:14.750', N'2018-04-21 20:00:14.750', N'f44f3dd2f74ea4667947fed6b979200d', N'15111336508', N'教师10', N'6')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'15', N'2018-04-21 20:06:33.080', N'2018-04-21 20:06:33.080', N'f44f3dd2f74ea4667947fed6b979200d', N'15111336509', N'教师11', N'6')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'16', N'2018-04-21 20:06:40.000', N'2018-04-21 20:06:40.000', N'f44f3dd2f74ea4667947fed6b979200d', N'151113365102', N'教师122', N'6')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'25', N'2018-04-24 14:15:37.000', N'2018-04-24 14:15:37.000', N'f44f3dd2f74ea4667947fed6b979200d', N'122', N'werfw', N'6')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'29', N'2018-04-24 14:20:12.000', N'2018-04-24 14:20:12.000', N'f44f3dd2f74ea4667947fed6b979200d', N'15111336588', N'高分学生', N'7')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'30', N'2018-04-24 16:54:04.000', N'2018-04-24 16:54:04.000', N'f44f3dd2f74ea4667947fed6b979200d', N'15111336580', N'良好学生', N'7')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'31', N'2018-04-24 17:48:01.000', N'2018-04-24 17:48:01.000', N'f44f3dd2f74ea4667947fed6b979200d', N'15111336586', N'合格学生', N'7')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'32', N'2018-04-25 17:09:22.000', N'2018-04-25 17:09:22.000', N'f44f3dd2f74ea4667947fed6b979200d', N'15111336581', N'偏数学科学生', N'7')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'33', N'2018-04-25 17:10:14.043', N'2018-04-25 17:10:14.043', N'f44f3dd2f74ea4667947fed6b979200d', N'15111336582', N'偏语文科学生', N'7')
GO

INSERT INTO [dbo].[account_tb] ([account_id], [create_date], [login_date], [password], [phone], [realname], [role_id]) VALUES (N'34', N'2018-04-25 17:11:22.550', N'2018-04-25 17:11:22.550', N'f44f3dd2f74ea4667947fed6b979200d', N'15111336583', N'偏多科学生', N'7')
GO

SET IDENTITY_INSERT [dbo].[account_tb] OFF
GO


-- ----------------------------
-- Table structure for analyse_tb
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[analyse_tb]') AND type IN ('U'))
	DROP TABLE [dbo].[analyse_tb]
GO

CREATE TABLE [dbo].[analyse_tb] (
  [analyse_id] int  IDENTITY(1,1) NOT NULL,
  [business_id] int  NULL,
  [conclusion] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [score] float(53)  NULL,
  [sub_type] int  NULL,
  [type] int  NULL,
  [update_date] datetime  NULL
)
GO

ALTER TABLE [dbo].[analyse_tb] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for course_tb
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[course_tb]') AND type IN ('U'))
	DROP TABLE [dbo].[course_tb]
GO

CREATE TABLE [dbo].[course_tb] (
  [course_id] int  IDENTITY(1,1) NOT NULL,
  [duty] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [name] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [update_date] datetime  NULL
)
GO

ALTER TABLE [dbo].[course_tb] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of course_tb
-- ----------------------------
SET IDENTITY_INSERT [dbo].[course_tb] ON
GO

INSERT INTO [dbo].[course_tb] ([course_id], [duty], [name], [update_date]) VALUES (N'11', N'亲亲子衿', N'语文', N'2018-04-25 09:06:33.263')
GO

INSERT INTO [dbo].[course_tb] ([course_id], [duty], [name], [update_date]) VALUES (N'12', N'数学', N'数学', N'2018-04-24 18:03:21.140')
GO

INSERT INTO [dbo].[course_tb] ([course_id], [duty], [name], [update_date]) VALUES (N'13', N'英语', N'英语', N'2018-04-24 18:03:28.560')
GO

SET IDENTITY_INSERT [dbo].[course_tb] OFF
GO


-- ----------------------------
-- Table structure for role_tb
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[role_tb]') AND type IN ('U'))
	DROP TABLE [dbo].[role_tb]
GO

CREATE TABLE [dbo].[role_tb] (
  [role_id] int  IDENTITY(1,1) NOT NULL,
  [duty] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [name] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [update_date] datetime  NULL
)
GO

ALTER TABLE [dbo].[role_tb] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of role_tb
-- ----------------------------
SET IDENTITY_INSERT [dbo].[role_tb] ON
GO

INSERT INTO [dbo].[role_tb] ([role_id], [duty], [name], [update_date]) VALUES (N'5', N'超级管理员', N'超级管理员', N'2018-04-19 17:12:03.220')
GO

INSERT INTO [dbo].[role_tb] ([role_id], [duty], [name], [update_date]) VALUES (N'6', N'教师', N'教师', N'2018-04-19 17:12:03.220')
GO

INSERT INTO [dbo].[role_tb] ([role_id], [duty], [name], [update_date]) VALUES (N'7', N'学生', N'学生', N'2018-04-19 17:12:03.220')
GO

SET IDENTITY_INSERT [dbo].[role_tb] OFF
GO


-- ----------------------------
-- Table structure for score_tb
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[score_tb]') AND type IN ('U'))
	DROP TABLE [dbo].[score_tb]
GO

CREATE TABLE [dbo].[score_tb] (
  [score_id] int  IDENTITY(1,1) NOT NULL,
  [score] float(53)  NULL,
  [student_account_id] int  NULL,
  [teacher_course_id] int  NULL,
  [update_date] datetime  NULL
)
GO

ALTER TABLE [dbo].[score_tb] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of score_tb
-- ----------------------------
SET IDENTITY_INSERT [dbo].[score_tb] ON
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'1', N'33.000000000000000', N'3', N'2', N'2018-04-25 16:54:31.447')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'4', N'44.000000000000000', N'3', N'1', N'2018-04-25 16:56:08.520')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'6', N'88.000000000000000', N'3', N'4', N'2018-04-25 17:04:27.337')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'7', N'96.000000000000000', N'29', N'1', N'2018-04-25 17:05:13.810')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'8', N'90.000000000000000', N'29', N'2', N'2018-04-25 17:04:46.400')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'9', N'98.000000000000000', N'29', N'4', N'2018-04-25 17:05:07.980')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'10', N'84.000000000000000', N'30', N'1', N'2018-04-25 17:06:23.547')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'11', N'85.000000000000000', N'30', N'2', N'2018-04-25 17:06:05.013')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'12', N'82.000000000000000', N'30', N'4', N'2018-04-25 17:06:28.880')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'13', N'65.000000000000000', N'31', N'1', N'2018-04-25 17:06:51.263')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'14', N'68.000000000000000', N'31', N'2', N'2018-04-25 17:06:56.153')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'15', N'67.000000000000000', N'31', N'4', N'2018-04-25 17:07:06.020')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'16', N'85.000000000000000', N'32', N'1', N'2018-04-25 17:09:33.883')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'17', N'87.000000000000000', N'32', N'2', N'2018-04-25 17:09:39.460')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'18', N'55.000000000000000', N'32', N'4', N'2018-04-25 17:09:44.557')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'19', N'54.000000000000000', N'33', N'1', N'2018-04-25 17:10:41.187')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'20', N'67.000000000000000', N'33', N'2', N'2018-04-25 17:10:46.740')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'21', N'89.000000000000000', N'33', N'4', N'2018-04-25 17:10:55.567')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'22', N'45.000000000000000', N'34', N'1', N'2018-04-25 17:11:31.297')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'23', N'58.000000000000000', N'34', N'2', N'2018-04-25 17:11:35.797')
GO

INSERT INTO [dbo].[score_tb] ([score_id], [score], [student_account_id], [teacher_course_id], [update_date]) VALUES (N'24', N'78.000000000000000', N'34', N'4', N'2018-04-25 17:11:40.500')
GO

SET IDENTITY_INSERT [dbo].[score_tb] OFF
GO


-- ----------------------------
-- Table structure for teacher_course_tb
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[teacher_course_tb]') AND type IN ('U'))
	DROP TABLE [dbo].[teacher_course_tb]
GO

CREATE TABLE [dbo].[teacher_course_tb] (
  [teacher_course_id] int  IDENTITY(1,1) NOT NULL,
  [account_id] int  NULL,
  [course_id] int  NULL,
  [update_date] datetime  NULL
)
GO

ALTER TABLE [dbo].[teacher_course_tb] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of teacher_course_tb
-- ----------------------------
SET IDENTITY_INSERT [dbo].[teacher_course_tb] ON
GO

INSERT INTO [dbo].[teacher_course_tb] ([teacher_course_id], [account_id], [course_id], [update_date]) VALUES (N'1', N'4', N'11', N'2018-04-25 09:52:18.680')
GO

INSERT INTO [dbo].[teacher_course_tb] ([teacher_course_id], [account_id], [course_id], [update_date]) VALUES (N'2', N'4', N'13', N'2018-04-25 13:59:46.460')
GO

INSERT INTO [dbo].[teacher_course_tb] ([teacher_course_id], [account_id], [course_id], [update_date]) VALUES (N'4', N'5', N'12', N'2018-04-25 11:57:14.983')
GO

INSERT INTO [dbo].[teacher_course_tb] ([teacher_course_id], [account_id], [course_id], [update_date]) VALUES (N'5', N'5', N'13', N'2018-04-25 11:57:21.210')
GO

INSERT INTO [dbo].[teacher_course_tb] ([teacher_course_id], [account_id], [course_id], [update_date]) VALUES (N'6', N'6', N'11', N'2018-04-25 11:59:07.080')
GO

INSERT INTO [dbo].[teacher_course_tb] ([teacher_course_id], [account_id], [course_id], [update_date]) VALUES (N'7', N'6', N'12', N'2018-04-25 11:59:10.717')
GO

INSERT INTO [dbo].[teacher_course_tb] ([teacher_course_id], [account_id], [course_id], [update_date]) VALUES (N'8', N'6', N'13', N'2018-04-25 11:59:14.037')
GO

INSERT INTO [dbo].[teacher_course_tb] ([teacher_course_id], [account_id], [course_id], [update_date]) VALUES (N'9', N'4', N'12', N'2018-04-25 13:59:53.597')
GO

SET IDENTITY_INSERT [dbo].[teacher_course_tb] OFF
GO


-- ----------------------------
-- Primary Key structure for table account_tb
-- ----------------------------
ALTER TABLE [dbo].[account_tb] ADD CONSTRAINT [PK__account___46A222CD07020F21] PRIMARY KEY CLUSTERED ([account_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table analyse_tb
-- ----------------------------
ALTER TABLE [dbo].[analyse_tb] ADD CONSTRAINT [PK__analyse___A779B13D0AD2A005] PRIMARY KEY CLUSTERED ([analyse_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table course_tb
-- ----------------------------
ALTER TABLE [dbo].[course_tb] ADD CONSTRAINT [PK__course_t__8F1EF7AE164452B1] PRIMARY KEY CLUSTERED ([course_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table role_tb
-- ----------------------------
ALTER TABLE [dbo].[role_tb] ADD CONSTRAINT [PK__role_tb__760965CC03317E3D] PRIMARY KEY CLUSTERED ([role_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table score_tb
-- ----------------------------
ALTER TABLE [dbo].[score_tb] ADD CONSTRAINT [PK__score_tb__8CA190501A14E395] PRIMARY KEY CLUSTERED ([score_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table teacher_course_tb
-- ----------------------------
ALTER TABLE [dbo].[teacher_course_tb] ADD CONSTRAINT [PK__teacher___5FFA5BE41273C1CD] PRIMARY KEY CLUSTERED ([teacher_course_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

