package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import Bean.LoaiBean;
import Bean.MonBean;
import Bo.LoaiBo;

/**
 * Servlet implementation class QuanLyLoaiController
 */
@WebServlet("/QuanLyLoaiController")
public class QuanLyLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyLoaiController() {
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
			
			LoaiBo lbo = new LoaiBo();
			request.setAttribute("dsloai", lbo.getLoai());
			
			String maloai = request.getParameter("txtMaLoai");
			String tenloai = request.getParameter("txtTenLoai");
			String btnThem = request.getParameter("them");
			String btnSua = request.getParameter("sua");
			String btnXoa = request.getParameter("xoa");
			String sua = request.getParameter("btnSua");
			String key = request.getParameter("txttk");
			String tatcaloai = request.getParameter("tcl");
			
			if(btnThem!=null) {
				long dem=0;
				for (LoaiBean dsl : lbo.getLoai()) {
					if(dsl.getMaLoai().equals(maloai)) {
						dem++;
						request.setAttribute("tb", "Mã loại đã tồn tại!");
						break;
					}
				}
				if(dem==0) {
					int kq = lbo.Them(maloai,tenloai);
					if(kq == 1) {
						request.setAttribute("tb", "Thêm loại thành công!");
						request.setAttribute("dsloai", lbo.getLoai());
						RequestDispatcher rd = request.getRequestDispatcher("QuanLyLoai.jsp");
						rd.forward(request, response);
						return;
					}
					else
						request.setAttribute("tb", "Thêm loại thất bại!");
				}
			}
			if(btnSua!=null) {
				int kq = lbo.Sua(maloai,tenloai);
				if(kq == 1) {
					request.setAttribute("tb", "Sửa loại thành công!");
					request.setAttribute("dsloai", lbo.getLoai());
					RequestDispatcher rd = request.getRequestDispatcher("QuanLyLoai.jsp");
					rd.forward(request, response);
					return;
				}
				else
					request.setAttribute("tb", "Sửa loại thất bại!");
			}
			if(btnXoa!=null) {
				int kq = lbo.Xoa(maloai);
				if(kq == 1) {
					request.setAttribute("tb", "Xóa loại thành công!");
					request.setAttribute("dsloai", lbo.getLoai());
					RequestDispatcher rd = request.getRequestDispatcher("QuanLyLoai.jsp");
					rd.forward(request, response);
					return;
				}
				else
					request.setAttribute("tb", "Xóa loại thất bại!");
			}
			if(sua!=null) {
				request.setAttribute("loai", lbo.getCTLoai(sua));
			}
			if(key!=null) {
				request.setAttribute("dsloai", lbo.TimKiemLoai(key));
			}
			if(tatcaloai!=null) {
				request.setAttribute("dsloai", lbo.getLoai());
			}
			RequestDispatcher rd = request.getRequestDispatcher("QuanLyLoai.jsp");
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
