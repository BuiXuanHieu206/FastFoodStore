package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.LoaiBean;
import Bean.MonBean;

public class LoaiDao {
	public ArrayList<LoaiBean> getLoai() throws Exception{
		ArrayList<LoaiBean> ds= new ArrayList<LoaiBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select * from Loai";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String maloai = rs.getString("MaLoai");
			String tenloai = rs.getString("TenLoai");
			ds.add(new LoaiBean(maloai, tenloai));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
	public LoaiBean getCTLoai(String maloai) throws Exception{
		LoaiBean loai = new LoaiBean();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select * from Loai where MaLoai like ?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, "%"+maloai+"%");
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		if (rs.next()) {
			loai.setMaLoai(rs.getString("MaLoai"));
			loai.setTenLoai(rs.getString("TenLoai"));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return loai;
	}
	public int Them(String maloai, String tenloai) {
		try {
			KetNoiCSDL kn = new KetNoiCSDL();
			kn.knCSDL();
			//B2: Tạo câu lệnh SQL
			String sql = "INSERT INTO Loai(MaLoai, TenLoai) VALUES(?,?)";
			//B3: Tạo câu lệnh 
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Truyền tham số vào câu lệnh nếu có
			cmd.setString(1, maloai);
			cmd.setString(2, tenloai);
			int rs = cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Sua(String maloai, String tenloai) {
		try {
			KetNoiCSDL kn = new KetNoiCSDL();
			kn.knCSDL();
			//B2: Tạo câu lệnh SQL
			String sql = "update Loai set TenLoai=? where MaLoai=?";
			//B3: Tạo câu lệnh 
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Truyền tham số vào câu lệnh nếu có
			cmd.setString(1, tenloai);
			cmd.setString(2, maloai);
			int rs = cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Xoa(String maloai) {
		try {
			KetNoiCSDL kn = new KetNoiCSDL();
			kn.knCSDL();
			//B2: Tạo câu lệnh SQL
			String sql = "delete from Loai where MaLoai = ?";
			//B3: Tạo câu lệnh 
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Truyền tham số vào câu lệnh nếu có
			cmd.setString(1, maloai);
			int rs = cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public ArrayList<LoaiBean> TimKiemLoai(String key) throws Exception{
		ArrayList<LoaiBean> ds= new ArrayList<LoaiBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select * from Loai where TenLoai like ?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, "%"+key+"%");
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String maloai = rs.getString("MaLoai");
			String tenloai = rs.getString("TenLoai");
			ds.add(new LoaiBean(maloai, tenloai));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
}
