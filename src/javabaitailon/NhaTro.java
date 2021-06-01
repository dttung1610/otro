package javabaitailon;

public class NhaTro {
	private String MANT;
	private String TENCT;
	private String DIACHI;
	private String SDT;
	
	
	public String getMANT() {
		return MANT;
	}
	public void setMANT(String mANT) {
		MANT = mANT;
	}
	public String getTENCT() {
		return TENCT;
	}
	public void setTENCT(String tENCT) {
		TENCT = tENCT;
	}
	public String getDIACHI() {
		return DIACHI;
	}
	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	
	public NhaTro(String mANT, String tENCT, String dIACHI, String sDT) {
		super();
		MANT = mANT;
		TENCT = tENCT;
		DIACHI = dIACHI;
		SDT = sDT;
	}
	
	public NhaTro(String MANT) {
		this(MANT,"TENCT","DIACHI","SDT");
	}
	public NhaTro() {
		this("MANT");
	}
	@Override
	public String toString() {
		return "NhaTro [MANT=" + MANT + ", TENCT=" + TENCT + ", DIACHI=" + DIACHI + ", SDT=" + SDT + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DIACHI == null) ? 0 : DIACHI.hashCode());
		result = prime * result + ((MANT == null) ? 0 : MANT.hashCode());
		result = prime * result + ((SDT == null) ? 0 : SDT.hashCode());
		result = prime * result + ((TENCT == null) ? 0 : TENCT.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaTro other = (NhaTro) obj;
		if (DIACHI == null) {
			if (other.DIACHI != null)
				return false;
		} else if (!DIACHI.equals(other.DIACHI))
			return false;
		if (MANT == null) {
			if (other.MANT != null)
				return false;
		} else if (!MANT.equals(other.MANT))
			return false;
		if (SDT == null) {
			if (other.SDT != null)
				return false;
		} else if (!SDT.equals(other.SDT))
			return false;
		if (TENCT == null) {
			if (other.TENCT != null)
				return false;
		} else if (!TENCT.equals(other.TENCT))
			return false;
		return true;
	}
	
	
}
