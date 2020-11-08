package cn.tf.blog.web.servlet;

import cn.tf.blog.bean.User;
import cn.tf.blog.service.ServiceImpl.UserServiceImpl;
import cn.tf.blog.service.UserService;
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
import java.util.Map;

@WebServlet("/loginUserServlet")
public class LoginUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //获取数据
        Map<String, String[]> map = request.getParameterMap();
        //封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用service进行登录查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);

        //判断登陆是否成功
        String result;
        HttpSession session = request.getSession();
        if (loginUser != null){
            //成功
            //存入session
            session.setAttribute("user",loginUser);
            result = "登陆成功！";
        }else {
            //失败
            result = "用户名或密码错误！";
        }
        //相应结果
        PrintWriter out = response.getWriter();
        out.write(result);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
