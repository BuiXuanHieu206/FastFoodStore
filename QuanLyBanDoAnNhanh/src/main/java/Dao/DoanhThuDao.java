package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.DoanhThuBean;


public class DoanhThuDao {
	public ArrayList<DoanhThuBean> tkDoanhThu() throws Exception{
		ArrayList<DoanhThuBean> ds= new ArrayList<DoanhThuBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select MaLoai, TenLoai, isnull(count(SoLuongMua),0) as TongSoLuong, isnull(sum(ThanhTien),0) as TongDoanhThu\r\n"
				+ "from ViewThongKeDoanhThu \r\n"
				+ "where DaMua = 1\r\n"
				+ "group by MaLoai, TenLoai\r\n"
				+ "order by MaLoai asc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String maloai = rs.getString("MaLoai");
			String tenloai = rs.getString("TenLoai");
			Long tongsoluong = rs.getLong("TongSoLuong");
			Long tongdoanhthu = rs.getLong("TongDoanhThu");
			ds.add(new DoanhThuBean(maloai, tenloai, tongsoluong, tongdoanhthu));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<DoanhThuBean> tkDoanhThuNgay(String ngay, String thang, String nam) throws Exception{
		ArrayList<DoanhThuBean> ds= new ArrayList<DoanhThuBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select MaLoai, TenLoai, isnull(count(SoLuongMua),0) as TongSoLuong, isnull(sum(ThanhTien),0) as TongDoanhThu\r\n"
				+ "from ViewThongKeDoanhThu \r\n"
				+ "where DaMua = 1 and DAY(NgayDatHang)=? and MONTH(NgayDatHang)=? and YEAR(NgayDatHang)=?\r\n"
				+ "group by MaLoai, TenLoai\r\n"
				+ "order by MaLoai asc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, ngay);
		cmd.setString(2, thang);
		cmd.setString(3, nam);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String maloai = rs.getString("MaLoai");
			String tenloai = rs.getString("TenLoai");
			Long tongsoluong = rs.getLong("TongSoLuong");
			Long tongdoanhthu = rs.getLong("TongDoanhThu");
			ds.add(new DoanhThuBean(maloai, tenloai, tongsoluong, tongdoanhthu));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<DoanhThuBean> tkDoanhThuThang(String thang, String nam) throws Exception{
		ArrayList<DoanhThuBean> ds= new ArrayList<DoanhThuBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select MaLoai, TenLoai, isnull(count(SoLuongMua),0) as TongSoLuong, isnull(sum(ThanhTien),0) as TongDoanhThu\r\n"
				+ "from ViewThongKeDoanhThu \r\n"
				+ "where DaMua = 1 and MONTH(NgayDatHang)=? and YEAR(NgayDatHang)=?\r\n"
				+ "group by MaLoai, TenLoai\r\n"
				+ "order by MaLoai asc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, thang);
		cmd.setString(2, nam);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String maloai = rs.getString("MaLoai");
			String tenloai = rs.getString("TenLoai");
			Long tongsoluong = rs.getLong("TongSoLuong");
			Long tongdoanhthu = rs.getLong("TongDoanhThu");
			ds.add(new DoanhThuBean(maloai, tenloai, tongsoluong, tongdoanhthu));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<DoanhThuBean> tkDoanhThuNam(String nam) throws Exception{
		ArrayList<DoanhThuBean> ds= new ArrayList<DoanhThuBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select MaLoai, TenLoai, isnull(count(SoLuongMua),0) as TongSoLuong, isnull(sum(ThanhTien),0) as TongDoanhThu\r\n"
				+ "from ViewThongKeDoanhThu \r\n"
				+ "where DaMua = 1 and YEAR(NgayDatHang)=?\r\n"
				+ "group by MaLoai, TenLoai\r\n"
				+ "order by MaLoai asc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, nam);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			String maloai = rs.getString("MaLoai");
			String tenloai = rs.getString("TenLoai");
			Long tongsoluong = rs.getLong("TongSoLuong");
			Long tongdoanhthu = rs.getLong("TongDoanhThu");
			ds.add(new DoanhThuBean(maloai, tenloai, tongsoluong, tongdoanhthu));
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return ds;
	}
	public Long TongDoanhThu() throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select isnull(sum(ThanhTien),0) as TongDoanhThu\r\n"
				+ "from ViewThongKeDoanhThu \r\n"
				+ "where DaMua = 1";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		Long tong=(long)0;
		if (rs.next()) {
			tong = rs.getLong("TongDoanhThu");
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return tong;
	}
	public Long TongDoanhThuNgay(String ngay, String thang, String nam) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select isnull(sum(ThanhTien),0) as TongDoanhThu\r\n"
				+ "from ViewThongKeDoanhThu \r\n"
				+ "where DaMua = 1 and DAY(NgayDatHang)=? and MONTH(NgayDatHang)=? and YEAR(NgayDatHang)=?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, ngay);
		cmd.setString(2, thang);
		cmd.setString(3, nam);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		Long tong=(long)0;
		if (rs.next()) {
			tong = rs.getLong("TongDoanhThu");
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return tong;
	}
	public Long TongDoanhThuThang(String thang, String nam) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select isnull(sum(ThanhTien),0) as TongDoanhThu\r\n"
				+ "from ViewThongKeDoanhThu \r\n"
				+ "where DaMua = 1 and MONTH(NgayDatHang)=? and YEAR(NgayDatHang)=?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, thang);
		cmd.setString(2, nam);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		Long tong=(long)0;
		if (rs.next()) {
			tong = rs.getLong("TongDoanhThu");
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return tong;
	}
	public Long TongDoanhThuNam(String nam) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select isnull(sum(ThanhTien),0) as TongDoanhThu\r\n"
				+ "from ViewThongKeDoanhThu \r\n"
				+ "where DaMua = 1 and YEAR(NgayDatHang)=?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, nam);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		Long tong=(long)0;
		if (rs.next()) {
			tong = rs.getLong("TongDoanhThu");
		}
		//B7: Đóng các đối tượngs
		rs.close();
		kn.cn.close();
		return tong;
	}
}
