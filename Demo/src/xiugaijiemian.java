
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.fabric.xmlrpc.base.Data;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import cn.edu.jsu.yym.dbc.DatabaseConnection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class xiugaijiemian extends JFrame {

	private JPanel contentPane;
	private JTextField xuehao;
	private JTextField xingming;
	private JTextField cp1;
	private JTextField cp2;
	private JTextField cp3;
	private JTextField cp4;
	private JTextField cp5;
	static double averg2;
	static xiugaijiemian frame1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xiugaijiemian frame = new xiugaijiemian();
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
	public xiugaijiemian() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\14682\\Pictures\\Saved Pictures\\2.jpg"));
		setTitle("\u4FEE\u6539\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 330);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7F16\u53F7");
		lblNewLabel.setBounds(32, 21, 60, 18);
		
		xuehao = new JTextField();
		xuehao.setBounds(106, 18, 115, 24);
		xuehao.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setBounds(257, 21, 30, 18);
		
		xingming = new JTextField();
		xingming.setBounds(301, 18, 86, 24);
		xingming.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u88C1\u52241");		
		lblNewLabel_2.setBounds(32, 71, 38, 18);
		JLabel lblNewLabel_3 = new JLabel("\u88C1\u52242");		
		lblNewLabel_3.setBounds(32, 108, 38, 18);
		JLabel lblNewLabel_4 = new JLabel("\u88C1\u52243");		
		lblNewLabel_4.setBounds(32, 145, 38, 18);
		JLabel lblNewLabel_5 = new JLabel("\u88C1\u52244");		
		lblNewLabel_5.setBounds(32, 182, 38, 18);
		JLabel lblNewLabel_6 = new JLabel("\u88C1\u52245");
		lblNewLabel_6.setBounds(32, 218, 38, 18);
		
		cp1 = new JTextField();
		cp1.setBounds(76, 68, 86, 24);
		cp1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cp1.addKeyListener(new KeyAdapter() {//增加成绩输入框键盘事件焦点
							  @Override
							  public void keyPressed(KeyEvent e) {//监听键盘键入内容
							    if(e.getKeyChar()==KeyEvent.VK_ENTER) {//如果是回车键					      
							    	cp2.requestFocus();//密码框得到焦点					      
							    }
							   }
							});
					}
				});
			}
		});
		cp1.setColumns(10);
		
		cp2 = new JTextField();
		cp2.setBounds(76, 105, 86, 24);
		cp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp2.addKeyListener(new KeyAdapter() {//增加成绩输入框键盘事件焦点
					  @Override
					  public void keyPressed(KeyEvent e) {//监听键盘键入内容
					    if(e.getKeyChar()==KeyEvent.VK_ENTER) {//如果是回车键					      
					    	cp3.requestFocus();//密码框得到焦点					      
					    }
					   }
					});
			}
		});
		cp2.setColumns(10);
		
		cp3 = new JTextField();
		cp3.setBounds(76, 142, 86, 24);
		cp3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp3.addKeyListener(new KeyAdapter() {//增加成绩输入框键盘事件焦点
					  @Override
					  public void keyPressed(KeyEvent e) {//监听键盘键入内容
					    if(e.getKeyChar()==KeyEvent.VK_ENTER) {//如果是回车键					      
					    	cp4.requestFocus();//密码框得到焦点					      
					    }
					   }
					});	
		}
		});
		cp3.setColumns(10);
		
		cp4 = new JTextField();
		cp4.setBounds(76, 179, 86, 24);
		cp4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cp4.addKeyListener(new KeyAdapter() {//增加成绩输入框键盘事件焦点
					  @Override
					  public void keyPressed(KeyEvent e) {//监听键盘键入内容
					    if(e.getKeyChar()==KeyEvent.VK_ENTER) {//如果是回车键					      
					    	cp5.requestFocus();//密码框得到焦点					      
					    }
					   }
					});
			}
		});
		cp4.setColumns(10);
		
		cp5 = new JTextField();
		cp5.setBounds(76, 215, 86, 24);
		cp5.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(257, 108, 130, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(257, 71, 130, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String xm=xingming.getText();
				String xh=xuehao.getText();
				if(checkstudent(xm,xh)) {
					double cj;
					double no1=Double.parseDouble(cp1.getText());
					double no2=Double.parseDouble(cp2.getText());
					double no3=Double.parseDouble(cp3.getText());
					double no4=Double.parseDouble(cp4.getText());
					double no5=Double.parseDouble(cp5.getText());
					double a1=Double.parseDouble(cp1.getText());
					double a2=Double.parseDouble(cp2.getText());
					double a3=Double.parseDouble(cp3.getText());
					double a4=Double.parseDouble(cp4.getText());
					double a5=Double.parseDouble(cp5.getText());
				averg2=frame1.averg(a1,a2,a3,a4,a5);
				cj=(double) Math.round(averg2 * 100)/100;
				JOptionPane.showMessageDialog(null, "修改成功!!");
				JOptionPane.showMessageDialog(null, "平均分是"+(double) Math.round(averg2 * 100) / 100);
				Gai(xm,xh,cj,no1,no2,no3,no4,no5);
				xuehao.setText("");
				xingming.setText("");
				cp1.setText("");
				cp2.setText("");
				cp3.setText("");
				cp4.setText("");
				cp5.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "修改失败，学号或姓名不正确！");
					xuehao.setText("");
					xingming.setText("");
					xuehao.requestFocus();					
				}
					
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(257, 232, 130, 27);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_5);
		contentPane.add(cp4);
		contentPane.add(lblNewLabel_6);
		contentPane.add(cp5);
		contentPane.add(lblNewLabel_3);
		contentPane.add(cp2);
		contentPane.add(lblNewLabel_2);
		contentPane.add(cp1);
		contentPane.add(lblNewLabel);
		contentPane.add(xuehao);
		contentPane.add(lblNewLabel_4);
		contentPane.add(cp3);
		contentPane.add(lblNewLabel_1);
		contentPane.add(xingming);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\src=http___bpic.588ku.com_element_origin_min_pic_00_92_85_4456f23be8baf9c.jpg&refer=http___bpic.588ku.jfif"));
		lblNewLabel_7.setBounds(205, 100, 38, 43);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\src=http___bpic.588ku.com_element_pic_00_19_59_7556cc746ab7f87.jpg&refer=http___bpic.588ku.jfif"));
		lblNewLabel_8.setBounds(205, 228, 38, 34);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=3017215024,630383570&fm=26&gp=0.jpg"));
		lblNewLabel_9.setBounds(213, 67, 30, 27);
		contentPane.add(lblNewLabel_9);
	}
	public static double averg(double a1,double a2,double a3,double a4,double a5) {
		double aver=(a1+a2+a3+a4+a5)/5;
		return aver;
	}
	public static boolean checkstudent(String xm,String xh) {
		DatabaseConnection dbcs2=new DatabaseConnection();
		String sql2="select xm,xh from student";
		try(Connection conn=(Connection) dbcs2.getConnection();//获取数据库
				PreparedStatement slh2=(PreparedStatement) conn.prepareStatement(sql2);){
					ResultSet xg=slh2.executeQuery();
					while(xg.next()) {
						if((xm.compareTo(xg.getString(1))==0)&&(xh.compareTo(xg.getString(2))==0))
							return true;
					}
				}catch (SQLException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
				return false;
	}
	public static void Gai(String xm,String xh,double cj,double no1,double no2,double no3,double no4,double no5) {
		DatabaseConnection dbcs2=new DatabaseConnection();
		String sql2="update student set cj=" + cj + ",no1=" + no1 + ",no2=" + no2 + ",no3=" + no3 + ",no4=" + no4 + ",no5=" + no5 + " where xm='" + xm + "' and xh='" + xh + "'";
		try(Connection conn=(Connection) dbcs2.getConnection();//获取数据库
        		Statement slh2=(Statement) conn.createStatement();){//实例化PreparedStatement
    		  slh2.executeUpdate(sql2);
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
		
		}
	}
	

