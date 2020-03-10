package bean;

/**
 * Created by GeorgeYang on 2018/1/1.
 */

/**
 *学生论文操作权限JavaBean，继承StudentArticleBean，用于存储从数据库读取的论文数据
 */
public class StudentArticleAuthorityBean extends StudentArticleBean {
    /**是否有操作权限*/
    private boolean hasAuthority;

    /**
     * 学生论文操作权限JavaBean构造方法
     * @param studentId 学生ID
     * @param title 论文标题
     * @param content 论文内容
     * @param pictureAddr 论文封面存储地址
     */
    public StudentArticleAuthorityBean(String studentId, String title, String content, String pictureAddr) {
        super(studentId, title, content, pictureAddr);
    }

    /**
     *判断studentID对应的用户是否有该论文的操作权限
     * 将用户传入的studentID与当前论文的studentID比较
     * 若相同则将hasAuthority赋值true，否则false
     * @param studentID 用户传入的studentID
     */
    public void validateAuthority(String studentID){
        if (getStudentId().equals(studentID)){
            hasAuthority = true;
        } else {
            hasAuthority = false;
        }
    }

    public boolean isHasAuthority() {
        return hasAuthority;
    }

}
