package cn.tf.blog.web.servlet;

import cn.tf.blog.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int data = 0;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //相应结果
        if (user != null){
            data = 1;
        }
        PrintWriter out = response.getWriter();
        out.print(data);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
