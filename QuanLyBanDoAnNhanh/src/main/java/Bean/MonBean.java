package Bean;

import java.util.Date;

public class MonBean {
	private String MaMon;
	private String TenMon;
	private long Gia;
	private long SoLuong;
	private String Anh;
	private Date NgayNhap;
	private String MaLoai;
	public MonBean() {
		super();
	}
	public MonBean(String maMon, String tenMon, long gia, long soLuong, String anh, Date ngayNhap, String maLoai) {
		super();
		MaMon = maMon;
		TenMon = tenMon;
		Gia = gia;
		SoLuong = soLuong;
		Anh = anh;
		NgayNhap = ngayNhap;
		MaLoai = maLoai;
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
	public long getGia() {
		return Gia;
	}
	public void setGia(long gia) {
		Gia = gia;
	}
	public long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(long soLuong) {
		SoLuong = soLuong;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public Date getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	
}
