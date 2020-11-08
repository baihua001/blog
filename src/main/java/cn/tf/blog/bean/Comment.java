package cn.tf.blog.bean;

public class Comment {
    private int commentid;
    private String c_content;
    private String c_time;
    private String nickname;
    private int b_blogid;

    public Comment(int commentid, String c_content, String c_time, String nickname, int b_blogid) {
        this.commentid = commentid;
        this.c_content = c_content;
        this.c_time = c_time;
        this.nickname = nickname;
        this.b_blogid = b_blogid;
    }

    public Comment() {
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getB_blogid() {
        return b_blogid;
    }

    public void setB_blogid(int b_blogid) {
        this.b_blogid = b_blogid;
    }
}
