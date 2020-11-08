package cn.tf.blog.dao;

import cn.tf.blog.bean.Favorite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface FavoriteDao {
    /**
     * 根据用户id何博客id确认是否收藏
     * @param isfavorite
     * @return
     */
    @Select("select * from favorite where user_id = #{user_id} and blogid = #{blogid}")
    Favorite findIsFavorite(Favorite isfavorite);

    /**
     * 添加收藏记录
     * @param favorite
     */
    @Insert("insert into favorite(user_id,blogid) values(#{user_id},#{blogid})")
    void addFavorite(Favorite favorite);

    /**
     * 删除收藏
     * @param favorite
     */
    @Delete("delete from favorite where user_id = #{user_id} and blogid = #{blogid}")
    void deletFavoriteServlet(Favorite favorite);
}
