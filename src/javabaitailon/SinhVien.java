package javabaitailon;

public class SinhVien {
	private String MSSV;
	private String hoTen;
	private String ngaySinh;
	private String gioiTinh;
	private String queQuan;
	private String CNganh;
	private String lop;
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getCNganh() {
		return CNganh;
	}
	public void setCNganh(String cNganh) {
		CNganh = cNganh;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	
	public SinhVien(String mSSV, String hoTen, String ngaySinh, String gioiTinh, String queQuan, String cNganh,
			String lop) {
		super();
		MSSV = mSSV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.queQuan = queQuan;
		CNganh = cNganh;
		this.lop = lop;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SinhVien [MSSV=" + MSSV + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh
				+ ", queQuan=" + queQuan + ", CNganh=" + CNganh + ", lop=" + lop + "]";
	}
	
	
}
