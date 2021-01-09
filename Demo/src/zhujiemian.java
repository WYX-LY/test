import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.yym.dbc.DatabaseConnection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
public class zhujiemian extends JFrame {

	private JPanel contentPane;
	private JTextField ZhangHao;
	private JPasswordField MiMa; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zhujiemian frame = new zhujiemian();
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
	public zhujiemian() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=2216186295,2127833073&fm=26&gp=0.jpg"));
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		
		setTitle("���Դ��ϵͳ");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 341);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(337, 27, 89, 37);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=ZhangHao.getText();
				String code=MiMa.getText();
				if(checkID(id, code)==true) {
				zhujiemian f1=new zhujiemian();
				dafengjiemian f2=new dafengjiemian();
				JOptionPane.showMessageDialog(null, "��¼�ɹ�");
				dispose();
				f2.setVisible(true);
				f2.setLocationRelativeTo(null);}
				else {
					JOptionPane.showMessageDialog(null, "�˺Ż��������");
					MiMa.requestFocus();//������ý���			
					MiMa.selectAll();//ȫѡ��ǰ����
				}
			}
		});
		
		JButton button = new JButton("\u53D6\u6D88");
		button.setBackground(Color.RED);
		button.setBounds(337, 77, 89, 38);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//ϵͳ�˳�
			}
		});
		
		ZhangHao = new JTextField();
		ZhangHao.setBackground(Color.WHITE);
		ZhangHao.setBounds(96, 33, 143, 30);
		ZhangHao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZhangHao.addKeyListener(new KeyAdapter() {//���ӳɼ����������¼�����
					  @Override
					  public void keyPressed(KeyEvent e) {//�������̼�������
					    if(e.getKeyChar()==KeyEvent.VK_ENTER) {//����ǻس���					      
					    	MiMa.requestFocus();//�����õ�����					      
					    }
					   }
					});

			}
		});
		ZhangHao.setToolTipText("\u8D26\u53F7");
		ZhangHao.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setBounds(52, 39, 30, 18);
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(52, 82, 30, 18);
		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u9762\u8BD5\u6253\u5206\u7CFB\u7EDF!");
		label.setBounds(116, 225, 310, 32);
		label.setForeground(Color.RED);
		label.setFont(new Font("����", Font.PLAIN, 28));
		
		MiMa = new JPasswordField();
		MiMa.setBackground(Color.WHITE);
		MiMa.setBounds(96, 76, 143, 31);
		MiMa.setToolTipText("\u5BC6\u7801");
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(MiMa);
		contentPane.add(ZhangHao);
		contentPane.add(btnNewButton_1);
		contentPane.add(button);
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("\u70B9\u51FB\u6CE8\u518C:");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 17));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(224, 131, 89, 18);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("\u6CE8\u518C");
		btnNewButton_2.setBackground(Color.GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=ZhangHao.getText();
				String code;
					if(Zhu(id)==false) {
						id=ZhangHao.getText();
						code=MiMa.getText();
						updataID( id, code);
						JOptionPane.showMessageDialog(null, "ע��ɹ���");
						MiMa.requestFocus();
					}
					else {
						JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ���ʹ���µ��˺ţ�");
						ZhangHao.requestFocus();
						ZhangHao.selectAll();
					}
				
				
			}
		});
		btnNewButton_2.setBounds(313, 128, 113, 27);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\src=http___pic.baike.soso.com_p_20130806_20130806213317-1513026654.jpg&refer=http___pic.baike.soso.jfif"));
		lblNewLabel_3.setBounds(14, 196, 89, 85);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\src=http___bpic.588ku.com_element_origin_min_pic_00_91_35_1056f167545954f.jpg&refer=http___bpic.588ku.jfif"));
		lblNewLabel_4.setBounds(10, 71, 42, 40);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=1131243438,3346717062&fm=26&gp=0.jpg"));
		lblNewLabel_5.setBounds(10, 26, 42, 44);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=3770835321,2683520112&fm=26&gp=0.jpg"));
		lblNewLabel_6.setBounds(184, 123, 36, 37);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\src=http___bpic.588ku.com_element_origin_min_pic_19_04_09_5c711cda7f68f5938ef37eb0e2ae8839.jpg&refer=http___bpic.588ku.jfif"));
		lblNewLabel_7.setBounds(287, 82, 36, 33);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=3426520471,1745478195&fm=26&gp=0.jpg"));
		lblNewLabel_8.setBounds(287, 33, 36, 31);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\14682\\Pictures\\Saved Pictures\\u=2871986365,3938116455&fm=26&gp=0.jpg"));
		lblNewLabel_9.setBounds(0, 0, 509, 294);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("��¼");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}

	protected EventObject arg() {
		// TODO Auto-generated method stub
		return null;
	}
	public static boolean checkID(String id,String code){
		DatabaseConnection dbcs1=new DatabaseConnection();//�Լ������DatabaseConnection��
		String sql1="select id,code from teacher";
    	try(Connection conn=(Connection) dbcs1.getConnection();//��ȡ���ݿ�
    		PreparedStatement slh1=(PreparedStatement) conn.prepareStatement(sql1);){//ʵ����PreparedStatement
    		ResultSet cx=slh1.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(cx.next()) {//�������ݼ�
    			if((id.compareTo(cx.getString(1))==0)&&(code.compareTo(cx.getString(2))==0))
    					return true;
        		}
    	    	}catch(SQLException e) {
    	    		e.printStackTrace();
    	    	}
    		return false;
    	    }
	public static void updataID(String id,String code) {
		DatabaseConnection dbcs3=new DatabaseConnection();
		String sql="insert into teacher(id,code) values(?,?)";
		try(Connection conn=(Connection) dbcs3.getConnection();
				PreparedStatement slh=(PreparedStatement) conn.prepareStatement(sql);){
			slh.setString(1, id);
			slh.setString(2, code);
			slh.addBatch();//Ԥ����SQL���,ֻ����һ��,Ч�ʸ�
    		slh.executeBatch();//����ִ�в������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean Zhu(String id) {
		DatabaseConnection dbcs3=new DatabaseConnection();
		String sql="select id from teacher";
		try(Connection conn=(Connection) dbcs3.getConnection();
				PreparedStatement slh= (PreparedStatement) conn.prepareStatement(sql);){
			ResultSet zc=slh.executeQuery();
			while (zc.next()) {
				if((id.compareTo(zc.getString(1))==0))
					return true;	
			}			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
			// TODO: handle exception
		}
}
