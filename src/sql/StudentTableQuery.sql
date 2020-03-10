use J2EE
go

if exists (Select * From sysobjects where name = 'StudentPaper')
	drop Table dbo.StudentPaper

if exists (Select * From sysobjects where name = 'Student')
	drop Table dbo.Student

create table dbo.Student
(
	StudentID varchar(10) primary key not null,
	StudentName varchar(50),
	StudentCollege varchar(50)
);

create table dbo.StudentPaper
(
	PaperID INT PRIMARY KEY NOT NULL IDENTITY,
	StudentID varchar(10) not null,
	PaperTitle varchar(50),
	PaperContent text,
	PicAddress text,
	CONSTRAINT FK_studentId FOREIGN KEY (StudentID) REFERENCES dbo.Student(StudentID) ON DELETE CASCADE
)

if EXISTS (SELECT * FROM sysobjects WHERE NAME  = 'Account')
  DROP TABLE dbo.Account;
CREATE TABLE dbo.Account
(
  StudentID VARCHAR(50) PRIMARY KEY NOT NULL,
  password VARCHAR(50) NOT NULL
)