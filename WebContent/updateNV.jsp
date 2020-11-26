<%@page import="com.phanvu.model.bean.NhanVien"%>
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
		NhanVien nv = (NhanVien) request.getAttribute("nhanVien");
		
	%>
	<form name="editForm" method="POST" action="UpdateNhanVien">
		<table style="margin-left: auto;margin-right: auto;">
			<caption><h2>Cập nhật thông tin nhân viên</h2></caption>	
			<tr>
				<td>Mã nhân viên:</td>
				<td>
					<input type="text" name="maNV" value="<%=nv.getMaNV()%>" readonly>
				</td>
			</tr>		
			<tr>
				<td>Họ và tên:</td>
				<td>
					<input type="text" name="fullName" value="<%=nv.getFullName()%>">
				</td>
			</tr>
			<tr>
				<td>Tuổi:</td>
				<td><input type="text" name="age" value="<%=nv.getAge()%>"></td>
			</tr>
			<tr>
				<td>Địa chỉ</td>
				<td><input type="text" name="address" value="<%=nv.getAddress()%>"></td>
			</tr>
			<tr>
				<td>Giới tính:</td>
				<td>
					<span for="name">Nam</span>
					<input type="radio" 
							name="gioiTinh" 
							value="1"
							<%
								String check;
								if(nv.getGioiTinh() == true){
									check = "checked";
								}else check = "";
							%>
							<%=check %>
							id = "name">
							
					<span for="nu">Nữ</span>
					<input id="nu"
							 type="radio" 
							 name="gioiTinh" 
							 value="0" 
							 <%
								String check1;
								if(nv.getGioiTinh() == false){
									check1 = "checked";
								}else check1 = "";
							%>
							 <%=check1 %>>
				</td>
			</tr>
			<tr>
				<td>Ngày sinh:</td>
				<td><input type="text" name="ngaySinh" value="<%=nv.getNgaySinh()%>"></td>
			</tr>
			<tr>
				<td>Số điện thoại</td>
				<td><input type="text" name="phone" value="<%=nv.getPhone()%>"></td>
			</tr>
			<tr>
				<td>Địa chỉ email:</td>
				<td>
					<input type="text" name="email" value="<%=nv.getEmail()%>">
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
				<td><input type="submit" name="UpdateNhanVien" value="Cập nhật">
					<input type="reset" name="reset" value="Reset"> <input
					type="button" name="cancel" value="Cancel" onclick="cancel()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>