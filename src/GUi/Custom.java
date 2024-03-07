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
	private JButton button =  new  JButton("确认付款");
	private JButton button1 = new JButton("已下订单");
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
		this.setTitle("顾客下单界面v0.9");
		this.setBounds(100,200,845,598);
		this.setVisible(true);
		
		
		//广告语
		JLabel labelad = new JLabel("足不出户，也能享受购物的快乐！");
		labelad.setFont(new Font("宋体", Font.PLAIN, 25));
		labelad.setAlignmentY(CENTER_ALIGNMENT);
		labelad.setBounds(50, -10, 544, 80);//字的位置
		this.getContentPane().add(labelad);
		
	    //姓名
		JLabel labelname = new JLabel("姓名");
		labelname.setAlignmentY(CENTER_ALIGNMENT);
		labelname.setBounds(420, 214, 43, 47);//字的位置
		name.setBounds(420, 271, 100, 30);//框的位置
		this.getContentPane().add(labelname);
		this.getContentPane().add(name);
		
		//手机号
		JLabel labelnumber = new JLabel("手机号");
		labelnumber.setAlignmentY(CENTER_ALIGNMENT);
		labelnumber.setBounds(621, 220, 283, 35);//字的位置
		number.setBounds(621, 263, 200, 30);//框的位置
		this.getContentPane().add(labelnumber);
		this.getContentPane().add(number);
		
		//地址
		JLabel labeladdress = new JLabel("请输入详细住址");
		labeladdress.setAlignmentY(CENTER_ALIGNMENT);
		labeladdress.setBounds(420, 303, 270, 49);//字的位置
		address.setBounds(416, 362, 400, 30);//框的位置
		this.getContentPane().add(labeladdress);
		this.getContentPane().add(address);
		
		//输入店铺名称
		JLabel labelShopName = new JLabel("请输入店铺名称（包含地址）");
		labelShopName.setAlignmentY(CENTER_ALIGNMENT);
		labelShopName.setBounds(50, 25, 300, 80);//字的位置
		shop.setBounds(50, 80, 226, 122);//框的位置
		this.getContentPane().add(labelShopName);
		this.getContentPane().add(shop);
		
		//输入商品
		JLabel labelItemName = new JLabel("请输入需要代购的商品");
		labelItemName.setAlignmentY(CENTER_ALIGNMENT);
		labelItemName.setBounds(50, 198, 200, 30);//字的位置
		item.setBounds(50, 238, 226, 80);//框的位置
		this.getContentPane().add(labelItemName);
		this.getContentPane().add(item);
		
		//输入预付金额
		JLabel labelItemamount = new JLabel("请输入预付金额");
		labelItemamount.setAlignmentY(CENTER_ALIGNMENT);
		labelItemamount.setBounds(50, 361, 200, 30);//字的位置
		amount.setBounds(50, 409, 100, 30);//框的位置
		this.getContentPane().add(labelItemamount);
		this.getContentPane().add(amount);
		
		//已下订单按钮
		button1.setBounds(50, 512, 150, 30);
		this.getContentPane().add(button1);
		button1.addActionListener(this);
		
		//确认付款按钮
		button.setBounds(666, 512, 150, 30);
		this.getContentPane().add(button);
		button.addActionListener(this);
		
		this.setResizable(false);
		
		//配送费
		JLabel labelfee = new JLabel("配送费：3元");
		labelfee.setAlignmentY(CENTER_ALIGNMENT);
		labelfee.setBounds(416, 374, 131, 73);//字的位置
		this.getContentPane().add(labelfee);
		
		//付款方式
		JLabel labelpayway = new JLabel("付款方式：余额");
		labelpayway.setAlignmentY(CENTER_ALIGNMENT);
		labelpayway.setBounds(414, 419, 122, 49);//字的位置
		this.getContentPane().add(labelpayway);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Custom.class.getResource("/images/\u7A77.jpg")));
		label.setBounds(0, 0, 839, 569);
		getContentPane().add(label);
		
		
		}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//成功付款窗口弹出
		String shop1 = shop.getText();
		String item1 = item.getText();
		String amount1 = amount.getText();
		String name1=name.getText();
		String number1 = number.getText();
		String address1=address.getText();
		
		
		if (e.getSource() == button){
				// 弹出确认地址窗口
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
				// 关闭当前窗口
				//this.dispose();
			}
		
		//已下订单窗口弹出
		if(e.getSource() == button1){
			// 弹出已下订单窗口
			new Order();
			
			// 关闭当前窗口
			this.dispose();
		    }
		
	}
	
	
}