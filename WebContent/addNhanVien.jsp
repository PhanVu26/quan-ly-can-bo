<%@page import="com.phanvu.model.bean.ChucVu"%>
<%@page import="com.phanvu.model.bean.PhongBan"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		List<PhongBan> listPb = (List<PhongBan>) request.getAttribute("listPB");
		List<ChucVu> listChucVu = (List<ChucVu>) request.getAttribute("listCV");
	%>
	<form name="addNVForm" method="POST" action="addNV">
		<table style="margin-left: auto;margin-right: auto;">
			<caption><h2>Thêm nhân viên</h2></caption>
			
			<tr>
				<td>Họ và tên:</td>
				<td>
					<input type="text" name="fullName">
				</td>
			</tr>
			<tr>
				<td>Tuổi:</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>Địa chỉ</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>Giới tính:</td>
				<td>
					<span>Nam</span><input type="radio" name="gioiTinh" value=1>
					<span>Nữ</span><input type="radio" name="gioiTinh" value=0>
				</td>
			</tr>
			<tr>
				<td>Ngày sinh:</td>
				<td><input type="text" name="ngaySinh"></td>
			</tr>
			<tr>
				<td>Số điện thoại</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>Địa chỉ email:</td>
				<td>
					<input type="text" name="email">
				</td>
			</tr>
			<tr>
				<td>Chức vụ:</td>
				<td>
					<select name="chucVu">
						<%
							for(ChucVu cv : listChucVu){
						%>
								<option value="<%=cv.getMaChucVu()%>"> <%=cv.getTenChucVu() %></option>
							<%} %>
					</select>
				</td>
			</tr>
			<tr>
				<td>Phòng ban</td>
				<td>
					<select name="phongBan">
						<%
							for(PhongBan pb : listPb){
						%>
								<option value="<%=pb.getMaPB() %>"> <%= pb.getTenPB() %></option>
							<%} %>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="addNV" value="Thêm mới">
					<input type="reset" name="reset" value="Reset"> <input
					type="button" name="cancel" value="Cancel" onclick="cancel()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>