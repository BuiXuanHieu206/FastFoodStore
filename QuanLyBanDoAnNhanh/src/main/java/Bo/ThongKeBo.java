package Bo;

import java.util.ArrayList;

import Bean.DonHangBean;
import Bean.LichSuMuaHangBean;
import Bean.TKLoaiBean;
import Dao.ThongKeDao;

public class ThongKeBo {
	ThongKeDao tkdao = new ThongKeDao();
	public ArrayList<TKLoaiBean> tkLoai() throws Exception{
		return tkdao.tkLoai();
	}
	public Long DonHangDaMua(Long madh) throws Exception{
		return tkdao.DonHangDaMua(madh);
	}
	public int CapNhatDaMua(Long madh) throws Exception {
		return tkdao.CapNhatDaMua(madh);
	}
	public ArrayList<DonHangBean> tkDonHang() throws Exception{
		return tkdao.tkDonHang();
	}
	public ArrayList<DonHangBean> tkDonHangNgay(String ngay) throws Exception{
		return tkdao.tkDonHangNgay(ngay);
	}
	public ArrayList<DonHangBean> tkDonHangThang(String thang, String nam) throws Exception{
		return tkdao.tkDonHangThang(thang, nam);
	}
	public ArrayList<DonHangBean> tkDonHangNam(String nam) throws Exception{
		return tkdao.tkDonHangNam(nam);
	}
	public ArrayList<LichSuMuaHangBean> ChiTietDonHang(Long madh) throws Exception{
		return tkdao.ChiTietDonHang(madh);
	}
	public int SoDonHang(ArrayList<DonHangBean> ds) {
		return ds.size();
	}
	public int DonHangHoanTat(ArrayList<DonHangBean> ds) {
		int sl=0;
		for (DonHangBean dh : ds) {
			if(dh.isDaMua()==true)
				sl++;
		}
		return sl;
	}
	public int DonHangChoXacNhan(ArrayList<DonHangBean> ds) {
		int sl=0;
		for (DonHangBean dh : ds) {
			if(dh.isDaMua()==false)
				sl++;
		}
		return sl;
	}
}
