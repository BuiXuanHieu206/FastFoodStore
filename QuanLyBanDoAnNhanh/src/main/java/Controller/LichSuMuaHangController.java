package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.LichSuMuaHangBean;
import Bean.TaiKhoanBean;
import Bo.LichSuMuaHangBo;

/**
 * Servlet implementation class LichSuMuaHangController
 */
@WebServlet("/LichSuMuaHangController")
public class LichSuMuaHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LichSuMuaHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<LichSuMuaHangBean> ds = null;
			//Kiểm tra đăng nhập
			HttpSession session = request.getSession();
			TaiKhoanBean tk = (TaiKhoanBean)session.getAttribute("tk");
			if(session.getAttribute("tk")==null) {
				response.sendRedirect("DangNhapController");
				return;
			}
			else {
				//Lấy lịch sử mua hàng về
				LichSuMuaHangBo lsbo = new LichSuMuaHangBo();
				ds = lsbo.geLSMH((long)tk.getMaNguoiDung());
			}
			request.setAttribute("lsmh", ds);
			RequestDispatcher rd = request.getRequestDispatcher("LichSuMuaHang.jsp");
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
