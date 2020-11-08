<%--
  Created by IntelliJ IDEA.
  User: Baihua
  Date: 2020/10/22
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <header id="site-header">
        <div class="row">
            <div class="col-md-4 col-sm-5 col-xs-8">
                <div class="logo">
                    <h1><a href="index.html"><b>Black</b> &amp; White</a></h1>
                </div>
            </div><!-- col-md-4 -->
            <div class="col-md-8 col-sm-7 col-xs-4">
                <nav class="main-nav" role="navigation">
                    <div class="navbar-header">
                        <button type="button" id="trigger-overlay" class="navbar-toggle">
                            <span class="ion-navicon"></span>
                        </button>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="cl-effect-11"><a href="${pageContext.request.contextPath}/findBlogByPageAndreaderSeverlet" data-hover="首页">首页</a></li>
                            <li class="cl-effect-11"><a href="${pageContext.request.contextPath}/FindBlogByNicknameServlet" data-hover="我的博客">我的博客</a></li>
                            <li class="cl-effect-11"><a href="${pageContext.request.contextPath}/findBlogByCommentServlet" data-hover="评论的博客">评论的博客</a></li>
                            <li class="cl-effect-11"><a href="${pageContext.request.contextPath}/findBlogByFavoriteServlet" data-hover="收藏">收藏</a></li>
                            <li class="cl-effect-11"><a href="contact.jsp" data-hover="添加">添加</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </nav>
                <div id="header-search-box">
                    <a id="search-menu" href="#"><span id="search-icon" class="ion-ios-search-strong"></span></a>
                    <div id="search-form" class="search-form">
                        <form role="search" method="get" id="searchform" action="#">
                            <input type="search" placeholder="搜索" required>
                            <button type="submit"><span class="ion-ios-search-strong"></span></button>
                        </form>
                    </div>
                </div>
            </div><!-- col-md-8 -->
        </div>
    </header>
</div>
</body>
</html>
