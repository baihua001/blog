package cn.tf.blog.service.ServiceImpl;


import cn.tf.blog.bean.User;
import cn.tf.blog.dao.UserDao;
import cn.tf.blog.service.UserService;
import cn.tf.blog.web.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;


public class UserServiceImpl implements UserService {
    //private UserDao userDao;
    @Override
    public String regist(User user) {
        SqlSession session = MybatisUtils.getSqlSession();
        UserDao dao = session.getMapper(UserDao.class);
        try {

            //查询用户名重复
            User u = dao.findByUsername(user.getUsername());
            //判断查询到没有
            if (u != null) {
                return "用户名重复！";
            }
            //没查到，保存用户信息
            dao.saveUser(user);
            return "注册成功！";
        }finally {
            session.close();
        }
    }

    @Override
    public User login(User loginUser) {
        SqlSession session = MybatisUtils.getSqlSession();
        UserDao dao = session.getMapper(UserDao.class);
        User user = dao.findByUsernameAndPassword(loginUser);
        session.close();
        return user;
    }

    @Override
    public String updateUser(User user) {
        SqlSession session = MybatisUtils.getSqlSession();
        UserDao dao = session.getMapper(UserDao.class);
        try {
            dao.upateUser(user);
            return "修改成功！";
        }finally {
            session.close();
        }
    }


}
