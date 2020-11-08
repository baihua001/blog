<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Baihua
  Date: 2020/10/23
  Time: 13:14
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
                <h1 class="page-title">修改博客</h1>
                <article class="post">
                    <div class="entry-content clearfix">
                        <form action="updateBlogServlet?blogid=${blog.blogid}" method="post" class="contact-form">
                            <div class="row">
                                <div class=".col-md-8">
                                    <input type="text" id="title" name="title" placeholder="标题" value="${blog.title}" required><br>
                                    <input type="text" id="type" name="type" placeholder="类别"  value="${blog.type}" required><br>
                                    <textarea id="descriptor" name="descriptor" rows="7" placeholder="博客简介"  required>
                                        ${blog.descriptor}
                                    </textarea><br>
                                    <textarea id="content" name="content" class="editor" rows="14" placeholder="博客内容" >${blog.content}</textarea><br>
                                    <label>是否可见：</label><br>
                                    <c:if test="${blog.isDisplay == 1}">
                                        <input style="width: 20px" type="radio" name="isDisplay" value="1" checked="checked"/>是
                                        <input style="width: 20px" type="radio" name="isDisplay" value="0" />否<br>
                                    </c:if>
                                    <c:if test="${blog.isDisplay == 0}">
                                        <input style="width: 20px" type="radio" name="isDisplay" value="1" />是
                                        <input style="width: 20px" type="radio" name="isDisplay" value="0" checked="checked"/>否<br>
                                    </c:if>
                                    <button class="btn-send btn-5 btn-5b ion-ios-paperplane" ><span>修改博客</span>
                                    </button>
                                </div>
                            </div>    <!-- row -->
                        </form>
                    </div>
                </article>
            </main>
        </div>
    </div>
</div>
<footer id="site-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p class="copyright">&copy; 2020 td.cn</p>
            </div>
        </div>
    </div>
</footer>
<script src="js/script.js"></script>
<script src="ckeditor5/build/ckeditor.js"></script>
<script>ClassicEditor


        .create( document.querySelector( '.editor' ), {

        toolbar: {
            items: [
                '|',
                'bold',
                'italic',
                'link',
                '|',
                'indent',
                'alignment',
                'outdent',
                '|',
                'imageUpload',
                'blockQuote',
                'insertTable',
                'undo',
                'redo',
                'code',
                'codeBlock',
                '|',
                'htmlEmbed',
                'fontSize',
                'fontFamily',
                'fontColor',
                'highlight',
                'removeFormat',
                'restrictedEditingException',
                'specialCharacters',
                'strikethrough',
                'subscript',
                'horizontalLine'
            ]
        },
        language: 'zh-cn',
        licenseKey: '',

    } )
    .then( editor => {
        window.editor = editor;








    } )
    .catch( error => {
        console.error( 'Oops, something went wrong!' );
        console.error( 'Please, report the following error on https://github.com/ckeditor/ckeditor5/issues with the build id and the error stack trace:' );
        console.warn( 'Build id: hgr0slbkg3wt-k2pv5y68xfno' );
        console.error( error );
    } );

</script>



</body>
</html>
