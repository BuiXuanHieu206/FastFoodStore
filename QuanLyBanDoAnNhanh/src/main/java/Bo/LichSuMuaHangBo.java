package Bo;

import java.util.ArrayList;

import Bean.LichSuMuaHangBean;
import Dao.LichSuMuaHangDao;

public class LichSuMuaHangBo {
	LichSuMuaHangDao lsdao = new LichSuMuaHangDao();
	public ArrayList<LichSuMuaHangBean> geLSMH(Long mand) throws Exception{
		return lsdao.geLSMH(mand);
	}
}
