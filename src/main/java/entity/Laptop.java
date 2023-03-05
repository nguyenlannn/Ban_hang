package entity;

public class Laptop {
	private int ma;
	private String ten;
	private String anh;
	private int gia;
	private String tieuDe;
	private String thuongHieu;
	private String chip;
	private String manHinh;
	private String ram;
	private String oCung;
	private String cardDoHoa;
	private String webcam;
	private String ketNoiKhongDay;
	private String congGiaoTiep;
	private String pin;
	private String trongLuong;
	private String chatLieu;
	private String mauSac;
	private int baoHanh;
	private int theLoai;
	private String dongMay;
	private int soLuong;
	private int giamGia;

	public Laptop() {
		super();
	}

	public Laptop(int ma, String ten, String anh, int gia, String tieuDe, String thuongHieu, String chip,
			String manHinh, String ram, String oCung, String cardDoHoa, String webcam, String ketNoiKhongDay,
			String congGiaoTiep, String pin, String trongLuong, String chatLieu, String mauSac, int baoHanh,
			int theLoai, String dongMay, int soLuong, int giamGia) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.anh = anh;
		this.gia = gia;
		this.tieuDe = tieuDe;
		this.thuongHieu = thuongHieu;
		this.chip = chip;
		this.manHinh = manHinh;
		this.ram = ram;
		this.oCung = oCung;
		this.cardDoHoa = cardDoHoa;
		this.webcam = webcam;
		this.ketNoiKhongDay = ketNoiKhongDay;
		this.congGiaoTiep = congGiaoTiep;
		this.pin = pin;
		this.trongLuong = trongLuong;
		this.chatLieu = chatLieu;
		this.mauSac = mauSac;
		this.baoHanh = baoHanh;
		this.theLoai = theLoai;
		this.dongMay = dongMay;
		this.soLuong = soLuong;
		this.giamGia = giamGia;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
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

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getManHinh() {
		return manHinh;
	}

	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getoCung() {
		return oCung;
	}

	public void setoCung(String oCung) {
		this.oCung = oCung;
	}

	public String getCardDoHoa() {
		return cardDoHoa;
	}

	public void setCardDoHoa(String cardDoHoa) {
		this.cardDoHoa = cardDoHoa;
	}

	public String getWebcam() {
		return webcam;
	}

	public void setWebcam(String webcam) {
		this.webcam = webcam;
	}

	public String getKetNoiKhongDay() {
		return ketNoiKhongDay;
	}

	public void setKetNoiKhongDay(String ketNoiKhongDay) {
		this.ketNoiKhongDay = ketNoiKhongDay;
	}

	public String getCongGiaoTiep() {
		return congGiaoTiep;
	}

	public void setCongGiaoTiep(String congGiaoTiep) {
		this.congGiaoTiep = congGiaoTiep;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(String trongLuong) {
		this.trongLuong = trongLuong;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public int getBaoHanh() {
		return baoHanh;
	}

	public void setBaoHanh(int baoHanh) {
		this.baoHanh = baoHanh;
	}

	public int getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(int theLoai) {
		this.theLoai = theLoai;
	}

	public String getDongMay() {
		return dongMay;
	}

	public void setDongMay(String dongMay) {
		this.dongMay = dongMay;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}

	@Override
	public String toString() {
		return "Laptop [ma=" + ma + ", ten=" + ten + ", anh=" + anh + ", gia=" + gia + ", tieuDe=" + tieuDe
				+ ", thuongHieu=" + thuongHieu + ", chip=" + chip + ", manHinh=" + manHinh + ", ram=" + ram + ", oCung="
				+ oCung + ", cardDoHoa=" + cardDoHoa + ", webcam=" + webcam + ", ketNoiKhongDay=" + ketNoiKhongDay
				+ ", congGiaoTiep=" + congGiaoTiep + ", pin=" + pin + ", trongLuong=" + trongLuong + ", chatLieu="
				+ chatLieu + ", mauSac=" + mauSac + ", baoHanh=" + baoHanh + ", theLoai=" + theLoai + ", dongMay="
				+ dongMay + ", soLuong=" + soLuong + ", giamGia=" + giamGia + "]";
	}

}
