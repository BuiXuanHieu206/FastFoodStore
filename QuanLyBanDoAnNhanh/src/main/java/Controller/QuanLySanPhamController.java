package Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

import Bean.MonBean;
import Bo.LoaiBo;
import Bo.MonBo;

/**
 * Servlet implementation class QuanLySanPhamController
 */
@WebServlet("/QuanLySanPhamController")
public class QuanLySanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLySanPhamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // Client gửi dữ liệu lên server bằng utf-8
		response.setCharacterEncoding("utf-8"); // Ngược lại
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "img";
		response.getWriter().println(dirUrl1);
		// Lấy loại và sách về
		LoaiBo lbo = new LoaiBo();
		MonBo mbo = new MonBo();
		if(request.getContentLength()<=0) {//Chay lan dau
			try {
				request.setAttribute("dsl", lbo.getLoai());
				request.setAttribute("dsm", mbo.getMon());
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd= request.getRequestDispatcher("QuanLySanPham.jsp");
			rd.forward(request, response);
			return;
		}
		try {
			String mamon = null, tenmon = null, gia = null, soluong = null, anh = null, maloai = null;
			String btnThem = null, btnSua = null, btnXoa = null, sua = null, xoa = null, anhcu = null, key = null, tatcasp = null;

			// Lấy loại về
			request.setAttribute("dsl", lbo.getLoai());
			request.setAttribute("dsm", mbo.getMon());
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "img";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							anh = "img/" + nameimg;
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Duong dan luu file la: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("txtMaMon"))
						mamon = fileItem.getString();
					if (tentk.equals("txtTenMon"))
						tenmon = fileItem.getString("utf-8");
					if (tentk.equals("txtGia"))
						gia = fileItem.getString();
					if (tentk.equals("txtSoLuong"))
						soluong = fileItem.getString();
					if (tentk.equals("selectMaLoai"))
						maloai = fileItem.getString();
					if (tentk.equals("txtAnh"))
						anhcu = fileItem.getString();
					if (tentk.equals("them"))
						btnThem = fileItem.getString();
					if (tentk.equals("sua"))
						btnSua = fileItem.getString();
					if (tentk.equals("xoa"))
						btnXoa = fileItem.getString();
					if (tentk.equals("btnSua"))
						sua = fileItem.getString();
					if (tentk.equals("btnXoa"))
						xoa = fileItem.getString();
					if (tentk.equals("txttk"))
						key = fileItem.getString("utf-8");
					if (tentk.equals("tcsp"))
						tatcasp = fileItem.getString();
				}
			}
			if(btnThem!=null) {
				long dem=0;
				for (MonBean dsm : mbo.getMon()) {
					if(dsm.getMaMon().equals(mamon)) {
						dem++;
						request.setAttribute("tb", "Mã món đã tồn tại!");
						break;
					}
				}
				if(dem==0) {
					int kq = mbo.Them(mamon, tenmon, Long.parseLong(gia), Long.parseLong(soluong), anh, maloai);
					request.setAttribute("dsm", mbo.getMon());
					if(kq == 1) {
						request.setAttribute("tb", "Thêm món thành công!");
						request.setAttribute("dsm", mbo.getMon());
					}
					else
						request.setAttribute("tb", "Thêm món thất bại!");
				}
			}
			if(btnSua!=null) {
				int kq = 0;
				if(anh!=null)
					kq = mbo.Sua(mamon, tenmon, Long.parseLong(gia), Long.parseLong(soluong), anh, maloai);
				else
					kq = mbo.Sua(mamon, tenmon, Long.parseLong(gia), Long.parseLong(soluong), anhcu, maloai);
				if(kq == 1) {
					request.setAttribute("tb", "Sửa món thành công!");
					request.setAttribute("dsm", mbo.getMon());
				}
				else
					request.setAttribute("tb", "Sửa món thất bại!");
			}
			if(btnXoa!=null) {
				int kq = mbo.Xoa(mamon);
				if(kq == 1) {
					request.setAttribute("tb", "Xóa món thành công!");
					request.setAttribute("dsm", mbo.getMon());
				}
				else
					request.setAttribute("tb", "Xóa món thất bại!");
			}
			if(sua!=null) {
				request.setAttribute("sp", mbo.getCTSanPham(sua));
			}
			if(key!=null) {
				request.setAttribute("dsm", mbo.TimKiemMon(key));
			}
			if(tatcasp!=null) {
				request.setAttribute("dsm", mbo.getMon());
			}
			RequestDispatcher rd = request.getRequestDispatcher("QuanLySanPham.jsp");
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
