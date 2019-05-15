CREATE TABLE `SG_LOB_TEST`(
	SLT_ID int(10) PRIMARY KEY,--书籍ID
	SLT_NAME varchar(64),--书名
	SLT_PAGEIMG blob,--封面图
	SLT_CONTENT text,--书籍内容
	SLT_CREADATE date,--创建日期
	SLT_MODIDATE date--修改日期
);
