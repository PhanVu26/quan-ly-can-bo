<%@page import="com.phanvu.model.bean.NhanVien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<form name="searchForm" action="SearchServlet" method="POST">
		<input type="button" value="Thêm mới"> <input type="text"
			name="keySearch">
		<button type="submit">Search</button>
	</form>
	<br>
	<%
		List<NhanVien> listNV = (List<NhanVien>) request.getAttribute("listNV");
	%>
	<table border="1" width="100%">
		<tr>
			<th>Tên nhân viên</th>
			<th>Tuổi</th>
			<th>Giới tính</th>
			<th>Ngày sinh</th>
			<th>Địa chỉ</th>
			<th>Điện thoại</th>
			<th>Email</th>
			<th>Chức Vụ</th>
			<th>Phòng ban</th>
			<th colspan="2">Thao tác</th>

		</tr>
		<%
			for(NhanVien nv : listNV){
				%>
					<tr>
						<td><%=nv.getFullName() %></td>
						<td><%=nv.getAge() %></td>
						<td><%=nv.getGioiTinh() %></td>
						<td><%=nv.getNgaySinh() %></td>
						<td><%=nv.getAddress() %></td>
						<td><%=nv.getPhone() %></td>
						<td><%=nv.getEmail() %></td>
						<td><%=nv.getChucVu().getTenChucVu() %></td>
						<td><%=nv.getPhongBan().getTenPB() %></td>
						<td><a href="DeleteNhanVien?maNV=<%=nv.getMaNV() %>">Delete</a></td>
						<td><a href="UpdateNhanVien?maNV=<%=nv.getMaNV() %>">Update</a></td>
					</tr>
			<%} %>

	</table>
</body>
</html>