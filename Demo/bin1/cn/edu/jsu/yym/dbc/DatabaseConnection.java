package cn.edu.jsu.yym.dbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	//定义MySQL数据库驱动程序
	private static final String DBRIVER="com.mysql.jdbc.Driver";
	//定义MySQL数据库连接地址，text是自己的数据库名称
	private static final String DBURL="jdbc:mysql://localhost:3306/test";
	private static final String DBUSER="root"; //MySQL数据库连接用户名
	private static final String PASSWORD="123"; //MySQL数据库连接密码
	private Connection conn=null; //保存连接对象
	public DatabaseConnection() {//构造方法连接数据库
		try {
			Class.forName(DBRIVER);
			System.out.println("加载驱动成功");
			this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
			System.out.println("链接成功！！！！！");
		} catch (Exception e) {e.printStackTrace();}
	}
	public Connection getConnection() {//返回数据库连接对象
		return this.conn;
	}
	public void close() {//关闭数据连接
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
