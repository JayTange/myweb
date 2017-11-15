<%--
  Created by IntelliJ IDEA.
  User: 唐杰
  Date: 2017/11/14
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<%@include file="../theme/tag.jsp" %>
<link href="//cdn.bootcss.com/dropzone/4.3.0/min/dropzone.min.css" rel="stylesheet"/>
<style>
    #dropzone {
        margin-bottom: 3rem;
    }

    .dropzone {
        border: 2px dashed #0087F7;
        border-radius: 5px;
        background: white;
    }

    .dropzone .dz-message {
        font-weight: 400;
    }

    .dropzone .dz-message .note {
        font-size: 0.8em;
        font-weight: 200;
        display: block;
        margin-top: 1.4rem;
    }

    .attach-img {
        width: 100px;
        height: 100px;
        border-radius: 10px;
        box-shadow: 0px 0px 8px #333;
    }

    .attach-text {
        font-size: 12px;
        font-weight: 300;
    }

    .attach-img:hover {
        background-color: #f9f9f9;
    }
</style>
<div class="col-sm-12">
    <h4 class="page-title">文件管理</h4>
</div>
<div class="row">
    <div class="col-md-12 portlets">
        <!-- Your awesome content goes here -->
        <div class="m-b-30">
            <form action="#" class="dropzone" id="dropzone">
                <div class="fallback">
                    <input name="file" type="file" multiple="multiple"/>
                </div>
                <div class="dz-message">
                    将文件拖至此处或点击上传.
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
