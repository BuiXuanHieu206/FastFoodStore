package Bean;

import java.util.Date;

public class LichSuMuaHangBean {
	private Long MaDH;
	private Long MaCTDH;
	private String TenMon;
	private Long Gia;
	private Long SoLuongMua;
	private Long ThanhTien;
	private Date NgayMua;
	private boolean DaMua;
	public LichSuMuaHangBean() {
		super();
	}
	public LichSuMuaHangBean(Long maDH, Long maCTDH, String tenMon, Long gia, Long soLuongMua, Long thanhTien,
			Date ngayMua, boolean daMua) {
		super();
		MaDH = maDH;
		MaCTDH = maCTDH;
		TenMon = tenMon;
		Gia = gia;
		SoLuongMua = soLuongMua;
		ThanhTien = gia*soLuongMua;
		NgayMua = ngayMua;
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
		ThanhTien = Gia*SoLuongMua;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public boolean isDaMua() {
		return DaMua;
	}
	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}
}
