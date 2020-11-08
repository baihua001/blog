package cn.tf.blog.web.servlet;

import cn.tf.blog.service.CommentService;
import cn.tf.blog.service.ServiceImpl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delCommentByIdServlet")
public class DelCommentByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String Commentid = request.getParameter("commentid");
        String blogid = request.getParameter("blogid");

        //调用service删除
        CommentService service = new CommentServiceImpl();
        service.delCommentByIdServlet(Commentid);
        //跳转回本页面
        response.sendRedirect(request.getContextPath()+"/findBlogByIdServlet?id="+blogid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
