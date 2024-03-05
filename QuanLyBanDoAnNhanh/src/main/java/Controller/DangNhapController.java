package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.TaiKhoanBean;
import Bo.TaiKhoanBo;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
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
			HttpSession session = request.getSession();
			TaiKhoanBo tkbo = new TaiKhoanBo();
			if(tenDN!=null && matKhau!=null){
				TaiKhoanBean tk = tkbo.DangNhap(tenDN, matKhau);
				if(tk!=null){
					//Tạo ra 1 session tên là dn, gán un vào session
					session.setAttribute("tk", tk);
					if(tk.getQuyen().equals("Khách hàng")) {
						response.sendRedirect("TrangChuController");
						return;
					}
					else {
						response.sendRedirect("TrangChu_AdminController");
						return;
					}
					//Qua về trang menu
				}else{
					//Ngược lại: Hiển thị thông báo
					request.setAttribute("tb", "Sai tên đăng nhập hoặc mật khẩu!");
					RequestDispatcher rd = request.getRequestDispatcher("DangNhap.jsp");
					rd.forward(request, response);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("DangNhap.jsp");
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
