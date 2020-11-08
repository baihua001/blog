package cn.tf.blog.web.servlet;

import cn.tf.blog.bean.Blog;
import cn.tf.blog.bean.User;
import cn.tf.blog.service.BlogService;
import cn.tf.blog.service.ServiceImpl.BlogServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/addBlogServlet")
public class AddBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        //获取参数
        Map<String, String[]> map = request.getParameterMap();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user"); //作者
        String author = user.getNickname();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String publishDataTime = sdf.format(date); //日期
        //封装
        Blog blog = new Blog();
        try {
            BeanUtils.populate(blog, map);
            BeanUtils.copyProperty(blog,"author",author);
            BeanUtils.copyProperty(blog,"publishDataTime",publishDataTime);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //保存
        System.out.println("-----------------------------------------------"+blog);
        BlogService service = new BlogServiceImpl();
        service.addBlog(blog);

        //跳转
        response.sendRedirect(request.getContextPath()+"/findBlogByPageAndreaderSeverlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
