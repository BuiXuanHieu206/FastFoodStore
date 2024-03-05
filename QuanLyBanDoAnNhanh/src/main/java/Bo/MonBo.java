package Bo;

import java.util.ArrayList;

import Bean.MonBean;
import Dao.MonDao;

public class MonBo {
	MonDao mdao = new MonDao();
	public ArrayList<MonBean> getMon() throws Exception{
		return mdao.getMon();
	}
	public ArrayList<MonBean> TimKiemMon(String key) throws Exception{
		return mdao.TimKiemMon(key);
	}
	public ArrayList<MonBean> TimKiemLoai(String key) throws Exception{
		return mdao.TimKiemLoai(key);
	}
	public ArrayList<MonBean> sanPhamMoi() throws Exception{
		return mdao.sanPhamMoi();
	}
	public ArrayList<MonBean> TimKiemGia(Long g) throws Exception{
		return mdao.TimKiemGia(g);
	}
	public MonBean getCTSanPham(String mamon) throws Exception{
		return mdao.getCTSanPham(mamon);
	}
	public void CapNhatSoLuong(String mamon, Long slm) throws Exception{
		mdao.CapNhatSoLuong(mamon,slm);
	}
	public int Them(String mamon, String tenmon, Long gia, Long soluong, String anh, String maloai) {
		return mdao.Them(mamon, tenmon, gia, soluong, anh, maloai);
	}
	public int Sua(String mamon, String tenmon, Long gia, Long soluong, String anh, String maloai) {
		return mdao.Sua(mamon, tenmon, gia, soluong, anh, maloai);
	}
	public int Xoa(String mamon) {
		return mdao.Xoa(mamon);
	}
}
