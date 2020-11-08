package cn.tf.blog.web.servlet;

import cn.tf.blog.bean.Blog;
import cn.tf.blog.bean.Comment;
import cn.tf.blog.bean.Favorite;
import cn.tf.blog.bean.User;
import cn.tf.blog.service.BlogService;
import cn.tf.blog.service.FavoriteService;
import cn.tf.blog.service.ServiceImpl.BlogServiceImpl;
import cn.tf.blog.service.ServiceImpl.FavoriteServiceImpl;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/findBlogByIdServlet")
public class FindBlogByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        //获取id
        String id = request.getParameter("id");
        //查询博客内容和评论
        BlogService service = new BlogServiceImpl();
        Blog blog = service.findBlogById(id);
        List<Comment> comments = service.findCommentByBlogId(id);
        List<Blog> blogs = service.findBlogByRead();
        //将获取数据存入requset
        request.setAttribute("blog", blog);
        request.setAttribute("comment", comments);
        request.setAttribute("blogs", blogs);


        //转发
        request.getRequestDispatcher("/single.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
