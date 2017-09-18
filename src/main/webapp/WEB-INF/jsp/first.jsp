<%--
  Created by IntelliJ IDEA.
  User: tangj
  Date: 2017/9/18
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int sum = 0;
    for(int i = 0;i<100;i++){
        sum = sum+i;
    }
    System.out.println(sum);
%>
</body>
</html>
