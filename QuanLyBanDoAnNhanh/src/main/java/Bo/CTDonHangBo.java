package Bo;

import java.util.ArrayList;

import Bean.AdminXNBean;
import Dao.CTDonHangDao;

public class CTDonHangBo {
	CTDonHangDao ctdao = new CTDonHangDao();
	public int Them(Long madh, String mamon ,long soluongmua) throws Exception{
		return ctdao.Them(madh, mamon, soluongmua);
	}
	public ArrayList<AdminXNBean> getXacNhan() throws Exception{
		return ctdao.getXacNhan();
	}
	public int CapNhat(long MaCTDH) throws Exception{
		return ctdao.CapNhat(MaCTDH);
	}
}
