package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.DanhGiaBean;

public class DanhGiaDao {
	public ArrayList<DanhGiaBean> getDanhGia(String mamon) throws Exception{
		ArrayList<DanhGiaBean> dg= new ArrayList<DanhGiaBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select * from DanhGia where MaMon = ?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, mamon);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			int MaBaiDG = rs.getInt("MaBaiDG");
			String NoiDung = rs.getString("NoiDung");
			Date NgayDG = rs.getDate("NgayDG");
			int MaNguoiDung = rs.getInt("MaNguoiDung");
			String MaMon = rs.getString("MaMon");
			dg.add(new DanhGiaBean(MaBaiDG, NoiDung, NgayDG, MaNguoiDung, MaMon));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return dg;
	}
}
