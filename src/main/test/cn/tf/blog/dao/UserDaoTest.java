package cn.tf.blog.dao;

import cn.tf.blog.bean.User;
import cn.tf.blog.web.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
//        System.out.println("阿历山大疯狂静安寺拉丁方块");
    }
}
