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
 * Servlet implementation class DoiMatKhauController
 */
@WebServlet("/DoiMatKhauController")
public class DoiMatKhauController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoiMatKhauController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String matKhau = request.getParameter("txtMatKhau");
			String matKhauMoi = request.getParameter("txtMatKhauMoi");
			String nlmatKhau = request.getParameter("txtNLMatKhau");
			String tendn = request.getParameter("tendn");
			HttpSession session = request.getSession();
			TaiKhoanBo tkbo = new TaiKhoanBo();
			if(matKhau!=null && matKhauMoi!=null && nlmatKhau!=null){
				if(tkbo.KiemTraMatKhau(tendn,matKhau)==0) {
					request.setAttribute("tb", "Mật khẩu nhập vào không đúng, vui lòng nhập lại!");
					RequestDispatcher rd = request.getRequestDispatcher("DoiMatKhau.jsp");
					rd.forward(request, response);
					return;
				}else {
					if(matKhauMoi.equals(nlmatKhau)) {
						if(tkbo.DoiMatKhau(tendn, nlmatKhau)==1) {
							request.setAttribute("tb", "Đổi mật khẩu thành công!");
							RequestDispatcher rd = request.getRequestDispatcher("DoiMatKhau.jsp");
							rd.forward(request, response);
							return;
						}else {
							request.setAttribute("tb", "Đổi mật khẩu thất bại!");
							RequestDispatcher rd = request.getRequestDispatcher("DoiMatKhau.jsp");
							rd.forward(request, response);
							return;
						}
					}else {
						request.setAttribute("tb", "Mật khẩu mới và nhập lại mật khẩu không trùng khớp, vui lòng nhập lại!");
						RequestDispatcher rd = request.getRequestDispatcher("DoiMatKhau.jsp");
						rd.forward(request, response);
						return;
					}
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("DoiMatKhau.jsp");
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
