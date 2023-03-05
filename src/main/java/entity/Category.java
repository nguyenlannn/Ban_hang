package entity;

public class Category {
	private int ma;
	private String ten;

	public Category() {
		super();
	}

	public Category(int ma, String ten) {
		super();
		this.ma = ma;
		this.ten = ten;
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

	@Override
	public String toString() {
		return "Category [ma=" + ma + ", ten=" + ten + "]";
	}

}
