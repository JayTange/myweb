<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>后台管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta content="tangt" name="author"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/limonte-sweetalert2/6.4.1/sweetalert2.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="//cdn.bootcss.com/limonte-sweetalert2/6.4.1/sweetalert2.min.js"></script>
    <link href="/resource/css/style.min.css" rel="stylesheet" type="text/css">
    <script src="/resource/js/base.js"></script>
    <script src="/resource/js/jquery.app.js"></script>
    <%@include file="../common/tag.jsp" %>
    <link href="/resource/plugin/tagsinput/jquery.tagsinput.css" rel="stylesheet">
    <link href="/resource/plugin/select2/dist/css/select2-bootstrap.css" rel="stylesheet">
    <link href="/resource/plugin/toggles/toggles.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/multi-select/0.9.12/css/multi-select.min.css" rel="stylesheet"/>
    <link href="//cdn.bootcss.com/select2/3.4.8/select2.min.css" rel="stylesheet"/>
    <link href="//tale-static.b0.upaiyun.com/mditor/css/mditor.min.css" rel="stylesheet"/>
    <link href="//cdn.bootcss.com/summernote/0.8.2/summernote.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/dropzone/4.3.0/min/dropzone.min.css" rel="stylesheet">
</head>
<body class="fixed-left">
<div id="wrapper">
    <div class="topbar">
        <div class="topbar-left">
            <div class="text-center p-t-10" style="margin: 0 auto;">
                <div class="pull-left" style="padding-left: 10px;">
                    <a href="/index">
                        <img src="/resource/image/unicorn.png" width="50" height="50"/>
                    </a>
                </div>
                <div class="pull-left" style="padding-left: 10px;">
                    <span style="font-size: 28px; color: #2f353f; line-height: 50px;">Welcome</span>
                </div>
            </div>
        </div>
        <div class="navbar navbar-default" role="navigation">
            <div class="container">
                <div class="">
                    <div class="pull-left">
                        <button type="button" class="button-menu-mobile open-left">
                            <i class="fa fa-bars"></i>
                        </button>
                        <span class="clearfix"></span>
                    </div>

                    <ul class="nav navbar-nav navbar-right pull-right">
                        <li class="dropdown">
                            <!-- 下拉框按钮 放博客初始页-->
                            <a href="/articlemanage" class="dropdown-toggle profile" data-toggle="dropdown"
                               aria-expanded="true"><img src="/resource/image/unicorn.png" alt="user-img"
                                                         class="img-circle"> </a>
                            <ul class="dropdown-menu">
                                <li><a href="/list" target="_blank"><i class="fa fa-eye" aria-hidden="true"></i>查看网站</a>
                                </li>
                                <li><a href="/admin/profile"><i class="fa fa-sun-o"></i> 个人设置</a></li>
                                <li><a href="/logout"><i class="fa fa-sign-out"></i> 注销</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="left side-menu">
        <div class="sidebar-inner slimscrollleft">
            <div id="sidebar-menu">
                <ul>
                    <li class="active">
                        <a href="/index" class="waves-effect home"><i class="fa fa-dashboard"
                                                                      aria-hidden="true"></i><span> 仪表盘 </span></a>
                    </li>
                    <li class="active">
                        <a href="/admin/article/publish" class="waves-effect active #end"><i
                                class="fa fa-pencil-square-o" aria-hidden="true"></i><span> 发布文章 </span></a>
                    </li>
                    <li class="active">
                        <a href="/articlemanage" class="waves-effect active #end"><i class="fa fa-list"
                                                                                     aria-hidden="true"></i><span> 文章管理 </span></a>
                    </li>

                    <li class="active">
                        <a href="/admin/attach" class="waves-effect active #end"><i class="fa fa-cloud-upload"
                                                                                    aria-hidden="true"></i><span> 文件管理 </span></a>
                    </li>

                    <li class="has_sub">
                        <a href="javascript:void(1)" class="waves-effect  active subdrop #end"><i
                                class="fa fa-cubes"></i><span> 其他管理 </span><span class="pull-right"><i
                                class="fa fa-plus"></i></span></a>
                        <ul class="list-unstyled">
                            <li class="active">
                                <a href="/admin/comments" class="waves-effect  active #end"><i class="fa fa-comments"
                                                                                               aria-hidden="true"></i><span> 评论管理 </span></a>
                            </li>
                            <li class="active">
                                <a href="/admin/category" class="waves-effect active #end"><i class="fa fa-tags"
                                                                                              aria-hidden="true"></i><span> 分类/标签 </span></a>
                            </li>
                            <li class="active">
                                <a href="/admin/template" class="waves-effect active #end"><i class="fa fa-hashtag"></i><span> 编辑模板 </span></a>
                            </li>
                        </ul>
                    </li>

                    <li class="active">
                        <a href="/admin/themes" class="waves-effect active #end"><i class="fa fa-diamond"
                                                                                    aria-hidden="true"></i><span> 主题设置 </span></a>
                    </li>

                    <li #if(active=='setting') class="active" #end>
                        <a href="/admin/setting" class="waves-effect active #end"><i class="fa fa-gear"
                                                                                     aria-hidden="true"></i><span> 系统设置 </span></a>
                    </li>

                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="content-page">
        <div class="content">
            <div class="container">
                <!--文章编辑模块 -->
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

                    <div class="col-sm-12">
                        <form id="articleForm">
                            <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                                <input class="form-control" placeholder="请输入文章标题（必须）" name="title" required
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
                                    <c:if test="${categories == null}">
                                        <option value="默认分类" selected>默认分类</option>
                                    </c:if>

                                    <c:forEach items="${categories}" var="ca">
                                        <option value="${ca.name}" #if(null !=contents && exist_cat(c,
                                                contents.categories)) selected #end>
                                                ${ca.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="clearfix"></div>
                            <div class="form-group col-xs-12">
                                <div class="pull-right">
                                    　 <c:choose>
                                    <c:when test="${contents!=null && contents.fmtType=='html'}">
                                        <a id="switch-btn" href="javascript:void(0)"
                                           class="btn btn-purple btn-sm waves-effect waves-light switch-editor">
                                            切换为Markdown编辑器
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a id="switch-btn" href="javascript:void(0)"
                                           class="btn btn-purple btn-sm waves-effect waves-light switch-editor">
                                            切换为富文本编辑器
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                                </div>
                                <
                            </div>
                            <div id="md-container" class="form-group col-md-12">
                                <textarea id="md-editor"
                                          class="#if(null != contents && contents.fmtType != 'html') hide #end">${contents.content ?! ''}</textarea>
                            </div>

                            <div id="html-container" class="form-group col-md-12">
                                <div class="summernote">
                                    #if(null != contents && contents.fmtType == 'html')
                                    ${contents.content ?! ''}
                                    #end
                                </div>
                            </div>

                            <div class="form-group col-md-3 col-sm-4">
                                <label class="col-sm-4">开启评论</label>
                                <div class="col-sm-8">
                                    <div class="toggle toggle-success allow-${contents.allowComment ?! true}"
                                         onclick="allow_comment(this);" on="${contents.allowComment ?! true}"></div>
                                </div>
                            </div>

                            <div class="form-group col-md-3 col-sm-4">
                                <label class="col-sm-4">允许Ping</label>
                                <div class="col-sm-8">
                                    <div class="toggle toggle-success allow-${contents.allowPing ?! true}"
                                         onclick="allow_ping(this);" on="${contents.allowPing ?! true}"></div>
                                </div>
                            </div>

                            <div class="form-group col-md-3 col-sm-4">
                                <label class="col-sm-4">允许订阅</label>
                                <div class="col-sm-8">
                                    <div class="toggle toggle-success allow-${contents.allowFeed ?! true}"
                                         onclick="allow_feed(this);" on="${contents.allowFeed ?! true}"></div>
                                </div>
                            </div>

                            <div class="form-group col-md-3">
                                <label class="col-sm-5">添加缩略图</label>
                                <div class="col-sm-7">
                                    <div id="thumb-toggle" class="toggle toggle-success" on="false"
                                         thumb_url="${contents.thumbImg ?! ''}" onclick="add_thumbimg(this);"></div>
                                </div>
                            </div>

                            <div id="dropzone-container" class="form-group col-md-12 hide">
                                <div class="dropzone dropzone-previews" id="dropzone">
                                    <div class="dz-message">
                                        <p>可以为你的文章添加一张缩略图 ;)</p>
                                    </div>
                                </div>
                                <input type="hidden" name="thumbImg" id="thumbImg"/>
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

                            <div class="clearfix"></div>

                            <div class="text-right">
                                <a class="btn btn-default waves-effect waves-light" href="/admin/article">返回列表</a>
                                <button type="button" class="btn btn-primary waves-effect waves-light" onclick="subArticle('publish');">
                                    保存文章
                                </button>
                                <button type="button" class="btn btn-warning waves-effect waves-light" onclick="subArticle('draft');">
                                    存为草稿
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <footer class="footer text-right">
                    2017 © <a href="https://github.com/JayTange" target="_blank">tangt</a>.
                </footer>
            </div>
        </div>
    </div>
</div>
<script src="//tale-static.b0.upaiyun.com/mditor/js/mditor.min.js"></script>
<script src="//cdn.bootcss.com/wysihtml5/0.3.0/wysihtml5.min.js"></script>
<script src="//cdn.bootcss.com/summernote/0.8.2/summernote.min.js"></script>
<script src="//cdn.bootcss.com/summernote/0.8.2/lang/summernote-zh-CN.min.js"></script>
<script src="//cdn.bootcss.com/multi-select/0.9.12/js/jquery.multi-select.min.js"></script>
<script src="//cdn.bootcss.com/select2/3.4.8/select2.min.js"></script>
<script src="//cdn.bootcss.com/jquery-toggles/2.0.4/toggles.min.js"></script>
<script src="//cdn.bootcss.com/dropzone/4.3.0/min/dropzone.min.js"></script>
<script src="//cdn.bootcss.com/to-markdown/3.1.0/to-markdown.min.js"></script>
<script src="/resource/plugin/tagsinput/jquery.tagsinput.min.js"></script>
<script src="/resource/plugin/jquery-multi-select/jquery.quicksearch.js"></script>
<script src="/resource/js/article.js" type="text/javascript"></script>
</body>
</html>