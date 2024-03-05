package Bean;

public class TKLoaiBean {
	private String MaLoai;
	private String TenLoai;
	private long SoMon;
	public TKLoaiBean() {
		super();
	}
	public TKLoaiBean(String maLoai, String tenLoai, long soMon) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
		SoMon = soMon;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}
	public long getSoMon() {
		return SoMon;
	}
	public void setSoMon(long soMon) {
		SoMon = soMon;
	}
	
}
