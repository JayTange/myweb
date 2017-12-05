<%@ page import="org.seckill.entity.Contents" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="themeheader.jsp" %>
<%@include file="tag.jsp" %>
<div class="main-content archive-page clearfix">
    <div class="categorys-item">
      <c:forEach items="${archive}" var="sk">
          <div class="categorys-title">${sk.date}</div>
          <div class="post-lists">
              <div class="post-lists-body">
                  <c:forEach items="${sk.articles}" var="article">
                      <div class="post-list-item">
                          <div class="post-list-item-container">
                              <div class="item-label">
                                  <%
                                      Contents contents = (Contents) request.getAttribute("article");
                                      String href =  Commons.permalink(contents.getCid(),contents.getSlug());
                                      String createdTime = Commons.fmtdate(contents.getCreated());
                                      request.setAttribute("href",href);
                                      request.setAttribute("createdTime",createdTime);
                                  %>
                                  <div class="item-title">
                                    <a href="${href}">${article.title}</a>
                                  </div>
                                  <div class="item-meta clearfix">
                                      <div class="item-meta-date">发布于 ${createdTime}</div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </c:forEach>
              </div>
          </div>
      </c:forEach>
    </div>
</div>

<%@include file="themefooter.jsp" %>