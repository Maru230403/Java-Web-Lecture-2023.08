<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("newline", "\n"); %>
 
<!DOCTYPE html>
<html>
<head>
   <%@ include file="./common/head.jspf" %>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <script>
      function showModal(){
         $('#deleteModal').modal('show');
      }
   
   </script>
</head>
<body>
   <%@ include file="./common/top.jspf" %>
   
    <div class="container" style="margin-top:80px">
       <div class="row">
             <%@ include file="./common/aside.jspf" %>
             <!-- ================= Main ==================== -->
             <div class="col-9">
                <h3>
                   <strong>블로그 상세 조회</strong>
                	<span style="font-size:0.6em;">
	                   <a href="/demo/blog/list">
	                      <i class="ms-5 fa-solid fa-list"></i> 목록
	                   </a>
	                   <a href="/demo/blog/update/${blog.bid}">
	                      <i class="ms-3 fa-regular fa-pen-to-square"></i> 수정
	                   </a>
	                   <a href="/demo/blog/delete/${blog.bid}">
	                      <i class="ms-3 fa-solid fa-trash-can"></i> 삭제
	                   </a>
	                   <a href="javascript:showModal()">
                      <i class="ms-3 fa-regular fa-window-maximize"></i> 모달로 삭제
                   	   </a>
	                  </button>
               	 	</span>
                </h3>
                <hr>
                <div class="row">
                   <div class="col-8">  <!-- 왼쪽 정렬 -->
                      <h5>${blog.title}</h5>
                      <h6>ID: ${blog.bid} | ${fn:replace(blog.modTime, 'T', ' ')}</h6>
                   </div>
                   <div class="col-4 text-end">  <!-- 오른쪽끝 정렬 -->
                      <h5>${blog.penName}</h5>
                      <h6>조회 ${blog.viewCount}</h6>
                   </div>
                </div>
                <hr>
	                <div class="row">
	               <div class="col-1"></div>                
	               <div class="col-10">
	                  ${fn:replace(blog.content, newline, '<br>')}
	               </div>                
	               <div class="col-1"></div>                
	                </div>
	             </div>
            <!-- ================= Main ==================== -->
       </div>
   </div>
   <%@ include file="./common/bottom.jspf" %>
   
	   <div class="modal" id="deleteModal">
	   <div class= "modal-dialog">
            <div class="modal-content">
        
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">삭제확인</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
        
                <!-- Modal body -->
                <div class="modal-body">
                    정말로 삭제하시겠습니까?
                </div>
        
                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal"
                    		onclick="location.href='/demo/blog/deleteConfirm/${blog.bid}'">삭제</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>