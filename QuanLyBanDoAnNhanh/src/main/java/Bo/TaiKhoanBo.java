package Bo;

import java.util.ArrayList;

import Bean.TaiKhoanBean;
import Dao.TaiKhoanDao;

public class TaiKhoanBo {
	TaiKhoanDao tkdao = new TaiKhoanDao();
	public int KiemTraSDT(String SDT) throws Exception{
		return tkdao.KiemTraSDT(SDT);
	}
	public int KiemTraEmail(String Email) throws Exception{
		return tkdao.KiemTraEmail(Email);
	}
	public int KiemTraTenDN(String TenDN) throws Exception{
		return tkdao.KiemTraTenDN(TenDN);
	}
	public int KiemTraMatKhau(String tendn, String mk) throws Exception{
		return tkdao.KiemTraMatKhau(tendn, mk);
	}
	public int DangKy(String hoten, String diachi, String sodt, String email, String tendn, String matkhau) throws Exception{
		return tkdao.DangKy(hoten, diachi, sodt, email, tendn, matkhau);
	}
	public TaiKhoanBean DangNhap(String tdn, String mk) throws Exception{
		return tkdao.DangNhap(tdn, mk);
	}
	public ArrayList<TaiKhoanBean> getKH() throws Exception{
		return tkdao.getKH();
	}
	public int DoiMatKhau(String tendn, String mkm) throws Exception{
		return tkdao.DoiMatKhau(tendn, mkm);
	}
	public ArrayList<TaiKhoanBean> getKhachHang() throws Exception{
		return tkdao.getKhachHang();
	}
	public TaiKhoanBean getTK(Long mand) throws Exception{
		return tkdao.getTK(mand);
	}
	public ArrayList<TaiKhoanBean> TimKiemKey(String key) throws Exception{
		return tkdao.TimKiemKey(key);
	}
	public int Sua(String hoten, String diachi, String sdt, String email, Long mand) {
		return tkdao.Sua(hoten, diachi, sdt, email, mand);
	}
	public int Xoa(Long mand) {
		return tkdao.Xoa(mand);
	}
}