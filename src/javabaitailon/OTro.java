package javabaitailon;

public class OTro {
	private String MSSV;
	private String maNhaTro;
	
	private String ngayden;
	private String ngaydi;
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public String getMaNhaTro() {
		return maNhaTro;
	}
	public void setMaNhaTro(String maNhaTro) {
		this.maNhaTro = maNhaTro;
	}
	
	public String getNgayden() {
		return ngayden;
	}
	public void setNgayden(String ngayden) {
		this.ngayden = ngayden;
	}
	public String getNgaydi() {
		return ngaydi;
	}
	public void setNgaydi(String ngaydi) {
		this.ngaydi = ngaydi;
	}
	public OTro(String mSSV, String maNhaTro,  String ngayden, String ngaydi) {
		super();
		MSSV = mSSV;
		this.maNhaTro = maNhaTro;
		
		this.ngayden = ngayden;
		this.ngaydi = ngaydi;
	}
	public OTro(String mSSV, String maNhaTro) {
		this(mSSV,maNhaTro,"ngayden","ngaydi");
	}
	public OTro(String mSSV) {
		this(mSSV,"  maNhaTro","ngayden","ngaydi");
	}
	
	
	public OTro() {
		this("mSSV");
	}
	@Override
	public String toString() {
		return "OTro [MSSV=" + MSSV + ", maNhaTro=" + maNhaTro 
				+ ", ngayden=" + ngayden + ", ngaydi=" + ngaydi + "]";
	}
	
	
}
