package cn.edu.jsu.yym.dbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	//����MySQL���ݿ���������
	private static final String DBRIVER="com.mysql.jdbc.Driver";
	//����MySQL���ݿ����ӵ�ַ��text���Լ������ݿ�����
	private static final String DBURL="jdbc:mysql://localhost:3306/test";
	private static final String DBUSER="root"; //MySQL���ݿ������û���
	private static final String PASSWORD="123"; //MySQL���ݿ���������
	private Connection conn=null; //�������Ӷ���
	public DatabaseConnection() {//���췽���������ݿ�
		try {
			Class.forName(DBRIVER);
			System.out.println("���������ɹ�");
			this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
			System.out.println("���ӳɹ�����������");
		} catch (Exception e) {e.printStackTrace();}
	}
	public Connection getConnection() {//�������ݿ����Ӷ���
		return this.conn;
	}
	public void close() {//�ر���������
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
