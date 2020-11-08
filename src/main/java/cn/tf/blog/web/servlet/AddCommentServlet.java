package cn.tf.blog.web.servlet;

import cn.tf.blog.bean.Comment;
import cn.tf.blog.bean.User;
import cn.tf.blog.service.CommentService;
import cn.tf.blog.service.ServiceImpl.CommentServiceImpl;
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

@WebServlet("/addCommentServlet")
public class AddCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        String content = request.getParameter("comment");//评论内容
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String time = sdf.format(date); //日期
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String author = user.getNickname();//作者
        String bolgid = request.getParameter("id");

        //封装
        Comment comment = new Comment();
        try {
            BeanUtils.copyProperty(comment,"c_content",content);
            BeanUtils.copyProperty(comment,"c_time",time);
            BeanUtils.copyProperty(comment,"nickname",author);
            BeanUtils.copyProperty(comment,"b_blogid",bolgid);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(comment);
        //service进行添加
        CommentService service = new CommentServiceImpl();
        service.addComment(comment);
        //页面跳转
        response.sendRedirect(request.getContextPath()+"/findBlogByIdServlet?id="+bolgid);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
