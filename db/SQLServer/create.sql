--Database : desktop
--UserName: Enoxs
--Password: Rhz0908100!

CREATE TABLE [dbo].[APP_INFO](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[APP_NAME] nvarchar(50) NOT NULL,
	[APP_VERSION] nvarchar(20) NOT NULL,
	[APP_DATE] datetime NOT NULL,
	[APP_AUTHOR] nvarchar(10) NULL,ª
	[APP_REMARK] nvarchar(100) NULL
PRIMARY KEY CLUSTERED ([ID] ASC)
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[USER_INFO](
	[ID] [bigint] IDENTITY(1,1) NOT NULL,
	[USER_NAME] nvarchar(50) NOT NULL,
	[USER_ACCOUNT] nvarchar(10) NOT NULL,
	[USER_PASSWORD] nvarchar(50) NULL,
	[USER_REMARK] nvarchar(100) NULL
PRIMARY KEY CLUSTERED ([ID] ASC)
) ON [PRIMARY]
GO
