<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.seckill.util.Commons" %>
<%@ page import="java.util.Map" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<footer class="footer bg-white">
    <div class="footer-social">
        <div class="footer-container clearfix">
            <%
               Map<String,String> socialMap  = Commons.social();
               request.setAttribute("socialMap",socialMap);
            %>
            <div class="social-list">
            </div>
        </div>
    </div>
    <div class="footer-meta">
        <div class="footer-container">
            <div class="meta-item meta-copyright">
                <div class="meta-copyright-info">
                    <div class="info-text">
                        <a href="http://blog.hanshuai.xin" style="display: block;margin: 0 auto;" class="info-logo">
                            <img style="display: block;margin: 0 auto;" src="/resource/user/img/logo.png"/>
                        </a>
                        <br/>
                        <p>&copy; 版权所有 <a href="https://github.com/JayTange/myweb" target="_blank"
                                          rel="nofollow">My Blog</a> 保留一切权利
                        </p>
                        <br/>
                    </div>
                </div>
            </div>

        </div>
    </div>
</footer>


</body>
</html>
