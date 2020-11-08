package cn.tf.blog.service;

import cn.tf.blog.bean.Favorite;

public interface FavoriteService {
    /**
     * 查询是否收藏，收藏返回1，没有返回0
     * @param favorite
     * @return
     */
    boolean findIsFavorite(Favorite favorite);

    /**
     * 添加收藏记录
     * @param favorite
     */
    void addFavorite(Favorite favorite);

    /**
     * 删除收藏记录
     * @param favorite
     */
    void deletFavoriteServlet(Favorite favorite);
}
