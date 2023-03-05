package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import context.DBContext;
import entity.Camera;
import entity.Category;
import entity.Laptop;
import entity.Order;
import entity.User;
import service.Service;

public class DAO {

	public List<Laptop> getAllLaptop() {
		List<Laptop> list = new ArrayList<>();
		String sql = "select * from laptop order by(ma) desc;";
		Connection conn = new DBContext().getConnection();
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Laptop(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getInt(23)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Laptop> getLimit6Laptop() {
		List<Laptop> list = new ArrayList<>();
		String sql = "select * from laptop order by(ma) desc limit 6;";
		Connection conn = new DBContext().getConnection();
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Laptop(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getInt(23)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Laptop> getNext6Laptop(int amount) {
		List<Laptop> list = new ArrayList<>();
		String sql = "SELECT * FROM laptop order by(ma) desc LIMIT 6 OFFSET ?;";
		Connection conn = new DBContext().getConnection();
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setInt(1, amount);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Laptop(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getInt(23)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Camera> getAllCamera() {
		List<Camera> list = new ArrayList<>();
		String sql = "select * from camera order by(ma) desc;";
		Connection conn = new DBContext().getConnection();
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Camera(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Camera> getLimit6Camera() {
		List<Camera> list = new ArrayList<>();
		String sql = "select * from camera order by(ma) desc limit 6;";
		Connection conn = new DBContext().getConnection();
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Camera(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Camera> getNext6Camera(int amount) {
		List<Camera> list = new ArrayList<>();
		String sql = "select * from camera order by(ma) desc LIMIT 6 OFFSET ?;";
		Connection conn = new DBContext().getConnection();
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setInt(1, amount);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Camera(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		String sql = "select * from the_loai;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getTopLaptop() {
		String sql = "select maSP, sum(so_luong) from don_hang where the_loai=1 and trang_thai='Thành công'  group by(maSP) order by(sum(so_luong)) desc limit 1;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getTopCamera() {
		String sql = "select maSP, sum(so_luong) from don_hang where the_loai=2 and trang_thai='Thành công'  group by(maSP) order by(sum(so_luong)) desc limit 1;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Laptop> getLaptopByCID(String cid) {
		List<Laptop> list = new ArrayList<>();
		String sql = "select * from laptop where the_loai = ? order by(ma) desc limit 6;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, cid);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Laptop(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getInt(23)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Camera> getCameraByCID(String cid) {

		List<Camera> list = new ArrayList<>();
		String sql = "select * from camera where the_loai = ? order by(ma) desc limit 6;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, cid);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Camera(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Laptop getDetailByLaptop(int ma, int theLoai) {
		String sql = "select * from laptop where ma = ? and the_loai = ?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setInt(1, ma);
			sta.setInt(2, theLoai);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new Laptop(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getInt(23));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Camera getDetailByCamera(int ma, int theLoai) {
		String sql = "select * from camera where ma = ? and the_loai = ?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setInt(1, ma);
			sta.setInt(2, theLoai);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new Camera(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Laptop> getSearchByNameLaptop(String txtSearch) {
		List<Laptop> list = new ArrayList<>();
		String sql = "select * from laptop where ten like ? order by(ma) desc;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, "%" + txtSearch + "%");
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Laptop(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getInt(23)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Camera> getSearchByNameCamera(String txtSearch) {
		List<Camera> list = new ArrayList<>();
		String sql = "select * from camera where ten like ? order by(ma) desc;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, "%" + txtSearch + "%");
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Camera(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
						rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19), rs.getInt(20),
						rs.getString(21), rs.getInt(22), rs.getString(23), rs.getInt(24)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean logup(User u) {
		int rs = 0;
		String sql = "insert into nguoi_dung(tai_khoan,email,matKhau) values(?,?,?);";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, u.getTaiKhoan());
			sta.setString(2, u.getEmail());
			sta.setString(3, u.getMatKhau());
			rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rs == 1) {
			return true;
		}
		return false;
	}

	public User login(User u) {
		String sql = "select * from nguoi_dung where tai_khoan=? and matKhau=? and isAdmin=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, u.getTaiKhoan());
			sta.setString(2, u.getMatKhau());
			sta.setInt(3, 0);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User loginAdmin(User u) {
		String sql = "select * from nguoi_dung where tai_khoan=? and matKhau=? and isAdmin=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, u.getTaiKhoan());
			sta.setString(2, u.getMatKhau());
			sta.setInt(3, 1);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User checkAccount(User u) {
		String sql = "select * from nguoi_dung where tai_khoan=? and email=?;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setString(1, u.getTaiKhoan());
			sta.setString(2, u.getEmail());
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updatePassword(String password, User u) {
		String sql = "update nguoi_dung set matKhau=? where tai_khoan=?;";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, password);
			sta.setString(2, u.getTaiKhoan());
			int rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean order(Order o) {
		int rs = 0;
		String sql = "insert into don_hang(the_loai,maSP,ten,anh,gia,so_luong,dia_chi,sdt,thoi_gian,maKH) values(?,?,?,?,?,?,?,?,?,?);";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setInt(1, o.getTheLoai());
			sta.setInt(2, o.getMaSP());
			sta.setString(3, o.getTen());
			sta.setString(4, o.getAnh());
			sta.setLong(5, o.getGia());
			sta.setInt(6, o.getSoLuong());
			sta.setString(7, o.getDiaChi());
			sta.setString(8, o.getSdt());
			sta.setString(9, new Service().getDateTime());
			sta.setInt(10, o.getMaKH());
			rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rs == 1) {
			return true;
		}
		return false;
	}

	public void minusLaptop(Order o) {
		String sql1 = "update laptop set so_luong = so_luong-? where ma=? and the_loai=?;";
		try {
			Connection con1 = new DBContext().getConnection();
			PreparedStatement sta1 = con1.prepareStatement(sql1);
			sta1.setInt(1, o.getSoLuong());
			sta1.setInt(2, o.getMaSP());
			sta1.setInt(3, o.getTheLoai());
			int rs1 = sta1.executeUpdate();
			sta1.close();
			con1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void minusCamera(Order o) {
		String sql2 = "update camera set so_luong = so_luong-? where ma=? and the_loai=?;";
		try {
			Connection con2 = new DBContext().getConnection();
			PreparedStatement sta2 = con2.prepareStatement(sql2);
			sta2.setInt(1, o.getSoLuong());
			sta2.setInt(2, o.getMaSP());
			sta2.setInt(3, o.getTheLoai());
			int rs2 = sta2.executeUpdate();
			sta2.close();
			con2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean setAccount(User u) {
		int rs = 0;
		String sql = "update nguoi_dung set tai_khoan=?, email=?,matKhau=?,dia_chi=?, sdt=? where ma=?;";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, u.getTaiKhoan());
			sta.setString(2, u.getEmail());
			sta.setString(3, u.getMatKhau());
			sta.setString(4, u.getDiaChi());
			sta.setString(5, u.getSdt());
			sta.setInt(6, u.getMa());
			rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rs == 1) {
			return true;
		}
		return false;
	}

	public boolean setAccountAdmin(User u) {
		String arr[] = u.getMatKhau().split("\\$");
		int rs = 0;
		String sql = "update nguoi_dung set tai_khoan=?, email=?,matKhau=? where ma=? and matKhau=?;";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, u.getTaiKhoan());
			sta.setString(2, u.getEmail());
			sta.setString(3, arr[1]);
			sta.setInt(4, u.getMa());
			sta.setString(5, arr[0]);
			rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rs == 1) {
			return true;
		}
		return false;
	}

	public List<Order> getOrderByAccount(User user) {
		List<Order> list = new ArrayList<Order>();
		String sql = "select don_hang.ma,don_hang.the_loai,don_hang.maSP,don_hang.ten,don_hang.anh,don_hang.gia,don_hang.so_luong,don_hang.dia_chi,don_hang.sdt,don_hang.thoi_gian,don_hang.trang_thai,don_hang.maKH from don_hang, nguoi_dung where don_hang.maKH=nguoi_dung.ma and nguoi_dung.ma=? order by(ma) desc;";
		try {
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			sta.setInt(1, user.getMa());
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getLong(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getInt(12)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addLaptop(Laptop l) {
		String sql = "insert into laptop(ten,anh,gia,tieu_de,thuong_hieu,chip,man_hinh,ram,o_cung,card_do_hoa,webcam,ket_noi_khong_day,cong_giao_tiep,pin,trong_luong,chat_lieu,mau_sac,bao_hanh,the_loai,dong_may,so_luong,giam_gia) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, l.getTen());
			sta.setString(2, l.getAnh());
			sta.setInt(3, l.getGia());
			sta.setString(4, l.getTieuDe());
			sta.setString(5, l.getThuongHieu());
			sta.setString(6, l.getChip());
			sta.setString(7, l.getManHinh());
			sta.setString(8, l.getRam());
			sta.setString(9, l.getoCung());
			sta.setString(10, l.getCardDoHoa());
			sta.setString(11, l.getWebcam());
			sta.setString(12, l.getKetNoiKhongDay());
			sta.setString(13, l.getCongGiaoTiep());
			sta.setString(14, l.getPin());
			sta.setString(15, l.getTrongLuong());
			sta.setString(16, l.getChatLieu());
			sta.setString(17, l.getMauSac());
			sta.setInt(18, l.getBaoHanh());
			sta.setInt(19, l.getTheLoai());
			sta.setString(20, l.getDongMay());
			sta.setInt(21, l.getSoLuong());
			sta.setInt(22, l.getGiamGia());
			int rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addCamera(Camera c) {
		String sql = "insert into camera(ten,anh,gia,tieu_de,thuong_hieu,cam_bien_anh,do_phan_giai,ong_kinh,goc_nhin,chuan_nen_video,luu_tru,ket_noi,nguon_dien,hong_ngoai_tam_nhin,trong_luong,nhiet_do_hoat_dong,xuat_xu,bao_hanh,the_loai,cam_bien,so_luong,noi_lap_dat,giam_gia) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, c.getTen());
			sta.setString(2, c.getAnh());
			sta.setInt(3, c.getGia());
			sta.setString(4, c.getTieuDe());
			sta.setString(5, c.getThuongHieu());
			sta.setString(6, c.getCamBienAnh());
			sta.setString(7, c.getDoPhanGiai());
			sta.setString(8, c.getOngKinh());
			sta.setString(9, c.getGocNhin());
			sta.setString(10, c.getChuanNenVideo());
			sta.setString(11, c.getLuuTru());
			sta.setString(12, c.getKetNoi());
			sta.setString(13, c.getNguonDien());
			sta.setString(14, c.getHongNgoaiTamNhin());
			sta.setString(15, c.getTrongLuong());
			sta.setString(16, c.getNhietDoHoatDong());
			sta.setString(17, c.getXuatXu());
			sta.setInt(18, c.getBaoHanh());
			sta.setInt(19, c.getTheLoai());
			sta.setString(20, c.getCamBien());
			sta.setInt(21, c.getSoLuong());
			sta.setString(22, c.getNoiLapDat());
			sta.setInt(23, c.getGiamGia());
			int rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editLaptop(Laptop l) {
		String sql = "update laptop set ten=?,anh=?,gia=?,tieu_de=?,thuong_hieu=?,chip=?,man_hinh=?,ram=?,o_cung=?,card_do_hoa=?,webcam=?,ket_noi_khong_day=?,cong_giao_tiep=?,pin=?,trong_luong=?,chat_lieu=?,mau_sac=?,bao_hanh=?,the_loai=?,dong_may=?,so_luong=?, giam_gia=? where ma=?;";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, l.getTen());
			sta.setString(2, l.getAnh());
			sta.setInt(3, l.getGia());
			sta.setString(4, l.getTieuDe());
			sta.setString(5, l.getThuongHieu());
			sta.setString(6, l.getChip());
			sta.setString(7, l.getManHinh());
			sta.setString(8, l.getRam());
			sta.setString(9, l.getoCung());
			sta.setString(10, l.getCardDoHoa());
			sta.setString(11, l.getWebcam());
			sta.setString(12, l.getKetNoiKhongDay());
			sta.setString(13, l.getCongGiaoTiep());
			sta.setString(14, l.getPin());
			sta.setString(15, l.getTrongLuong());
			sta.setString(16, l.getChatLieu());
			sta.setString(17, l.getMauSac());
			sta.setInt(18, l.getBaoHanh());
			sta.setInt(19, l.getTheLoai());
			sta.setString(20, l.getDongMay());
			sta.setInt(21, l.getSoLuong());
			sta.setInt(22, l.getGiamGia());
			sta.setInt(23, l.getMa());
			int rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteLaptop(String ma) {
		String sql = "delete from laptop where ma=?;";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, ma);
			int rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editCamera(Camera c) {
		String sql = "update camera set ten=?,anh=?,gia=?,tieu_de=?,thuong_hieu=?,cam_bien_anh=?,do_phan_giai=?,ong_kinh=?,goc_nhin=?,chuan_nen_video=?,luu_tru=?,ket_noi=?,nguon_dien=?,hong_ngoai_tam_nhin=?,trong_luong=?,nhiet_do_hoat_dong=?,xuat_xu=?,bao_hanh=?,the_loai=?,cam_bien=?,so_luong=?,noi_lap_dat=?,giam_gia=? where ma=?;";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, c.getTen());
			sta.setString(2, c.getAnh());
			sta.setInt(3, c.getGia());
			sta.setString(4, c.getTieuDe());
			sta.setString(5, c.getThuongHieu());
			sta.setString(6, c.getCamBienAnh());
			sta.setString(7, c.getDoPhanGiai());
			sta.setString(8, c.getOngKinh());
			sta.setString(9, c.getGocNhin());
			sta.setString(10, c.getChuanNenVideo());
			sta.setString(11, c.getLuuTru());
			sta.setString(12, c.getKetNoi());
			sta.setString(13, c.getNguonDien());
			sta.setString(14, c.getHongNgoaiTamNhin());
			sta.setString(15, c.getTrongLuong());
			sta.setString(16, c.getNhietDoHoatDong());
			sta.setString(17, c.getXuatXu());
			sta.setInt(18, c.getBaoHanh());
			sta.setInt(19, c.getTheLoai());
			sta.setString(20, c.getCamBien());
			sta.setInt(21, c.getSoLuong());
			sta.setString(22, c.getNoiLapDat());
			sta.setInt(23, c.getGiamGia());
			sta.setInt(24, c.getMa());
			int rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCamera(String ma) {
		String sql = "delete from camera where ma=?;";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, ma);
			int rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Order> getAllOrder() {
		List<Order> list = new ArrayList<>();
		String sql = "select * from don_hang order by(ma) desc;";
		Connection conn = new DBContext().getConnection();
		try {
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getLong(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getInt(12)));
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public int cxn() {
		try {
			String sql = "select count(*) as 'cho_xac_nhan' from don_hang where trang_thai='Chờ xác nhận';";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int dg() {
		try {
			String sql = "select count(*) as 'dang_giao' from don_hang where trang_thai='Đang giao';";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int tc() {
		try {
			String sql = "select count(*) as 'thanh_cong' from don_hang where trang_thai='Thành công';";
			Connection conn = new DBContext().getConnection();
			PreparedStatement sta = conn.prepareStatement(sql);
			ResultSet rs = sta.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			rs.close();
			sta.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void editOrder(Order o) {
		String sql = "update don_hang set trang_thai=? where ma=?;";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setString(1, o.getTrangThai());
			sta.setInt(2, o.getMa());
			int rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean deleteOrder(Order o) {
		int rs = 0;
		String sql = "delete from don_hang where ma=? and trang_thai=?;";
		try {
			Connection con = new DBContext().getConnection();
			PreparedStatement sta = con.prepareStatement(sql);
			sta.setInt(1, o.getMa());
			sta.setString(2, "Chờ xác nhận");
			rs = sta.executeUpdate();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rs == 1) {
			return true;
		}
		return false;
	}

	public void plusLaptop(Order o) {
		String sql1 = "update laptop set so_luong = so_luong+? where ma=? and the_loai=?;";
		try {
			Connection con1 = new DBContext().getConnection();
			PreparedStatement sta1 = con1.prepareStatement(sql1);
			sta1.setInt(1, o.getSoLuong());
			sta1.setInt(2, o.getMaSP());
			sta1.setInt(3, o.getTheLoai());
			int rs1 = sta1.executeUpdate();
			sta1.close();
			con1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void plusCamera(Order o) {
		String sql2 = "update camera set so_luong = so_luong+? where ma=? and the_loai=?;";
		try {
			Connection con2 = new DBContext().getConnection();
			PreparedStatement sta2 = con2.prepareStatement(sql2);
			sta2.setInt(1, o.getSoLuong());
			sta2.setInt(2, o.getMaSP());
			sta2.setInt(3, o.getTheLoai());
			int rs2 = sta2.executeUpdate();
			sta2.close();
			con2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
