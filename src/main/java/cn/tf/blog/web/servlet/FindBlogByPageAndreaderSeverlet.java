package cn.tf.blog.web.servlet;

import cn.tf.blog.bean.Blog;
import cn.tf.blog.bean.PageBean;
import cn.tf.blog.service.BlogService;
import cn.tf.blog.service.ServiceImpl.BlogServiceImpl;
import cn.tf.blog.service.ServiceImpl.UserServiceImpl;
import cn.tf.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findBlogByPageAndreaderSeverlet")
public class FindBlogByPageAndreaderSeverlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取页码
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "4";
        }

        //传递参数  设置编码  ****不需要
        //进行查询
        BlogService service = new BlogServiceImpl();
        PageBean<Blog> pb = service.findBlogByPage(currentPage,rows);//根据分页查询
        List<Blog> blogs = service.findBlogByRead();                 //查询三个热门
        //将查询到的数据存入requset

        request.setAttribute("pb",pb);
        request.setAttribute("blogs",blogs);


        //转发到index.jsp
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
