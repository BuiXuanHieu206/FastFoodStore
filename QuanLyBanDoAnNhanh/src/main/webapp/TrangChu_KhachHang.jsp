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
                            <a href="TrangChuController" class="nav-item nav-link active">Trang chủ</a>
                            <a href="SanPhamController" class="nav-item nav-link">Sản phẩm</a>
                            <a href="CTSanPhamController" class="nav-item nav-link">Chi tiết sản phẩm</a>
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

        <!-- Hero Start -->
        <div class="container-fluid py-5 mb-5 hero-header">
            <div class="container py-5">
                <div class="row g-5 align-items-center">
                    <div class="col-md-12 col-lg-7">
                        <h4 class="mb-3 text-secondary">Đa dạng các loại sản phẩm</h4>
                        <h1 class="mb-5 display-3 text-primary">Đồ ăn &<br>Nước giải khát</br></h1>
                        <div class="position-relative mx-auto">
	                        <form action="SanPhamController" method="post">
	                            <input class="form-control border-2 border-secondary w-75 py-3 px-4 rounded-pill" type="text" placeholder="Tìm kiếm" name="txttk" required>
	                            <button type="submit" class="btn btn-primary border-2 border-secondary py-3 px-4 position-absolute rounded-pill text-white h-100" style="top: 0; right: 25%;">Tìm kiếm ngay</button>
	                        </form>
                        </div>
                    </div>
                    <div class="col-md-12 col-lg-5">
                        <div id="carouselId" class="carousel slide position-relative" data-bs-ride="carousel">
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active rounded">
                                    <img src="img/DoAn.jpg" class="img-fluid w-100 h-100 bg-secondary rounded" alt="First slide">
                                    <a href="SanPhamController?ml=L004" class="btn px-4 py-2 text-white rounded">Đồ ăn</a>
                                </div>
                                <div class="carousel-item rounded">
                                    <img src="img/ThucUong.jpg" class="img-fluid w-100 h-100 rounded" alt="Second slide">
                                    <a href="SanPhamController?ml=L003" class="btn px-4 py-2 text-white rounded">Nước giải khát</a>
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselId" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselId" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero End -->


        <!-- Featurs Section Start -->
        <div class="container-fluid featurs py-5">
            <div class="container py-5">
                <div class="row g-4">
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fas fa-car-side fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>Miễn phí giao hàng</h5>
                                <p class="mb-0">Đơn từ 200.000 đồng</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fas fa-user-shield fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>Thanh toán bảo mật</h5>
                                <p class="mb-0">100% thanh toán bảo mật</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fas fa-exchange-alt fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>Hoàn trả</h5>
                                <p class="mb-0">Hoàn tiền nếu sản phẩm lỗi</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle bg-secondary mb-5 mx-auto">
                                <i class="fa fa-phone-alt fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>Hỗ trợ 24/7</h5>
                                <p class="mb-0">Hỗ trợ nhanh chóng mọi lúc</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Featurs Section End -->


        <!-- Fruits Shop Start-->
        <div class="container-fluid fruite py-5">
            <div class="container py-5">
                <div class="tab-class text-center">
                    <div class="row g-4">
                        <div class="col-lg-4 text-start">
                            <h1>Sản phẩm</h1>
                        </div>
                        <div class="col-lg-8 text-end">
                            <ul class="nav nav-pills d-inline-flex text-center mb-5">
                                <li class="nav-item">
                                    <a class="d-flex m-2 py-2 bg-light rounded-pill active" data-bs-toggle="pill" href="#tab-1">
                                        <span class="text-dark" style="width: 130px;">Tất cả sản phẩm</span>
                                    </a>
                                </li>
                                <c:forEach items="${dsloai}" var="loai">
									<li class="nav-item">
	                                    <a class="d-flex py-2 m-2 bg-light rounded-pill" data-bs-toggle="pill" href="#tab-${loai.getMaLoai()}">
	                                        <span class="text-dark" style="width: 130px;">${loai.getTenLoai()}</span>
	                                    </a>
	                                </li>
								</c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="tab-content">
                        <div id="tab-1" class="tab-pane fade show p-0 active">
                            <div class="row g-4">
                                <div class="col-lg-12">
                                    <div class="row g-4">
                                    	<c:choose>
                                    		<c:when test="${dsmon.size()<1}">
                                				<p class="text-center"><i>${tb}</i></p>
                                			</c:when>
                                			<c:otherwise>
                                				<c:forEach items="${dsmon}" var="mon">
													<div class="col-md-6 col-lg-4 col-xl-3">
			                                            <div class="rounded position-relative fruite-item">
			                                                <div class="fruite-img">
			                                                    <img src="${mon.getAnh()}" class="img-fluid w-75 rounded-top object-fit-contain" alt="">
			                                                </div>
			                                                <c:forEach items="${dsloai}" var="loai">
			                                                	<c:if test="${mon.getMaLoai() eq loai.getMaLoai()}">
			                                                		<div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">${loai.getTenLoai()}</div>
			                                                	</c:if>
			                                                </c:forEach>
			                                                <div class="p-4 border border-secondary border-top-0 rounded-bottom">
			                                                    <h4>${mon.getTenMon()}</h4>
			                                                    <div class="d-flex justify-content-between flex-lg-wrap">
			                                                        <p class="text-dark fs-5 fw-bold mb-0">${mon.getGia()} ₫</p>
			                                                        <a href="CTSanPhamController?cart=${mon.getMaMon()}" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Thêm vào giỏ</a>
			                                                    </div>
			                                                </div>
			                                            </div>
			                                        </div>
												</c:forEach>
                                			</c:otherwise>
                                    	</c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:forEach items="${dsloai}" var="loai">
                        	<div id="tab-${loai.getMaLoai()}" class="tab-pane fade show p-0">
	                            <div class="row g-4">
	                                <div class="col-lg-12">
	                                    <div class="row g-4">
	                                    	<c:forEach items="${dsmon}" var="mon">
	                                    		<c:if test="${mon.getMaLoai() eq loai.getMaLoai()}">
	                                    			<div class="col-md-6 col-lg-4 col-xl-3">
			                                            <div class="rounded position-relative fruite-item">
			                                                <div class="fruite-img">
			                                                    <img src="${mon.getAnh()}" class="img-fluid w-75 rounded-top object-fit-contain" alt="">
			                                                </div>
			                                                <div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">${loai.getTenLoai()}</div>
			                                                <div class="p-4 border border-secondary border-top-0 rounded-bottom">
			                                                    <h4>${mon.getTenMon()}</h4>
			                                                    <div class="d-flex justify-content-between flex-lg-wrap">
			                                                        <p class="text-dark fs-5 fw-bold mb-0">${mon.getGia()} ₫</p>
			                                                        <a href="CTSanPhamController?cart=${mon.getMaMon()}" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Thêm vào giỏ</a>
			                                                    </div>
			                                                </div>
			                                            </div>
			                                        </div>
	                                    		</c:if>
	                                    	</c:forEach>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
                        </c:forEach>
                    </div>
                </div>      
            </div>
        </div>
        <!-- Fruits Shop End-->


        <!-- Featurs Start -->
        <div class="container-fluid service py-5">
            <div class="container py-5">
                <div class="row g-4 justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <a href="SanPhamController?ml=L004">
                            <div class="service-item bg-secondary rounded border border-secondary">
                                <img src="img/MonChien.jpg" class="img-fluid rounded-top w-100" alt="">
                                <div class="px-4 rounded-bottom">
                                    <div class="service-content bg-primary text-center p-4 rounded">
                                        <h5 class="text-white">Ăn vặt</h5>
                                        <h3 class="mb-0">20% OFF</h3>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <a href="SanPhamController?ml=L001">
                            <div class="service-item bg-dark rounded border border-dark">
                                <img src="img/DoNgot.jpg" class="img-fluid rounded-top w-100" alt="">
                                <div class="px-4 rounded-bottom">
                                    <div class="service-content bg-light text-center p-4 rounded">
                                        <h5 class="text-primary">Bánh ngọt</h5>
                                        <h3 class="mb-0">Free ship</h3>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-6 col-lg-4">
                        <a href="SanPhamController?ml=L003">
                            <div class="service-item bg-primary rounded border border-primary">
                                <img src="img/NuocNgot.jpg" class="img-fluid rounded-top w-100" alt="">
                                <div class="px-4 rounded-bottom">
                                    <div class="service-content bg-secondary text-center p-4 rounded">
                                        <h5 class="text-white">Nước giải khát</h5>
                                        <h3 class="mb-0">Rẻ bất ngờ</h3>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Featurs End -->


        <!-- Sản phẩm mới - Hiển thị 5 sản phẩm được thêm mới gần nhất-->
        <div class="container-fluid vesitable py-5">
            <div class="container py-5">
                <h1 class="mb-0">Sản phẩm mới</h1>
                <div class="owl-carousel vegetable-carousel justify-content-center">
                	<c:forEach items="${spMoi}" var="spMoi">
                		<div class="border border-primary rounded position-relative vesitable-item">
	                        <div class="vesitable-img">
	                            <img src="${spMoi.getAnh()}" class="img-fluid w-100 rounded-top" alt="">
	                        </div>
	                        <c:forEach items="${dsloai}" var="loai">
				                <c:if test="${spMoi.getMaLoai() eq loai.getMaLoai()}">
				                	<div class="text-white bg-primary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">${loai.getTenLoai()}</div>
				                </c:if>
			                </c:forEach>
	                        <div class="p-4 rounded-bottom">
	                            <h4>${spMoi.getTenMon()}</h4>
	                            <div class="d-flex justify-content-between flex-lg-wrap">
	                                <p class="text-dark fs-5 fw-bold mb-0">${spMoi.getGia()}  ₫</p>
	                                <a href="CTSanPhamController?cart=${mon.getMaMon()}" class="btn border border-secondary rounded-pill px-3 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Thêm vào giỏ</a>
	                            </div>
	                        </div>
	                    </div>
                	</c:forEach>
                </div>
            </div>
        </div>
        <!-- Sản phẩm mới -->


        <!-- Banner Section Start-->
        <div class="container-fluid banner bg-secondary my-5">
            <div class="container py-5">
                <div class="row g-4 align-items-center">
                    <div class="col-lg-6">
                        <div class="py-4">
                            <h1 class="display-3 text-white">Món ăn bán chạy số 1</h1>
                            <p class="fw-normal display-3 text-dark mb-4">Trong cửa hàng của chúng tôi</p>
                            <p class="mb-4 text-dark">Già trẻ lớn bé, ăn vào là mê.</p>
                            <a href="CTSanPhamController?cart=F002" class="banner-btn btn border-2 border-white rounded-pill text-dark py-3 px-5">Mua ngay</a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="position-relative">
                            <img src="img/Hamburger.jpg" class="img-fluid w-100 rounded" alt="">
                            <div class="d-flex align-items-center justify-content-center bg-white rounded-circle position-absolute" style="width: 140px; height: 140px; top: 0; left: 0;">
                                <div class="d-flex flex-column">
                                    <span class="h2 mb-0">32.000 ₫</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Banner Section End -->

        <!-- Fact Start -->
        <div class="container-fluid py-5">
            <div class="container">
                <div class="bg-light p-5 rounded">
                    <div class="row g-4 justify-content-center">
                        <div class="col-md-6 col-lg-6 col-xl-3">
                            <div class="counter bg-white rounded p-5">
                                <i class="fa fa-users text-secondary"></i>
                                <h4>Khách hàng hài lòng</h4>
                                <h1>1963</h1>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-6 col-xl-3">
                            <div class="counter bg-white rounded p-5">
                                <i class="fa fa-users text-secondary"></i>
                                <h4>Chất lượng phục vụ</h4>
                                <h1>99%</h1>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-6 col-xl-3">
                            <div class="counter bg-white rounded p-5">
                                <i class="fa fa-users text-secondary"></i>
                                <h4>Chứng nhận chất lượng</h4>
                                <h1>20</h1>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-6 col-xl-3">
                            <div class="counter bg-white rounded p-5">
                                <i class="fa fa-users text-secondary"></i>
                                <h4>Nhiều sản phẩm đa dạng</h4>
                                <h1>789</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fact Start -->

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
                    <c:choose>
                    	<c:when test="${tk!=null }">
                    		<div class="col-lg-3 col-md-6">
		                        <div class="d-flex flex-column text-start footer-item">
		                            <h4 class="text-light mb-3">Tài khoản</h4>
		                            <a class="btn-link" href="">Tài khoản của tôi</a>
		                            <a class="btn-link" href="GioHangController">Giỏ hàng</a>
		                            <a class="btn-link" href="LichSuMuaHangController">Lịch sử mua hàng</a>
		                        </div>
		                    </div>
                    	</c:when>
                    	<c:otherwise>
                    		<div class="col-lg-3 col-md-6">
	                        <div class="d-flex flex-column text-start footer-item">
	                            <h4 class="text-light mb-3">Tài khoản</h4>
	                            <a class="btn-link" href="DangNhapController">Tài khoản của tôi</a>
	                            <a class="btn-link" href="GioHangController">Giỏ hàng</a>
	                            <a class="btn-link" href="LichSuMuaHangController">Lịch sử mua hàng</a>
	                        </div>
	                    </div>
                    	</c:otherwise>
                    </c:choose>
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