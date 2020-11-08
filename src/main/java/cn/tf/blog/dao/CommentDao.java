package cn.tf.blog.dao;

import cn.tf.blog.bean.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface CommentDao {
    /**
     * 添加评论
     * @param comment
     */
    @Insert("insert into comment values(null,#{c_content}, #{c_time}, #{nickname}, #{b_blogid})")
    void addComment(Comment comment);

    /**
     * 根据id删除评论
     * @param commentid
     */
    @Delete("delete from comment where commentid = #{commentid}")
    void delCommentByIdServlet(@Param("commentid") int commentid);
}
