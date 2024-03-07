package GUi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;




import com.mysql.jdbc.PreparedStatement;
import javax.swing.ImageIcon;



public class Custom extends JFrame implements ActionListener{
	private JTextField shop = new JTextField();
	private JTextField item = new JTextField();
	private JTextField amount = new JTextField();
	private JButton button =  new  JButton("ȷ�ϸ���");
	private JButton button1 = new JButton("���¶���");
	private JTextField address = new JTextField();
	private JTextField name = new JTextField();
	private JTextField number = new JTextField();

    public static void main(String[] args) {
		new Custom();
		}

	
	public Custom() {
		JFrame frame = new JFrame();
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("�˿��µ�����v0.9");
		this.setBounds(100,200,845,598);
		this.setVisible(true);
		
		
		//�����
		JLabel labelad = new JLabel("�㲻������Ҳ�����ܹ���Ŀ��֣�");
		labelad.setFont(new Font("����", Font.PLAIN, 25));
		labelad.setAlignmentY(CENTER_ALIGNMENT);
		labelad.setBounds(50, -10, 544, 80);//�ֵ�λ��
		this.getContentPane().add(labelad);
		
	    //����
		JLabel labelname = new JLabel("����");
		labelname.setAlignmentY(CENTER_ALIGNMENT);
		labelname.setBounds(420, 214, 43, 47);//�ֵ�λ��
		name.setBounds(420, 271, 100, 30);//���λ��
		this.getContentPane().add(labelname);
		this.getContentPane().add(name);
		
		//�ֻ���
		JLabel labelnumber = new JLabel("�ֻ���");
		labelnumber.setAlignmentY(CENTER_ALIGNMENT);
		labelnumber.setBounds(621, 220, 283, 35);//�ֵ�λ��
		number.setBounds(621, 263, 200, 30);//���λ��
		this.getContentPane().add(labelnumber);
		this.getContentPane().add(number);
		
		//��ַ
		JLabel labeladdress = new JLabel("��������ϸסַ");
		labeladdress.setAlignmentY(CENTER_ALIGNMENT);
		labeladdress.setBounds(420, 303, 270, 49);//�ֵ�λ��
		address.setBounds(416, 362, 400, 30);//���λ��
		this.getContentPane().add(labeladdress);
		this.getContentPane().add(address);
		
		//�����������
		JLabel labelShopName = new JLabel("������������ƣ�������ַ��");
		labelShopName.setAlignmentY(CENTER_ALIGNMENT);
		labelShopName.setBounds(50, 25, 300, 80);//�ֵ�λ��
		shop.setBounds(50, 80, 226, 122);//���λ��
		this.getContentPane().add(labelShopName);
		this.getContentPane().add(shop);
		
		//������Ʒ
		JLabel labelItemName = new JLabel("��������Ҫ��������Ʒ");
		labelItemName.setAlignmentY(CENTER_ALIGNMENT);
		labelItemName.setBounds(50, 198, 200, 30);//�ֵ�λ��
		item.setBounds(50, 238, 226, 80);//���λ��
		this.getContentPane().add(labelItemName);
		this.getContentPane().add(item);
		
		//����Ԥ�����
		JLabel labelItemamount = new JLabel("������Ԥ�����");
		labelItemamount.setAlignmentY(CENTER_ALIGNMENT);
		labelItemamount.setBounds(50, 361, 200, 30);//�ֵ�λ��
		amount.setBounds(50, 409, 100, 30);//���λ��
		this.getContentPane().add(labelItemamount);
		this.getContentPane().add(amount);
		
		//���¶�����ť
		button1.setBounds(50, 512, 150, 30);
		this.getContentPane().add(button1);
		button1.addActionListener(this);
		
		//ȷ�ϸ��ť
		button.setBounds(666, 512, 150, 30);
		this.getContentPane().add(button);
		button.addActionListener(this);
		
		this.setResizable(false);
		
		//���ͷ�
		JLabel labelfee = new JLabel("���ͷѣ�3Ԫ");
		labelfee.setAlignmentY(CENTER_ALIGNMENT);
		labelfee.setBounds(416, 374, 131, 73);//�ֵ�λ��
		this.getContentPane().add(labelfee);
		
		//���ʽ
		JLabel labelpayway = new JLabel("���ʽ�����");
		labelpayway.setAlignmentY(CENTER_ALIGNMENT);
		labelpayway.setBounds(414, 419, 122, 49);//�ֵ�λ��
		this.getContentPane().add(labelpayway);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Custom.class.getResource("/images/\u7A77.jpg")));
		label.setBounds(0, 0, 839, 569);
		getContentPane().add(label);
		
		
		}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//�ɹ�����ڵ���
		String shop1 = shop.getText();
		String item1 = item.getText();
		String amount1 = amount.getText();
		String name1=name.getText();
		String number1 = number.getText();
		String address1=address.getText();
		
		
		if (e.getSource() == button){
				// ����ȷ�ϵ�ַ����
			add a=new add();
			a.setShop(shop1);
			a.setItem(item1);
			a.setAmount(amount1);
			a.setName(name1);
			a.setPhone(number1);
			a.setAddress(address1);
			try {
				if (a.checkdingdan()) {
              new Paysuccess();
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//
				// �رյ�ǰ����
				//this.dispose();
			}
		
		//���¶������ڵ���
		if(e.getSource() == button1){
			// �������¶�������
			new Order();
			
			// �رյ�ǰ����
			this.dispose();
		    }
		
	}
	
	
}