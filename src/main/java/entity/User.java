package entity;

public class User {
	private int ma;
	private String taiKhoan;
	private String email;
	private String matKhau;
	private String diaChi;
	private String sdt;
	private int isAdmin;

	public User() {
		super();
	}

	public User(int ma, String taiKhoan, String email, String matKhau, String diaChi, String sdt,
			int isAdmin) {
		super();
		this.ma = ma;
		this.taiKhoan = taiKhoan;
		this.email = email;
		this.matKhau = matKhau;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.isAdmin = isAdmin;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
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

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [ma=" + ma + ", taiKhoan=" + taiKhoan + ", email=" + email + ", matKhau=" + matKhau + ", diaChi="
				+ diaChi + ", sdt=" + sdt + ", isAdmin=" + isAdmin + "]";
	}

	
}
