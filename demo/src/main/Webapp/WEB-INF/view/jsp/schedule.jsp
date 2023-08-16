<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/head.jspf" %>
	<style>
		th { text-align: center; width: 14.28%; }
        td { height: 100px; }
	</style>
</head>
<body>
	<%@ include file="./common/top.jspf" %>
	
	<div class="container" style="margin-top:80px">
	        <div class="row">
	        <%@ include file="./common/aside.jspf" %>
	        <!-- ================== Main =============== -->
	            <div class="col-9">
	                <h3><strong>일정표</strong></h3>
	                <hr>
	                <div class="d-flex justify-content-between">
	                    <div>2023-03-15(수)</div>
	                    <div>
	                        <a href="#"><i class="fa-solid fa-angles-left"></i></a>
	                        <a href="#"><i class="fa-solid fa-angle-left ms-2"></i></a>
	                        <span class="badge bg-primary mx-2">2023.03</span>
	                        <a href="#"><i class="fa-solid fa-angle-right me-2"></i></a>
	                        <a href="#"><i class="fa-solid fa-angles-right"></i></a>
	                    </div>
	                    <div>
	                        <a href="#"><i class="fa-solid fa-pen me-3"></i></a>
	                        <a href="#"><i class="fa-solid fa-table-list"></i></a>
	                    </div>
	                </div>
	                <table class="table table-bordered mt-2">
	                    <tr>
	                        <th class="text-danger">일</th>
	                        <th>월</th><th>화</th><th>수</th><th>목</th><th>금</th>
	                        <th class="text-primary">토</th>
	                    </tr>
	                    <tr>
	                        <td class="text-danger" style="opacity: 0.5;">26</td>
	                        <td style="opacity: 0.5;">27</td>
	                        <td style="opacity: 0.5;">28</td>
	                        <td>
	                            <div class="d-flex justify-content-between">
	                                <div class="text-danger">1</div>
	                                <div>삼일절</div>
	                            </div>
	                        </td>
	                        <td>2</td>
	                        <td>3</td>
	                        <td class="text-primary">4</td>
	                    </tr>
	                    <tr>
	                        <td class="text-danger">5</td>
	                        <td>6</td>
	                        <td>7</td>
	                        <td>8</td>
	                        <td>9</td>
	                        <td>10</td>
	                        <td class="text-primary">11</td>
	                    </tr>
	                    <tr>
	                        <td class="text-danger">12</td>
	                        <td>13
	                            <div class="mt-1" style="font-size: 12px;">09:00 오리엔테이션</div>
	                        </td>
	                        <td>
	                            <div class="d-flex justify-content-between">
	                                <div>14</div>
	                                <div>화이트데이</div>
	                            </div>
	                            <div class="mt-1" style="font-size: 12px;">
	                                <strong>12:00 케냐방문</strong><br>
	                                18:00 귀가
	                            </div>
	                        </td>
	                        <td style="background-color: #efffff;">15</td>
	                        <td>16</td>
	                        <td>17</td>
	                        <td class="text-primary">18</td>
	                    </tr>
	                    <tr>
	                        <td class="text-danger">19</td>
	                        <td>20</td>
	                        <td>21</td>
	                        <td>22</td>
	                        <td>23</td>
	                        <td>24</td>
	                        <td class="text-primary">25</td>
	                    </tr>
	                    <tr>
	                        <td class="text-danger">26</td>
	                        <td>27</td>
	                        <td>28</td>
	                        <td>29</td>
	                        <td>30</td>
	                        <td>31</td>
	                        <td class="text-primary" style="opacity: 0.5;">1</td>
	                    </tr>
	                </table>
	            </div>
	         <!-- ================== Main =============== -->
	        </div>
	    </div>

	<%@ include file="./common/bottom.jspf" %>

</body>
</html>