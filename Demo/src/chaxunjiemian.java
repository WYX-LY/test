import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import cn.edu.jsu.yym.dbc.DatabaseConnection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.SocketOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class chaxunjiemian extends JFrame {

	private JPanel contentPane;
	private JTextField xuehao;
	private JTextField xingming;
	private JTextField mean;
	private JButton btnNewButton_1;
	private JTextField cp1;
	private JTextField cp2;
	private JTextField cp3;
	private JTextField cp4;
	private JTextField cp5;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chaxunjiemian frame = new chaxunjiemian();
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
	public chaxunjiemian() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=609639723,873760637&fm=26&gp=0.jpg"));
		setTitle("\u67E5\u8BE2\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 444);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u5B66\u751F\u7F16\u53F7");
		lblNewLabel.setBounds(19, 18, 105, 35);
		
		xuehao = new JTextField();
		xuehao.setBounds(138, 23, 142, 24);
		xuehao.setColumns(10);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(328, 26, 30, 18);
		
		xingming = new JTextField();
		xingming.setBounds(372, 23, 107, 24);
		xingming.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");		
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String xm=xingming.getText();
				String xh=xuehao.getText();
				if(checkstudent(xm,xh)==true) {
					List<String> list1=Cha(xm, xh);
					String[] array=list1.toArray(new String[list1.size()]);
					mean.setText(array[0]);
					cp1.setText(array[1]);
					cp2.setText(array[2]);
					cp3.setText(array[3]);
					cp4.setText(array[4]);
					cp5.setText(array[5]);
					JOptionPane.showMessageDialog(null,"查询成功");
					xuehao.requestFocus();
					xuehao.selectAll();
				}
				else {
					JOptionPane.showMessageDialog(null, "查询失败，学号或姓名错误！");
					xuehao.requestFocus();
					xuehao.selectAll();
				}
				
			}
		});
		btnNewButton.setBounds(423, 69, 145, 45);
		JLabel lblNewLabel_3 = new JLabel("\u5E73\u5747\u6210\u7EE9");
		lblNewLabel_3.setBounds(100, 272, 60, 18);
		
		mean = new JTextField();
		mean.setBounds(174, 269, 86, 24);
		mean.setColumns(10);
		
		btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(423, 316, 145, 43);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("\u88C1\u52241");		
		lblNewLabel_4.setBounds(122, 82, 38, 18);
		JLabel lblNewLabel_5 = new JLabel("\u88C1\u52242");	
		lblNewLabel_5.setBounds(122, 120, 38, 18);
		JLabel lblNewLabel_6 = new JLabel("\u88C1\u52243");		
		lblNewLabel_6.setBounds(122, 157, 38, 18);
		JLabel lblNewLabel_7 = new JLabel("\u88C1\u52244");		
		lblNewLabel_7.setBounds(122, 194, 38, 18);
		JLabel lblNewLabel_8 = new JLabel("\u88C1\u52245");
		lblNewLabel_8.setBounds(122, 231, 38, 18);
		
		cp1 = new JTextField();
		cp1.setBounds(174, 79, 86, 24);
		cp1.setColumns(10);
		
		cp2 = new JTextField();
		cp2.setBounds(174, 117, 86, 24);
		cp2.setColumns(10);
		
		cp3 = new JTextField();
		cp3.setBounds(174, 154, 86, 24);
		cp3.setColumns(10);
		
		cp4 = new JTextField();
		cp4.setBounds(174, 191, 86, 24);
		cp4.setColumns(10);
		
		cp5 = new JTextField();
		cp5.setBounds(174, 228, 86, 24);
		cp5.setColumns(10);
		
		btnNewButton_2 = new JButton("\u8FD4\u56DE");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(423, 193, 145, 45);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(xuehao);
		contentPane.add(label);
		contentPane.add(xingming);
		contentPane.add(lblNewLabel_4);
		contentPane.add(cp1);
		contentPane.add(lblNewLabel_3);
		contentPane.add(mean);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_8);
		contentPane.add(cp4);
		contentPane.add(cp3);
		contentPane.add(cp2);
		contentPane.add(cp5);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("\u6E05\u7A7A");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuehao.setText("");
				xingming.setText("");
				cp1.setText("");
				cp2.setText("");
				cp3.setText("");
				cp4.setText("");
				cp5.setText("");
				mean.setText("");
			}
		});
		btnNewButton_3.setBounds(423, 130, 145, 45);
		contentPane.add(btnNewButton_3);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=609639723,873760637&fm=26&gp=0.jpg"));
		lblNewLabel_1.setBounds(382, 70, 30, 43);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\src=http___bpic.588ku.com_element_pic_00_19_59_7556cc746ab7f87.jpg&refer=http___bpic.588ku.jfif"));
		lblNewLabel_2.setBounds(374, 309, 38, 56);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\src=http___bpic.588ku.com_element_origin_min_pic_00_92_85_4456f23be8baf9c.jpg&refer=http___bpic.588ku.jfif"));
		lblNewLabel_9.setBounds(382, 193, 38, 45);
		contentPane.add(lblNewLabel_9);
	}
	public static boolean checkstudent(String xm,String xh) {
		DatabaseConnection dbcs2=new DatabaseConnection();
		String sql2="select xm,xh from student";
		try(Connection conn=(Connection) dbcs2.getConnection();//获取数据库
				PreparedStatement slh2=(PreparedStatement) conn.prepareStatement(sql2);){
					ResultSet cx=slh2.executeQuery();
					while(cx.next()) {
						if((xm.compareTo(cx.getString(1))==0)&&(xh.compareTo(cx.getString(2))==0))
							return true;
					}
				}catch (SQLException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				return false;
	}
	public static List<String> Cha(String xm,String xh) {
		List<String> lists = new ArrayList<String>();
		DatabaseConnection dbcs2=new DatabaseConnection();
		String sql2="select * from student";
		try(Connection conn=(Connection) dbcs2.getConnection();//获取数据库
				PreparedStatement slh2=(PreparedStatement) conn.prepareStatement(sql2);){
				ResultSet cx=slh2.executeQuery();//执行查询语句，结果放到数据集中
			while (cx.next()) {
				if(xm.equals(cx.getString(1))&&xh.equals(cx.getString(2))) {
					List<String> list = new ArrayList<String>();
					list.add(cx.getString("cj"));
					list.add(cx.getString("no1"));
					list.add(cx.getString("no2"));
					list.add(cx.getString("no3"));
					list.add(cx.getString("no4"));
					list.add(cx.getString("no5"));
					lists.addAll(list);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return lists;
	}
	public static  List<String>getSelectall(String sql) {
		List<String> lists = new ArrayList<String>();
		DatabaseConnection dbcs2=new DatabaseConnection();
		try(Connection conn=(Connection) dbcs2.getConnection();//获取数据库
				PreparedStatement slh2=(PreparedStatement) conn.prepareStatement(sql);){
				ResultSet cx=slh2.executeQuery();//执行查询语句，结果放到数据集中
			while (cx.next()) {
				
				List<String> list = new ArrayList<String>();
				list.add(cx.getString(1));
				list.add(cx.getString(2));
				list.add(cx.getString(3));
				list.add(cx.getString(4));
				list.add(cx.getString(5));
				list.add(cx.getString(6));
				list.add(cx.getString(7));
				list.add(cx.getString(8));
				lists.addAll(list);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lists;
	}
}
