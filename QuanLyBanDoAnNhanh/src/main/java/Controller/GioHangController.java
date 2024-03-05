package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.MonBean;
import Bo.GioHangBo;
import Bo.LoaiBo;
import Bo.MonBo;


/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
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
			
			//Lấy loại và sách về
			MonBo mbo = new MonBo();
			
			HttpSession session = request.getSession();
			String tltb = request.getParameter("tltb");
			String cn = request.getParameter("cn");
			String tl = request.getParameter("tl");
			String ttmh = request.getParameter("ttmh");
			
			String anh = request.getParameter("anh");
			String MM = request.getParameter("mm");
			String TM = request.getParameter("tm");
			String gia = request.getParameter("gia");
			
			if (MM!=null && TM!=null && gia!=null && anh!=null) {
				GioHangBo g = null;
				//Nếu mua hàng lần đầu
				if (session.getAttribute("giohang") == null) {//Mua lần dầu
					g = new GioHangBo();
					session.setAttribute("giohang", g);//Tao giỏ
					session.setAttribute("slgiohang", g.SoLuongGioHang());
				}
				//Gán session: gh vào biến: g
				g = (GioHangBo) session.getAttribute("giohang");
				//Thêm giỏ hàng vào biến: g
				//g.Them(sp.getAnh(), sp.getMaMon(), sp.getTenMon(), sp.getGia(), (long)1);
				g.Them(anh, MM, TM, Long.parseLong(gia), (long)1);
				//Lưu biến vào session
				session.setAttribute("giohang", g);
				session.setAttribute("slgiohang", g.SoLuongGioHang());
				response.sendRedirect("GioHangController");
				return;
			}
			if(tltb != null){
				GioHangBo g = (GioHangBo) session.getAttribute("giohang");
				g.TraLaiToanBo();
				session.setAttribute("giohang", g);
				session.setAttribute("slgiohang", g.SoLuongGioHang());
				if(g.ds.size()==0) {
					session.removeAttribute("giohang");
					response.sendRedirect("GioHangController");
					return;
				}
			}
			if(tl != null){
				GioHangBo g = (GioHangBo) session.getAttribute("giohang");
				g.Xoa(tl);
				session.setAttribute("giohang", g);
				session.setAttribute("slgiohang", g.SoLuongGioHang());
				if(g.ds.size()==0) {
					session.removeAttribute("giohang");
					response.sendRedirect("GioHangController");
					return;
				}
			}
			if(cn != null){
				MonBean sp = mbo.getCTSanPham(cn);
				GioHangBo g = (GioHangBo) session.getAttribute("giohang");
				String slm= request.getParameter(cn);
				if(slm != "" && Long.parseLong(slm)<=sp.getSoLuong()) {
					g.CapNhatSoLuong(cn, Long.parseLong(slm));
					session.setAttribute("giohang", g);
				}
				else if(slm=="")
					request.setAttribute("tb", "Số lượng mua không được để trống!");
				else 
					request.setAttribute("tb", "Số lượng trong kho không đủ, vui lòng nhập lại!");
			}
			if(ttmh != null) {
				RequestDispatcher rd = request.getRequestDispatcher("SanPhamController");
				rd.forward(request, response);
				return;
			}
			String[] ds = request.getParameterValues("c1");
			if(ds!=null){
				GioHangBo g = (GioHangBo) session.getAttribute("giohang");
				for(String pt:ds)
					g.Xoa(pt);
				session.setAttribute("giohang", g);
				session.setAttribute("slgiohang", g.SoLuongGioHang());
				if(g.ds.size()==0) {
					session.removeAttribute("giohang");
					response.sendRedirect("GioHangController");
					return;
				}
			}
			
			if(session.getAttribute("giohang")!=null) {
				GioHangBo g = (GioHangBo) session.getAttribute("giohang");
				request.setAttribute("dsgh", g.ds);
				request.setAttribute("tongtien", g.TongTien());
			}
			RequestDispatcher rd = request.getRequestDispatcher("GioHang.jsp");
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
