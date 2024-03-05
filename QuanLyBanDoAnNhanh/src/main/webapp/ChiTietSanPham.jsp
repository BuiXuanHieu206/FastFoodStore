<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <title>XUNHIU Fast Food Store</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

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
                    <a href="TrangChuController" class="navbar-brand"><h1 class="text-primary display-6">XUNHIU</h1></a>
                    <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                        <span class="fa fa-bars text-primary"></span>
                    </button>
                    <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
                        <div class="navbar-nav mx-auto">
                            <a href="TrangChuController" class="nav-item nav-link">Trang chủ</a>
                            <a href="SanPhamController" class="nav-item nav-link">Sản phẩm</a>
                            <a href="CTSanPhamController" class="nav-item nav-link active">Chi tiết sản phẩm</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Danh mục</a>
                                <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                    <a href="GioHangController" class="dropdown-item">Giỏ hàng</a>
                                    <a href="LichSuMuaHangController" class="dropdown-item">Lịch sử mua hàng</a>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex m-3 me-0">
                            <a href="GioHangController" class="position-relative me-4 my-auto">
                                <i class="fa fa-shopping-bag fa-2x"></i>
                                <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" style="top: -5px; left: 15px; height: 20px; min-width: 20px;">
                                	<c:choose>
                                		<c:when test="${slgiohang!=null}">${slgiohang}</c:when>
                                		<c:otherwise>0</c:otherwise>
                                	</c:choose>
                                </span>
                            </a>
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
            <h1 class="text-center text-white display-6">Chi tiết sản phẩm</h1>
            <ol class="breadcrumb justify-content-center mb-0">
                <li class="breadcrumb-item"><a href="TrangChuController">Trang chủ</a></li>
                <li class="breadcrumb-item active text-white">Chi tiết sản phẩm</li>
            </ol>
        </div>
        <!-- Single Page Header End -->

		<!-- Single Product Start -->
        <div class="container-fluid py-5 mt-5">
            <div class="container py-5">
                <div class="row g-4 mb-5">
                    <div class="col-lg-8 col-xl-9">
                    	<c:choose>
                    		<c:when test="${sp.getMaMon().length()>0}">
		                        <div class="row g-4">
		                            <div class="col-lg-6">
		                                <div class="border rounded">
		                                    <a href="#">
		                                        <img src="${sp.getAnh()}" class="img-fluid rounded" alt="Image">
		                                    </a>
		                                </div>
		                            </div>
		                            <div class="col-lg-6">
		                                <h4 class="fw-bold mb-3">${sp.getTenMon()}</h4>
		                                <c:forEach items="${dsloai}" var="loai">
		                                	<c:if test="${loai.getMaLoai() eq sp.getMaLoai()}">
		                                		<p class="mb-3">Loại: ${loai.getTenLoai()}</p>
		                                	</c:if>
		                                </c:forEach>
		                                <h5 class="fw-bold mb-3">${sp.getGia()} ₫</h5>
		                                <a href="GioHangController?mm=${sp.getMaMon()}&tm=${sp.getTenMon()}&gia=${sp.getGia()}&anh=${sp.getAnh()}" class="btn border border-secondary rounded-pill px-4 py-2 mb-4 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Thêm vào giỏ</a>
		                            </div>
		                            <div class="col-lg-12">
		                                <nav>
		                                    <div class="nav nav-tabs mb-3">
		                                        <button class="nav-link active border-white border-bottom-0" type="button" role="tab"
		                                            id="nav-about-tab" data-bs-toggle="tab" data-bs-target="#nav-about"
		                                            aria-controls="nav-about" aria-selected="true">Mô tả</button>
		                                        <button class="nav-link border-white border-bottom-0" type="button" role="tab"
		                                            id="nav-mission-tab" data-bs-toggle="tab" data-bs-target="#nav-mission"
		                                            aria-controls="nav-mission" aria-selected="false">Đánh giá</button>
		                                    </div>
		                                </nav>
		                                <div class="tab-content mb-5">
		                                    <div class="tab-pane active" id="nav-about" role="tabpanel" aria-labelledby="nav-about-tab">
		                                        <div class="px-2">
		                                            <div class="row g-4">
		                                                <div class="col-6">
		                                                    <div class="row bg-light align-items-center justify-content-center py-2">
		                                                        <div class="col-6">
		                                                            <p class="mb-0">Tên món</p>
		                                                        </div>
		                                                        <div class="col-6">
		                                                            <p class="mb-0">${sp.getTenMon()}</p>
		                                                        </div>
		                                                    </div>
		                                                    <c:forEach items="${dsloai}" var="loai">
							                                	<c:if test="${loai.getMaLoai() eq sp.getMaLoai()}">
							                                		<div class="row align-items-center justify-content-center py-2">
				                                                        <div class="col-6">
				                                                            <p class="mb-0">Loại</p>
				                                                        </div>
				                                                        <div class="col-6">
				                                                            <p class="mb-0">${loai.getTenLoai()}</p>
				                                                        </div>
		                                                    		</div>
							                                	</c:if>
							                                </c:forEach>
		                                                    <div class="row bg-light align-items-center justify-content-center py-2">
		                                                        <div class="col-6">
		                                                            <p class="mb-0">Giá</p>
		                                                        </div>
		                                                        <div class="col-6">
		                                                            <p class="mb-0">${sp.getGia()} đồng</p>
		                                                        </div>
		                                                    </div>
		                                                    <div class="row align-items-center justify-content-center py-2">
		                                                        <div class="col-6">
		                                                            <p class="mb-0">Số lượng</p>
		                                                        </div>
		                                                        <div class="col-6">
		                                                            <p class="mb-0">${sp.getSoLuong()}</p>
		                                                        </div>
		                                                    </div>
		                                                    <div class="row bg-light align-items-center justify-content-center py-2">
		                                                        <div class="col-6">
		                                                            <p class="mb-0">Ngày nhập</p>
		                                                        </div>
		                                                        <div class="col-6">
		                                                            <p class="mb-0">${sp.getNgayNhap()}</p>
		                                                        </div>
		                                                    </div>
		                                                </div>
		                                            </div>
		                                        </div>
		                                    </div>
		                                    <div class="tab-pane" id="nav-mission" role="tabpanel" aria-labelledby="nav-mission-tab">
		                                        <c:choose>
			                                        <c:when test="${dsDG.size()>0}">
			                                        	<c:forEach items="${dsDG}" var="dg">
			                                        		<div class="d-flex">
					                                            <img src="img/avatar.jpg" class="img-fluid rounded-circle p-3" style="width: 100px; height: 100px;" alt="">
					                                            <div class="">
					                                                <p class="mb-2" style="font-size: 14px;">${dg.getNgayDG()}</p>
					                                                <div class="d-flex justify-content-between">
					                                                    <c:forEach items="${dstaikhoan}" var="dstk">
					                                                    	<c:if test="${dstk.getMaNguoiDung()==dg.getMaNguoiDung()}">
					                                                    		<h5>${dstk.getHoTen()}</h5>
					                                                    	</c:if>
					                                                    </c:forEach>
					                                                </div>
					                                                <p>${dg.getNoiDung()}</p>
					                                            </div>
					                                        </div>
			                                        	</c:forEach>
			                                        </c:when>
			                                        <c:otherwise>
			                                        	<p class="text-center"><i>Sản phẩm này hiện chưa có đánh giá.</i></p>	
			                                        </c:otherwise>
		                                        </c:choose>
		                                    </div>
		                                </div>
		                            </div>
		                            <c:if test="${tk!=null}">
		                            	<form action="#">
			                                <h4 class="mb-5 fw-bold">Đánh giá</h4>
			                                <div class="row g-4">
			                                    <div class="col-lg-12">
			                                        <div class="border-bottom rounded my-4">
			                                            <textarea name="" id="" class="form-control border-0" cols="30" rows="8" placeholder="Viết đánh giá..." spellcheck="false" required></textarea>
			                                        </div>
			                                    </div>
			                                    <div class="col-lg-12">
			                                        <div class="d-flex justify-content-between py-3 mb-5">
			                                            <a href="#" class="btn border border-secondary text-primary rounded-pill px-4 py-3"> Gửi đánh giá</a>
			                                        </div>
			                                    </div>
			                                </div>
			                            </form>
		                            </c:if>
		                        </div>
                    		</c:when>
                    		<c:otherwise>
                    			<p class="text-center"><i>Vui lòng chọn món ăn trong mục <a href="SanPhamController">Sản phẩm</a></i></p>
                    		</c:otherwise>
                    	</c:choose>
                    </div>
                    <div class="col-lg-4 col-xl-3">
                        <div class="row g-4 fruite">
                            <div class="col-lg-12">
                                <div class="input-group w-100 mx-auto d-flex mb-4">
                                    <form action="SanPhamController" method="post">
	                                	<div class="input-group w-100 mx-auto d-flex">
				                            <input name="txttk" type="search" class="form-control p-3" placeholder="Tên sản phẩm" aria-describedby="search-icon-1" required>
				                            <button id="search-icon-1" class="input-group-text p-3"><i class="fa fa-search"></i></button>
	                               		</div>
	                               	</form>
                                </div>
                                <div class="mb-4">
                                    <h4>Danh mục sản phẩm</h4>
                                    <ul class="list-unstyled fruite-categorie">
	                                    <c:forEach items="${tkloai}" var="tkloai">
		                                    <li>
				                                <div class="d-flex justify-content-between fruite-name">
				                                	<a href="SanPhamController?ml=${tkloai.getMaLoai()}"><i class="fas fa-apple-alt me-2"></i>${tkloai.getTenLoai()}</a>
				                                	<span>(${tkloai.getSoMon()})</span>
				                                </div>
			                                </li>
	                                    </c:forEach>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <h4 class="mb-4">Sản phẩm mới</h4>
                       			<c:forEach items="${spMoi}" var="spMoi">
	                                <div class="d-flex align-items-center justify-content-start">
	                                    <div class="rounded" style="width: 100px; height: 100px;">
	                                        <img src="${spMoi.getAnh()}" class="img-fluid rounded" alt="Image">
	                                    </div>
	                                    <div>
	                                        <h6 class="mb-2">${spMoi.getTenMon()}</h6>
	                                        <div class="d-flex mb-2">
	                                            <h5 class="fw-bold me-2">${spMoi.getGia()} ₫</h5>
	                                            <h5 class="text-danger text-decoration-line-through">${spMoi.getGia()+5000} ₫</h5>
	                                        </div>
	                                    </div>
	                                </div>
                                </c:forEach>
                                <div class="d-flex justify-content-center my-4">
                                	<a href="SanPhamController" class="btn border border-secondary px-4 py-3 rounded-pill text-primary w-100">Xem thêm</a>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="position-relative">
                                    <img src="img/Banner.jpg" class="img-fluid w-100 rounded" alt="">
                                    <div class="position-absolute" style="top: 50%; right: 10px; transform: translateY(-50%);">
                                        <h3 class="text-secondary fw-bold">Ngon <br> Bổ <br> Rẻ</h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Single Product End -->

        <!-- Footer Start -->
        <div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
            <div class="container py-5">
                <div class="pb-4 mb-4" style="border-bottom: 1px solid rgba(226, 175, 24, 0.5) ;">
                    <div class="row g-4">
                        <div class="col-lg-3">
                            <a href="TrangChuController">
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
                            <a class="btn-link" href="">Tài khoản của tôi</a>
                            <a class="btn-link" href="">Chi tiết sản phẩm</a>
                            <a class="btn-link" href="">Giỏ hàng</a>
                            <a class="btn-link" href="">Lịch sử đặt hàng</a>
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