create database furama_module_4;

INSERT INTO customer_type (customer_type_id,customer_type_name) VALUES
(1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');

INSERT INTO customer (customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address, status_delete) VALUES
("KH-001", 1, "Nguyễn Hoàng Hảo", "1999-10-10", 0, "201802281", "0978144014", "hao@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0),
("KH-002", 4, "Trần Văn Khánh", "1995-10-10", 0, "201802281", "0978144014", "khanh@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0),
("KH-003", 5, "Nguyễn Dương Trung Kiên", "1999-10-10", 0, "201802281", "0978144014", "kien@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0),
("KH-004", 2, "Trần Xuân Trường", "1998-10-10", 0, "201802281", "0978144014", "truong@gmail.com.vn", "1 Như Nguyệt, Đà Nẵng",0),
("KH-005", 3, "Nguyễn Bảo Long", "1998-10-10", 0, "201802281", "0978144014", "long@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0),
("KH-006", 1, "Nguyễn Hữu Toàn", "1999-10-10", 0, "201802281", "0978144014", "toan@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0),
("KH-007", 4, "Huỳnh Nhật Hoàng", "1995-10-10", 0, "201802281", "0978144014", "hoang@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0),
("KH-008", 5, "Nguyễn Đình Luân", "1999-10-10", 0, "201802281", "0978144014", "luan@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0),
("KH-009", 2, "Nguyễn Thiên Duy", "1998-10-10", 0, "201802281", "0978144014", "duy@gmail.com.vn", "1 Như Nguyệt, Đà Nẵng",0),
("KH-010", 3, "Huỳnh Kim Hiếu", "1998-10-10", 0, "201802281", "0978144014", "hieu@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0),
("KH-011", 1, "Trần Mạnh Cường", "1999-10-10", 0, "201802281", "0978144014", "cuong@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0),
("KH-012", 4, "Nguyễn Duy Trung", "1995-10-10", 0, "201802281", "0978144014", "trung@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0),
("KH-013", 5, "Nguyễn Quang Phúc", "1999-10-10", 0, "201802281", "0978144014", "phuc@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0),
("KH-014", 2, "Hồ Duy Tuấn", "1998-10-10", 0, "201802281", "0978144014", "tuan@gmail.com.vn", "1 Như Nguyệt, Đà Nẵng",0),
("KH-015", 3, "Hồ Văn Chung", "1998-10-10", 0, "201802281", "0978144014", "long@gmail.com.vn", "14-12 Hoà An, Đà Nẵng",0);

INSERT INTO education (education_id,education_name) VALUES
(1,'Intermediate'),
(2,'College'),
(3,'University'),
(4,'Postgraduate');

INSERT INTO position (position_id,position_name) VALUES
(1,'Receptionist'),
(2,'Serve'),
(3,'Expert'),
(4,'Supervision'),
(5,'Manage'),
(6,'Director');

INSERT INTO division (division_id,division_name) VALUES
(1,'Sales - Marketing'),
(2,'Administration'),
(3,'Service'),
(4,'Manage');

INSERT INTO `user` (user_name,`password`) VALUES
("hao","hao"),
("khanh","khanh"),
("kien","kien"),
("truong","truong"),
("long","long"),
("toan","toan"),
("hoang","hoang"),
("luan","luan"),
("duy","duy"),
("hieu","hieu"),
("cuong","cuong"),
("trung","trung"),
("phuc","phuc"),
("tuan","tuan"),
("chung","chung");

INSERT INTO employee (employee_id, employee_address, employee_birthday, employee_email, employee_id_card, employee_name, employee_phone, employee_salary, status_delete, division_id,education_id,position_id,user_name) VALUES
(1, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "hao@gmail.com.vn", "201802281", "Nguyễn Hoàng Hảo", "0978144014", 10000, 0, 1, 2, 3, "hao"),
(2, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "khanh@gmail.com.vn", "201802281", "Trần Văn Khánh", "0978144014", 10000, 0, 2, 2, 3, "khanh"),
(3, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "kien@gmail.com.vn", "201802281", "Nguyễn Dương Trung Kiên", "0978144014", 10000, 0, 1, 2, 3, "kien"),
(4, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "truong@gmail.com.vn", "201802281", "Trần Xuân Trường", "0978144014", 10000, 0, 1, 2, 3, "truong"),
(5, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "long@gmail.com.vn", "201802281", "Nguyễn Bảo Long", "0978144014", 10000, 0, 1, 2, 3, "long"),
(6, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "toan@gmail.com.vn", "201802281", "Nguyễn Hữu Toàn", "0978144014", 10000, 0, 1, 2, 3, "toan"),
(7, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "hoang@gmail.com.vn", "201802281", "Huỳnh Nhật Hoàng", "0978144014", 10000, 0, 1, 2, 3, "hoang"),
(8, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "luan@gmail.com.vn", "201802281", "Nguyễn Đình Luân", "0978144014", 10000, 0, 1, 2, 3, "luan"),
(9, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "duy@gmail.com.vn", "201802281", "Nguyễn Thiên Duy", "0978144014", 10000, 0, 1, 2, 3, "duy"),
(10, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "hieu@gmail.com.vn", "201802281", "Huỳnh Kim Hiếu", "0978144014", 10000, 0, 1, 2, 3, "hieu"),
(11, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "cuong@gmail.com.vn", "201802281", "Trần Mạnh Cường", "0978144014", 10000, 0, 1, 2, 3, "cuong"),
(12, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "trung@gmail.com.vn", "201802281", "Nguyễn Duy Trung", "0978144014", 10000, 0, 1, 2, 3, "trung"),
(13, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "phuc@gmail.com.vn", "201802281", "Nguyễn Quang Phúc", "0978144014", 10000, 0, 1, 2, 3, "phuc"),
(14, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "tuan@gmail.com.vn", "201802281", "Hồ Duy Tuấn", "0978144014", 10000, 0, 1, 2, 3, "tuan"),
(15, "14-12 Hoà An, Đà Nẵng", "1999-10-10", "chung@gmail.com.vn", "201802281", "Hồ Văn Chung", "0978144014", 10000, 0, 1, 2, 3, "chung");

INSERT INTO rent_type (id, `type`) VALUES
(1,"hour"),
(2,"day"),
(3,"month");

INSERT INTO service_type (id,`name`) VALUES
(1,"Villa"),
(2,"House"),
(3,"Room");

INSERT INTO service (id, amount_customer, area, cost, `description`, floor, `name`, pool_area, standard_room, `status`, rent_type_id, service_type_id) VALUES
(1,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(2,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(3,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(4,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(5,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(6,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(7,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(8,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(9,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(10,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(11,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(12,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(13,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(14,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3),
(15,10,100,2000,"Villa 2 floor", 2,"Villa 2", 10,"Vip",0,2,3);

