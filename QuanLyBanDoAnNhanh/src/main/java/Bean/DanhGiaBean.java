package Bean;

import java.util.Date;

public class DanhGiaBean {
	private int MaBaiDG;
	private String NoiDung;
	private Date NgayDG;
	private int MaNguoiDung;
	private String MaMon;
	public DanhGiaBean() {
		super();
	}
	public DanhGiaBean(int maBaiDG, String noiDung, Date ngayDG, int maNguoiDung, String maMon) {
		super();
		MaBaiDG = maBaiDG;
		NoiDung = noiDung;
		NgayDG = ngayDG;
		MaNguoiDung = maNguoiDung;
		MaMon = maMon;
	}
	public int getMaBaiDG() {
		return MaBaiDG;
	}
	public void setMaBaiDG(int maBaiDG) {
		MaBaiDG = maBaiDG;
	}
	public String getNoiDung() {
		return NoiDung;
	}
	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}
	public Date getNgayDG() {
		return NgayDG;
	}
	public void setNgayDG(Date ngayDG) {
		NgayDG = ngayDG;
	}
	public int getMaNguoiDung() {
		return MaNguoiDung;
	}
	public void setMaNguoiDung(int maNguoiDung) {
		MaNguoiDung = maNguoiDung;
	}
	public String getMaMon() {
		return MaMon;
	}
	public void setMaMon(String maMon) {
		MaMon = maMon;
	}
	
}
