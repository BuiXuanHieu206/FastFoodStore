package Bean;

public class DoanhThuBean {
	private String MaLoai;
	private String TenLoai;
	private Long TongSoLuong;
	private Long TongDoanhThu;
	public DoanhThuBean() {
		super();
	}
	public DoanhThuBean(String maLoai, String tenLoai, Long tongSoLuong, Long tongDoanhThu) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
		TongSoLuong = tongSoLuong;
		TongDoanhThu = tongDoanhThu;
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
	public Long getTongSoLuong() {
		return TongSoLuong;
	}
	public void setTongSoLuong(Long tongSoLuong) {
		TongSoLuong = tongSoLuong;
	}
	public Long getTongDoanhThu() {
		return TongDoanhThu;
	}
	public void setTongDoanhThu(Long tongDoanhThu) {
		TongDoanhThu = tongDoanhThu;
	}
}
