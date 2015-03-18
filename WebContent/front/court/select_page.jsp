<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>IBM Emp: Home</title></head>
<body bgcolor='white'>




<h3>資料查詢:</h3>
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

<ul>
  <li><a href='court.do?action=getAll'>List</a> all Court. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="court.do" >
        <b>輸入場地編號 (如1001):</b>
        <input type="text" name="cid">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="coSvc" scope="page" class="com.court.model.CourtService" />
   
  <li>
     <FORM METHOD="post" ACTION="court.do" >
       <b>選擇開放時間:</b>
       <select size="1" name="COURT_NO">
         <c:forEach var="courtVO" items="${coSvc.all}" > 
          <option value="${courtVO.cid}">${courtVO.copen}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
     </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="court.do" >
       <b>選擇場地名稱:</b>
       <select size="1" name="COURT_NO">
         <c:forEach var="courtVO" items="${coSvc.all}" > 
          <option value="${courtVO.cid}">${courtVO.cname}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
     </FORM>
  </li>
</ul>




<ul>
  <li><a href='addCourt.jsp'>Add</a> a new Court.</li>
</ul>

</body>

</html>
