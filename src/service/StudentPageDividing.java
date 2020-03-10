package service;

import bean.PageBean;
import bean.StudentBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GeorgeYang on 2018/1/1.
 */

/**
 * 学生信息分页类（实现查找功能）
 * 继承PageDividing父类，
 * 实现getList和getTotalRecord方法
 */
public class StudentPageDividing extends PageDividing{

    /**
     * 获取存储学生信息JavaBean的list的方法
     * @param page 用户传入的装有页面信息的page对象
     * @return 返回装有学生信息JavaBean的list
     */
    public List<StudentBean> getList(PageBean page){
        int recordPerPage = page.getRecordPerPage();
        int currentPage = page.getCurrentPage();
        List<StudentBean> stuList = new ArrayList<>();

        try{
            String sql = "Select top " + recordPerPage + " * " +
                    "From dbo.Student " +
                    "Where StudentID not IN " +
                    "(Select top " + (currentPage - 1) * recordPerPage + " StudentID From dbo.Student)";
            ResultSet rs = dbConnect.query(sql);
            while(rs.next()){
                String stuID = rs.getString(1);
                String stuName = rs.getString(2);
                String stuCollege = rs.getString(3);
                StudentBean stu = new StudentBean(stuID, stuName, stuCollege);
                stuList.add(stu);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stuList;
    }

    /**
     * 获取存储在数据库的学生信息记录总数的方法
     * @return 学生信息记录总数
     */
    public int getTotalRecord(){
        int recordNum = 0;
        try{
            String sql = "Select count(*) FROM dbo.Student";
            ResultSet rs = dbConnect.query(sql);
            while(rs.next()){
                recordNum = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordNum;
    }
}
