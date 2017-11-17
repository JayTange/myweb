<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="themeheader.jsp" %>
<%@include file="tag.jsp" %>

<div class="main-content index-page clearfix">
    <div class="post-lists">
        <div class="post-lists-body">
            <c:forEach items="${page.rows}" var="sk">
                <div class="post-list-item">
                    <div class="post-list-item-container">
                        <%
                            Random random = new Random();
                            Integer randInt = random.nextInt(38);
                            String bgimg = "/resource/user/img/rand/" + randInt + ".jpg";
                            request.setAttribute("bgimg", bgimg);

                        %>
                        <div class="item-thumb bg-deepgrey" style="background-image: url(${bgimg});"></div>
                        <a href="/article/${sk.slug}">
                            <div class="item-desc">
                                <p>adfa</p>
                            </div>
                        </a>
                        <div class="item-slant reverse-slant &lt; bg-deepgrey"></div>
                        <div class="item-slant"></div>
                        <div class="item-label">
                            <div class="item-title">
                                <a href="/article/${sk.slug}">${sk.title}</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

</div>
<%@include file="themefooter.jsp" %>
