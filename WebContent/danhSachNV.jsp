<%@page import="com.phanvu.model.bean.PhongBan"%>
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
	<%
		List<NhanVien> listNV = (List<NhanVien>) request.getAttribute("listNV");
		List<PhongBan> listPB = (List<PhongBan>) request.getAttribute("listPB");
	%>
	<form name="searchForm" action="SearchNV" method="POST">
		<a href="addNV" target="mainContent"><input type="button"
			value="Thêm mới"></a> <input type="text" name="keySearch" placeholder="Nhập tên NV">
		<select name="phongBan">
			<option value="-1"> Tất cả
			<%
				for (PhongBan pb : listPB) {
			%>
			<option value="<%=pb.getMaPB()%>">
				<%=pb.getTenPB()%></option>
			<%
				}
			%>
		</select>
		<button type="submit">Search</button>
	</form>
	<br>

	<table border="1" width="100%">
		<caption><h2>Danh sách nhân viên </h2></caption>
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
			for (NhanVien nv : listNV) {
		%>
		<tr>
			<td><%=nv.getFullName()%></td>
			<td><%=nv.getAge()%></td>
			<td><%=nv.getGioiTinh() == true ? 1 : 0%></td>
			<td><%=nv.getNgaySinh()%></td>
			<td><%=nv.getAddress()%></td>
			<td><%=nv.getPhone()%></td>
			<td><%=nv.getEmail()%></td>
			<td><%=nv.getChucVu().getTenChucVu()%></td>
			<td><%=nv.getPhongBan().getTenPB()%></td>
			<td><a href="DeleteNhanVien?maNV=<%=nv.getMaNV()%>">Delete</a></td>
			<td><a href="UpdateNhanVien?maNV=<%=nv.getMaNV()%>">Update</a></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>