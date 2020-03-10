package service;

import bean.PageBean;
import bean.StudentBean;
import bean.DBConnect;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GeorgeYang on 2017/12/27.
 */

/**
 *分页抽象类，提供部分分页方法及抽象方法
 */
public abstract class PageDividing {
    /**数据库连接对象*/
    DBConnect dbConnect;

    /**
     *构造方法，实例化数据库连接对象
     */
    public PageDividing(){
        try {
            dbConnect = new DBConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *计算用户从前台返回的页码所对应的页数，
     * 若currentPageStr为空则返回1，
     * 若不为空则返回currentPageStr的整形值
     * @param currentPageStr 用户传入的当前页码
     * @return 返回页码对应的页数
     */
    public int pageCounting(String currentPageStr){
        //如果currentPage为空，则判断出为第一页
        if (currentPageStr == null || currentPageStr.equals("")){
            return 1;
        } else {
            return Integer.parseInt(currentPageStr);
        }
    }

    /**
     * 获取待输出到页面的总记录数的方法声明，由子类具体实现
     * @return 返回记录数
     */
    public abstract int getTotalRecord();

    /**
     * 获取输出到页面的记录list的方法声明，
     * 该list装有学生信息JavaBean或学生论文信息JavaBean，
     * 由子类具体实现
     * @param page 用户传入的page对象
     * @return 返回装有学生或学生论文JavaBean的list
     */
    public abstract List getList(PageBean page);
}
