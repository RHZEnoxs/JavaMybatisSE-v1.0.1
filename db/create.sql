--Database : desktop
--UserName: Enoxs
--Password: Rhz0908100!

CREATE TABLE [dbo].[APP_INFO](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[APP_NAME] nvarchar(50) NOT NULL,
	[APP_VERSION] nvarchar(20) NOT NULL,
	[APP_DATE] datetime NOT NULL,
	[APP_AUTHOR] nvarchar(10) NULL,
	[APP_REMARK] nvarchar(100) NULL
PRIMARY KEY CLUSTERED ([ID] ASC)
) ON [PRIMARY]
GO

INSERT INTO [dbo].[APP_INFO]
           ([APP_NAME]
           ,[APP_VERSION]
           ,[APP_DATE]
           ,[APP_AUTHOR]
           ,[APP_REMARK])
     VALUES(
			'JavaProjSE-v1.0.1', 
			'v1.0.1', 
			'2018-08-01 18:00:01', 
			'Enoxs', 
			'Java Project Simple Example Version 1.0.1')
GO
INSERT INTO [dbo].[APP_INFO]
           ([APP_NAME]
           ,[APP_VERSION]
           ,[APP_DATE]
           ,[APP_AUTHOR]
           ,[APP_REMARK])
     VALUES(
			'AndroidProjSE-v1.0.2', 
			'v1.0.2', 
			'2018-08-02 18:30:01', 
			'Enoxs', 
			'Android Project Simple Example Version 1.0.2')
GO
INSERT INTO [dbo].[APP_INFO]
           ([APP_NAME]
           ,[APP_VERSION]
           ,[APP_DATE]
           ,[APP_AUTHOR]
           ,[APP_REMARK])
     VALUES(
			'AlgorithmsX-v1.0.1', 
			'v1.0.1', 
			'2018-08-03 19:00:01', 
			'Enoxs', 
			'Algorithms / LeetCode / HackerRank')
GO