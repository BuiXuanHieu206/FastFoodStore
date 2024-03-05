package Bo;

import java.util.ArrayList;

import Bean.DoanhThuBean;
import Dao.DoanhThuDao;

public class DoanhThuBo {
	DoanhThuDao dtdao = new DoanhThuDao();
	public ArrayList<DoanhThuBean> tkDoanhThu() throws Exception{
		return dtdao.tkDoanhThu();
	}
	public ArrayList<DoanhThuBean> tkDoanhThuNgay(String ngay, String thang, String nam) throws Exception{
		return dtdao.tkDoanhThuNgay(ngay, thang, nam);
	}
	public ArrayList<DoanhThuBean> tkDoanhThuThang(String thang, String nam) throws Exception{
		return dtdao.tkDoanhThuThang(thang, nam);
	}
	public ArrayList<DoanhThuBean> tkDoanhThuNam(String nam) throws Exception{
		return dtdao.tkDoanhThuNam(nam);
	}
	public Long TongDoanhThu() throws Exception{
		return dtdao.TongDoanhThu();
	}
	public Long TongDoanhThuNgay(String ngay, String thang, String nam) throws Exception{
		return dtdao.TongDoanhThuNgay(ngay, thang, nam);
	}
	public Long TongDoanhThuThang(String thang, String nam) throws Exception{
		return dtdao.TongDoanhThuThang(thang, nam);
	}
	public Long TongDoanhThuNam(String nam) throws Exception{
		return dtdao.TongDoanhThuNam(nam);
	}
}
