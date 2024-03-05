<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <title>XUNHIU Admin</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
		
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap" rel="stylesheet"> 

        <!-- Icon Font Stylesheet -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>

        <!-- Spinner Start -->
        <div id="spinner" class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" role="status"></div>
        </div>
        <!-- Spinner End -->


        <!-- Navbar start -->
        <div class="container-fluid fixed-top">
            <div class="container topbar bg-primary d-none d-lg-block">
                <div class="d-flex justify-content-between">
                    <div class="top-info ps-2">
                        <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <span class="text-white">149 Phan Bội Châu, Trường An, TP.Huế</span></small>
                        <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><span class="text-white">bbuihieu@gmail.com</span></small>
                    </div>
                    <c:choose>
						<c:when test="${tk!=null }">
							<div class="top-link pe-2">
		                        <a href="#" class="text-white"><small class="text-white mx-2">Xin chào: ${tk.getHoTen() }</small></a>
		                    </div>
						</c:when>
						<c:otherwise>
							<div class="top-link pe-2">
		                        <a href="DangNhapController" class="text-white"><small class="text-white mx-2">Đăng nhập</small>/</a>
		                        <a href="DangKyController" class="text-white"><small class="text-white mx-2">Đăng ký</small></a>
		                    </div>
						</c:otherwise>
					</c:choose>
                </div>
            </div>
            <div class="container px-0">
                <nav class="navbar navbar-light bg-white navbar-expand-xl">
                    <a href="TrangChu_AdminController" class="navbar-brand"><h1 class="text-primary display-6">XUNHIU</h1></a>
                    <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                        <span class="fa fa-bars text-primary"></span>
                    </button>
                    <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
                        <div class="navbar-nav mx-auto">
                            <a href="TrangChu_AdminController" class="nav-item nav-link">Trang chủ</a>
                            <a href="AdminXNController" class="nav-item nav-link">Xác nhận đơn hàng</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle active" data-bs-toggle="dropdown">Quản lý danh mục</a>
                                <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                	<a href="QuanLyTaiKhoanController" class="dropdown-item">Quản lý tài khoản</a>
                                    <a href="QuanLyLoaiController" class="dropdown-item">Quản lý loại</a>
                                    <a href="QuanLySanPhamController" class="dropdown-item">Quản lý sản phẩm</a>
                                </div>
                            </div>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Thống kê</a>
                                <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                	<a href="ThongKeDonHangController" class="dropdown-item">Đơn hàng</a>
                                    <a href="ThongKeDoanhThuController" class="dropdown-item">Doanh thu</a>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex m-3 me-0">
                            <c:choose>
								<c:when test="${tk!=null }">
									<div class="nav-item dropdown my-auto">
										<a href="#" class="dropdown-toggle" data-bs-toggle="dropdown">
				                        	<i class="fas fa-user fa-2x"></i>
				                        </a>
		                                <div class="dropdown-menu m-0 bg-secondary rounded-0">
		                                    <a href="#" class="dropdown-item">${tk.getHoTen()}</a>
		                                    <a href="DoiMatKhauController" class="dropdown-item">Đổi mật khẩu</a>
		                                    <a href="DangXuatController" class="dropdown-item">Đăng xuất</a>
		                                </div>
		                            </div>
								</c:when>
								<c:otherwise>
									<a href="DangNhapController" class="my-auto">
		                                <i class="fas fa-user fa-2x"></i>
		                            </a>
								</c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Navbar End -->
        
        <!-- Single Page Header start -->
        <div class="container-fluid page-header py-5">
            <h1 class="text-center text-white display-6">Quản lý sản phẩm</h1>
            <ol class="breadcrumb justify-content-center mb-0">
                <li class="breadcrumb-item"><a href="TrangChu_AdminController">Trang chủ</a></li>
                <li class="breadcrumb-item active text-white">Quản lý sản phẩm</li>
            </ol>
        </div>
        <!-- Single Page Header End -->
        
        <!-- Quản lý sản phẩm start -->
        <div class="container-fluid contact pt-5">
            <div class="container-sm pt-5">
                <div class="p-5 bg-light rounded">
                    <div class="row g-4">
                    	<form action="QuanLySanPhamController" method="post" enctype= "multipart/form-data">
	                        <div class="col-lg-12">
	                           	<div class="was-validated">
	                           		<h3 class="mb-4 text-primary text-center">THÔNG TIN SẢN PHẨM</h3>
	                           		<c:choose>
	                           			<c:when test="${sp!=null}">
	                           				<h5 class="mb-2">Mã món</h5>
	                           				<input type="text" class="w-100 form-control border-0 py-3 mb-4" value="${sp.getMaMon()}" placeholder="Mã món" name="txtMaMon" readonly>
	                           				<h5 class="mb-2">Tên món</h5>
	                           				<input type="text" class="w-100 form-control border-0 py-3 mb-4" value="${sp.getTenMon()}" placeholder="Tên món" name="txtTenMon" required>
			                                <h5 class="mb-2">Giá</h5>
			                                <input type="number" class="w-100 form-control border-0 py-3 mb-4" placeholder="Giá" 
			                                	min="1" oninput="this.value = this.value.replace(/[^0-9]/g, '');" value="${sp.getGia()}" name="txtGia" required>
			                                <h5 class="mb-2">Số lượng</h5>
			                                <input type="number" class="w-100 form-control border-0 py-3 mb-4" placeholder="Số lượng"
			                                	min="1" oninput="this.value = this.value.replace(/[^0-9]/g, '');" value="${sp.getSoLuong()}" name="txtSoLuong" required>
			                                <h5 class="mb-2">Ảnh</h5>
			                                <input type="file" class="w-100 form-control border-0 py-3 mb-4" placeholder="Ảnh" name="txtfile">
			                                <input type="text" class="w-100 form-control border-0 py-3 mb-4" placeholder="Ảnh" value="${sp.getAnh()}" name="txtAnh" hidden>
			                                <h5 class="mb-2">Mã loại</h5>
			                                <select class="w-100 form-control border-0 py-3 mb-4" name="selectMaLoai" required>
											    <option value="" disabled selected>Chọn mã loại</option>
											    <c:forEach items="${dsl}" var="l">
											    	<c:choose>
											    		<c:when test="${l.getMaLoai() eq sp.getMaLoai()}">
											    			<option value="${l.getMaLoai()}" selected>${l.getMaLoai()}</option>
											    		</c:when>
											    		<c:otherwise>
											    			<option value="${l.getMaLoai()}">${l.getMaLoai()}</option>
											    		</c:otherwise>
											    	</c:choose>
											    </c:forEach>
											</select>
	                           			</c:when>
	                           			<c:otherwise>
	                           				<h5 class="mb-2">Mã món</h5>
	                           				<input type="text" class="w-100 form-control border-0 py-3 mb-4" placeholder="Mã món" name="txtMaMon" required>
			                                <h5 class="mb-2">Tên món</h5>
			                                <input type="text" class="w-100 form-control border-0 py-3 mb-4" placeholder="Tên món" name="txtTenMon" required>
			                                <h5 class="mb-2">Giá</h5>
			                                <input type="number" class="w-100 form-control border-0 py-3 mb-4" placeholder="Giá" 
			                                	min="1" oninput="this.value = this.value.replace(/[^0-9]/g, '');" name="txtGia" required>
			                                <h5 class="mb-2">Số lượng</h5>
			                                <input type="number" class="w-100 form-control border-0 py-3 mb-4" placeholder="Số lượng"
			                                	min="1" oninput="this.value = this.value.replace(/[^0-9]/g, '');" name="txtSoLuong" required>
			                                <h5 class="mb-2">Ảnh</h5>
			                                <input type="file" class="w-100 form-control border-0 py-3 mb-4" placeholder="Ảnh" name="txtfile" required>
			                                <h5 class="mb-2">Mã loại</h5>
			                                <select class="w-100 form-control border-0 py-3 mb-4" name="selectMaLoai" required>
											    <option value="" disabled selected>Chọn mã loại</option>
											    <c:forEach items="${dsl}" var="l">
											    	<option value="${l.getMaLoai()}">${l.getMaLoai()}</option>
											    </c:forEach>
											</select>
	                           			</c:otherwise>
	                           		</c:choose>
	                           	</div>
	                            <c:if test="${tb!=null}">
				           			<div class="alert alert-warning">
										<strong>Thông báo:</strong> ${tb}
									</div>
				           		</c:if>
	                        </div>
	                        <div class="d-flex p-3">
	                        	<input class="w-100 btn form-control border-secondary py-3 me-5 bg-white" type="submit" name="them" value="Thêm">
		                        <input class="w-100 btn form-control border-secondary py-3 me-5 bg-white" type="submit" name="sua" value="Sửa">
		                        <input class="w-100 btn form-control border-secondary py-3 bg-white" data-bs-toggle="modal" data-bs-target="#myModal" value="Xóa">
	                        </div>
	                        <!-- The Modal -->
							<div class="modal" id="myModal">
								<div class="modal-dialog modal-dialog-centered">
									<div class="modal-content">
									
									<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title">Cảnh báo!</h4>
											<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
										</div>
									
									<!-- Modal body -->
										<div class="modal-body">
											Bạn có chắc chắn muốn xóa không?
										</div>
									
										<!-- Modal footer -->
										<div class="modal-footer">
											<form action="QuanLySanPhamController" method="post" enctype= "multipart/form-data">
												<input type="submit" class="btn btn-primary" value="Có" name="xoa">
											</form>
											<button class="btn btn-danger" data-bs-dismiss="modal">Không</button>
										</div>
									
									</div>
								</div>
							</div>
							<!-- The Modal end -->
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Quản lý sản phẩm end -->
        
		<!-- Cart Page Start -->
        <div class="container-fluid pb-5">
            <div class="container py-5">
            	<div class="row g-4">
                    <div class="col-lg-12">
                        <div class="row g-4 mb-4">
                            <div class="col-xl-3">
                                <form action="QuanLySanPhamController" method="post" enctype= "multipart/form-data">
                                	<div class="input-group w-100 mx-auto d-flex">
			                            <input name="txttk" type="search" class="form-control p-3" placeholder="Tên sản phẩm" aria-describedby="search-icon-1" required>
			                            <button id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></button>
                               		</div>
                               	</form>
                            </div>
                            <div class="col-6"></div>
                            <div class="col-xl-3">
                            	<form action="QuanLySanPhamController" method="post" enctype= "multipart/form-data">
                                	<input type="submit" name="tcsp" value="Tất cả sản phẩm" class="w-100 btn form-control border-secondary py-3 me-5 bg-white">
                            	</form>
                            </div>
                        </div>
                	</div>
                </div>
                <div class="table-responsive">
                    <table class="table">
                        <thead class="text-center">
                          <tr>
                            <th scope="col">Mã món</th>
                            <th scope="col">Tên món</th>
                            <th scope="col">Giá</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Ảnh</th>
                            <th scope="col">Ngày nhập</th>
                            <th scope="col">Mã loại</th>
                            <th scope="col">Chi tiết</th>
                          </tr>
                        </thead>
                        <tbody>
                       		<c:forEach items="${dsm}" var="m">
                      			<tr>
                      				<td class="text-center">
	                                    <p class="mb-0 mt-4">${m.getMaMon()}</p>
	                                </td>
	                                <td class="text-center">
	                                    <p class="mb-0 mt-4">${m.getTenMon()}</p>
	                                </td>
	                                <td class="text-center">
	                                    <p class="mb-0 mt-4">${m.getGia()}</p>
	                                </td>
	                                <td class="text-center">
	                                    <p class="mb-0 mt-4">${m.getSoLuong()}</p>
	                                </td>
	                                <th scope="row">
	                                    <div class="d-flex align-items-center">
	                                        <img src="${m.getAnh()}" class="img-fluid rounded-circle" style="width: 80px; height: 80px;" alt="">
	                                    </div>
	                                </th>
	                                <td class="text-center">
	                                    <p class="mb-0 mt-4">${m.getNgayNhap()}</p>
	                                </td>
	                                <td class="text-center">
	                                    <p class="mb-0 mt-4">${m.getMaLoai()}</p>
	                                </td>
	                                <form action="QuanLySanPhamController" method="post" enctype= "multipart/form-data">
		                                <td class="text-center">
		                                	<button class="btn btn-md rounded-circle bg-light border mt-4" value="${m.getMaMon()}" name="btnSua">
		                                        <i class="fa fa-check text-success"></i>
		                                    </button>
		                                </td>
	                                </form>
	                            </tr>
                       		</c:forEach>
                        </tbody>
                    </table>
              	</div>
            </div>
        </div>
        <!-- Cart Page End -->
        
        <!-- Footer Start -->
        <div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
            <div class="container py-5">
                <div class="pb-4 mb-4" style="border-bottom: 1px solid rgba(226, 175, 24, 0.5) ;">
                    <div class="row g-4">
                        <div class="col-lg-3">
                            <a href="TrangChu_AdminController">
                                <h1 class="text-primary mb-0">XUNHIU</h1>
                                <p class="text-secondary mb-0">Fast Food Store</p>
                            </a>
                        </div>
						<div class="col-lg-6">
			                <div class="position-relative mx-auto">
				                <h4 class="text-light" style="text-align: center">Chất lượng tạo nên thương hiệu</h4>
				                <h6 class="text-light" style="text-align: center">
				                	<i>Đem lại cho bạn những trải nghiệm tốt hơn mỗi ngày!</i>
				                </h6>
			                </div>
                       	</div>
                        <div class="col-lg-3">
                            <div class="d-flex justify-content-end pt-3">
                                <a class="btn  btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-outline-secondary me-2 btn-md-square rounded-circle" href=""><i class="fab fa-youtube"></i></a>
                                <a class="btn btn-outline-secondary btn-md-square rounded-circle" href=""><i class="fab fa-linkedin-in"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row g-5">
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-item">
                            <h4 class="text-light mb-3">Về tôi</h4>
                            <p class="mb-4">Sinh viên: Bùi Xuân Hiếu</p>
                            <p class="mb-4">Mã sinh viên: 20T1020375</p>
                            <p class="mb-4">Học phần: Java nâng cao - N5</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="d-flex flex-column text-start footer-item">
                            <h4 class="text-light mb-3">Thông tin cửa hàng</h4>
                            <a class="btn-link" href="">Lịch sử</a>
                            <a class="btn-link" href="">Liên hệ với chúng tôi</a>
                            <a class="btn-link" href="">FAQs & trợ giúp</a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="d-flex flex-column text-start footer-item">
                            <h4 class="text-light mb-3">Tài khoản</h4>
                            <a class="btn-link" href="#">Tài khoản của tôi</a>
                            <a class="btn-link" href="#">Đổi mật khẩu</a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-item">
                            <h4 class="text-light mb-3">Liên hệ</h4>
                            <p>Địa chỉ: 149 Phan Bội Châu, Trường An, TP.Huế</p>
                            <p>Email: bbuihieu@gmail.com</p>
                            <p>Phone: 0329753345</p>
                            <p>Thanh toán khả dụng</p>
                            <img src="img/payment.png" class="img-fluid" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->

        <!-- Back to Top -->
        <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i class="fa fa-arrow-up"></i></a>   

        
    <!-- JavaScript Libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/lightbox/js/lightbox.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    </body>

</html>