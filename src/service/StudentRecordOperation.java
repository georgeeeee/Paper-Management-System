package service;

import bean.DBConnect;
import bean.StudentBean;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by GeorgeYang on 2018/1/1.
 */

/**
 * 学生信息记录操作类（实现记录的增加、删除、修改功能）
 */
public class StudentRecordOperation{
    DBConnect dbConnect;

    /**
     * 构造方法，定义数据库连接对象
     */
    public StudentRecordOperation(){
        try {
            dbConnect = new DBConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *插入学生信息记录方法
     * @param studentBean 待插入学生信息记录JavaBean
     */
    public void insertRecord(StudentBean studentBean) {
        String sql = "INSERT INTO dbo.Student VALUES(?, ?, ?)";
        dbConnect.insert(sql, studentBean.getStudentId(), studentBean.getName(), studentBean.getCollege());
    }

    /**
     * 删除学生信息记录方法
     * @param studentID 待删除学生信息记录的学生ID
     */
    public void deleteRecord(String studentID) {
        String sql = "DELETE FROM dbo.Student WHERE StudentID = ?";
        try {
            dbConnect.delete(sql, studentID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改学生信息记录
     * @param studentBean 装有已修改的学生记录的JavaBean
     * @param elderStudentID 修改前的学生记录的StudentID
     */
    public void modifyRecord(StudentBean studentBean, String elderStudentID) {
        String sql = "UPDATE dbo.Student " +
                "SET " +
                "StudentID = ?, " +
                "StudentName = ?, " +
                "StudentCollege = ? " +
                "WHERE " +
                "StudentID = '" + elderStudentID + "'";
        try {
            dbConnect.modify(sql, studentBean.getStudentId(), studentBean.getName(), studentBean.getCollege());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
