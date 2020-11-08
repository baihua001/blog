<%--
  Created by IntelliJ IDEA.
  User: Baihua
  Date: 2020/10/22
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Black &amp; White</title>

    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="css/pace.css">
    <link rel="stylesheet" href="css/custom.css">

    <!-- js -->
    <script src="js/jquery-2.1.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/pace.min.js"></script>
    <script src="js/modernizr.custom.js"></script>
    <script>
        function deleterComment(commentid) {
            if (confirm("确定删除？")) {
                location.href = "${pageContext.request.contextPath}/delCommentByIdServlet?blogid=${blog.blogid}&commentid=" + commentid;
            }
        }

        function deleterBlog() {
            if (confirm("确定删除？")) {
                location.href = "${pageContext.request.contextPath}/delBlogByIdServlet?id=${blog.blogid}";
            }
        }
    </script>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="content-body">
    <div class="container">
        <div class="row">
            <main class="col-md-8">
                <article class="post post-1">
                    <header class="entry-header">
                        <h1 class="entry-title">${blog.title}
                            <a type="button" class="btn btn-default btn-xs" onclick="addFavorite();">
                                <span id="favorite" class="glyphicon glyphicon-star-empty"></span>收藏
                                <%--                                <span class="glyphicon glyphicon-star"></span>--%>
                            </a>
                            <div class="entry-meta">
                                <span class="post-category"><a href="#">${blog.type}</a></span>
                                <span class="post-date"><a href="#"><time class="entry-date"
                                                                          datetime="2012-11-09T23:15:57+00:00">2017年5月11日</time></a></span>
                                <span class="post-author"><a href="#">${blog.author}</a></span>

                                <span class="views-count"><a href="#">${blog.readCount} 阅读</a></span>
                            </div>
                    </header>
                    <div class="entry-content clearfix">
                        <p>
                            ${blog.content}
                        </p>
                    </div>
                    <c:if test="${user.nickname == blog.author}">
                        <a href=javascript:deleterBlog()>删除</a>
                        <a href="${pageContext.request.contextPath}/findBlogToUpdateServlet?id=${blog.blogid}">修改</a>
                    </c:if>
                </article>
                <section class="comment-area" id="comment-area">
                    <hr>
                    <h3>发表评论</h3>
                    <form action="${pageContext.request.contextPath}/addCommentServlet?id=${blog.blogid}" method="post"
                          class="comment-form">
                        <div class="row">
                            <div class="col-md-12">
                                <label for="id_comment">评论：</label>
                                <textarea name="comment" id="id_comment" required></textarea>
                                <button type="submit" class="comment-btn">发表</button>
                            </div>
                        </div>    <!-- row -->
                    </form>
                    <div class="comment-list-panel">
                        <h3>评论列表，共 <span>${comment.size()}</span> 条评论</h3>
                        <ul class="comment-list list-unstyled">
                            <c:forEach items="${comment}" var="c">
                            <li class="comment-item">
                                <span class="nickname">${c.nickname}</span>
                                <time class="submit-date" datetime="2012-11-09T23:15:57+00:00">${c.c_time}</time>
                                <div class="text">
                                        ${c.c_content}
                                </div>
                                <c:if test="${user.nickname == c.nickname}">
                                    <a href=javascript:deleterComment(${c.commentid})>删除</a>
                                </c:if>
                                </c:forEach>
                            </li>
                        </ul>
                    </div>
                </section>
            </main>
            <aside class="col-md-4">
                <div class="widget widget-content">
                    <h3 class="widget-title">文章目录</h3>
                    <ul>
                        <li>
                            <a href="#">教程特点</a>
                        </li>
                        <li>
                            <a href="#">谁适合这个教程</a>
                        </li>
                        <li>
                            <a href="#">在线预览</a>
                        </li>
                        <li>
                            <a href="#">资源列表</a>
                        </li>
                        <li>
                            <a href="#">获取帮助</a>
                        </li>
                    </ul>
                </div>
                <div class="widget widget-archives">
                    <c:if test="${user!=null}">
                        <img src="${user.headPort}" width="150px" height="150px"/><br>
                        <ul>
                            <li>
                                <a href="#" style="text-decoration:underline ;color:dodgerblue">${user.nickname}</a><br>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/logOutServlet"
                                   style="text-decoration:underline ;color:dodgerblue">退出登录</a>
                            </li>
                        </ul>
                    </c:if>
                    <c:if test="${user==null}">
                        <a href="login.html">你还未登陆！</a>
                    </c:if>
                </div>
                <div class="widget widget-recent-posts">
                    <h3 class="widget-title">热门文章</h3>
                    <ul>
                        <c:forEach items="${blogs}" var="blogs">
                            <li>
                                <a href="${pageContext.request.contextPath}/findBlogByIdServlet?id=${blogs.blogid}">${blogs.title}</a>
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

<script>
    //页面加载前查询本博客是否收藏
    var isFavorite = 0;
    var blogid = ${blog.blogid};
    $(function () {

        //发送请求判断是否收藏
        $.get("isFavoriteServlet", {blogid: blogid}, function (flag) {
            if (flag == "true") {
                //收藏了
                $("#favorite").removeClass("glyphicon-star-empty").addClass("glyphicon-star");
                isFavorite = 1;
            } else {
                //没收藏
            }
        })

    })

    function addFavorite() {
        //判断是否登录
        $.get("findUserServlet", {}, function (data) {
            if (data == 1) {
                //登陆了
                //判断是否收藏
                if (isFavorite == 0) {
                    //没收藏
                    $.get("addFavoriteServlet", {blogid, blogid}, function (data) {
                        //刷新页面
                        alert(data);
                        location.reload();
                    })
                } else {
                    //收藏了
                    if (confirm("确定取消收藏？")) {
                        $.get("deletFavoriteServlet", {blogid, blogid}, function () {
                            //刷新页面
                            location.reload();
                        })
                    }
                }
            } else {
                //没登陆
                alert("您尚未登录，请登录");
                location.href = "login.html";
            }
        })
    }


</script>
<script src="js/script.js"></script>

</body>
</html>
