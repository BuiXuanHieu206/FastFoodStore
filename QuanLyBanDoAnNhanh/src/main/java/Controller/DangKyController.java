package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bo.TaiKhoanBo;

/**
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tenDN = request.getParameter("txtTenDN");
			String matKhau = request.getParameter("txtMatKhau");
			String hoTen = request.getParameter("txtHoTen");
			String email = request.getParameter("txtEmail");
			String diaChi = request.getParameter("txtDiaChi");
			String sdt = request.getParameter("txtSDT");
			TaiKhoanBo tkbo = new TaiKhoanBo();
			if(tenDN != null && matKhau != null && hoTen != null && email != null && diaChi!=null && sdt!=null){
				if(tkbo.KiemTraTenDN(tenDN)==1)
					request.setAttribute("tb", "Tên đăng nhập này đã tồn tại!");
				else if(tkbo.KiemTraEmail(email)==1)
					request.setAttribute("tb", "Email này đã được dùng để đăng ký!");
				else if(tkbo.KiemTraSDT(sdt)==1)
					request.setAttribute("tb", "Số điện thoại này đã tồn tại!");
				else if(tkbo.DangKy(hoTen, diaChi, sdt, email, tenDN, matKhau)==1){
					response.sendRedirect("DangNhapController");
					return;
					//Qua về trang menu
				}else{
					//Ngược lại: Hiển thị thông báo
					request.setAttribute("tb", "Đăng ký thất bại!");
					RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp");
					rd.forward(request, response);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("DangKy.jsp");
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
