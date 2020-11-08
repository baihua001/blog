package cn.tf.blog.dao;

import cn.tf.blog.bean.Blog;
import cn.tf.blog.bean.Comment;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface BlogDao {

    /**
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from blog where isDisplay = 1")
    int findTotalCount();

    /**
     * 分页查询
     * @param start
     * @param rows
     * @return
     */
    @Select("select * from blog where isDisplay = 1 limit #{start},#{rows}")
    List<Blog> findByPage(@Param("start") int start, @Param("rows") int rows);

    /**
     * 查询最热门的3个博客
     * @param
     * @return
     */
    @Select("select * from blog where isDisplay = 1 order by readCount desc limit 0,3")
    List<Blog> findBlogByRead();

    /**
     * 通过id差博客
     * @param parseInt
     * @return
     */
    @Select("select * from blog where blogid = #{parseInt}")
    Blog findBlogById(@Param("parseInt") int parseInt);



    /**
     * 通过博客id查评论
     * @param id
     * @return
     */
    @Select("select * from comment where b_boldid = #{id}")
    List<Comment> findCommentByBlogId(@Param("id") int id);

    /**
     * 博客阅读量+1
     * @param parseInt
     */
    @Update("update blog set readCount = readCount + 1 WHERE blogid = #{blogid}")
    void blogReadcountIncrease(@Param("blogid") int parseInt);

    /**
     * 添加博客
     * @param blog
     */
    @Insert("insert into blog values(null,#{title},#{author},#{type},#{publishDataTime},#{descriptor},#{isDisplay},0,#{content})")
    void addBlog(Blog blog);

    /**
     * 查询自己的博客
     * @param author
     * @return
     */
    @Select("select * from blog where author = #{author}")
    List<Blog> findBlogByNickname(@Param("author") String author);

    /**
     * 删除博客
     * @param parseInt
     */
    @Delete("delete from blog where blogid = #{blogid}")
    void delBlogByIdServlet(@Param("blogid") int parseInt);

    /**
     * 多表查询我评论过的博客
     * @param nickname
     * @return
     */
    @Select("SELECT distinct blog.* from blog,comment where blogid = comment.b_boldid and comment.nickname = #{nickname} and isDisplay = 1" )
    List<Blog> findBlogByCommentServlet(@Param("nickname") String nickname);

    /**
     * 修改博客
     * @param blog
     */
    @Update("update blog set title = #{title},type = #{type},publishDataTime = #{publishDataTime},descriptor = #{descriptor},isDisplay = #{isDisplay},content = #{content} where blogid = #{blogid}")
    void updateBlog(Blog blog);

    /**
     * 根据收藏表查博客
     * @param user_id
     * @return
     */
    @Select("SELECT distinct blog.* from blog,favorite where blog.blogid = favorite.blogid and user_id = #{user_id} and isDisplay = 1" )
    List<Blog> findBlogByFavoriteServlet(int user_id);
}
