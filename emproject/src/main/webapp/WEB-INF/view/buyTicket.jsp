<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>이용권 구매</title>
</head>
<body>

    <h2>이용권 구매</h2>

    <form action="/purchase" method="post" id="purchaseForm">
        <label>
            이용권 선택:
            <select name="ticketType" id="ticketType" onchange="showOptions()">
                <option value="daily">일일권</option>
                <option value="regular">정기권</option>
            </select>
        </label>
        <br>

        <div id="dailyOptions" style="display: block;">
            <label>
                일일권
                <select name="dailyQuantity">
                    <option value="1">1시간 이용권</option>
                    <option value="2">2시간 이용권</option>
                </select>
            </label>
        </div>

        <div id="regularOptions" style="display: none;">
            <label>
                정기권
                <select name="regularQuantity">
                    <option value="7_1">7일 1시간 이용권</option>
                    <option value="7_2">7일 2시간 이용권</option>
                    <option value="30_1">30일 1시간 이용권</option>
                    <option value="30_2">30일 2시간 이용권</option>
                    <option value="180_1">180일 1시간 이용권</option>
                    <option value="180_2">180일 2시간 이용권</option>
                    <option value="365_1">365일 1시간 이용권</option>
                    <option value="365_2">365일 2시간 이용권</option>
                </select>
            </label>
        </div>

        <!-- 예: 결제 세부 정보 -->
        <label>
            카드 번호:
            <input type="text" name="cardNumber">
        </label>
        <br>

        <br>
        <button type="submit">선택한 이용권 결제</button>
    </form>

    <script>
        function showOptions() {
            var ticketType = document.getElementById('ticketType').value;
            var dailyOptions = document.getElementById('dailyOptions');
            var regularOptions = document.getElementById('regularOptions');

            if (ticketType === 'daily') {
                dailyOptions.style.display = 'block';
                regularOptions.style.display = 'none';
            } else if (ticketType === 'regular') {
                dailyOptions.style.display = 'none';
                regularOptions.style.display = 'block';
            }
        }
    </script>

</body>
</html>
