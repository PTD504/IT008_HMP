CREATE DATABASE HotelManagementDB;
USE HotelManagementDB;

CREATE TABLE hotel (
    hotel_id INT AUTO_INCREMENT PRIMARY KEY,
    hotel_name NVARCHAR(30),
    hotel_address NVARCHAR(100),
    hotel_phone CHAR(10),
    hotel_email VARCHAR(50),
    hotel_stars INT,
    nums_reviews INT
);

CREATE TABLE employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name NVARCHAR(40),
    employee_birth DATE,
    employee_phone CHAR(10),
    employee_email VARCHAR(50),
    employee_position SMALLINT DEFAULT 1, -- (0 : 'Quản lý' || 1 : 'Nhân viên')
    employee_hire DATE
);

CREATE TABLE accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

CREATE TABLE guests (
    guest_id INT AUTO_INCREMENT PRIMARY KEY,
    guest_name NVARCHAR(40),
    guest_birth DATE,
    guest_phone CHAR(10),
    guest_email VARCHAR(50),
    guest_address NVARCHAR(100),
    guest_identityCard VARCHAR(12)
);

CREATE TABLE room_types (
    type_id INT AUTO_INCREMENT PRIMARY KEY,
    type_name NVARCHAR(100),
    type_room_price INT,
    capacity SMALLINT
);

CREATE TABLE rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number INT,
    floor INT,
    room_type_id INT,
    room_status BOOLEAN,
    FOREIGN KEY (room_type_id) REFERENCES room_types(type_id)
);

CREATE TABLE ad_services (
    service_id INT AUTO_INCREMENT PRIMARY KEY,
    service_description NVARCHAR(100),
    service_price INT
);

CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    guest_id INT,
    room_id INT,
    service_id INT,
    checkin_date DATE,
    checkout_date DATE,
    total_price INT,
    FOREIGN KEY (guest_id) REFERENCES guests(guest_id),
    FOREIGN KEY (room_id) REFERENCES rooms(room_id),
    FOREIGN KEY (service_id) REFERENCES ad_services(service_id)
);

CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT,
    employee_id INT,
    pay_amount INT,
    pay_date DATE,
    pay_method NVARCHAR(50),
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id),
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    guest_id INT,
    payment_id INT,
    stars INT,
    review_content NVARCHAR(1000),
    FOREIGN KEY (guest_id) REFERENCES guests(guest_id),
    FOREIGN KEY (payment_id) REFERENCES payments(payment_id)
);

DELIMITER //

CREATE TRIGGER insert_new_booking
AFTER INSERT ON bookings
FOR EACH ROW
BEGIN
    UPDATE rooms
    SET room_status = TRUE
    WHERE room_id = NEW.room_id;
END;
//

CREATE TRIGGER insert_new_payment
AFTER INSERT ON payments
FOR EACH ROW
BEGIN
    UPDATE rooms
    SET room_status = FALSE
    WHERE room_id = (SELECT room_id FROM bookings WHERE booking_id = NEW.booking_id);
END;
//

CREATE TRIGGER insert_new_review
AFTER INSERT ON reviews
FOR EACH ROW
BEGIN 
    UPDATE hotel
    SET hotel_stars = hotel_stars + NEW.stars, nums_reviews = nums_reviews + 1
    WHERE hotel_id = 1;
END
//

DELIMITER ;

INSERT INTO employees (employee_name, employee_birth, employee_phone, employee_email, employee_position, employee_hire) VALUES
('Nguyễn Văn A', '1990-01-15', '0912345670', 'nguyenvana@example.com', 0, '2010-05-01'),
('Trần Thị B', '1985-03-22', '0912345671', 'tranthib@example.com', 1, '2015-03-12'),
('Lê Văn C', '1992-07-09', '0912345672', 'levanc@example.com', 1, '2017-06-25'),
('Phạm Thị D', '1988-08-14', '0912345673', 'phamthid@example.com', 0, '2012-08-30'),
('Hoàng Minh E', '1995-11-18', '0912345674', 'hoangminhe@example.com', 1, '2018-09-10'),
('Đặng Thị F', '1991-04-25', '0912345675', 'dangthif@example.com', 1, '2016-11-20'),
('Vũ Văn G', '1989-12-30', '0912345676', 'vuvang@example.com', 0, '2011-02-15'),
('Ngô Thị H', '1993-06-05', '0912345677', 'ngothih@example.com', 1, '2014-07-22'),
('Đoàn Minh I', '1990-09-12', '0912345678', 'doanminhi@example.com', 1, '2013-04-18'),
('Mai Văn J', '1987-10-27', '0912345679', 'maivanj@example.com', 0, '2009-11-05'),
('Lý Thị K', '1996-02-16', '0912345680', 'lythik@example.com', 1, '2019-03-15'),
('Tô Văn L', '1994-05-03', '0912345681', 'tovanl@example.com', 1, '2017-12-10'),
('Bùi Thị M', '1991-08-21', '0912345682', 'buithim@example.com', 0, '2016-05-25'),
('Cao Văn N', '1986-11-08', '0912345683', 'caovann@example.com', 1, '2011-10-30'),
('Lương Thị O', '1990-03-14', '0912345684', 'luongthio@example.com', 1, '12-12-2003');
-- YYYY-MM-DD

