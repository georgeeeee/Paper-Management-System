package bean;

/**
 * Created by GeorgeYang on 2017/12/26.
 */

/**
 *学生信息JavaBean
 */
public class StudentBean {
    /**学生ID*/
    private String studentId;
    /**学生姓名*/
    private String name;
    /**学生所在学院*/
    private String college;

    /**
     * 学生信息JavaBean构造方法
     * @param studentId 学生ID
     * @param name 学生姓名
     * @param college 学生所在学院
     */
    public StudentBean(String studentId, String name, String college) {
        this.studentId = studentId;
        this.name = name;
        this.college = college;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


}
