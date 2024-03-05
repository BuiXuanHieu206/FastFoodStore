package Bo;

import Dao.DonHangDao;

public class DonHangBo {
	DonHangDao dhdao = new DonHangDao();
	public int Them(long mand) throws Exception{
		return dhdao.Them(mand);
	}
	public long getMaxDH() throws Exception{
		return dhdao.getMaxDH();
	}
}
