package cn.tf.blog.bean;

public class Blog {
    private int blogid;
    private String title;
    private String author;
    private String type;
    private String publishDataTime;
    private String descriptor;
    private int isDisplay;
    private String readCount;
    private String content;

    public Blog(int blogid, String title, String author, String type, String publishDataTime, String descriptor, int isDisplay, String readCount, String content) {
        this.blogid = blogid;
        this.title = title;
        this.author = author;
        this.type = type;
        this.publishDataTime = publishDataTime;
        this.descriptor = descriptor;
        this.isDisplay = isDisplay;
        this.readCount = readCount;
        this.content = content;
    }

    public Blog() {
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogid=" + blogid +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", publishDataTime='" + publishDataTime + '\'' +
                ", descriptor='" + descriptor + '\'' +
                ", isDisplay=" + isDisplay +
                ", readCount='" + readCount + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublishDataTime() {
        return publishDataTime;
    }

    public void setPublishDataTime(String publishDataTime) {
        this.publishDataTime = publishDataTime;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public int getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(int isDisplay) {
        this.isDisplay = isDisplay;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }


}
