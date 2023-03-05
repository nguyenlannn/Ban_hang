create database ban_hang;
use ban_hang;

create table camera (
  ma int AUTO_INCREMENT PRIMARY KEY,
  ten varchar(255),
  anh varchar(255),
  gia int,
  tieu_de varchar(255),
  thuong_hieu varchar(255),
  cam_bien_anh varchar(255),
  do_phan_giai varchar(255),
  ong_kinh varchar(255),
  goc_nhin varchar(255),
  chuan_nen_video varchar(255),
  luu_tru varchar(255),
  ket_noi varchar(255),
  nguon_dien varchar(255),
  hong_ngoai_tam_nhin varchar(255),
  trong_luong varchar(255),
  nhiet_do_hoat_dong varchar(255),
  xuat_xu varchar(255),
  bao_hanh int,
  the_loai int,
  cam_bien varchar(255),
  so_luong int,
  noi_Lap_dat varchar(255),
  giam_gia int,
   UNIQUE (ten)
);

create table laptop (
  ma int AUTO_INCREMENT PRIMARY KEY,
  ten varchar(255),
  anh varchar(255),
  gia int,
  tieu_de varchar(255),
  thuong_hieu varchar(255),
  chip varchar(255),
  man_hinh varchar(255),
  ram varchar(255),
  o_cung varchar(255),
  card_do_hoa varchar(255),
  webcam varchar(255),
  ket_noi_khong_day varchar(255),
  cong_giao_tiep text,
  pin varchar(255),
  trong_luong varchar(255),
  chat_lieu varchar(255),
  mau_sac varchar(255),
  bao_hanh int,
  the_loai int,
  dong_may varchar(255),
  so_luong int,
  giam_gia int,
   UNIQUE (ten)
);

create table the_loai (
  ma int AUTO_INCREMENT PRIMARY KEY,
  ten varchar(255)
);

create table nguoi_dung (
  ma int AUTO_INCREMENT PRIMARY KEY,
  tai_khoan varchar(255),
  email varchar(255),
  matKhau varchar(255),
  dia_chi varchar(255),
  sdt varchar(255),
  isAdmin int default 0,
   UNIQUE (tai_khoan),
    UNIQUE (email)
);

create table don_hang (
  ma int AUTO_INCREMENT PRIMARY KEY,
  the_loai int,
  maSP int,
  ten varchar(255),
  anh varchar(255),
  gia bigint,
  so_luong int,
  dia_chi varchar(255),
  sdt varchar(255),
  thoi_gian datetime,
  trang_thai varchar(255) default 'Chờ xác nhận',
  maKH int
);
ALTER TABLE don_hang 
ADD CONSTRAINT lien_ket_01 
FOREIGN KEY (maKH) 
REFERENCES nguoi_dung(ma);
INSERT INTO `ban_hang`.`nguoi_dung` (`tai_khoan`, `email`, `matKhau`, `isAdmin`)
VALUES ('admin', 'nguyenhuucuong23102000@gmail.com', '1', '1');
INSERT INTO `ban_hang`.`the_loai` (`ten`) VALUES ('Laptop');
INSERT INTO `ban_hang`.`the_loai` (`ten`) VALUES ('Camera');
