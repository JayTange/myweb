<%@ page import="org.seckill.entity.Contents" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="themeheader.jsp" %>
<%@include file="tag.jsp" %>
<article class="main-content post-page" itemscope itemtype="http://schema.org/Article">
    <div class="post-header">
        <h1 class="post-title" itemprop="name headline">
            <a href="#" itemprop="name headline"> ${article.title}</a>
        </h1>
        <%
            Contents contents = (Contents) request.getAttribute("acticle");
            String created = Commons.fmtdate(contents.getCreated());
            String categories = Commons.show_categories(contents.getCategories());
            String tags = Commons.show_tags(contents.getTags());
            String articleShow = Commons.article(contents.getContent());
            String modified = Commons.fmtdate(contents.getModified(),'yyyy/MM/dd HH:mm');

            request.setAttribute("created",created);
            request.setAttribute("categories",categories);
            request.setAttribute("tags",tags);
            request.setAttribute("articleShow",articleShow);
            request.setAttribute("modified",modified);
        %>

        <div class="post-data">
            <time datetime="" itemprop="datePublished">发布于${created}</time>/ <a href="#">${categories}</a>/ <a href="#comments">${article.commentsNum}条评论</a>/ <a></a>
        </div>
    </div>

    <div id="post-content" class="post-content" itemprop="articleBody">

        <p class="post-tags">${tags}</p>
        ${articleShow}
        <p class="post-info">
            本站文章除注明转载/出处外，均为本站原创或翻译，转载前请务必署名,转载请标明出处<br/>最后编辑时间为:
            ${modified}
        </p>
    </div>
</article>

</body>
</html>
