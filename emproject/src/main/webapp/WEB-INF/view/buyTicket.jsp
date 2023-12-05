<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>이용권 구매</title>
</head>
<body>

    <h2>이용권 구매</h2>

    <form action="/purchase" method="post">
        <label>
            <input type="radio" name="ticketType" value="standard"> 표준 이용권 (￦10,000)
        </label>
        <br>
        <label>
            <input type="radio" name="ticketType" value="premium"> 프리미엄 이용권 (￦30,000)
        </label>
        <br>

        <!-- 필요한 경우 더 많은 옵션을 추가할 수 있습니다. -->
        <!-- 예: 수량 선택 -->
        <label>
            수량:
            <select name="quantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>
        </label>
        <br>

        <!-- 예: 결제 세부 정보 -->
        <label>
            카드 번호:
            <input type="text" name="cardNumber">
        </label>
        <br>

        <br>
        <button type="submit">선택한 이용권 결제</button>
    </form>

</body>
</html>
