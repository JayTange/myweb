<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="util/header.jsp" %>
<div class="row">
    <div class="col-sm-12">
        <h4 class="page-title">Tale仪表盘</h4>
    </div>

    <div class="row">
        <div class="col-sm-6 col-lg-3">
            <div class="mini-stat clearfix bx-shadow bg-info">
                <span class="mini-stat-icon"><i class="fa fa-quote-right" aria-hidden="true"></i></span>
                <div class="mini-stat-info text-right">
                    发表了<span class="counter"></span>篇文章
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-lg-3">
            <div class="mini-stat clearfix bg-purple bx-shadow">
                <span class="mini-stat-icon"><i class="fa fa-comments-o" aria-hidden="true"></i></span>
                <div class="mini-stat-info text-right">
                    收到了<span class="counter"></span>条留言
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-lg-3">
            <div class="mini-stat clearfix bg-success bx-shadow">
                <span class="mini-stat-icon"><i class="fa fa-cloud-upload" aria-hidden="true"></i></span>
                <div class="mini-stat-info text-right">
                    上传了<span class="counter"></span>个附件
                </div>
            </div>
        </div>

    </div>

    <div class="row"></div>
</div>
<%@include file="util/footer.jsp"%>
</body>
</html>
