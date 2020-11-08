<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Baihua
  Date: 2020/10/24
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Black &amp; White</title>

    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/ionicons.min.css">
    <link rel="stylesheet" href="css/pace.css">
    <link rel="stylesheet" href="css/custom.css">

    <!-- js -->
    <script src="js/jquery-2.1.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/pace.min.js"></script>
    <script src="js/modernizr.custom.js"></script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="content-body">
    <div class="container">
        <div class="row">
            <main class="col-md-12">

                <c:forEach items="${blogs}" var="blog">
                    <article class="post post-1">
                        <header class="entry-header">
                            <h1 class="entry-title">
                                <a href="${pageContext.request.contextPath}/findBlogByIdServlet?id=${blog.blogid}">${blog.title}</a>
                            </h1>
                            <div class="entry-meta">
                                <span class="post-category"><a href="#">${blog.type}</a></span>

                                <span class="post-date"><a href="#"><time class="entry-date"
                                                                          datetime="2012-11-09T23:15:57+00:00">${blog.publishDataTime}</time></a></span>

                                <span class="post-author"><a href="#">${blog.author}</a></span>

                                <span class="comments-link"><a href="">${blog.readCount} 阅读</a></span>
                            </div>
                        </header>
                        <div class="entry-content clearfix">
                            <p>${blog.descriptor}</p>
                            <div class="read-more cl-effect-14">
                                <a href="${pageContext.request.contextPath}/findBlogByIdServlet?id=${blog.blogid}"
                                   class="more-link">继续阅读 <span class="meta-nav">→</span></a>
                            </div>
                        </div>
                    </article>
                </c:forEach>
            </main>
        </div>
    </div>
</div>
<footer id="site-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p class="copyright">&copy; 2020 tf.cn</p>
            </div>
        </div>
    </div>
</footer>


<script src="js/script.js"></script>
</body>
</html>
