package GUi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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






import sql.PTXTDataBase;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;


public class my extends JInternalFrame implements ActionListener{
	private JLabel Subject = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u8D26\u53F7\uFF1A");
	private JButton button = new JButton("\u67E5\u770B");
	private JTableHeader jth; 
	private JTable tabDemo; 
	private JScrollPane scpDemo;
	private JTextField textField;
	private final JDesktopPane desktopPane = new JDesktopPane();
	private final JLabel label_1 = new JLabel("\u8F9B");
	
	

	public static void main(String[] args)  {
		new my();
		
	}

	
	public my() {
		setFrameIcon(new ImageIcon(my.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		setClosable(true);
		setIconifiable(true);
		JFrame frame = new JFrame();
		getContentPane().setLayout(null);
		this.setTitle("\u4E2A\u4EBA\u4FE1\u606F");
		this.setBounds(100,200,518,402);
		this.setVisible(true);
		this.scpDemo = new JScrollPane();  
		this.scpDemo.setBounds(46,64,406,280);
		Subject.setFont(new Font("华文楷体", Font.PLAIN, 15));
		Subject.setBounds(35, 13, 146, 50);
		button.setBounds(352, 23, 100, 30);
		
		getContentPane().add(Subject);
		getContentPane().add(button);
		getContentPane().add(scpDemo); 
		
		textField = new JTextField();
		textField.setBounds(167, 23, 175, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(0, 0, 502, 372);
		getContentPane().add(desktopPane);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(my.class.getResource("/images/my.jpg")));
		label.setBounds(0, 0, 502, 372);
		desktopPane.add(label);
		label_1.setBounds(448, 75, 54, 15);
		
		desktopPane.add(label_1);
		button.addActionListener(this);
		
		}

		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = textField.getText();
		if (e.getSource() == button) {
			show s=new show();
				s.setID(id);
			try{    
				Connection conn = show.getConnection();
			{
				
				Object[][] info = show.search(conn);       //将数据库数据转换为jtable表
				// 定义表头  
				String[] title = {"账号","用户名","信用分","已接订单数","收入总额"};  
			   
				this.tabDemo = new JTable(info,title);  
				// 显示表头  
				this.jth = this.tabDemo.getTableHeader();  
				this.scpDemo.setViewportView(tabDemo);
			}
			}catch(SQLException sqle){  
			JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);  
			}
			}
	}
	}
			
