package cn.tf.blog.service;

import cn.tf.blog.bean.Comment;

public interface CommentService {
    /**
     * 添加评论
     * @param comment
     */
    void addComment(Comment comment);

    /**
     * 根据评论id删除评论
     * @param commentid
     */
    void delCommentByIdServlet(String commentid);
}
