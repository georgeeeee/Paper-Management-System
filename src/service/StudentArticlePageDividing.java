package service;

import bean.PageBean;
import bean.StudentArticleAuthorityBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GeorgeYang on 2018/1/1.
 */

/**
 * 学生论文记录分页类（实现记录的查找功能）
 * 继承PageDividing父类，
 * 实现getList和getTotalRecord方法
 */
public class StudentArticlePageDividing extends PageDividing{
    /**当前登陆学生的ID*/
    private String loginStudentID;

    /**构造函数*/
    public StudentArticlePageDividing(String loginStudentID){
        this.loginStudentID = loginStudentID;
    }

    /**
     * 获取存储学生论文JavaBean的list的方法
     * @param page 用户传入的装有页面信息的page对象
     * @return 返回装有学生论文JavaBean的list
     */
    public List<StudentArticleAuthorityBean> getList(PageBean page){
        int recordPerPage = page.getRecordPerPage();
        int currentPage = page.getCurrentPage();
        List<StudentArticleAuthorityBean> stuArticleList = new ArrayList<>();

        try{
            /**
             * @param sql 获取前n条数据，n为（当前页数-1）* 每页记录数上限
             */
            String sql = "Select top " + recordPerPage + " * " +
                    "From dbo.StudentPaper " +
                    "Where StudentID not IN " +
                    "(Select top " + (currentPage - 1) * recordPerPage + " StudentID From dbo.StudentPaper)";
            ResultSet rs = dbConnect.query(sql);
            while(rs.next()){
                String stuID = rs.getString(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String picAddress = rs.getString(5);
                StudentArticleAuthorityBean stuArticle = new StudentArticleAuthorityBean(stuID, title, content, picAddress);
                stuArticleList.add(stuArticle);
            }

            for (StudentArticleAuthorityBean bean : stuArticleList) {
                bean.validateAuthority(loginStudentID);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stuArticleList;
    }

    /**
     * 获取存储在数据库的学生论文记录总数的方法
     * @return 学生论文记录总数
     */
    public int getTotalRecord(){
        int recordNum = 0;
        try{
            String sql = "Select count(*) FROM dbo.StudentPaper";
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