INSERT INTO Guests (guest_name, guest_birth, guest_phone, guest_email, guest_address) VALUES
('Nguyễn Văn An', '1980-04-15', '0901234567', 'an.nguyen@example.com', '123 Đường Lý Thái Tổ, Hà Nội'),
('Trần Thị Bảo', '1985-09-22', '0902234567', 'bao.tran@example.com', '456 Đường Trần Phú, Đà Nẵng'),
('Lê Văn Cường', '1990-12-30', '0903234567', 'cuong.le@example.com', '789 Đường Nguyễn Huệ, TP.HCM'),
('Phạm Thị Dung', '1975-07-05', '0904234567', 'dung.pham@example.com', '321 Đường Lê Lợi, Huế'),
('Hoàng Minh Hùng', '1988-11-19', '0905234567', 'hung.hoang@example.com', '654 Đường Lê Thánh Tông, Hội An'),
('Đặng Thị Hạnh', '1992-02-14', '0906234567', 'hanh.dang@example.com', '987 Đường Bạch Đằng, Đà Lạt'),
('Vũ Văn Khôi', '1983-06-18', '0907234567', 'khoi.vu@example.com', '135 Đường Lý Tự Trọng, Cần Thơ'),
('Ngô Thị Lan', '1978-10-25', '0908234567', 'lan.ngo@example.com', '246 Đường Hùng Vương, Bình Dương'),
('Đoàn Minh Long', '1985-03-12', '0909234567', 'long.doan@example.com', '369 Đường Nguyễn Trãi, Hải Phòng'),
('Mai Văn Nam', '1995-01-09', '0910234567', 'nam.mai@example.com', '471 Đường Quang Trung, Vũng Tàu'),
('Lý Thị Ngọc', '1991-08-28', '0911234567', 'ngoc.ly@example.com', '582 Đường Độc Lập, Biên Hòa'),
('Tô Văn Phát', '1989-05-20', '0912234567', 'phat.to@example.com', '693 Đường Bùi Thị Xuân, Nha Trang'),
('Bùi Thị Quyên', '1984-12-01', '0913234567', 'quyen.bui@example.com', '174 Đường Phạm Văn Đồng, Vinh'),
('Cao Văn Quý', '1980-11-16', '0914234567', 'quy.cao@example.com', '285 Đường Trương Định, Thái Nguyên'),
('Lương Thị Thu', '1993-07-08', '0915234567', 'thu.luong@example.com', '396 Đường Phạm Ngọc Thạch, Bắc Ninh'),
('Hà Văn Toàn', '1992-04-10', '0916234567', 'toan.ha@example.com', '417 Đường Minh Khai, Long An'),
('Đỗ Thị Uyên', '1990-01-26', '0917234567', 'uyen.do@example.com', '518 Đường Đinh Tiên Hoàng, Gia Lai'),
('Phan Văn Việt', '1987-06-30', '0918234567', 'viet.phan@example.com', '639 Đường Đội Cấn, Thanh Hóa'),
('Trịnh Thị Xuyên', '1979-09-15', '0919234567', 'xuyen.trinh@example.com', '750 Đường Kim Liên, Phú Yên'),
('Lê Văn Yên', '1996-03-05', '0920234567', 'yen.le@example.com', '861 Đường Tô Hiệu, Kon Tum');

INSERT INTO room_types (type_name, type_room_price, capacity) VALUES
('Phòng Đơn', 500000, 1),
('Phòng Đôi', 700000, 2),
('Phòng Gia Đình', 1200000, 4),
('Phòng Suite', 2000000, 2),
('Phòng Deluxe', 1500000, 2),
('Phòng Tiêu Chuẩn', 800000, 2),
('Phòng Cao Cấp', 1800000, 2),
('Phòng Executive', 2500000, 2),
('Phòng Tổng Thống', 5000000, 4),
('Phòng Studio', 1000000, 2);

INSERT INTO rooms (room_number, floor, room_type_id, room_status) VALUES
(101, 1, 1, TRUE), (102, 1, 2, TRUE), (103, 1, 3, FALSE), (104, 1, 4, TRUE), (105, 1, 5, FALSE),
(106, 1, 6, TRUE), (107, 1, 7, TRUE), (108, 1, 8, FALSE), (109, 1, 9, TRUE), (110, 1, 10, FALSE),
(201, 2, 1, TRUE), (202, 2, 2, TRUE), (203, 2, 3, FALSE), (204, 2, 4, TRUE), (205, 2, 5, FALSE),
(206, 2, 6, TRUE), (207, 2, 7, TRUE), (208, 2, 8, FALSE), (209, 2, 9, TRUE), (210, 2, 10, FALSE),
(301, 3, 1, TRUE), (302, 3, 2, TRUE), (303, 3, 3, FALSE), (304, 3, 4, TRUE), (305, 3, 5, FALSE),
(306, 3, 6, TRUE), (307, 3, 7, TRUE), (308, 3, 8, FALSE), (309, 3, 9, TRUE), (310, 3, 10, FALSE);

