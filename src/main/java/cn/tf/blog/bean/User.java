package cn.tf.blog.bean;

public class User {
    private int user_id;
    private String username;
    private String password;
    private String nickname;
    private String headPort;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", headPort='" + headPort + '\'' +
                '}';
    }

    public String getHeadPort() {
        return headPort;
    }

    public void setHeadPort(String headPort) {
        this.headPort = headPort;
    }

    public User() {
    }

    public User(int user_id, String username, String password, String nickname, String headPort) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.headPort = headPort;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
