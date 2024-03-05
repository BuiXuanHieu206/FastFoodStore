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
import Bo.DanhGiaBo;
import Bo.LoaiBo;
import Bo.MonBo;
import Bo.TaiKhoanBo;
import Bo.ThongKeBo;

/**
 * Servlet implementation class CTSanPhamController
 */
@WebServlet("/CTSanPhamController")
public class CTSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CTSanPhamController() {
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
			
			//Lấy món
			MonBo mbo = new MonBo();
			ArrayList<MonBean> ds = mbo.getMon();
			
			//Lấy loại
			LoaiBo lbo = new LoaiBo();
			request.setAttribute("dsloai", lbo.getLoai());
			
			//Lấy số lượng mỗi loại
			ThongKeBo tkbo = new ThongKeBo();
			request.setAttribute("tkloai", tkbo.tkLoai());
			
			//Lấy 5 sản phẩm được thêm mới gần nhất
			ArrayList<MonBean> spMoi = mbo.sanPhamMoi();
			request.setAttribute("spMoi", spMoi);
			
			//Lấy sản phẩm đưa vào chi tiết
			String cart = request.getParameter("cart"); //Lấy mã món
			request.setAttribute("sp", mbo.getCTSanPham(cart));
			request.setAttribute("dsmon", ds);
			
			//Lấy tài khoản là khách hàng
			TaiKhoanBo taikhoanbo = new TaiKhoanBo();
			request.setAttribute("dstaikhoan", taikhoanbo.getKH());
			
			//Lấy đánh giá sản phẩm
			DanhGiaBo dgbo = new DanhGiaBo();
			request.setAttribute("dsDG", dgbo.getDanhGia(cart));
			
			RequestDispatcher rd = request.getRequestDispatcher("ChiTietSanPham.jsp");
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