INSERT INTO ad_services (service_description, service_price) VALUES
('Dịch vụ giặt ủi', 100000),
('Dịch vụ ăn sáng', 200000),
('Dịch vụ đưa đón sân bay', 500000),
('Dịch vụ massage', 300000),
('Dịch vụ spa', 400000),
('Dịch vụ cho thuê xe', 600000),
('Dịch vụ phòng VIP', 700000),
('Dịch vụ hồ bơi', 150000),
('Dịch vụ chăm sóc trẻ em', 250000),
('Dịch vụ đặt vé', 350000);

INSERT INTO bookings (guest_id, room_id, service_id, checkin_date, checkout_date, total_price)
VALUES
(1, 1, 1, '2024-01-01', '2024-01-05', 200000),
(2, 2, 2, '2024-01-06', '2024-01-10', 400000),
(3, 3, 3, '2024-01-11', '2024-01-15', 600000),
(4, 4, 4, '2024-01-16', '2024-01-20', 800000),
(5, 5, 5, '2024-01-21', '2024-01-25', 1000000),
(6, 6, 6, '2024-01-26', '2024-01-30', 1200000),
(7, 7, 7, '2024-01-31', '2024-02-04', 1400000),
(8, 8, 8, '2024-02-05', '2024-02-09', 1600000),
(9, 9, 9, '2024-02-10', '2024-02-14', 1800000),
(10, 10, 10, '2024-02-15', '2024-02-19', 2000000),
(11, 11, 1, '2024-02-20', '2024-02-24', 200000),
(13, 13, 3, '2024-03-02', '2024-03-06', 600000),
(14, 14, 4, '2024-03-07', '2024-03-11', 800000),
(15, 15, 5, '2024-03-12', '2024-03-16', 1000000),
(16, 16, 6, '2024-03-17', '2024-03-21', 1200000),
(17, 17, 7, '2024-03-22', '2024-03-26', 1400000),
(18, 18, 8, '2024-03-27', '2024-03-31', 1600000),
(19, 19, 9, '2024-04-01', '2024-04-05', 1800000),
(20, 20, 10, '2024-04-06', '2024-04-10', 2000000),
(1, 1, 1, '2024-04-11', '2024-04-15', 200000),
(2, 2, 2, '2024-04-16', '2024-04-20', 400000),
(3, 3, 3, '2024-04-21', '2024-04-25', 600000),
(4, 4, 4, '2024-04-26', '2024-04-30', 800000),
(5, 5, 5, '2024-05-01', '2024-05-05', 1000000),
(6, 6, 6, '2024-05-06', '2024-05-10', 1200000),
(7, 7, 7, '2024-05-11', '2024-05-15', 1400000),
(8, 8, 8, '2024-05-16', '2024-05-20', 1600000),
(9, 9, 9, '2024-05-21', '2024-05-25', 1800000),
(10, 10, 10, '2024-05-26', '2024-05-30', 2000000),
(11, 11, 1, '2024-06-01', '2024-06-05', 200000),
(13, 13, 3, '2024-06-11', '2024-06-15', 600000),
(14, 14, 4, '2024-06-16', '2024-06-20', 800000),
(15, 15, 5, '2024-06-21', '2024-06-25', 1000000),
(16, 16, 6, '2024-06-26', '2024-06-30', 1200000),
(17, 17, 7, '2024-07-01', '2024-07-05', 1400000),
(18, 18, 8, '2024-07-06', '2024-07-10', 1600000),
(19, 19, 9, '2024-07-11', '2024-07-15', 1800000),
(20, 20, 10, '2024-07-16', '2024-07-20', 2000000),
(1, 1, 1, '2024-07-21', '2024-07-25', 200000),
(2, 2, 2, '2024-07-26', '2024-07-30', 400000),
(3, 3, 3, '2024-07-31', '2024-08-04', 600000),
(4, 4, 4, '2024-08-05', '2024-08-09', 800000),
(5, 5, 5, '2024-08-10', '2024-08-14', 1000000),
(6, 6, 6, '2024-08-15', '2024-08-19', 1200000),
(7, 7, 7, '2024-08-20', '2024-08-24', 1400000),
(8, 8, 8, '2024-08-25', '2024-08-29', 1600000),
(9, 9, 9, '2024-08-30', '2024-09-03', 1800000),
(10, 10, 10, '2024-09-04', '2024-09-08', 2000000);