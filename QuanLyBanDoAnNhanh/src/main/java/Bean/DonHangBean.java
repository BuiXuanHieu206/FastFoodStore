package Bean;

import java.util.Date;

public class DonHangBean {
	private Long MaDH;
	private String MaNguoiDung;
	private Date NgayDatHang;
	private boolean DaMua;
	public DonHangBean() {
		super();
	}
	public DonHangBean(Long maDH, String maNguoiDung, Date ngayDatHang, boolean daMua) {
		super();
		MaDH = maDH;
		MaNguoiDung = maNguoiDung;
		NgayDatHang = ngayDatHang;
		DaMua = daMua;
	}
	public Long getMaDH() {
		return MaDH;
	}
	public void setMaDH(Long maDH) {
		MaDH = maDH;
	}
	public String getMaNguoiDung() {
		return MaNguoiDung;
	}
	public void setMaNguoiDung(String maNguoiDung) {
		MaNguoiDung = maNguoiDung;
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
