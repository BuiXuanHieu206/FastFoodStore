package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.GioHangBean;
import Bean.LichSuMuaHangBean;
import Bean.TaiKhoanBean;
import Bo.CTDonHangBo;
import Bo.DonHangBo;
import Bo.GioHangBo;

/**
 * Servlet implementation class ThanhToanController
 */
@WebServlet("/ThanhToanController")
public class ThanhToanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Kiểm tra đăng nhập
			HttpSession session = request.getSession();
			TaiKhoanBean tk = (TaiKhoanBean)session.getAttribute("tk");
			if(session.getAttribute("tk")==null) {
				response.sendRedirect("DangNhapController");
				return;
			}
			else {
				DonHangBo dhbo = new DonHangBo();
				CTDonHangBo ctbo = new CTDonHangBo();
				//Tạo ra một đơn hàng
				dhbo.Them(tk.getMaNguoiDung());
				long maxdh = dhbo.getMaxDH();
				//Thêm vào bảng CTDH
				GioHangBo gh = (GioHangBo)session.getAttribute("giohang");
				for (GioHangBean h : gh.ds) {
					ctbo.Them(maxdh, h.getMaMon(), h.getSoLuongMua());
				}
				session.removeAttribute("giohang");
				session.setAttribute("slgiohang", 0);
				response.sendRedirect("LichSuMuaHangController");
			}
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
