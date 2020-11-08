package cn.tf.blog.bean;

public class Favorite {
    private int favorite_id;
    private int user_id;
    private int blogid;

    @Override
    public String toString() {
        return "favorite{" +
                "favorite_id=" + favorite_id +
                ", user_id=" + user_id +
                ", blogid=" + blogid +
                '}';
    }

    public Favorite(int favorite_id, int user_id, int blogid) {
        this.favorite_id = favorite_id;
        this.user_id = user_id;
        this.blogid = blogid;
    }

    public Favorite() {
    }

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }
}
