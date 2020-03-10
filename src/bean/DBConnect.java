package bean;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by GeorgeYang on 2017/12/5.
 */

/**
 *数据库连接类，负责数据库的连接以及调用增删改查的sql语句的操作
 */
public class DBConnect {
    private Connection conn;
    private String driver;
    private String url;
    private String username;
    private String password;

    /**
     *构造方法，从配置文件读取数据库连接参数
     * @throws IOException 可能抛出IO异常
     */
    public DBConnect() throws IOException {
        Properties prop = new Properties();
        InputStream sqlConfigFile = DBConnect.class.getResourceAsStream("/sql-config.properties");
        prop.load(sqlConfigFile);
        driver = prop.getProperty("driver");
        url = prop.getProperty("url");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
    }

    /**
     *数据库连接方法，通过反射获取驱动并连接对应的数据库
     * @return connection对象
     */
    public Connection getConnection() {
        try {
            if (conn == null) {
                Class.forName(this.driver);
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("数据库连接成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return conn;
        }
    }

    /**
     *插入方法，负责调用用户传入的sql语句和参数执行插入操作以及将参数传入sql的占位符中
     * @param sql 用户传入的sql语句
     * @param args 用户传入的参数
     * @return 返回一个布尔值，若该方法执行成功返回true，若prepareStatement无法执行则返回法false
     */
    public boolean insert(String sql, Object... args) {
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i + 1, args[i]);
            }
            if (pstmt.executeUpdate() != 1) {
                return false;
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return true;
        }
    }

    /**
     *查询方法，负责调用用户传入的sql语句和参数执行有参查询操作以及将参数传入sql的占位符中
     * @param sql 用户传入的sql语句
     * @param args 用户传入的参数
     * @return 返回一个ResultSet对象，用户可以通过调用getObject方法获取参数
     * @throws SQLException 可能抛出SQL异常
     */
    public ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt.executeQuery();
    }

    /**
     *查询方法，负责调用用户传入的sql语句执行无参查询操作
     * @param sql 用户传入的sql语句
     * @return 返回一个ResultSet对象，用户可以通过调用getObject方法获取参数
     * @throws SQLException 可能抛出SQL异常
     */
    public ResultSet query(String sql) throws SQLException {
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        return pstmt.executeQuery();
    }

    /**
     *修改方法，负责调用用户传入的sql语句和参数执行记录修改操作以及将参数传入sql的占位符中
     * @param sql 用户传入的sql语句
     * @param args 用户传入的参数
     * @throws SQLException 可能抛出SQL异常
     */
    public void modify(String sql, Object... args) throws SQLException {
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        pstmt.executeUpdate();
        pstmt.close();
    }

    /**
     *删除方法，负责调用用户传入的sql语句和参数执行记录删除操作以及将参数传入sql的占位符中
     * @param sql 用户传入的sql语句
     * @param args 用户传入的参数
     * @throws SQLException 可能抛出SQL异常
     */
    public void delete(String sql, Object... args) throws SQLException {
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        pstmt.executeUpdate();
        System.out.println("删除记录成功");
    }

    /**
     *当connection对象不为空且未关闭时，关闭数据库连接
     * @throws SQLException 可能抛出SQL异常
     */
    public void closeConn() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
