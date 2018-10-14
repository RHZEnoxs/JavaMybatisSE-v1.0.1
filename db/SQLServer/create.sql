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
