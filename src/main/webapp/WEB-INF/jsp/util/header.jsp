<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>后台管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta content="tangt" name="author"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <link href="/resource/css/style.min.css" rel="stylesheet" type="text/css">
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="//cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/limonte-sweetalert2/6.4.1/sweetalert2.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
</head>
<body class="fixed-left">
<div id="wrapper">
    <div class="topbar">
        <div class="topbar-left">
            <div class="text-center p-t-10" style="margin: 0 auto;">
                <div class="pull-left" style="padding-left: 10px;">
                    <a href="/admin/index">
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
                                <li><a href="/list" target="_blank"><i class="fa fa-eye" aria-hidden="true"></i>查看网站</a></li>
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
                        <a href="/admin/page" class="waves-effect active #end"><i class="fa fa-file-text"
                                                                                  aria-hidden="true"></i><span> 页面管理 </span></a>
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
