package service;

import bean.DBConnect;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GeorgeYang on 2018/1/1.
 */

/**
 *用户登陆操作类，提供用户登陆所需的业务方法
 */
public class Login {
    /**数据库连接对象*/
    private DBConnect dbConnect;

    /**
     * 构造方法，实例化数据库连接对象
     */
    public Login(){
        try {
            dbConnect = new DBConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *通过studentID从数据库获取password
     * @param studentID 学生ID
     * @return 学生ID对应的密码，若无法获取则返回null
     */
    public String getPassword(String studentID){
        String sql = "SELECT password FROM dbo.Account WHERE StudentID = '" + studentID +"'";
        String password = null;
        try {
            ResultSet rs = dbConnect.query(sql);
            while (rs.next()){
                password = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }
}
