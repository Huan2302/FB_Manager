<%@ page import="java.util.ArrayList" %>
<%@ page import="com.FB.Model.FBAccount" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Chuyển đổi UID FB sang SĐT</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="assets/fontawesome/css/all.min.css">
	<link rel="stylesheet" type="text/css" href="assets/style.css">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">
	      <img src="img/Facebook-200x200.jpeg" alt="">&nbsp&nbsp&nbsp
	      Convert Facebook UID To Phone
	    </a>
	    <form class="d-flex">
	      <button class="btn btn-outline-primary" type="submit">Đăng Nhập</button>
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
			  <button class="btn btn-danger" type="button">Lấy UID</button>
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
				    <div class="col">

				    	<h5>Nhập UID convert</h5>
				    	<div class="form-floating">
						  <textarea class="form-control" name="uid" placeholder="Leave a comment here" id="uid" style="height: 400px"></textarea>
						  <label for="uid">Nhập UID</label>
						</div>
				    </div>
				    <div class="col">
				    	<h5>Nhập UID convert</h5>
				    	<div class="form-floating">
						  <textarea class="form-control" name="phone" placeholder="Leave a comment here" id="phone" style="height: 400px"><%=request.getAttribute("listPhone")%></textarea>
						  <label for="phone">Comments</label>
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
		
	</div>

	<footer class="py-5">
	    
	</footer>

	<!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>

	<%--ajax--%>
<%--	<script type="text/javascript">--%>
<%--		var data = ${uid};--%>
<%--		function getPhone(status){--%>
<%--			$.ajax({--%>
<%--				url: '<%=request.getContextPath()%>/xu-ly',--%>
<%--				type: 'POST',--%>
<%--				cache: false,--%>
<%--				contentType:'application/json',--%>
<%--				data:JSON.stringify(data),--%>
<%--				dataType: 'json',--%>
<%--				success: function (data){--%>
<%--					const data1 = JSON.parse(data);--%>
<%--					$("#phone").html(data);--%>
<%--				},--%>
<%--				error:function (){--%>
<%--					alert("lỗi");--%>
<%--				}--%>
<%--			});--%>
<%--			return false;--%>
<%--		}--%>
<%--	</script>--%>
</body>
</html>