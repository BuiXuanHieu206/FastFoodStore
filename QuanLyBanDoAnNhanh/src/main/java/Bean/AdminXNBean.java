package Bean;

import java.util.Date;

public class AdminXNBean {
	private Long MaDH;
	private Long MaCTDH;
	private String TenDN;
	private String MaMon;
	private String TenMon;
	private Long Gia;
	private Long SoLuongMua;
	private Long ThanhTien;
	private Date NgayDatHang;
	private boolean DaMua;
	public AdminXNBean() {
		super();
	}
	public AdminXNBean(Long maDH, Long maCTDH, String tenDN, String maMon, String tenMon, Long gia, Long soLuongMua,
			Long thanhTien, Date ngayDatHang, boolean daMua) {
		super();
		MaDH = maDH;
		MaCTDH = maCTDH;
		TenDN = tenDN;
		MaMon = maMon;
		TenMon = tenMon;
		Gia = gia;
		SoLuongMua = soLuongMua;
		ThanhTien = thanhTien;
		NgayDatHang = ngayDatHang;
		DaMua = daMua;
	}
	public Long getMaDH() {
		return MaDH;
	}
	public void setMaDH(Long maDH) {
		MaDH = maDH;
	}
	public Long getMaCTDH() {
		return MaCTDH;
	}
	public void setMaCTDH(Long maCTDH) {
		MaCTDH = maCTDH;
	}
	public String getTenDN() {
		return TenDN;
	}
	public void setTenDN(String tenDN) {
		TenDN = tenDN;
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
		return ThanhTien;
	}
	public void setThanhTien(Long thanhTien) {
		ThanhTien = thanhTien;
	}
	public Date getNgayDatHang() {
		return NgayDatHang;
	}
	public void setNgayDatHang(Date ngayDatHang) {
		NgayDatHang = ngayDatHang;
	}
	public boolean isDaMua() {
		return DaMua;
	}
	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}
	
}
