<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.court.model.*"%>

<jsp:useBean id="list" scope="session" type="java.util.List" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<th>場地編號</th>
		<th>名稱</th>
		<th>網址</th>
		<th>費用</th>
		<th>開放時間</th>
		<th>縣市</th>
		<th>地址</th>
		<th>緯度</th>
		<th>經度</th>
		<th>電話</th>
		<th>聯絡人</th>
		<th>圖片</th>
		<th>描述</th>
		<th>瀏覽次數</th>
		<th>狀態</th>
		<th>最後修改時間</th>

	</tr>
<%@ include file="page1.file" %> 
<c:forEach var="courtVO" items="${list}" begin="<%=(whichPage-1)*rowsPerPage%>" end="<%=whichPage*rowsPerPage-1%>">
		<tr>

			<td>${courtVO.COURT_NO}</td>
			<td>${courtVO.COURT_NAME}</td>
			<td>${courtVO.COURT_SITE}</td>
			<td>${courtVO.COURT_FEE}</td>
			<td>${courtVO.COURT_OPEN}</td>
			<td>${courtVO.COURT_CITY}</td>
			<td>${courtVO.COURT_ADDR}</td>
			<td>${courtVO.COURT_LAT}</td>
			<td>${courtVO.COURT_LONG}</td>
			<td>${courtVO.COURT_TEL}</td>
			<td>${courtVO.COURT_CONT}</td>
			<td>${courtVO.COURT_PIC}</td>
			<td>${courtVO.COURT_DESC}</td>
			<td>${courtVO.COURT_VIEW}</td>
			<td>${courtVO.COURT_STATUS}</td>
			<td>${courtVO.COURT_DATE}</td>
		</tr>
	</c:forEach>


	
</table>
<%@ include file="page2.file" %>
</body>
</html>