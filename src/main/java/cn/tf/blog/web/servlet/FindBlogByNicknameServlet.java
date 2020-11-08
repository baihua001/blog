package cn.tf.blog.web.servlet;

import cn.tf.blog.bean.Blog;
import cn.tf.blog.bean.User;
import cn.tf.blog.service.BlogService;
import cn.tf.blog.service.ServiceImpl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/FindBlogByNicknameServlet")
public class FindBlogByNicknameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取参数
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String author = user.getNickname();
        //service进行查询
        BlogService service = new BlogServiceImpl();
        List<Blog> blogs = service.findBlogByNickname(author);
        //存入request
        request.setAttribute("blogs",blogs);
        //转发打jsp
        request.getRequestDispatcher("/full-width.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
