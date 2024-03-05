package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.TaiKhoanBean;
import Bo.TaiKhoanBo;

/**
 * Servlet implementation class QuanLyTaiKhoanController
 */
@WebServlet("/QuanLyTaiKhoanController")
public class QuanLyTaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyTaiKhoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8"); // Client gửi dữ liệu lên server bằng utf-8
			response.setCharacterEncoding("utf-8"); // Ngược lại
			
			TaiKhoanBo tkbo = new TaiKhoanBo();
			request.setAttribute("dstk", tkbo.getKhachHang());
			
			String manguoidung = request.getParameter("txtMaNguoiDung");
			String hoten = request.getParameter("txtHoTen");
			String diachi = request.getParameter("txtDiaChi");
			String sdt = request.getParameter("txtSDT");
			String email = request.getParameter("txtEmail");
			String tendn = request.getParameter("txtTenDN");
			String matkhau = request.getParameter("txtMatKhau");
			
			String btnThem = request.getParameter("them");
			String btnSua = request.getParameter("sua");
			String btnXoa = request.getParameter("xoa");
			String sua = request.getParameter("btnSua");
			String key = request.getParameter("txttk");
			String tatcatk = request.getParameter("tctk");
			
//			if(btnThem!=null) {
//				long dem=0;
//				for (LoaiBean dsl : lbo.getLoai()) {
//					if(dsl.getMaLoai().equals(maloai)) {
//						dem++;
//						request.setAttribute("tb", "Mã loại đã tồn tại!");
//						break;
//					}
//				}
//				if(dem==0) {
//					int kq = lbo.Them(maloai,tenloai);
//					if(kq == 1) {
//						request.setAttribute("tb", "Thêm loại thành công!");
//						request.setAttribute("dsloai", lbo.getLoai());
//						RequestDispatcher rd = request.getRequestDispatcher("QuanLyLoai.jsp");
//						rd.forward(request, response);
//						return;
//					}
//					else
//						request.setAttribute("tb", "Thêm loại thất bại!");
//				}
//			}
			if(btnSua!=null) {
				TaiKhoanBean tk = tkbo.getTK(Long.parseLong(manguoidung));
				if(tkbo.KiemTraSDT(sdt)==1 && sdt.equals(tk.getSDT())==false)
					request.setAttribute("tb", "Số điện thoại này đã được sử dụng!");
				else if(tkbo.KiemTraEmail(email)==1 && email.equals(tk.getEmail())==false)
					request.setAttribute("tb", "Email này đã được sử dụng!");
				else {
					int kq = tkbo.Sua(hoten, diachi, sdt, email, Long.parseLong(manguoidung));
					if(kq == 1) {
						request.setAttribute("tb", "Sửa tài khoản thành công!");
						request.setAttribute("dstk", tkbo.getKhachHang());
						RequestDispatcher rd = request.getRequestDispatcher("QuanLyTaiKhoan.jsp");
						rd.forward(request, response);
						return;
					}
					else
						request.setAttribute("tb", "Sửa tài khoản thất bại!");
				}
			}
			if(btnXoa!=null) {
				int kq = tkbo.Xoa(Long.parseLong(manguoidung));
				if(kq == 1) {
					request.setAttribute("tb", "Xóa tài khoản thành công!");
					request.setAttribute("dstk", tkbo.getKhachHang());
					RequestDispatcher rd = request.getRequestDispatcher("QuanLyTaiKhoan.jsp");
					rd.forward(request, response);
					return;
				}
				else
					request.setAttribute("tb", "Xóa tài khoản thất bại!");
			}
			if(sua!=null) {
				request.setAttribute("tk", tkbo.getTK(Long.parseLong(sua)));
			}
			if(key!=null) {
				request.setAttribute("dstk", tkbo.TimKiemKey(key));
			}
			if(tatcatk!=null) {
				request.setAttribute("dstk", tkbo.getKhachHang());
			}
			RequestDispatcher rd = request.getRequestDispatcher("QuanLyTaiKhoan.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
