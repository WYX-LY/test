package cn.edu.jsu.yym.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.openmbean.OpenDataException;
import javax.swing.JOptionPane;

public class DataOperate {
	static double averg;
	static DataOperate frame;
	//��������
	private static String firstName="��Ǯ��������֣���������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë�����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ������������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ů������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    public static double getNum1(double d,double end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��10֮�����
        return (double)(Math.random()*(end-d+1)+d);
    }
    //�������ѧ��
    public static StringBuilder getStuno() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder xh=new StringBuilder("20194");//ѧ��ǰ5λ��ͬ
    	StringBuilder xh1=new StringBuilder(String.valueOf(getNum(1,99999)));//���ȡ��5λ
    	if(xh1.length()==1) {
    		xh1=xh1.insert(0, "0000");//�����1λ����ǰ������4��0
    		xh=xh.append(xh1);//ǰ5λ���5λƴ�ӳ�ѧ��
    	}else if(xh1.length()==2) {
    		xh1=xh1.insert(0, "000");//�����2λ����ǰ������3��0
    		xh=xh.append(xh1);
    	}else if (xh1.length()==3) {
    		xh1=xh1.insert(0, "00");//�����3λ����ǰ������2��0
    		xh=xh.append(xh1);			
		}else if (xh1.length()==4) {
			xh1=xh1.insert(0, "0");
			xh=xh.append(xh1);
		}
    	else {
    		xh=xh.append(xh1);
    	}
    	return xh;
    }
    //��������������� 
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
    public static void main(String[] args) {
    	addCJ();
    }
    public static void addCJ() {//���ӳɼ�
    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	String sql="insert into student1(xh,xm,cj,no1,no2,no3,no4,no5) values(?,?,?,?,?,?,?,?)";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement slh=conn.prepareStatement(sql);){//ʵ����PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//���弯��       
        	Double cj;
        	String a,b,c,d,e;
    		for(int i=1;i<=10000;) {		
    			String xh=getStuno().toString();//�����ȡѧ��
    			if(!alist.contains(xh)) {//�ж�ѧ���Ƿ�Ψһ
    				
    				alist.add(xh);//��ѧ�ż��뼯��
    				String xm=getChineseName();//�����ȡ����
    				
    				Double no1=getNum1(0, 9.00) ;//�����ȡ�ɼ�
    	        	Double no2=getNum1(0, 9.00);//�����ȡ�ɼ�
    	        	Double no3=getNum1(0, 9.00);//�����ȡ�ɼ�
    	        	Double no4=getNum1(0, 9.00);//�����ȡ�ɼ�
    	        	Double no5=getNum1(0, 9.00);//�����ȡ�ɼ�
    	        	
    	        	a=String.valueOf(no1);
    	        	b=String.valueOf(no2);
    	        	c=String.valueOf(no3);
    	        	d=String.valueOf(no4);
    	        	e=String.valueOf(no5);//�Ѹ�double���͵ķ���ת����string���ͣ�
    	        	
    	        	double a1=Double.valueOf(a);
    				double a2=Double.valueOf(b);
    				double a3=Double.valueOf(c);
    				double a4=Double.valueOf(d);
    				double a5=Double.valueOf(e);//��string���͵ķ���ת����double����
    				cj=DataOperate.averg(a1, a2, a3, a4, a5);
    				//��ȡ���ƽ���ɼ�
    				slh.setString(1, xh);//�����1��ռλ��������
    	    		slh.setString(2, xm);//�����2��ռλ��������
    	    		slh.setDouble(3, cj);//�����3��ռλ��������   	    		
					slh.setDouble(4, no1);
    	    		slh.setDouble(5, no2);
    	    		slh.setDouble(6, no3);
    	    		slh.setDouble(7, no4);
    	    		slh.setDouble(8, no5);
    	    		slh.addBatch();//�����������ȴ�ִ��
    	    		System.out.print(i+"\n");
    				i++;//ѧ��Ψһ��ѭ����������ִ��
    			}
    		}
    		slh.executeBatch();//����ִ�в������   
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public static double averg(double a1,double a2,double a3,double a4,double a5) {
		double aver=(a1+a2+a3+a4+a5)/5;
		return aver;
    }
}