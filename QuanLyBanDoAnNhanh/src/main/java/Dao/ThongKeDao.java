package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.DonHangBean;
import Bean.LichSuMuaHangBean;
import Bean.TKLoaiBean;

public class ThongKeDao {
	public ArrayList<TKLoaiBean> tkLoai() throws Exception{
		ArrayList<TKLoaiBean> ds= new ArrayList<TKLoaiBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select Loai.MaLoai, TenLoai, isnull(count(MaMon),0) as SoMon from Loai left join Mon on Loai.MaLoai = Mon.MaLoai\r\n"
				+ "group by Loai.MaLoai, TenLoai";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String mamon = rs.getString("MaLoai");
			String tenmon = rs.getString("TenLoai");
			Long somon = rs.getLong("SoMon");
			ds.add(new TKLoaiBean(mamon, tenmon, somon));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
	public Long DonHangDaMua(Long madh) throws Exception{
		long check=0;
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select * from ChiTietDonHang where MaDH=? and DaMua = 0";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setLong(1, madh);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next())
			check++;
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return check;
	}
	public int CapNhatDaMua(Long madh) throws Exception {
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "update DonHang set DaMua=1 where MaDH=?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setLong(1, madh);
		//B5: Thực hiện câu lệnh
		int check = cmd.executeUpdate();
		kn.cn.close();
		return check;
	}
	public ArrayList<DonHangBean> tkDonHang() throws Exception{
		ArrayList<DonHangBean> ds= new ArrayList<DonHangBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select *, dateadd(DAY,2,NgayDatHang) as NgayDat from DonHang order by MaDH desc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			Long madh = rs.getLong("MaDH");
			String manguoidung = rs.getString("MaNguoiDung");
			Date ngaydat = rs.getDate("NgayDat");
			boolean damua = rs.getBoolean("DaMua");
			ds.add(new DonHangBean(madh, manguoidung, ngaydat, damua));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<DonHangBean> tkDonHangNgay(String ngay) throws Exception{
		ArrayList<DonHangBean> ds= new ArrayList<DonHangBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select *, dateadd(DAY,2,NgayDatHang) as NgayDat from DonHang where NgayDatHang=? order by MaDH desc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, ngay);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			Long madh = rs.getLong("MaDH");
			String manguoidung = rs.getString("MaNguoiDung");
			Date ngaydat = rs.getDate("NgayDat");
			boolean damua = rs.getBoolean("DaMua");
			ds.add(new DonHangBean(madh, manguoidung, ngaydat, damua));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<DonHangBean> tkDonHangThang(String thang, String nam) throws Exception{
		ArrayList<DonHangBean> ds= new ArrayList<DonHangBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select *, dateadd(DAY,2,NgayDatHang) as NgayDat from DonHang where month(NgayDatHang)=? and year(NgayDatHang)=? order by MaDH desc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, thang);
		cmd.setString(2, nam);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			Long madh = rs.getLong("MaDH");
			String manguoidung = rs.getString("MaNguoiDung");
			Date ngaydat = rs.getDate("NgayDat");
			boolean damua = rs.getBoolean("DaMua");
			ds.add(new DonHangBean(madh, manguoidung, ngaydat, damua));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<DonHangBean> tkDonHangNam(String nam) throws Exception{
		ArrayList<DonHangBean> ds= new ArrayList<DonHangBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select *, dateadd(DAY,2,NgayDatHang) as NgayDat from DonHang where year(NgayDatHang)=? order by MaDH desc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, nam);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			Long madh = rs.getLong("MaDH");
			String manguoidung = rs.getString("MaNguoiDung");
			Date ngaydat = rs.getDate("NgayDat");
			boolean damua = rs.getBoolean("DaMua");
			ds.add(new DonHangBean(madh, manguoidung, ngaydat, damua));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<LichSuMuaHangBean> ChiTietDonHang(Long madh) throws Exception{
		ArrayList<LichSuMuaHangBean> ds = new ArrayList<LichSuMuaHangBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select *, dateadd(DAY,2,NgayDatHang) as NgayDat from ViewLichSuMuaHang where MaDH=?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setLong(1, madh);
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
