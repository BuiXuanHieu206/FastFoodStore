package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import Bean.LichSuMuaHangBean;

public class LichSuMuaHangDao {
	public ArrayList<LichSuMuaHangBean> geLSMH(Long mand) throws Exception{
		ArrayList<LichSuMuaHangBean> ds = new ArrayList<LichSuMuaHangBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select *, dateadd(DAY,2,NgayDatHang) as NgayDat from ViewLichSuMuaHang where MaNguoiDung = ? order by MaDH desc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setLong(1, mand);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			Long MaDH = rs.getLong("MaDH");
			Long MaCTDH = rs.getLong("MaCTDH");
			String TenMon = rs.getString("TenMon");
			Long Gia = rs.getLong("Gia");
			Long SoLuongMua = rs.getLong("SoLuongMua");
			Long ThanhTien = rs.getLong("ThanhTien");
			Date NgayMua = rs.getDate("NgayDat");
			Boolean DaMua = rs.getBoolean("DaMua");
			ds.add(new LichSuMuaHangBean(MaDH, MaCTDH, TenMon, Gia, SoLuongMua, ThanhTien, NgayMua, DaMua));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return ds;
	}
}
