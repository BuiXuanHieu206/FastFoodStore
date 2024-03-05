package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DonHangDao {
	public int Them(long mand) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		String sql = "insert into DonHang (MaNguoiDung, NgayDatHang, DaMua) values (?,?,0)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, mand);
		Date n1 = new Date();
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		String st=dd.format(n1);
		Date n2 = dd.parse(st);
		cmd.setDate(2, new java.sql.Date(n2.getTime()));
		int kq=cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public long getMaxDH() throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		String sql = "select max(MaDH) as MaxDH from DonHang";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		long madh = 0;
		if(rs.next())
			madh = rs.getLong("MaxDH");
		rs.close();
		cmd.close();
		kn.cn.close();
		return madh;
	}
}
