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
import javax.swing.ButtonGroup;

import Bean.DoanhThuBean;
import Bo.DoanhThuBo;


/**
 * Servlet implementation class ThongKeDoanhThuController
 */
@WebServlet("/ThongKeDoanhThuController")
public class ThongKeDoanhThuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongKeDoanhThuController() {
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
			String ToanBo = request.getParameter("tcdt");
			
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
			DoanhThuBo dtbo = new DoanhThuBo();
			ArrayList<DoanhThuBean> ds = dtbo.tkDoanhThu();
			Long TongDoanhThu = dtbo.TongDoanhThu();
			request.setAttribute("dsdt", ds);
			request.setAttribute("tongdoanhthu", TongDoanhThu);
			request.setAttribute("ngay", ngay);
			request.setAttribute("thang", thang);
			request.setAttribute("nam", nam);
			
			if(btnThongKe!=null) {
				if(option.equals("option1")) {
					ds = dtbo.tkDoanhThuNgay(Ngay, Thang, Nam);
					TongDoanhThu = dtbo.TongDoanhThuNgay(Ngay, Thang, Nam);
					request.setAttribute("title", " NGÀY "+Ngay+"-"+Thang+"-"+Nam);
				}
				if(option.equals("option2")) {
					ds = dtbo.tkDoanhThuThang(Thang, Nam);
					TongDoanhThu = dtbo.TongDoanhThuThang(Thang, Nam);
					request.setAttribute("title", " THÁNG "+Thang+"-"+Nam);
				}
				if(option.equals("option3")) {
					ds = dtbo.tkDoanhThuNam(Nam);
					TongDoanhThu = dtbo.TongDoanhThuNam(Nam);
					request.setAttribute("title", " NĂM "+Nam);
				}
				request.setAttribute("dsdt", ds);
				request.setAttribute("tongdoanhthu", TongDoanhThu);
				RequestDispatcher rd = request.getRequestDispatcher("ThongKeDoanhThu.jsp");
				rd.forward(request, response);
				return;
			}
			if(ToanBo!=null) {
				ds = dtbo.tkDoanhThu();
				TongDoanhThu = dtbo.TongDoanhThu();
				request.setAttribute("dsdt", ds);
				request.setAttribute("tongdoanhthu", TongDoanhThu);
				RequestDispatcher rd = request.getRequestDispatcher("ThongKeDoanhThu.jsp");
				rd.forward(request, response);
				return;
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("ThongKeDoanhThu.jsp");
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
