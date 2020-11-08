package cn.tf.blog.web.servlet;

import cn.tf.blog.bean.Blog;
import cn.tf.blog.service.BlogService;
import cn.tf.blog.service.ServiceImpl.BlogServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/updateBlogServlet")
public class UpdateBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        Map<String, String[]> map = request.getParameterMap();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String publishDataTime = sdf.format(date); //日期
        //封装对象
        Blog blog = new Blog();
        try {
            BeanUtils.populate(blog,map);
            BeanUtils.copyProperty(blog,"publishDataTime",publishDataTime);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(blog);
        //service进行修改
        BlogService service = new BlogServiceImpl();
        service.updateBlog(blog);

        //跳转页面
        response.sendRedirect(request.getContextPath()+"/findBlogByIdServlet?id="+blog.getBlogid());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
