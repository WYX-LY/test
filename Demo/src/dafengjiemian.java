import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import cn.edu.jsu.yym.dbc.DatabaseConnection;

import javax.print.attribute.standard.PrinterLocation;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.TexturePaint;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.chrono.MinguoChronology;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class dafengjiemian extends JFrame {

	private JPanel contentPane;
	private JTextField xuehao;
	private JTextField xingming;
	private JTextField cp1;
	private JTextField cp2;
	private JTextField cp3;
	private JTextField cp4;
	private JTextField cp5;
	static double  averg1;
	static dafengjiemian frame;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dafengjiemian frame=new dafengjiemian();
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
	public dafengjiemian() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=1131243438,3346717062&fm=26&gp=0.jpg"));
		setBackground(Color.WHITE);
		
		setTitle("\u6253\u5206\u754C\u9762");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 524, 421);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		xuehao = new JTextField();
		xuehao.setBounds(172, 18, 108, 24);
		xuehao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7F16\u53F7");
		lblNewLabel.setBounds(94, 21, 60, 18);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setBounds(305, 21, 30, 18);
		
		xingming = new JTextField();
		xingming.setBounds(353, 18, 108, 24);
		xingming.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u6253\u5206");
		lblNewLabel_2.setBounds(19, 18, 57, 216);
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblNewLabel_3 = new JLabel("\u88C1\u52241");		
		lblNewLabel_3.setBounds(94, 64, 38, 18);
		JLabel lblNewLabel_4 = new JLabel("\u88C1\u52242");		
		lblNewLabel_4.setBounds(94, 109, 38, 18);
		JLabel lblNewLabel_5 = new JLabel("\u88C1\u52243");		
		lblNewLabel_5.setBounds(94, 154, 72, 18);
		JLabel lblNewLabel_6 = new JLabel("\u88C1\u52244");		
		lblNewLabel_6.setBounds(94, 199, 38, 18);
		JLabel lblNewLabel_7 = new JLabel("\u88C1\u52245");
		lblNewLabel_7.setBounds(94, 243, 38, 18);
		
		cp1 = new JTextField();
		cp1.setBounds(172, 61, 86, 24);
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
		cp1.setColumns(10);
		
		cp2 = new JTextField();
		cp2.setBounds(172, 106, 86, 24);
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
		cp3.setBounds(172, 151, 86, 24);
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
		cp4.setBounds(172, 196, 86, 24);
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
		cp5.setBounds(172, 240, 86, 24);
		cp5.setColumns(10);
		
		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(346, 60, 140, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String xm=xingming.getText();
				String xh=xuehao.getText();
				if(Cha(xh)==false)
				{
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
				
				averg1=frame.averg(a1,a2,a3,a4,a5);	
				cj=(double) Math.round(averg1 * 100)/100;
				updateID(xm,xh,cj, no1, no2, no3, no4, no5);
				JOptionPane.showMessageDialog(null, "平均分是"+(double) Math.round(averg1 * 100) / 100);			
				File file=new File("D:/DAIMA/test/student.txt");
				try(FileWriter fw=new FileWriter(file,true)){//创建字符输出流
					//将用户输入的信息写入指定文件
					fw.write("姓名:"+xingming.getText()+"\t"+"学号:"+xuehao.getText()+"\t\t"+"平均成绩:"+cj+"\t"
								+"裁判一:"+cp1.getText()+"\t"+"裁判二:"+cp2.getText()+"\t"+"裁判三:"+cp3.getText()+"\t"+"裁判四:"
									+cp4.getText()+"\t"+"裁判五:"+cp5.getText()+"\t\n");	
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "增加数据成功！");
				xuehao.setText("");
				xingming.setText("");
				cp1.setText("");
				cp2.setText("");
				cp3.setText("");
				cp4.setText("");
				cp5.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "已有该学号");
					xingming.setText("");
					xuehao.setText("");
					cp1.setText("");
					cp2.setText("");
					cp3.setText("");
					cp4.setText("");
					cp5.setText("");//清空
					xuehao.requestFocus();//获得焦点				
				}
				}
			
		});
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(346, 105, 140, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chaxunjiemian f4=new chaxunjiemian();
				f4.setVisible(true);
				f4.setLocationRelativeTo(null);
			}
		});
		
		JButton btnNewButton_3 = new JButton("\u5220\u9664");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(346, 150, 140, 27);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shanchujiemian f5=new shanchujiemian();
				f5.setVisible(true);
				f5.setLocationRelativeTo(null);
			}
		});
		
		JButton btnNewButton_4 = new JButton("\u9000\u51FA");
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.setBounds(353, 312, 95, 41);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(346, 195, 140, 27);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xiugaijiemian f3=new xiugaijiemian();				
				f3.setVisible(true);
				f3.setLocationRelativeTo(null);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblNewLabel);
		contentPane.add(cp5);
		contentPane.add(cp4);
		contentPane.add(cp3);
		contentPane.add(cp2);
		contentPane.add(cp1);
		contentPane.add(xuehao);
		contentPane.add(lblNewLabel_1);
		contentPane.add(xingming);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_3);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=3080742142,1012787303&fm=26&gp=0.jpg"));
		lblNewLabel_8.setBounds(297, 146, 38, 35);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=3426520471,1745478195&fm=26&gp=0.jpg"));
		lblNewLabel_9.setBounds(297, 53, 38, 41);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=312177448,2700702957&fm=26&gp=0.jpg"));
		lblNewLabel_10.setBounds(305, 315, 30, 35);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=609639723,873760637&fm=26&gp=0.jpg"));
		lblNewLabel_12.setBounds(297, 98, 30, 41);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\2.jpg"));
		lblNewLabel_11.setBounds(297, 191, 30, 35);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=1479663527,2633284055&fm=26&gp=0.jpg"));
		lblNewLabel_13.setBounds(50, 11, 30, 38);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=2023504216,4278744971&fm=26&gp=0.jpg"));
		lblNewLabel_14.setBounds(14, 0, 491, 373);
		contentPane.add(lblNewLabel_14);
	}
	public static double averg(double a1,double a2,double a3,double a4,double a5) {
		double aver=(a1+a2+a3+a4+a5)/5;
		return aver;
	}

	public static void updateID(String xm,String xh,Double cj,Double no1,Double no2,Double no3,Double no4,Double no5) {
		System.out.println("平均成绩是"+cj);
    	DatabaseConnection dbcs2=new DatabaseConnection();
		String sql2="insert into student(xm,xh,cj,no1,no2,no3,no4,no5) values(?,?,?,?,?,?,?,?)";
    	try(Connection conn=(Connection) dbcs2.getConnection();//获取数据库,(Connection)为强制类型转换
        		PreparedStatement slh2=(PreparedStatement) conn.prepareStatement(sql2);){//实例化PreparedStatement
    					slh2.setString(1, xm);
    					slh2.setString(2, xh);
    					slh2.setDouble(3, cj);
    					slh2.setDouble(4, no1);
    					slh2.setDouble(5, no2);
    					slh2.setDouble(6,no3);
    					slh2.setDouble(7,no4);
    					slh2.setDouble(8, no5);
    					slh2.addBatch();//预编译SQL语句,只编译一回,效率高
        		slh2.executeBatch();//批量执行插入操作
        	}catch(SQLException e) {
        		e.printStackTrace();//执行与数据库建立连接需要抛出SQL异常
        	} 
   }
	public static boolean Cha(String xh) {
		DatabaseConnection dbcs2=new DatabaseConnection();
		String sql2="select xh from student";
		try(Connection conn=(Connection) dbcs2.getConnection();
				PreparedStatement slh2= (PreparedStatement) conn.prepareStatement(sql2);){
			ResultSet cx=slh2.executeQuery();
			while (cx.next()) {
				if((xh.compareTo(cx.getString(1))==0))
					return true;	
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
			// TODO: handle exception
		}


	
	
	
	
	
	
}
