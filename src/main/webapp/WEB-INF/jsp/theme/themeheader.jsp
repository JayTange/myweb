<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.seckill.util.Commons" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
    <meta name="renderer" content="webkit"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-transform"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>tile"</title>
    <link href="//cdn.bootcss.com/highlight.js/9.9.0/styles/xcode.min.css" rel="stylesheet">
    <link href="/resource/user/css/style.min.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<div class="browsehappy" role="dialog">
    当前网页 <strong>不支持</strong> 你正在使用的浏览器. 为了正常的访问, 请 <a href="http://browsehappy.com/" target="_blank">升级你的浏览器</a>。
</div>

<header id="header" class="header bg-white">
    <%
        String header = Commons.site_url();
        String archives = Commons.site_url("/archives");
        String links = Commons.site_url("/links");
        String about = Commons.site_url("/about");
        request.setAttribute("archives",archives);
        request.setAttribute("links",links);
        request.setAttribute("about",about);
        request.setAttribute("header",header);
    %>
    <div class="navbar-container">
        <a href="${header}" class="navbar-logo">
            <img src="/resource/user/img/logo.png" alt="首页"/>
        </a>
        <div class="navbar-menu">
            <a href="${archives}">归档</a>
            <a href="${links}">友链</a>
            <a href="${about}">关于</a>
        </div>
        <div class="navbar-search" onclick="">
            <span class="icon-search"></span>
            <form role="search" onsubmit="return false;">
                <span class="search-box">
                    <input type="text" id="search-inp" class="input" placeholder="搜索..." maxlength="30"
                           autocomplete="off"/>
                </span>
            </form>
        </div>
        <div class="navbar-mobile-menu" onclick="">
            <span class="icon-menu cross"><span class="middle"></span></span>
            <ul>
                <li><a th:href="${archives}">归档</a></li>
                <li><a th:href="${links}">友链</a></li>
                <li><a th:href="${about}">关于</a></li>
            </ul>
        </div>
    </div>
</header>

