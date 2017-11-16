<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="themeheader.jsp" %>
<%@include file="tag.jsp" %>
<body>
<div class="main-content index-page clearfix">
    <div class="post-lists">
        <div class="post-lists-body">

            <div class="post-list-item">
                <c:forEach items="${page.rows}" var="sk">
                    <%
                        Random random = new Random();
                        Integer randInt = random.nextInt(10);
                        request.setAttribute("randInt", randInt);

                    %>
                    <a href="/article/+${sk.slug} " class="item-thumb  bg-deepgrey"
                       style="background-image:url("/resource/user/img/+${randInt}.jpg")>
                    <dir class="item-desc">${sk.tags}</dir>
                    </a>
                    <div class="item-slant reverse-slant &lt; bg-deepgrey"></div>
                    <div class="item-slant"></div>
                    <div class="item-label">
                        <div class="item-title">
                            <a href="/article/+${sk.slug}">${sk.title}</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

</div>
<%@include file="themefooter.jsp"%>
