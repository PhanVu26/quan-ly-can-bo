<%@page import="com.phanvu.model.bean.PhongBan"%>
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
		PhongBan pb = (PhongBan) request.getAttribute("phongban");
		
	%>
	<form name="editForm" method="POST" action="UpdatePB">
		<table style="margin-left: auto;margin-right: auto;">
			<caption><h2>Cập nhật thông tin phòng ban</h2></caption>	
			<tr>
				<td>Mã phòng ban:</td>
				<td>
					<input type="text" name="maPB" value="<%=pb.getMaPB()%>" readonly>
				</td>
			</tr>		
			<tr>
				<td>Tên phòng ban:</td>
				<td>
					<input type="text" name="tenPB" value="<%=pb.getTenPB()%>">
				</td>
			</tr>

			<tr>
				<td><input type="submit" name="UpdatePB" value="Cập nhật">
					<input type="reset" name="reset" value="Reset"> <input
					type="button" name="cancel" value="Cancel" onclick="cancel()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>