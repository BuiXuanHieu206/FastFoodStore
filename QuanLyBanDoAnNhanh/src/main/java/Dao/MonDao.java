package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Bean.MonBean;

public class MonDao {
	public ArrayList<MonBean> getMon() throws Exception{
		ArrayList<MonBean> ds= new ArrayList<MonBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select *, dateadd(DAY,2,NgayNhap) as Ngay from Mon";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String mamon = rs.getString("MaMon");
			String tenmon = rs.getString("TenMon");
			Long gia = rs.getLong("Gia");
			Long soluong = rs.getLong("SoLuong");
			String anh = rs.getString("Anh");
			Date ngaynhap = rs.getDate("Ngay");
			String maloai = rs.getString("MaLoai");
			ds.add(new MonBean(mamon, tenmon, gia, soluong, anh, ngaynhap, maloai));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<MonBean> TimKiemMon(String key) throws Exception{
		ArrayList<MonBean> ds= new ArrayList<MonBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select *, dateadd(DAY,2,NgayNhap) as Ngay from Mon where TenMon like ?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1,"%"+key+"%");
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String mamon = rs.getString("MaMon");
			String tenmon = rs.getString("TenMon");
			Long gia = rs.getLong("Gia");
			Long soluong = rs.getLong("SoLuong");
			String anh = rs.getString("Anh");
			Date ngaynhap = rs.getDate("Ngay");
			String maloai = rs.getString("MaLoai");
			ds.add(new MonBean(mamon, tenmon, gia, soluong, anh, ngaynhap, maloai));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<MonBean> TimKiemLoai(String key) throws Exception{
		ArrayList<MonBean> ds= new ArrayList<MonBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select *, dateadd(DAY,2,NgayNhap) as Ngay from Mon where MaLoai like ?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1,"%"+key+"%");
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String mamon = rs.getString("MaMon");
			String tenmon = rs.getString("TenMon");
			Long gia = rs.getLong("Gia");
			Long soluong = rs.getLong("SoLuong");
			String anh = rs.getString("Anh");
			Date ngaynhap = rs.getDate("Ngay");
			String maloai = rs.getString("MaLoai");
			ds.add(new MonBean(mamon, tenmon, gia, soluong, anh, ngaynhap, maloai));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<MonBean> TimKiemGia(Long g) throws Exception{
		ArrayList<MonBean> ds= new ArrayList<MonBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select *, dateadd(DAY,2,NgayNhap) as Ngay from Mon where Gia <= ? order by Gia asc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setLong(1, g);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String mamon = rs.getString("MaMon");
			String tenmon = rs.getString("TenMon");
			Long gia = rs.getLong("Gia");
			Long soluong = rs.getLong("SoLuong");
			String anh = rs.getString("Anh");
			Date ngaynhap = rs.getDate("Ngay");
			String maloai = rs.getString("MaLoai");
			ds.add(new MonBean(mamon, tenmon, gia, soluong, anh, ngaynhap, maloai));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<MonBean> sanPhamMoi() throws Exception{
		ArrayList<MonBean> ds= new ArrayList<MonBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select top 5 *, dateadd(DAY,2,NgayNhap) as Ngay from Mon\r\n"
				+ "order by NgayNhap desc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String mamon = rs.getString("MaMon");
			String tenmon = rs.getString("TenMon");
			Long gia = rs.getLong("Gia");
			Long soluong = rs.getLong("SoLuong");
			String anh = rs.getString("Anh");
			Date ngaynhap = rs.getDate("Ngay");
			String maloai = rs.getString("MaLoai");
			ds.add(new MonBean(mamon, tenmon, gia, soluong, anh, ngaynhap, maloai));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
	public MonBean getCTSanPham(String mamon) throws Exception{
		MonBean sp = new MonBean();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select *, dateadd(DAY,2,NgayNhap) as Ngay from Mon where MaMon like ?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, "%"+mamon+"%");
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		if (rs.next()) {
			sp.setMaMon(rs.getString("MaMon"));
			sp.setTenMon(rs.getString("TenMon"));
			sp.setGia(rs.getLong("Gia"));
			sp.setSoLuong(rs.getLong("SoLuong"));
			sp.setAnh(rs.getString("Anh"));
			sp.setNgayNhap(rs.getDate("Ngay"));
			sp.setMaLoai(rs.getString("MaLoai"));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return sp;
	}
	public void CapNhatSoLuong(String mamon, Long slm) throws Exception{
		MonBean sp = new MonBean();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "update Mon set SoLuong = SoLuong - ? where MaMon = ?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setLong(1, slm);
		cmd.setString(2, mamon);
		//B5: Thực hiện câu lệnh
		int rs = cmd.executeUpdate();
		//B7: Đóng các đối tượng
		kn.cn.close();
	}
	public int Them(String mamon, String tenmon, Long gia, Long soluong, String anh, String maloai) {
		try {
			KetNoiCSDL kn = new KetNoiCSDL();
			kn.knCSDL();
			//B2: Tạo câu lệnh SQL
			String sql = "INSERT INTO Mon(MaMon, TenMon, Gia, SoLuong, Anh, NgayNhap, MaLoai)\r\n"
					+ "VALUES(?,?,?,?,?,?,?)";
			//B3: Tạo câu lệnh 
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Truyền tham số vào câu lệnh nếu có
			cmd.setString(1, mamon);
			cmd.setString(2, tenmon);
			cmd.setLong(3, gia);
			cmd.setLong(4, soluong);
			cmd.setString(5, anh);
			long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis);
			cmd.setDate(6, date);
			cmd.setString(7, maloai);
			int rs = cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Sua(String mamon, String tenmon, Long gia, Long soluong, String anh, String maloai) {
		try {
			KetNoiCSDL kn = new KetNoiCSDL();
			kn.knCSDL();
			//B2: Tạo câu lệnh SQL
			String sql = "update Mon set TenMon=?, Gia=?, SoLuong=?, Anh=?, MaLoai=? where MaMon=?";
			//B3: Tạo câu lệnh 
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Truyền tham số vào câu lệnh nếu có
			cmd.setString(1, tenmon);
			cmd.setLong(2, gia);
			cmd.setLong(3, soluong);
			cmd.setString(4, anh);
			cmd.setString(5, maloai);
			cmd.setString(6, mamon);
			int rs = cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Xoa(String mamon) {
		try {
			KetNoiCSDL kn = new KetNoiCSDL();
			kn.knCSDL();
			//B2: Tạo câu lệnh SQL
			String sql = "delete from Mon where MaMon = ?";
			//B3: Tạo câu lệnh 
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Truyền tham số vào câu lệnh nếu có
			cmd.setString(1, mamon);
			int rs = cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
