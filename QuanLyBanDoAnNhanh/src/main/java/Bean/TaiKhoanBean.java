package Bean;

public class TaiKhoanBean {
	private int MaNguoiDung;
	private String HoTen;
	private String DiaChi;
	private String SDT;
	private String Email;
	private String TenDN;
	private String MatKhau;
	private String Quyen;
	public TaiKhoanBean() {
		super();
	}
	public TaiKhoanBean(int maNguoiDung, String hoTen, String diaChi, String sDT, String email, String tenDN,
			String matKhau, String quyen) {
		super();
		MaNguoiDung = maNguoiDung;
		HoTen = hoTen;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
		TenDN = tenDN;
		MatKhau = matKhau;
		Quyen = quyen;
	}
	public int getMaNguoiDung() {
		return MaNguoiDung;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTenDN() {
		return TenDN;
	}
	public void setTenDN(String tenDN) {
		TenDN = tenDN;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getQuyen() {
		return Quyen;
	}
	public void setQuyen(String quyen) {
		Quyen = quyen;
	}
	
}
