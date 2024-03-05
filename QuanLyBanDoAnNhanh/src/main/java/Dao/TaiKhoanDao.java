package Dao;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.TaiKhoanBean;

public class TaiKhoanDao {
	public int KiemTraSDT(String SDT) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		String sql = "select SDT from TaiKhoan where SDT=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, SDT);
		ResultSet rs = cmd.executeQuery();
		while(rs.next())
			return 1;
		return 0;
	}
	public int KiemTraEmail(String Email) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		String sql = "select Email from TaiKhoan where Email=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, Email);
		ResultSet rs = cmd.executeQuery();
		while(rs.next())
			return 1;
		return 0;
	}
	public int KiemTraTenDN(String TenDN) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		String sql = "select TenDN from TaiKhoan where TenDN=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, TenDN);
		ResultSet rs = cmd.executeQuery();
		while(rs.next())
			return 1;
		return 0;
	}
	public int KiemTraMatKhau(String tendn, String mk) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		String sql = "select MatKhau from TaiKhoan where TenDN=? and MatKhau=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, mk);
		ResultSet rs = cmd.executeQuery();
		if(rs.next())
			return 1;
		return 0;
	}
	public int DangKy(String hoten, String diachi, String sodt, String email, String tendn, String matkhau) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//String matkhau = ecrypt(pass);
		//B2: Tạo câu lệnh SQL
		String sql = "insert into TaiKhoan(HoTen, DiaChi, SDT, Email, TenDN, MatKhau, Quyen) values(?, ?, ?, ?, ?, ?, ?)";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, hoten);
		cmd.setString(2, diachi);
		cmd.setString(3, sodt);
		cmd.setString(4, email);
		cmd.setString(5, tendn);
		cmd.setString(6, matkhau);
		cmd.setString(7, "Khách hàng");
		//B5: Thực hiện câu lệnh
		int check = 0;
		check = cmd.executeUpdate();
		kn.cn.close();
		return check;
	}
	public TaiKhoanBean DangNhap(String tdn, String mk) throws Exception{
		TaiKhoanBean tk = null;
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select * from TaiKhoan where TenDN=? and MatKhau=?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, tdn);
		cmd.setString(2, mk);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		if (rs.next()) {
			int maNguoiDung = rs.getInt("MaNguoiDung");
			String hoTen = rs.getString("HoTen");
			String diaChi = rs.getString("DiaChi");
			String sdt = rs.getString("SDT");
			String email = rs.getString("Email");
			String tenDN = rs.getString("TenDN");
			String matKhau = rs.getString("MatKhau");
			String quyen = rs.getString("Quyen");
			tk = new TaiKhoanBean(maNguoiDung,hoTen, diaChi, sdt, email, tenDN, matKhau, quyen);
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return tk;
	}
	public ArrayList<TaiKhoanBean> getKH() throws Exception{
		ArrayList<TaiKhoanBean> ds = new ArrayList<TaiKhoanBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select * from TaiKhoan where Quyen = 'Khách hàng'";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			int maNguoiDung = rs.getInt("MaNguoiDung");
			String hoTen = rs.getString("HoTen");
			String diaChi = rs.getString("DiaChi");
			String sdt = rs.getString("SDT");
			String email = rs.getString("Email");
			String tenDN = rs.getString("TenDN");
			String matKhau = rs.getString("MatKhau");
			String quyen = rs.getString("Quyen");
			ds.add(new TaiKhoanBean(maNguoiDung, hoTen, diaChi, sdt, email, tenDN, matKhau, quyen));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<TaiKhoanBean> getKhachHang() throws Exception{
		ArrayList<TaiKhoanBean> ds = new ArrayList<TaiKhoanBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select * from TaiKhoan where Quyen = 'Khách hàng'";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			int maNguoiDung = rs.getInt("MaNguoiDung");
			String hoTen = rs.getString("HoTen");
			String diaChi = rs.getString("DiaChi");
			String sdt = rs.getString("SDT");
			String email = rs.getString("Email");
			String tenDN = rs.getString("TenDN");
			String mk = rs.getString("MatKhau");
			String matkhau = ecrypt(mk);
			String quyen = rs.getString("Quyen");
			ds.add(new TaiKhoanBean(maNguoiDung, hoTen, diaChi, sdt, email, tenDN, matkhau, quyen));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int DoiMatKhau(String tendn, String mkm) throws Exception{
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//String matkhau = ecrypt(pass);
		//B2: Tạo câu lệnh SQL
		String sql = "update TaiKhoan set MatKhau = ? where TenDN = ?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, mkm);
		cmd.setString(2, tendn);
		//B5: Thực hiện câu lệnh
		int check = 0;
		check = cmd.executeUpdate();
		kn.cn.close();
		return check;
	}
	public TaiKhoanBean getTK(Long mand) throws Exception{
		TaiKhoanBean tk = null;
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select * from TaiKhoan where MaNguoiDung=?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setLong(1, mand);
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		if (rs.next()) {
			int maNguoiDung = rs.getInt("MaNguoiDung");
			String hoTen = rs.getString("HoTen");
			String diaChi = rs.getString("DiaChi");
			String sdt = rs.getString("SDT");
			String email = rs.getString("Email");
			String tenDN = rs.getString("TenDN");
			String mk = rs.getString("MatKhau");
			String matKhau = ecrypt(mk);
			String quyen = rs.getString("Quyen");
			tk = new TaiKhoanBean(maNguoiDung,hoTen, diaChi, sdt, email, tenDN, matKhau, quyen);
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return tk;
	}
	public ArrayList<TaiKhoanBean> TimKiemKey(String key) throws Exception{
		ArrayList<TaiKhoanBean> ds = new ArrayList<TaiKhoanBean>();
		KetNoiCSDL kn = new KetNoiCSDL();
		kn.knCSDL();
		//B2: Tạo câu lệnh SQL
		String sql = "select * from TaiKhoan where HoTen like ? or DiaChi like ?";
		//B3: Tạo câu lệnh 
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4: Truyền tham số vào câu lệnh nếu có
		cmd.setString(1, "%"+key+"%");
		cmd.setString(2, "%"+key+"%");
		//B5: Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		//B6: Duyệt rs
		while (rs.next()) {
			int maNguoiDung = rs.getInt("MaNguoiDung");
			String hoTen = rs.getString("HoTen");
			String diaChi = rs.getString("DiaChi");
			String sdt = rs.getString("SDT");
			String email = rs.getString("Email");
			String tenDN = rs.getString("TenDN");
			String mk = rs.getString("MatKhau");
			String matkhau = ecrypt(mk);
			String quyen = rs.getString("Quyen");
			ds.add(new TaiKhoanBean(maNguoiDung, hoTen, diaChi, sdt, email, tenDN, matkhau, quyen));
		}
		//B7: Đóng các đối tượng
		rs.close();
		kn.cn.close();
		return ds;
	}
	public int Sua(String hoten, String diachi, String sdt, String email, Long mand) {
		try {
			KetNoiCSDL kn = new KetNoiCSDL();
			kn.knCSDL();
			//B2: Tạo câu lệnh SQL
			String sql = "update TaiKhoan set HoTen=?, DiaChi=?, SDT=?, Email=? where MaNguoiDung=?";
			//B3: Tạo câu lệnh 
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Truyền tham số vào câu lệnh nếu có
			cmd.setString(1, hoten);
			cmd.setString(2, diachi);
			cmd.setString(3, sdt);
			cmd.setString(4, email);
			cmd.setLong(5, mand);
			int rs = cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int Xoa(Long mand) {
		try {
			KetNoiCSDL kn = new KetNoiCSDL();
			kn.knCSDL();
			//B2: Tạo câu lệnh SQL
			String sql = "delete from TaiKhoan where MaNguoiDung = ?";
			//B3: Tạo câu lệnh 
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4: Truyền tham số vào câu lệnh nếu có
			cmd.setLong(1, mand);
			int rs = cmd.executeUpdate();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static String ecrypt(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{ 
		String enrtext; 
		MessageDigest msd=MessageDigest.getInstance("MD5"); 
		byte[] srctextbyte=text.getBytes("UTF-8"); 
		byte[] enrtextbyte=msd.digest(srctextbyte); 
		BigInteger big = new BigInteger(1, enrtextbyte); 
		enrtext=big.toString(16); 
		return enrtext; 
	}
}
