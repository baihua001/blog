package cn.tf.blog.service.ServiceImpl;

import cn.tf.blog.bean.Comment;
import cn.tf.blog.dao.CommentDao;
import cn.tf.blog.service.CommentService;
import cn.tf.blog.web.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class CommentServiceImpl implements CommentService {
    private MybatisUtils mybatisUtils = new MybatisUtils();
    private SqlSession session = mybatisUtils.getSqlSession();
    private CommentDao commentDao = session.getMapper(CommentDao.class);

    @Override
    public void addComment(Comment comment) {
        commentDao.addComment(comment);
        session.close();
    }

    @Override
    public void delCommentByIdServlet(String commentid) {
        commentDao.delCommentByIdServlet(Integer.parseInt(commentid));
        session.close();
    }
}
