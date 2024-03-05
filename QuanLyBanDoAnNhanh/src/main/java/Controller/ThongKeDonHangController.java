package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.DonHangBean;
import Bean.LoaiBean;
import Bo.LoaiBo;
import Bo.ThongKeBo;

/**
 * Servlet implementation class ThongKeDonHangController
 */
@WebServlet("/ThongKeDonHangController")
public class ThongKeDonHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongKeDonHangController() {
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
			
			String Ngay = request.getParameter("selectNgay");
			String Thang = request.getParameter("selectThang");
			String Nam = request.getParameter("selectNam");
			String option = request.getParameter("optradio");
			String btnThongKe = request.getParameter("tk");
			String ToanBo = request.getParameter("tcdh");
			
			ArrayList<Integer> ngay= new ArrayList<Integer>();
			ArrayList<Integer> thang= new ArrayList<Integer>();
			ArrayList<Integer> nam= new ArrayList<Integer>();
			LocalDate today = LocalDate.now();
			int d = today.getDayOfMonth();
			int m = today.getMonthValue();
			Year year = Year.now();
			int y = year.getValue(); 
			
			request.setAttribute("ng", d);
			request.setAttribute("t", m);
			request.setAttribute("n", y);
			
			for(int i=1;i<=31;i++) {
				if(i<=12)
					thang.add(i);
				ngay.add(i);
			}
			for(int j=y-10;j<=y;j++)
				nam.add(j);
			ThongKeBo tkbo = new ThongKeBo();
			ArrayList<DonHangBean> ds = tkbo.tkDonHang();
			for (DonHangBean dh : ds) {
				if(tkbo.DonHangDaMua(dh.getMaDH())==0)
					tkbo.CapNhatDaMua(dh.getMaDH());
			}
			request.setAttribute("dsdh", tkbo.tkDonHang());
			request.setAttribute("tongdonhang", tkbo.SoDonHang(tkbo.tkDonHang()));
			request.setAttribute("donhoantat", tkbo.DonHangHoanTat(tkbo.tkDonHang()));
			request.setAttribute("donchoxn", tkbo.DonHangChoXacNhan(tkbo.tkDonHang()));
			request.setAttribute("ngay", ngay);
			request.setAttribute("thang", thang);
			request.setAttribute("nam", nam);
			
			if(btnThongKe!=null) {
				if(option.equals("option1")) {
					ds = tkbo.tkDonHangNgay(Nam+"-"+Thang+"-"+Ngay);
					request.setAttribute("title", " NGÀY "+Ngay+"-"+Thang+"-"+Nam);
				}
				if(option.equals("option2")) {
					ds = tkbo.tkDonHangThang(Thang, Nam);
					request.setAttribute("title", " THÁNG "+Thang+"-"+Nam);
				}
				if(option.equals("option3")) {
					ds = tkbo.tkDonHangNam(Nam);
					request.setAttribute("title", " NĂM "+Nam);
				}
				request.setAttribute("dsdh", ds);
				request.setAttribute("tongdonhang", tkbo.SoDonHang(ds));
				request.setAttribute("donhoantat", tkbo.DonHangHoanTat(ds));
				request.setAttribute("donchoxn", tkbo.DonHangChoXacNhan(ds));
				RequestDispatcher rd = request.getRequestDispatcher("ThongKeDonHang.jsp");
				rd.forward(request, response);
				return;
			}
			if(ToanBo!=null) {
				ds = tkbo.tkDonHang();
				request.setAttribute("dsdh", ds);
				RequestDispatcher rd = request.getRequestDispatcher("ThongKeDonHang.jsp");
				rd.forward(request, response);
				return;
			}
			RequestDispatcher rd = request.getRequestDispatcher("ThongKeDonHang.jsp");
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
