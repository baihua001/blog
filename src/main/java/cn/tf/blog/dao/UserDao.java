package cn.tf.blog.dao;


import cn.tf.blog.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface UserDao {


    /**
     * 注册用户名时排查用户名重复
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 注册保存用户信息
     * @param user
     */
    @Insert("insert into user(username,password,nickname,headPort) values(#{username},#{password},#{nickname},#{headPort})")
    void saveUser(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User findByUsernameAndPassword(User user);

    List<User> getUserList();


    /**
     * 修改用户名
     * @param user
     */
    @Update("update user set password = #{password}, nickname = #{nickname}, headPort = #{headPort} where username = #{username} ")
    void upateUser(User user);
}
