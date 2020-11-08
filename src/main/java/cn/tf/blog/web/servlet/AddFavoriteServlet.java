package cn.tf.blog.web.servlet;

import cn.tf.blog.bean.Favorite;
import cn.tf.blog.bean.User;
import cn.tf.blog.service.FavoriteService;
import cn.tf.blog.service.ServiceImpl.FavoriteServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/addFavoriteServlet")
public class AddFavoriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        //获取参数
        String blogid = request.getParameter("blogid");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int user_id = user.getUser_id();
        //封装参数
        Favorite favorite = new Favorite();
        try {
            BeanUtils.copyProperty(favorite,"blogid",blogid);
            BeanUtils.copyProperty(favorite,"user_id",user_id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //将参数传入service处理
        FavoriteService service = new FavoriteServiceImpl();
        service.addFavorite(favorite);

        String result = "收藏成功！";
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
