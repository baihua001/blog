<%--
  Created by IntelliJ IDEA.
  User: Baihua
  Date: 2020/10/22
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>

    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="css/pace.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="ckeditor5/build/ckeditor.js"></script>
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
            <main class="col-md-8">
                <c:forEach items="${pb.list}" var="blog">
                    <article class="post post-1">
                        <header class="entry-header">
                            <h1 class="entry-title">
                                <a href="${pageContext.request.contextPath}/findBlogByIdServlet?id=${blog.blogid}">${blog.title}</a>
                            </h1>
                            <div class="entry-meta">
                                <span class="post-category"><a href="#">${blog.type}</a></span>
                                <span class="post-date"><a href="#">${blog.publishDataTime}</a></span>
                                <span class="post-author"><a href="#">${blog.author}</a></span>
                                <span class="views-count"><a href="#">${blog.readCount} 阅读</a></span>
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
                <div class="pagination-simple">
                    <c:if test="${pb.currentPage == 1}">
                        <a>上一页</a>
                    </c:if>
                    <c:if test="${pb.currentPage > 1}">
                        <a href="${pageContext.request.contextPath}/findBlogByPageAndreaderSeverlet?currentPage=${pb.currentPage-1}">上一页</a>
                    </c:if>

                    <span class="current">第 ${pb.currentPage} 页 / 共 ${pb.totalPage} 页</span>

                    <c:if test="${pb.currentPage == pb.totalPage}">
                        <a>下一页</a>
                    </c:if>
                    <c:if test="${pb.currentPage < pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/findBlogByPageAndreaderSeverlet?currentPage=${pb.currentPage+1}">下一页</a>
                    </c:if>

                </div>

            </main>
            <aside class="col-md-4">
                <div class="widget widget-archives">
                    <c:if test="${user!=null}">
                        <img src="${user.headPort}" width="150px" height="150px"/><br>
                        <ul>
                            <li>
                                <a href="updateUser.jsp" style="text-decoration:underline ;color:dodgerblue">${user.nickname}</a><br>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/logOutServlet" style="text-decoration:underline ;color:dodgerblue">退出登录</a>
                            </li>
                        </ul>
                    </c:if>
                    <c:if test="${user==null}">
                        <a href="login.html" style="color: #990000">你还未登陆！请登录</a>
                    </c:if>
                </div>
                <div class="widget widget-recent-posts">
                    <h3 class="widget-title">热门博客</h3>
                    <ul>
                        <c:forEach items="${blogs}" var="blog">
                            <li>
                                <a href="${pageContext.request.contextPath}/findBlogByIdServlet?id=${blog.blogid}">${blog.title}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="widget widget-archives">
                    <h3 class="widget-title">归档</h3>
                    <ul>
                        <li>
                            <a href="#">2017 年 5 月</a>
                        </li>
                        <li>
                            <a href="#">2017 年 4 月</a>
                        </li>
                        <li>
                            <a href="#">2017 年 3 月</a>
                        </li>
                    </ul>
                </div>

                <div class="widget widget-category">
                    <h3 class="widget-title">分类</h3>
                    <ul>
                        <li>
                            <a href="#">Django 博客教程 <span class="post-count">(13)</span></a>
                        </li>
                        <li>
                            <a href="#">Python 教程 <span class="post-count">(11)</span></a>
                        </li>
                        <li>
                            <a href="#">Django 用户认证 <span class="post-count">(8)</span></a>
                        </li>
                    </ul>
                </div>

                <div class="widget widget-tag-cloud">
                    <h3 class="widget-title">标签云</h3>
                    <ul>
                        <li>
                            <a href="#">Django</a>
                        </li>
                        <li>
                            <a href="#">Python</a>
                        </li>
                        <li>
                            <a href="#">Java</a>
                        </li>
                        <li>
                            <a href="#">笔记</a>
                        </li>
                        <li>
                            <a href="#">文档</a>
                        </li>
                        <li>
                            <a href="#">AngularJS</a>
                        </li>
                        <li>
                            <a href="#">CSS</a>
                        </li>
                        <li>
                            <a href="#">JavaScript</a>
                        </li>
                        <li>
                            <a href="#">Snippet</a>
                        </li>
                        <li>
                            <a href="#">jQuery</a>
                        </li>
                    </ul>
                </div>
                <div class="rss">
                    <a href=""><span class="ion-social-rss-outline"></span> RSS 订阅</a>
                </div>
            </aside>
        </div>
    </div>
</div>


<script src="js/script.js"></script>

</body>
</html>
