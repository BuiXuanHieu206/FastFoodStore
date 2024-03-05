package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.MonBean;
import Bo.CTDonHangBo;
import Bo.MonBo;

/**
 * Servlet implementation class AdminXNController
 */
@WebServlet("/AdminXNController")
public class AdminXNController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminXNController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CTDonHangBo ctbo = new CTDonHangBo();
			MonBo mbo = new MonBo();
			String MaCTDH = request.getParameter("MaCTDH");
			String SLM = request.getParameter("slm");
			String MM = request.getParameter("mm");
			if(MaCTDH!=null && SLM!=null && MM!=null) {
				Long slm = Long.parseLong(SLM);
				MonBean sp = mbo.getCTSanPham(MM);
				if(slm<=sp.getSoLuong()) {
					ctbo.CapNhat(Long.parseLong(MaCTDH));
					mbo.CapNhatSoLuong(MM, slm);
					response.sendRedirect("AdminXNController");
					return;
				}
				else {
					request.setAttribute("tb","Số lượng "+sp.getTenMon()+" còn ("+sp.getSoLuong()+"), vui lòng nhập thêm để hoàn tất đơn hàng!");
				}
			}
			request.setAttribute("ds",ctbo.getXacNhan());
			RequestDispatcher rd = request.getRequestDispatcher("AdminXN.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
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
