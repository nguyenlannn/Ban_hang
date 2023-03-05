package entity;

public class Order {
	private int ma;
	private int theLoai;
	private int maSP;
	private String ten;
	private String anh;
	private long gia;
	private int soLuong;
	private String diaChi;
	private String sdt;
	private String thoiGian;
	private String trangThai;
	private int maKH;

	public Order() {
		super();
	}

	public Order(int ma, int theLoai, int maSP, String ten, String anh, long gia, int soLuong, String diaChi,
			String sdt, String thoiGian, String trangThai, int maKH) {
		super();
		this.ma = ma;
		this.theLoai = theLoai;
		this.maSP = maSP;
		this.ten = ten;
		this.anh = anh;
		this.gia = gia;
		this.soLuong = soLuong;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.thoiGian = thoiGian;
		this.trangThai = trangThai;
		this.maKH = maKH;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public int getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(int theLoai) {
		this.theLoai = theLoai;
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	@Override
	public String toString() {
		return "Order [ma=" + ma + ", theLoai=" + theLoai + ", maSP=" + maSP + ", ten=" + ten + ", anh=" + anh
				+ ", gia=" + gia + ", soLuong=" + soLuong + ", diaChi=" + diaChi + ", sdt=" + sdt + ", thoiGian="
				+ thoiGian + ", trangThai=" + trangThai + ", maKH=" + maKH + "]";
	}

}
