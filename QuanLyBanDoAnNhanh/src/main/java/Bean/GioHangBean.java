package Bean;

public class GioHangBean {
	private String Anh;
	private String MaMon;
	private String TenMon;
	private Long Gia;
	private Long SoLuongMua;
	private Long ThanhTien;
	public GioHangBean() {
		super();
	}
	public GioHangBean(String anh, String maMon, String tenMon, Long gia, Long soLuongMua) {
		super();
		Anh = anh;
		MaMon = maMon;
		TenMon = tenMon;
		Gia = gia;
		SoLuongMua = soLuongMua;
		ThanhTien = gia*soLuongMua;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public String getMaMon() {
		return MaMon;
	}
	public void setMaMon(String maMon) {
		MaMon = maMon;
	}
	public String getTenMon() {
		return TenMon;
	}
	public void setTenMon(String tenMon) {
		TenMon = tenMon;
	}
	public Long getGia() {
		return Gia;
	}
	public void setGia(Long gia) {
		Gia = gia;
	}
	public Long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(Long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public Long getThanhTien() {
		return SoLuongMua*Gia;
	}
	public void setThanhTien(Long thanhTien) {
		ThanhTien = thanhTien;
	}
	
	
}
