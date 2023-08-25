<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  

<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/head.jspf" %>
	<style>
	td, th { text-align: center;}
	</style>
	<script>
	function search() {
		let field =document.getElementById('field').value;
		let query =document.getElementById('query').value;
		// console.log("search()",field, query);
		location.href = '/demo/group/gpage?f=' + field + '&q=' + query;
	}
	</script>
</head>
<body>
	<%@ include file="./common/top.jspf" %>
	
	<div class="container" style="margin-top:80px">
	        <div class="row">
	        <%@ include file="./common/aside.jspf" %>
	        <!-- ================== Main =============== -->
	        <div class="col-9">
	        	<table class="table table-sm table-borderless">
	        		<tr>
	        			<td style="width: 52%; text-align: left;">
		        <h3>
		        	<strong>그룹목록</strong>
		        	<span style="font-size:0.6em;">
				        		<a href="/demo/blog/write">
				        			<i class="ms-5 fa-regular fa-file-lines"></i> 그룹추가
				        		</a>
				    </span>
		        </h3>
		        </td>
		        <td style="width: 15%;">
							<select class="form-select" id="field">
		                        <option value="ggname" ${field eq 'gganme' ? 'selected' : ''}>그룹명</option>
		                        <option value="entertainment" ${field eq 'entertainment' ? 'selected' : ''}>기획사</option>
		                    </select>
	        			</td>
	        			<td style="width: 25%;">
	        				<input class="form-control" placeholder="검색할 내용" id="query" value="${query}" 
	        						onkeyup="if(window.event.keyCode==13) search()">
	        			</td>
	        			<td style="width: 8%;">
	        				<button class="btn btn-outline-primary" onclick="search()">검색</button>
	        			</td>
	        		</tr>
	        	</table>
		        	<hr>
		        	<table class="table">
		        		<tr class= "table-secondary">
		        			<th style = "width: 10%;">GID</th>
			        		<th style = "width: 42%;">그룹명</th>
			        		<th style = "width: 48%;">기획사</th>
			        	</tr>
		        </table>
	        </div>
	        <!-- ====================== Main ============= -->
			 </div>
	    </div>

	<%@ include file="./common/bottom.jspf" %>

</body>
</html>