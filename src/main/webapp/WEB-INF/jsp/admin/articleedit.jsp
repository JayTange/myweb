<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@include file="../util/header.jsp" %>
<%@include file="../common/tag.jsp" %>
<!--文章编辑模块 -->
<link href="/resource/plugin/tagsinput/jquery.tagsinput.css" rel="stylesheet">
<link href="/resource/plugin/select2/select2-bootstrap.css" rel="stylesheet">
<link href="/resource/plugin/toggles/toggles.css" rel="stylesheet">

<link href="//cdn.bootcss.com/multi-select/0.9.12/css/multi-select.min.css" rel="stylesheet"/>
<link href="//cdn.bootcss.com/select2/3.4.8/select2.min.css" rel="stylesheet"/>
<link href="/resource/plugin/md/css/style.css" rel="stylesheet">

<style type="text/css">
    #tags_tagsinput {
        background-color: #fafafa;
        border: 1px solid #eeeeee;
    }

    #tags_addTag input {
        width: 100%;
    }

    #tags_addTag {
        margin-top: -5px;
    }
</style>
<div class="row">
    <div class="col-sm-12">
        <h4 class="page-title">
            <c:if test="${contents == null}">
                <span>编辑文章</span>
            </c:if>
            <c:if test="${contents!= null}">
                <span>发布文章</span>
            </c:if>
        </h4>
    </div>

    <div class="col-md-12">
        <form id="articleForm" role="form" novalidate="novalidate">

            <input type="hidden" name="categories" id="categories"/>
            <input type="hidden" name="cid" value="${contents.cid}" id="cid"/>
            <input type="hidden" name="status" value="${contents.status}" id="status"/>
            <input type="hidden" name="allowComment" value="${contents.allowComment}" id="allow_comment"/>
            <input type="hidden" name="allowPing" value="${contents.allowPing}" id="allow_ping"/>
            <input type="hidden" name="allowFeed" value="${contents.allowFeed}" id="allow_feed"/>
            <input type="hidden" name="content" id="content-editor"/>


            <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                <input class="form-control" placeholder="请输入文章标题（必须）" name="title"
                       required="required"
                       aria-required="true"
                       value="${contents.title}"/>
            </div>

            <div class="form-group col-md-6" style="padding: 0 0 0 10px;">
                <input class="form-control" placeholder="自定义访问路径，如：my-first-article  默认为文章id"
                       name="slug"
                       value="${contents.slug}"/>
            </div>

            <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                <input name="tags" id="tags" type="text" class="form-control" placeholder="请填写文章标签"
                       value="${contents.tags}"/>
            </div>

            <div class="form-group col-md-6">
                <select id="multiple-sel" class="select2 form-control" multiple="multiple"
                        data-placeholder="请选择分类...">

                    <c:forEach items="${categories}" var="ca">
                        <option value="${ca.name}" selected>
                                ${ca.name}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="clearfix"></div>
            <div class="form-group">
              <textarea style="height: 450px" autocomplete="off" id="text" name="text"
                        class="markdown-textarea" value="${contents.content}">${contents.content}</textarea>
            </div>

            <div class="form-group col-md-3 col-sm-4">
                <label class="col-sm-4">开启评论</label>
                <div class="col-sm-8">
                    <div class="toggle toggle-success allow-${contents.allowComment}"
                         onclick="allow_comment(this);" on="${contents.allowComment}"></div>
                </div>
            </div>

            <div class="form-group col-md-3 col-sm-4">
                <label class="col-sm-4">允许Ping</label>
                <div class="col-sm-8">
                    <div class="toggle toggle-success allow-${contents.allowPing}"
                         onclick="allow_ping(this);" on="${contents.allowPing}"></div>
                </div>
            </div>

            <div class="form-group col-md-3 col-sm-4">
                <label class="col-sm-4">允许订阅</label>
                <div class="col-sm-8">
                    <div class="toggle toggle-success allow-${contents.allowFeed}"
                         onclick="allow_feed(this);" on="${contents.allowFeed}"></div>
                </div>
            </div>

            <div class="clearfix"></div>

            <div class="text-right">
                <a class="btn btn-default waves-effect waves-light" href="/admin/article">返回列表</a>
                <button type="button" class="btn btn-primary waves-effect waves-light"
                        onclick="subArticle('publish');">
                    保存文章
                </button>
                <button type="button" class="btn btn-warning waves-effect waves-light"
                        onclick="subArticle('draft');">
                    存为草稿
                </button>
            </div>

        </form>
    </div>
</div>
<%@include file="../util/footer.jsp" %>


<script src="/resource/plugin/tagsinput/jquery.tagsinput.min.js"></script>
<script src="/resource/plugin/jquery-multi-select/jquery.quicksearch.js"></script>

<script src="/resource/plugin/md/js/jquery.scrollto.js"></script>
<script src="/resource/plugin/md/js/pagedown.js"></script>
<script src="/resource/plugin/md/js/pagedown-extra.js"></script>
<script src="/resource/plugin/md/js/diff.js"></script>
<script src="/resource/plugin/md/js/md.js"></script>



<script src="//cdn.bootcss.com/multi-select/0.9.12/js/jquery.multi-select.min.js"></script>
<script src="//cdn.bootcss.com/select2/3.4.8/select2.min.js"></script>
<script src="//cdn.bootcss.com/jquery-toggles/2.0.4/toggles.min.js"></script>
<script src="/resource/js/article.js" type="text/javascript"></script>
</body>
</html>
