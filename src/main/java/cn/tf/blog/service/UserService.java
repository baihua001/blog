package cn.tf.blog.service;

import cn.tf.blog.bean.Blog;
import cn.tf.blog.bean.PageBean;
import cn.tf.blog.bean.User;

import java.util.List;

public interface UserService {
    /**
     * 注册
     * @param user
     * @return
     */
    String regist(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    String updateUser(User user);
}
