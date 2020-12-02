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
		List<PhongBan> listPB = (List<PhongBan>) request.getAttribute("listPB");
	%>
	<form name="searchForm" action="SearchPB" method="POST">
		<a href="addPB.jsp" target="mainContent"><input type="button"
			value="Thêm mới"></a> <input type="text" name="keySearch" placeholder="Nhập tên phòng ban">
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
	<table border="1" width="100%">
		<caption><h2>Danh sách phòng ban </h2></caption>
		<tr>
			<th>Mã phòng ban</th>
			<th>Tên phòng ban</th>
			<th colspan="2">Thao tác</th>

		</tr>
		<%
			for(PhongBan pb : listPB){
				%>
					<tr>
						<td><%=pb.getMaPB() %></td>
						<td><%=pb.getTenPB()%></td>
						<td><a href="DeletePB?maPB=<%=pb.getMaPB() %>">Delete</a></td>
						<td><a href="UpdatePB?maPB=<%=pb.getMaPB() %>">Update</a></td>
					</tr>
			<%} %>

	</table>
</body>
</html>