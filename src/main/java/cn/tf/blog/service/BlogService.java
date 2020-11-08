package cn.tf.blog.service;

import cn.tf.blog.bean.Blog;
import cn.tf.blog.bean.Comment;
import cn.tf.blog.bean.PageBean;

import java.util.List;

public interface BlogService {
    /**
     * 根据分页进行查询
     * @param currentPage
     * @param rows
     * @return
     */
    PageBean<Blog> findBlogByPage(String currentPage, String rows);

    /**
     * 查询三个热门博客
     * @param
     * @return
     */
    List<Blog> findBlogByRead();

    /**
     * 通过id查询博客
     * @param id
     * @return
     */
    Blog findBlogById(String id);



    /**
     * 通过博客id查询评论
     * @param id
     * @return
     */
    List<Comment> findCommentByBlogId(String id);

    /**
     * 添加博客
     * @param blog
     */
    void addBlog(Blog blog);

    /**
     * 通过作者找评论
     * @param author
     * @return
     */
    List<Blog> findBlogByNickname(String author);

    /**
     * 根据id删除博客
     * @param id
     */
    void delBlogByIdServlet(String id);

    /**
     * 查询我评论过的博客
     * @param nickname
     * @return
     */
    List<Blog> findBlogByCommentServlet(String nickname);


    /**
     * 修改博客
     * @param blog
     */
    void updateBlog(Blog blog);

    /**
     * 根据我的收藏查博客
     * @param user_id
     * @return
     */
    List<Blog> findBlogByFavoriteServlet(int user_id);
}
