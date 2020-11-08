package cn.tf.blog.service.ServiceImpl;

import cn.tf.blog.bean.Favorite;
import cn.tf.blog.dao.FavoriteDao;
import cn.tf.blog.service.FavoriteService;
import cn.tf.blog.web.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class FavoriteServiceImpl implements FavoriteService {
    @Override
    public boolean findIsFavorite(Favorite isfavorite) {
        SqlSession session = MybatisUtils.getSqlSession();
        FavoriteDao commentDao = session.getMapper(FavoriteDao.class);
        try {
            Favorite favorite = commentDao.findIsFavorite(isfavorite);
            if (favorite != null) {
                return true;
            } else {
                return false;
            }
        } finally {
            session.close();
        }

    }

    @Override
    public void addFavorite(Favorite favorite) {
        SqlSession session = MybatisUtils.getSqlSession();
        FavoriteDao commentDao = session.getMapper(FavoriteDao.class);
        commentDao.addFavorite(favorite);
        session.close();

    }

    @Override
    public void deletFavoriteServlet(Favorite favorite) {
        SqlSession session = MybatisUtils.getSqlSession();
        FavoriteDao commentDao = session.getMapper(FavoriteDao.class);
        commentDao.deletFavoriteServlet(favorite);
        session.close();
    }
}
