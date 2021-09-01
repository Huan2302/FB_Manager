<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Chuyển đổi UID FB sang SĐT</title>
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="assets/fontawesome/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="assets/css/style.css">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">
	      <img src="<%=request.getContextPath()%>/img/itvinaentersite.png" alt="">&nbsp&nbsp&nbsp
	      Convert Facebook UID To Phone
	    </a>
	    <form action="sign.html" class="d-flex">
	      <button class="btn btn-outline-success" type="submit">Đăng Nhập</button>
	    </form>
	  </div>
	</nav>
	<div class="wrapper">	
		<div class="title">
			<h1>Chuyển đổi Facebook UID sang SĐT<br>
				Convert Facebook UID To Phone
			</h1>
		</div>

		<form action="index_submit" method="get" accept-charset="utf-8">
			<h3>Nhập Facebook URL của bạn</h3>
			<div class="input-group input-group-lg">
			  <input type="text" class="form-control" placeholder="https://www.facebook.com/username" aria-label="Recipient's username with two button addons">
			  <button class="btn btn-style" type="button">Lấy UID</button>
			  <button class="btn  btn-success" type="button">Lấy SĐT</button>
			</div>
			<div class="span12">
				<p>UID của bạn là: 123456789</p>
			</div>
		</form>

		<form action="<%=request.getContextPath()%>/xu-ly" method="post" accept-charset="utf-8">
			<div class="list_UID">
				<h3>Nhập danh sách UID</h3>
				<div class="container">
				  <div class="row row-cols-2">

				  	<!-- List UID -->
				    <div class="col">
				    	<h5>Nhập UID convert</h5>
				    	<div class="form-floating">
						  <textarea class="form-control" name="uid" placeholder="Leave a comment here" id="uid" style="height: 400px"></textarea>
						  <label for="uid">Nhập UID</label>
						</div>
				    </div>

				    <!-- Tải file UID -->
				    <div class="col">
				    	<h5>Tải file UID</h5>
				    	<div style="height: 400px;border-radius: 4px;border: 1px solid #CED4DA;" class="form-floating">
						  <div class="mb-3 m-4 text-start">
							  <label  for="formFile" class="form-label">Tải lên file tại đây:</label>
							  <input class="form-control" type="file" id="formFile">
							</div>
						</div>
				    </div>
				  </div>
				</div>
			</div>
			<br>
			<div class="d-grid gap-2">
				<input type="submit" class="btn btn-primary btn-lg" value="Convert">
<%--			  <button class="btn btn-primary btn-lg" onclick="getPhone()" type="button">--%>
<%--			  	<i class="fas fa-sync-alt"></i>&nbsp&nbsp Convert</button>--%>
			</div>
		</form>

		<div class="title">
			<h3 class="mt-5 pt-2">Bảng giá dịch vụ UID to Phone</h3>
			<p>Mua một lần dùng trọn đời</p>
		</div>
		<div class="row">
			<div class="col">
				<div class="card">
					<div class="card-header py-3">
						<h4 class="fw-bold my-0">Gói A</h4>
					</div>
					<div class="card-body card-style mt-3 mb-2">
						<h2 class="card-style-h2 card-title pricing-card-title border-bottom pb-3">Miễn phí</h2>
						<h4 class="card-style-h4 fs-5 fw-light pt-2 pb-3">10SĐT/ngày</h4>
						<button type="button" class="btn btn-primary">Dùng thử</button>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card">
					<div class="card-header py-3">
						<h4 class="fw-bold my-0">Gói B</h4>
					</div>
					<div class="card-body card-style mt-3 mb-2">
						<h2 class="card-style-h2 card-title pricing-card-title border-bottom pb-3">300,000đ</h2>
						<h4 class="card-style-h4 fs-5 fw-light pt-2 pb-3">50,000SĐT</h4>
						<button type="button" class="btn btn-primary">Mua ngay</button>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card">
					<div class="card-header py-3">
						<h4 class="fw-bold my-0">Gói C</h4>
					</div>
					<div class="card-body card-style mt-3 mb-2">
						<h2 class="card-style-h2 card-title pricing-card-title border-bottom pb-3">500,000đ</h2>
						<h4 class="card-style-h4 fs-5 fw-light pt-2 pb-3">100,000SĐT</h4>
						<button type="button" class="btn btn-primary">Mua ngay</button>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card">
					<div class="card-header py-3">
						<h4 class="fw-bold my-0">Gói D</h4>
					</div>
					<div class="card-body card-style mt-3 mb-2">
						<h2 class="card-style-h2 card-title pricing-card-title border-bottom pb-3">1,200,000đ</h2>
						<h4 class="card-style-h4 fs-5 fw-light pt-2 pb-3">500,000SĐT</h4>
						<button type="button" class="btn btn-primary">Mua ngay</button>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card">
					<div class="card-header py-3">
						<h4 class="fw-bold my-0">Gói E</h4>
					</div>
					<div class="card-body card-style mt-3 mb-2">
						<h2 class="card-style-h2 card-title pricing-card-title border-bottom pb-3">6,000,000đ</h2>
						<h4 class="card-style-h4 fs-5 fw-light pt-2 pb-3">Không giới hạn</h4>
						<button type="button" class="btn btn-primary">Mua ngay</button>
					</div>
				</div>
			</div>
			<div class="title">
				<p>Chỉ tính phí khi chuyển đổi thành công UID sàn SĐT ~ chỉ 5đ / SĐT thành công</p>
			</div>
		</div>

		

		<div class="row pt-4">
			<div class="col" style="padding-top: 30px;">

				<div class="info-table_style" >
					<h2 class="pt-2">Thông tin chuyển khoản</h2>
					<ul class="text-start pt-2">
						<li>
							<p class="d-inline">Bạn vui lòng chuyển khoản cho mình theo thông tin dưới đây:</p>
						</li>
						<li>
							<p class="d-inline">Số TK:</p>
						</li>
						<li>
							<p class="d-inline">Ngân hàng:</p>
						</li>
						<li>
							<p class="d-inline">Tên chủ tài khoản:</p>
						</li>
						<li>
							<p class="d-inline">Nội dung:</p>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-sm-6 col-xs-12">
			
					<h4 class="fs-5"">Video hướng dẫn quét UID bằng phần mềm SIMPLE UID</h4>	
					<iframe width="500" height="315" src="https://www.youtube.com/embed/UTv7l6czu5s" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				</div>
		</div>
	</div>

	<footer class="mt-5 bd-footer py-1 bg-light">
	    <p class="pt-3" style="text-align: center;">Tăng tỉ lệ chốt SALE từ 30-60%</p>
                <h5 style="text-align: center;">HOTLINE: index.htmlindex.html</h5>
                <p style="text-align: center; padding-bottom: 10px">Bạn muốn tăng hiệu quả quảng cáo Facebook Ads, Bạn muốn gọi điện thoại cho những người comment hoặc inbox,.. bạn đã đến đúng chỗ!</p>
	</footer>

	<!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>

   <script src="./assets/js/custom.js" type="text/javascript" charset="utf-8" async defer></script>


	
</body>
</html>