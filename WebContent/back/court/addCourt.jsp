<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.court.model.*"%>

<%
	java.sql.Date date_SQL2 = new java.sql.Date(
			System.currentTimeMillis());
%>
<jsp:useBean id="CourtVO" scope="request" class="com.court.model.CourtVO">
	<jsp:setProperty name="CourtVO" property="cname" value="�x�_��y��|" />
	<jsp:setProperty name="CourtVO" property="csite" value="http://www.pingpong-taipei.com.tw" />
	<jsp:setProperty name="CourtVO" property="cfee" value="�K�O" />
	<jsp:setProperty name="CourtVO" property="copen" value="���Ѷ}��" />
	<jsp:setProperty name="CourtVO" property="ccity" value="�x�_��" />
	<jsp:setProperty name="CourtVO" property="caddr" value="�����Ϥj����100��" />
	<jsp:setProperty name="CourtVO" property="clat" value="22.5" />
	<jsp:setProperty name="CourtVO" property="clng" value="123.51" />
	<jsp:setProperty name="CourtVO" property="ctel" value="02-24138432" />
	<jsp:setProperty name="CourtVO" property="ccon" value="������" />
	<jsp:setProperty name="CourtVO" property="cdesc" value="�w��j�B�ͤp�B�ͤ@�_�ӥ��y" />
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





	<h3>�s�W���apage:</h3>
	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>�Эץ��H�U���~:
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
				<td>���a�W��:</td>
				<td><input type="TEXT" name="cname" size="45"
					value="<%=CourtVO.getCname()%>" /></td>
			</tr>

			<tr>
				<td>���a���}:</td>
				<td><input type="TEXT" name="csite" size="45"
					value="<%=CourtVO.getCsite()%>" /></td>
			</tr>

			<tr>
				<td>���a�O��:</td>
				<td><input type="TEXT" name="cfee" size="45"
					value="<%=CourtVO.getCfee()%>" /></td>
			</tr>
			<tr>
				<td>���a�}��ɶ�:</td>
				<td><input type="TEXT" name="copen" size="45"
					value="<%=CourtVO.getCopen()%>" /></td>
			</tr>
			<tr>
				<td>���a����:</td>
				<td><input type="TEXT" name="ccity" size="45"
					value="<%=CourtVO.getCcity()%>" /></td>
			</tr>
			<tr>
				<td>���a�a�}:</td>
				<td><input type="TEXT" name="caddr" size="45"
					value="<%=CourtVO.getCaddr()%>" /></td>
			</tr>
			<tr>
				<td>�n��:</td>
				<td><input type="TEXT" name="clat" size="45"
					value="<%=CourtVO.getClat()%>" /></td>
			</tr>
			<tr>
				<td>�g��:</td>
				<td><input type="TEXT" name="clng" size="45"
					value="<%=CourtVO.getClng()%>" /></td>
			</tr>
			<tr>
				<td>���a�q��:</td>
				<td><input type="TEXT" name="ctel" size="45"
					value="<%=CourtVO.getCtel()%>" /></td>
			</tr>
			<tr>
				<td>���a�p���H:</td>
				<td><input type="TEXT" name="ccon" size="45"
					value="<%=CourtVO.getCcon()%>" /></td>
			</tr>
			<tr>
				<td>���a�y�z:</td>
				<td><input type="TEXT" name="cdesc" size="45"
					value="<%=CourtVO.getCdesc()%>" /></td>
			</tr>




		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="�e�X�s�W">
	</FORM>





</body>
</html>