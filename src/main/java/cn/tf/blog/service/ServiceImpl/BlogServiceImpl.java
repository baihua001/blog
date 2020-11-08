package cn.tf.blog.service.ServiceImpl;

import cn.tf.blog.bean.Blog;
import cn.tf.blog.bean.Comment;
import cn.tf.blog.bean.PageBean;
import cn.tf.blog.dao.BlogDao;
import cn.tf.blog.service.BlogService;
import cn.tf.blog.web.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    private MybatisUtils mybatisUtils = new MybatisUtils();


    @Override
    public PageBean<Blog> findBlogByPage(String _currentPage, String _rows) {
        SqlSession session = mybatisUtils.getSqlSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        try {
            int currentPage = Integer.parseInt(_currentPage);
            int rows = Integer.parseInt(_rows);

            //创建空的PageBean对象
            PageBean<Blog> pb = new PageBean<Blog>();
            //传入参数
            pb.setCurrentPage(currentPage);
            pb.setRows(rows);
            //查询总记录数
            int totalCount = blogDao.findTotalCount();
            pb.setTotalCount(totalCount);
            //查询Blog数据
            int start = (currentPage - 1) * rows;
            List<Blog> list = blogDao.findByPage(start, rows);
            pb.setList(list);
            //计算总页码
            int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
            pb.setTotalPage(totalPage);
            return pb;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Blog> findBlogByRead() {
        SqlSession session = mybatisUtils.getSqlSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        try {
            return blogDao.findBlogByRead();
        }finally {
            session.close();
        }
    }

    @Override
    public Blog findBlogById(String id) {
        SqlSession session = mybatisUtils.getSqlSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        try {
            blogDao.blogReadcountIncrease(Integer.parseInt(id));
            return blogDao.findBlogById(Integer.parseInt(id));
        }finally {
            session.close();
        }
    }

    @Override
    public List<Comment> findCommentByBlogId(String id) {
        SqlSession session = mybatisUtils.getSqlSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        try {
            return blogDao.findCommentByBlogId(Integer.parseInt(id));
        }finally {
            session.close();
        }
    }

    @Override
    public void addBlog(Blog blog) {
        SqlSession session = mybatisUtils.getSqlSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        blogDao.addBlog(blog);
        session.close();
    }

    @Override
    public List<Blog> findBlogByNickname(String author) {
        SqlSession session = mybatisUtils.getSqlSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        try {
            return blogDao.findBlogByNickname(author);
        }finally {
            session.close();
        }
    }

    @Override
    public void delBlogByIdServlet(String id) {
        SqlSession session = mybatisUtils.getSqlSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        blogDao.delBlogByIdServlet(Integer.parseInt(id));
        session.close();
    }

    @Override
    public List<Blog> findBlogByCommentServlet(String nickname) {
        SqlSession session = mybatisUtils.getSqlSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        try {
            return blogDao.findBlogByCommentServlet(nickname);
        }finally {
            session.close();
        }
    }

    @Override
    public void updateBlog(Blog blog) {
        SqlSession session = mybatisUtils.getSqlSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        blogDao.updateBlog(blog);
        session.close();
    }

    @Override
    public List<Blog> findBlogByFavoriteServlet(int user_id) {
        SqlSession session = mybatisUtils.getSqlSession();
        BlogDao blogDao = session.getMapper(BlogDao.class);
        try {
            return blogDao.findBlogByFavoriteServlet(user_id);
        }finally {
            session.close();
        }

    }


}
