USE HOTEL;
INSERT INTO BEDDETAIL VALUES (1,"1 giường sofa đơn, 1 giường king size"),(2,"1 giường đơn"); 

INSERT INTO ROOMTYPE VALUES (1, "Phòng Executive Suit",70,2499000,1),(2,"Phòng Deluxe Twin",60,2200000,2);

INSERT INTO ROOM VALUE (1, "P1.01",1,0,1);
INSERT INTO ROOM VALUES (2,"P1.02",1,0,2), (3,"P1.03",2,0,2);
INSERT INTO GUEST VALUES (1,"01010101","Phan Thanh Đăng","09090009", "dpt@gmail.com","2004-01-01","male","TPHCM"),
(2,"02020202","Nguyễn Văn A","03030303","NVA@gmail.com","1999-03-04","male","Hà Nội"),
(3,"03030303","Nguyễn Thị B","01010202","NTB@gmail.com","1999-05-06","female","Trà Vinh");
INSERT INTO STAFFTYPE VALUE(1,"Nhân viên dọn dẹp"); 

INSERT INTO STAFF VALUES (1,"01020304","Phan Trần C","00001111","PTC@gmail.com","2003-02-11","male","Long An","2024-01-01",1),
(2,"22222222","Vũ Thị D","008800","VTD@gmail.com","2001-03-09","female","Vĩnh Phúc","2021-03-04",1);

INSERT INTO BOOKING VALUES (1,2,1,1,"2024-12-10","2024-12-12",false,4400000),
(2,3,2,2,"2024-11-27","2024-11-29",false,4000000); 
UPDATE ROOM SET STATE=1 WHERE ID=2;
UPDATE ROOM SET STATE=2 WHERE ID=3;
