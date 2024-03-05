package Bo;

import java.util.ArrayList;

import Bean.DanhGiaBean;
import Dao.DanhGiaDao;

public class DanhGiaBo {
	DanhGiaDao dgdao = new DanhGiaDao();
	public ArrayList<DanhGiaBean> getDanhGia(String mamon) throws Exception{
		return dgdao.getDanhGia(mamon);
	}
}
