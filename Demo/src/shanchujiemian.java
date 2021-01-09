import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import cn.edu.jsu.yym.dbc.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class shanchujiemian extends JFrame {

	private JPanel contentPane;
	private JTextField xuehao;
	private JTextField xingming;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shanchujiemian frame = new shanchujiemian();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public shanchujiemian() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=418489394,2180262587&fm=26&gp=0.jpg"));
		setTitle("\u5220\u9664\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 615, 308);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u9700\u8981\u5220\u9664\u7684\u5B66\u751F\u7F16\u53F7");
		lblNewLabel.setBounds(24, 60, 198, 28);
		contentPane.add(lblNewLabel);
		
		xuehao = new JTextField();
		xuehao.setBounds(236, 62, 216, 24);
		contentPane.add(xuehao);
		xuehao.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String xm=xingming.getText();
				String xh=xuehao.getText();
				if(checkstudent(xm, xh)==true) {
					delete(xh, xm);										
					JOptionPane.showMessageDialog(null, "删除成功");
					xingming.setText("");
					xuehao.setText("");
					xuehao.requestFocus();
				}
				else {
					JOptionPane.showMessageDialog(null, "删除失败，学号或姓名错误！");
					xuehao.requestFocus();
					xuehao.selectAll();
				}
			}
		});
		btnNewButton.setBounds(464, 61, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(415, 190, 113, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(44, 190, 113, 27);
		contentPane.add(btnNewButton_1);
		
		xingming = new JTextField();
		xingming.setBounds(110, 101, 91, 24);
		contentPane.add(xingming);
		xingming.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setBounds(24, 101, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("\u6E05\u7A7A");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuehao.setText("");
				xingming.setText("");
			}
		});
		btnNewButton_3.setBounds(214, 190, 135, 27);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\src=http___bpic.588ku.com_element_origin_min_pic_00_92_85_4456f23be8baf9c.jpg&refer=http___bpic.588ku.jfif"));
		lblNewLabel_2.setBounds(0, 185, 36, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=312177448,2700702957&fm=26&gp=0.jpg"));
		lblNewLabel_3.setBounds(384, 185, 25, 36);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=3017215024,630383570&fm=26&gp=0.jpg"));
		lblNewLabel_4.setBounds(464, 24, 36, 36);
		contentPane.add(lblNewLabel_4);
	}
	public static void delete(String xh,String xm) {
		DatabaseConnection dbcs2=new DatabaseConnection();//使用打分界面中定义的连接数据库的类
		String sql2="delete from student where xm='" + xm + "' and xh='" + xh + "'";
		Connection conn=(Connection) dbcs2.getConnection();
		try {
			Statement slh2=(Statement) conn.createStatement();//实例化PreparedStatement
			slh2.executeLargeUpdate(sql2);
		}catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static boolean checkstudent(String xm,String xh) {
		DatabaseConnection dbcs2=new DatabaseConnection();
		String sql2="select xm,xh from student";
		try(Connection conn=(Connection) dbcs2.getConnection();//获取数据库
				PreparedStatement slh2=(PreparedStatement) conn.prepareStatement(sql2);){
					ResultSet sc=slh2.executeQuery();
					while(sc.next()) {
						if((xm.compareTo(sc.getString(1))==0)&&(xh.compareTo(sc.getString(2))==0))
							return true;
					}
				}catch (SQLException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				return false;
	}
	
	
	
	
}