<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  

<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/head.jspf" %>
</head>
<body>
	<%@ include file="./common/top.jspf" %>
	
	<div class="container" style="margin-top:80px">
	        <div class="row">
	        <%@ include file="./common/aside.jspf" %>
	        <!-- ================== Main =============== -->
	        <div class="col-9">
		        <h3><strong>그룹 수정</strong></h3>
		        <hr>
		        <div class="row">
		        	<div class="col-1"></div>
		        	<div class="col-10">
		        		<form action="/demo/group/update" method="post">
		        			<input type="hidden" name="bid" value="${group.gid}">
		        			<table class="table table-borderless">
		        				<tr>
		        					<td style="width: 10%;"><label class="col-form-label">그룹명</label></td>
		        					<td style="width: 90%;">
		        						<input class="form-control" type="text" name="ggname" value="${group.ggname}">
		        					</td>
		        				</tr>
		        				<tr>
		        					<td><label class="col-form-label"></label></td>
		        					<td><input class="form-control" type="text" name="entertainment" value="${group.entertainment}"></td>
		        				</tr>
		        				<tr>
		        					<td><label class="col-form-label">프로필</label></td>
		        					<td><textarea class="form-control" rows="10" name="profile1">${group.profile1}</textarea></td>
		        				</tr>
		        				<tr>
		        					<td colspan="2" style="text-align: center;">
		        						<input class="btn btn-primary" type="submit" value="제출">
		        						<input class="btn btn-secondary" type="reset" value="취소">
		        					</td>
		        				</tr>
		        			</table>
		        		</form>
		        	</div>
		        	<div class="col-1"></div>
		        </div>
	        </div>
	        <!-- ====================== Main ============= -->
			 </div>
	    </div>

	<%@ include file="./common/bottom.jspf" %>

</body>
</html>