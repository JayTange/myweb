<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.seckill.util.Commons" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String testEl = Commons.getTestElString();
    request.setAttribute("aaa",testEl);
%>
<span>测试El表达式</span><br/>
<span>${aaa}</span>
</body>
</html>
