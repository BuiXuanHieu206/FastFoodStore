package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.AdminXNBean;


public class CTDonHangDao {
	public int Them(Long madh, String mamon ,long soluongmua) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		String sql = "insert into ChiTietDonHang(MaDH,MaMon,SoLuongMua,DaMua) values(?,?,?,0)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, madh);
		cmd.setString(2, mamon);
		cmd.setLong(3, soluongmua);
		int kq=cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public ArrayList<AdminXNBean> getXacNhan() throws Exception{
		ArrayList<AdminXNBean> ds= new ArrayList<AdminXNBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select dateadd(DAY,2,NgayDatHang) as NgayDat, * from ViewAdminXN order by MaDH desc";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			long MaDH=rs.getLong("MaDH");
			long MaCTDH=rs.getLong("MaCTDH");
			String TenDN=rs.getString("TenDN");
			String MaMon=rs.getString("MaMon");
			String TenMon=rs.getString("TenMon");
			long Gia=rs.getLong("Gia");
			long SoLuongMua=rs.getLong("SoLuongMua");
			long ThanhTien=rs.getLong("ThanhTien");
			Date NgayDat = rs.getDate("NgayDat");
			boolean DaMua=rs.getBoolean("DaMua");
			ds.add(new AdminXNBean(MaDH, MaCTDH, TenDN, MaMon, TenMon, Gia, SoLuongMua, ThanhTien, NgayDat, DaMua));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int CapNhat(long MaCTDH) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		String sql = "update ChiTietDonHang set DaMua = 1 where MaCTDH = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, MaCTDH);
		int kq=cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
