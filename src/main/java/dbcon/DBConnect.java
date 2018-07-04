package dbcon;

import java.sql.*;
public class DBConnect {
    private Connection conn = null;
    private Statement stmt = null;
    private String url = null;
    private String user = null;
    private String password = null;
    public Statement connect()
    {


        try {
            Class.forName("com.mysql.jdbc.Driver"); //驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("驱动失败");
        }
        url ="jdbc:mysql://localhost:3306/mydb";
        user = "root";
        password = "vincent";
        try {
            conn = (Connection) DriverManager.getConnection(url,user,password);
            stmt = (Statement) conn.createStatement();
            System.out.print("连接成功");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stmt;

    }
    public void closeDB()
    {
        try {
            if(stmt != null) {
                stmt.close();
                stmt = null;
            }
            if(conn != null) {
                conn.close();
                conn = null;
            }
        } catch(Exception e) {
            System.out.println("数据库关闭错误");
            e.printStackTrace();
        }
    }
}
