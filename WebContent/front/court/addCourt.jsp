<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.court.model.*"%>

<%
	java.sql.Date date_SQL2 = new java.sql.Date(
			System.currentTimeMillis());
%>
<jsp:useBean id="CourtVO" scope="request" class="com.court.model.CourtVO">
	<jsp:setProperty name="CourtVO" property="cname" value="台北桌球協會" />
	<jsp:setProperty name="CourtVO" property="csite" value="http://www.pingpong-taipei.com.tw" />
	<jsp:setProperty name="CourtVO" property="cfee" value="免費" />
	<jsp:setProperty name="CourtVO" property="copen" value="全天開放" />
	<jsp:setProperty name="CourtVO" property="ccity" value="台北市" />
	<jsp:setProperty name="CourtVO" property="caddr" value="中正區大馬路100號" />
	<jsp:setProperty name="CourtVO" property="clat" value="22.5" />
	<jsp:setProperty name="CourtVO" property="clng" value="123.51" />
	<jsp:setProperty name="CourtVO" property="ctel" value="02-24138432" />
	<jsp:setProperty name="CourtVO" property="ccon" value="陳先生" />
	<jsp:setProperty name="CourtVO" property="cdesc" value="歡迎大朋友小朋友一起來打球" />
	<%
		CourtVO.setCnew(date_SQL2);
	%>
</jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>





	<h3>新增場地page:</h3>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>請修正以下錯誤:
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>

	<FORM METHOD="post" ACTION="court.do" name="form1">
		<table border="0">

			<tr>
				<td>場地名稱:</td>
				<td><input type="TEXT" name="cname" size="45"
					value="<%=CourtVO.getCname()%>" /></td>
			</tr>

			<tr>
				<td>場地網址:</td>
				<td><input type="TEXT" name="csite" size="45"
					value="<%=CourtVO.getCsite()%>" /></td>
			</tr>

			<tr>
				<td>場地費用:</td>
				<td><input type="TEXT" name="cfee" size="45"
					value="<%=CourtVO.getCfee()%>" /></td>
			</tr>
			<tr>
				<td>場地開放時間:</td>
				<td><input type="TEXT" name="copen" size="45"
					value="<%=CourtVO.getCopen()%>" /></td>
			</tr>
			<tr>
				<td>場地縣市:</td>
				<td><input type="TEXT" name="ccity" size="45"
					value="<%=CourtVO.getCcity()%>" /></td>
			</tr>
			<tr>
				<td>場地地址:</td>
				<td><input type="TEXT" name="caddr" size="45"
					value="<%=CourtVO.getCaddr()%>" /></td>
			</tr>
			<tr>
				<td>緯度:</td>
				<td><input type="TEXT" name="clat" size="45"
					value="<%=CourtVO.getClat()%>" /></td>
			</tr>
			<tr>
				<td>經度:</td>
				<td><input type="TEXT" name="clng" size="45"
					value="<%=CourtVO.getClng()%>" /></td>
			</tr>
			<tr>
				<td>場地電話:</td>
				<td><input type="TEXT" name="ctel" size="45"
					value="<%=CourtVO.getCtel()%>" /></td>
			</tr>
			<tr>
				<td>場地聯絡人:</td>
				<td><input type="TEXT" name="ccon" size="45"
					value="<%=CourtVO.getCcon()%>" /></td>
			</tr>
			<tr>
				<td>場地描述:</td>
				<td><input type="TEXT" name="cdesc" size="45"
					value="<%=CourtVO.getCdesc()%>" /></td>
			</tr>




		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>





</body>
</html>