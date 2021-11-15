<%@ page import="java.util.List" %>
<%@ page import="com.FB.Model.ResultModel" %>
<%@ page import="com.FB.Model.FBAccount" %>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs5/jq-3.3.1/dt-1.11.0/af-2.3.7/datatables.min.css"/>

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

	<br>
	
	<div class="container">
		<form method="get" action="<%=request.getContextPath()%>/download">
			<table class="table table-bordered" id="myTable">

				<%
					List<ResultModel> list = (List<ResultModel>) request.getAttribute("listPhone");
					List<FBAccount> list_Excel = (List<FBAccount>) session.getAttribute("listExcel");
					if (list!=null){
				%>
				<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">UID</th>
					<th scope="col">Phone</th>
				</tr>
				</thead>
				<tbody>
				<%

					int index = 0;
					for (ResultModel item:list){
						for (FBAccount account:item.getAccounts()){
							index++;
				%>
				<tr>
					<th scope="row"><%=index%></th>
					<td><%=account.getFacebook_id()%></td>
					<td><%=account.getPhone()%></td>
				</tr>
				<%
						}
					}
				%>
				</tbody>
				<%
				}else if (list_Excel!=null){
				%>
				<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">UID</th>
					<th scope="col">Gender</th>
					<th scope="col">Birthday</th>
					<th scope="col">Email</th>
					<th scope="col">SDT</th>
					<th scope="col">Localtion</th>
				</tr>
				</thead>
				<tbody>
				<%
					int index = 0;
					for (FBAccount item : list_Excel){
						index++;
				%>
				<tr>
					<th scope="row"><%=index%></th>
					<td><%=item.getName()%></td>
					<td><%=item.getFacebook_id()%></td>
					<td><%=item.getGender()%></td>
					<td><%=item.getBirthday()%></td>
					<td><%=item.getEmail()%></td>
					<td><%=item.getPhone()%></td>
					<td><%=item.getLocation()%></td>
				</tr>
				<%
					}
				%>
				</tbody>
				<%
					}
				%>
				</tbody>
			</table>
<%--			<input type="submit">--%>
		</form>

		<a href="<%=request.getContextPath()%>/download" class="link-primary">Xuất file Excel</a>
	</div>
	<script type="text/javascript" >
		$(document).ready( function () {
		    $('#myTable').DataTable();
		} );
	</script>

	<footer class="mt-5 bd-footer py-1 bg-light">
	    <p class="pt-3" style="text-align: center;">Tăng tỉ lệ chốt SALE từ 30-60%</p>
                <h5 style="text-align: center;">HOTLINE: index.htmlindex.html</h5>
                <p style="text-align: center; padding-bottom: 10px">Bạn muốn tăng hiệu quả quảng cáo Facebook Ads, Bạn muốn gọi điện thoại cho những người comment hoặc inbox,.. bạn đã đến đúng chỗ!</p>
	</footer>

<!-- Jquery -->


    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>

   <script src="./assets/js/custom.js" type="text/javascript" charset="utf-8" async defer></script>

	<script type="text/javascript" src="https://cdn.datatables.net/v/bs5/jq-3.3.1/dt-1.11.0/af-2.3.7/datatables.min.js"></script>
	
</body>
</html>