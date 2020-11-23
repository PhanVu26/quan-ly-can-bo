<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Tag frame</title>
</head>
<FRAMESET rows= "25%,*">
	<frame name="header" src="header.jsp" noresize="noresize"></frame>
	<FRAMESET cols= "20%,*,15%">
		<frame name="menu" src="menu.jsp" noresize="noresize"></frame>
		<frame name="mainContent" src="mainContent.jsp" noresize="noresize"></frame>
		<frame name="gallery" src="gallery.jsp" noresize="noresize"></frame>
	</FRAMESET>
</FRAMESET>
<body onload="">
</body>
</html>