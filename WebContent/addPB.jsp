<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="addPBForm" method="POST" action="addPB">
		<table style="margin-left: auto;margin-right: auto;">
			<caption><h2>Thêm phòng ban</h2></caption>
			
			<tr>
				<td>Tên phòng ban:</td>
				<td>
					<input type="text" name="tenPB">
				</td>
			</tr>
			<tr>
				<td><input type="submit" name="addPB" value="Thêm mới">
					<input type="reset" name="reset" value="Reset"> <input
					type="button" name="cancel" value="Cancel" onclick="cancel()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>