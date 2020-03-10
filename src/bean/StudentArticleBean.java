package bean;

/**
 * Created by GeorgeYang on 2017/12/26.
 */

/**
 * 学生论文信息JavaBean
 */
public class StudentArticleBean {
    /**学生ID*/
    private String studentId;
    /**论文标题*/
    private String title;
    /**论文内容*/
    private String content;
    /**论文封面存储地址，存储位置为本地*/
    private String pictureAddr;

    /**
     * 学生论文信息JavaBean构造方法
     * @param studentId 学生ID
     * @param title 论文标题
     * @param content 论文内容
     * @param pictureAddr 论文封面存储地址
     */
    public StudentArticleBean(String studentId, String title, String content, String pictureAddr) {
        this.studentId = studentId;
        this.title = title;
        this.content = content;
        this.pictureAddr = pictureAddr;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPictureAddr() {
        return pictureAddr;
    }

    public void setPictureAddr(String picture) {
        this.pictureAddr = pictureAddr;
    }
}
