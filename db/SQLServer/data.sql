--Database : desktop
--UserName: Enoxs
--Password: Rhz0908100!

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


INSERT INTO [dbo].[USER_INFO]
           ([USER_NAME]
           ,[USER_ACCOUNT]
           ,[USER_PASSWORD]
           ,[USER_REMARK])
     VALUES(
			'伊諾斯',
			'Enoxs',
			'0000',
			'開發者')
GO

INSERT INTO [dbo].[USER_INFO]
           ([USER_NAME]
           ,[USER_ACCOUNT]
           ,[USER_PASSWORD]
           ,[USER_REMARK])
     VALUES(
			'李察',
			'RHZ',
			'0000',
			'管理員')
GO

INSERT INTO [dbo].[USER_INFO]
           ([USER_NAME]
           ,[USER_ACCOUNT]
           ,[USER_PASSWORD]
           ,[USER_REMARK])
     VALUES(
			'OwO 您好',
			'OwO',
			'12345',
			'測試帳號')
GO