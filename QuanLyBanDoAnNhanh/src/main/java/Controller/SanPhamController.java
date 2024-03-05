package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.MonBean;
import Bo.LoaiBo;
import Bo.MonBo;
import Bo.ThongKeBo;

/**
 * Servlet implementation class SanPhamController
 */
@WebServlet("/SanPhamController")
public class SanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8"); //Client gửi dữ liệu lên server bằng utf-8
			response.setCharacterEncoding("utf-8"); //Ngược lại
			
			//Lấy loại và món về
			MonBo mbo = new MonBo();
			ArrayList<MonBean> ds = mbo.getMon();
			LoaiBo lbo = new LoaiBo();
			request.setAttribute("dsloai", lbo.getLoai());
			ThongKeBo tkbo = new ThongKeBo();
			request.setAttribute("tkloai", tkbo.tkLoai());
			String key = request.getParameter("txttk");
			String ml = request.getParameter("ml");
			ArrayList<MonBean> spMoi = mbo.sanPhamMoi();
			request.setAttribute("spMoi", spMoi);
			String gia = request.getParameter("rangeInput");
			request.setAttribute("boloc", gia);
			if(key!=null)
				ds = mbo.TimKiemMon(key);
			if(gia!=null)
				ds = mbo.TimKiemGia(Long.parseLong(gia));
			if(ml!=null)
				ds = mbo.TimKiemLoai(ml);
			if(ds.size()<1)
				request.setAttribute("tb", "Không có sản phẩm!");
			request.setAttribute("dsmon", ds);
			RequestDispatcher rd = request.getRequestDispatcher("SanPham.jsp");
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
