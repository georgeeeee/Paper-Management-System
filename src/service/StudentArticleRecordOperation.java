package service;

import bean.DBConnect;
import bean.StudentArticleBean;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by GeorgeYang on 2018/1/1.
 */

/**
 * 学生论文记录操作类（实现记录的增加、删除、修改功能）
 */
public class StudentArticleRecordOperation {
    /**数据库连接对象*/
    DBConnect dbConnect;

    /**
     * 构造方法，定义数据库连接对象
     */
    public StudentArticleRecordOperation() {
        try {
            dbConnect = new DBConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入学生论文记录方法
     * @param bean 待插入学生论文记录JavaBean
     */
    public void insertRecord(StudentArticleBean bean){
        String sql = "INSERT INTO dbo.StudentPaper VALUES(?, ?, ?, ?)";
        dbConnect.insert(sql, bean.getStudentId(), bean.getTitle(), bean.getContent(), bean.getPictureAddr());
        System.out.println(bean.getStudentId() + " " + bean.getTitle() + " " + bean.getContent() + " " + bean.getPictureAddr());
    }

    /**
     * 删除学生论文记录方法
     * @param title 待删除学生论文记录的论文标题
     */
    public void deleteRecord(String title){
        String sql = "DELETE FROM dbo.StudentPaper WHERE PaperTitle = ?";
        try {
            dbConnect.delete(sql, title);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改学生论文记录
     * @param bean 已修改修改学生论文记录JavaBean
     */
    public void modifyRecord(StudentArticleBean bean){
        String sql = "UPDATE dbo.StudentPaper " +
                "SET " +
                "StudentID = ?, " +
                "PaperTitle = ?, " +
                "PaperContent = ? " +
                "PicAddress = ? " +
                "WHERE " +
                "StudentID = '" + bean.getStudentId() + "'";
        try {
            dbConnect.modify(sql, bean.getStudentId(), bean.getTitle(), bean.getContent(), bean.getPictureAddr());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
