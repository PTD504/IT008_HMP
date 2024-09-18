CREATE DATABASE HotelManagementDB
GO
USE HotelManagementDB
GO

CREATE TABLE [dbo].[Hotel] 
(
	[hotelID]				INT IDENTITY(1, 1) PRIMARY KEY,
	[hotelName]				NVARCHAR(30),
	[hotelAddress]			NVARCHAR(100),
	[hotelPhone]			CHAR(10),
	[hotelEmail]			VARCHAR(50)
	-- [hotelStars]			DECIMAL(2, 1)
)
GO

CREATE TABLE [dbo].[Employees] 
(
	[employeeID]			INT IDENTITY(1, 1) PRIMARY KEY,
	[employeeName]			NVARCHAR(40),
	[employeeBirth]			DATE,
	[employeePhone]			CHAR(10),
	[employeeEmail]			VARCHAR(50),
	[employeePosition]		SMALLINT DEFAULT 1, -- (0 : 'Quản lý' || 1 : 'Nhân viên')
	[employeeHire]			DATE,
	CONSTRAINT chk_employeePosition CHECK (employeePosition IN ('Quản lý', 'Nhân viên'))
)
GO

CREATE TABLE [dbo].[Accounts]
(
	[accountID]				INT IDENTITY(1, 1) PRIMARY KEY,
	[username]				VARCHAR(50) NOT NULL,
	[password]				VARCHAR(50) NOT NULL,
	[employeeID]			INT FOREIGN KEY REFERENCES Employees(employeeID)
)
GO

CREATE TABLE [dbo].[Guests] 
(
	[guestID]				INT IDENTITY(1, 1) PRIMARY KEY,
	[guestName]				NVARCHAR(40),
	[guestBirth]			DATE,
	[guestPhone]			CHAR(10),
	[guestEmail]			VARCHAR(50),
	[guestAddress]			NVARCHAR(100)
)
GO

CREATE TABLE [dbo].[RoomTypes] 
(
	[typeID]				INT IDENTITY(1, 1) PRIMARY KEY,
	[typeName]		NVARCHAR(100),
	[typeRoomPrice]			MONEY,
	[capacity]				SMALLINT
)
GO

CREATE TABLE [dbo].[Rooms] 
(
	[roomID]				INT IDENTITY(1, 1) PRIMARY KEY,
	[roomNumber]			INT,
	[floor]					INT,
	[roomTypeID]			INT FOREIGN KEY REFERENCES RoomTypes(typeID),
	[roomStatus]			BIT
)
GO

CREATE TABLE [dbo].[AdServices] 
(
	[serviceID]				INT IDENTITY(1, 1) PRIMARY KEY,
	[serviceDescription]	NVARCHAR(100),
	[servicePrice]			MONEY
)
GO

CREATE TABLE [dbo].[Bookings] 
(
	[bookingID]				INT IDENTITY(1, 1) PRIMARY KEY,
	[guestID]				INT FOREIGN KEY REFERENCES Guests(guestID),
	[roomID]				INT FOREIGN KEY REFERENCES Rooms(roomID),
	[serviceID]				INT FOREIGN KEY REFERENCES AdServices(serviceID),
	[checkinDate]			DATE,
	-- [comfirmDate]			DATE,
	[checkoutDate]			DATE,
	-- [discount]				MONEY,
	[totalPrice]			MONEY
)
GO

CREATE TABLE [dbo].[Payments] 
(
	[paymentID]				INT IDENTITY(1, 1) PRIMARY KEY,
	[bookingID]				INT FOREIGN KEY REFERENCES Bookings(bookingID),
	[employeeID]			INT FOREIGN KEY REFERENCES Employees(employeeID),
	[payAmount]				MONEY,
	[payDate]				DATE,
	[payMethod]				NVARCHAR(50)
)
GO

-- Add some constraints (TRIGGER format)
CREATE TRIGGER INSERT_NEW_BOOKING
ON Bookings
FOR INSERT
AS
BEGIN
	DECLARE @roomID INT

	SELECT @roomID = roomID FROM INSERTED

	UPDATE Rooms
	SET roomStatus = 1
	WHERE roomID = @roomID
END
GO


CREATE TRIGGER INSERT_NEW_PAYMENT
ON Payments
FOR INSERT
AS
BEGIN
	DECLARE @roomID INT

	SELECT @roomID = bk.roomID 
	FROM INSERTED ist INNER JOIN Bookings bk ON ist.bookingID = bk.bookingID

	UPDATE Rooms
	SET roomStatus = 0
	WHERE roomID = @roomID
END



