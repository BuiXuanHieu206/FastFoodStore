package Bo;

import java.util.ArrayList;

import Bean.LoaiBean;
import Dao.LoaiDao;

public class LoaiBo {
	LoaiDao ldao = new LoaiDao();
	public ArrayList<LoaiBean> getLoai() throws Exception{
		return ldao.getLoai();
	}
	public LoaiBean getCTLoai(String maloai) throws Exception{
		return ldao.getCTLoai(maloai);
	}
	public int Them(String maloai, String tenloai) {
		return ldao.Them(maloai, tenloai);
	}
	public int Sua(String maloai, String tenloai) {
		return ldao.Sua(maloai, tenloai);
	}
	public int Xoa(String maloai) {
		return ldao.Xoa(maloai);
	}
	public ArrayList<LoaiBean> TimKiemLoai(String key) throws Exception{
		return ldao.TimKiemLoai(key);
	}
}
