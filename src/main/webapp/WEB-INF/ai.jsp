<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 1. 한글 사용 가능하게 설정 -->
<html>
<head>
    <title>AI 너무 좋아!</title>
</head>
<body>
<p>
    <!-- 2. req(request) 안에 set된 'data'라는 attribute가 있다면 출력 -->
    <%= request.getAttribute("data") %> <!-- 값을 출력 -->
</p>
</body>
</html>
