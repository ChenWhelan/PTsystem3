package GUi;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;

import sql.PTXTDataBase;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;

import data.customdingdan;
import javax.swing.ImageIcon;

public class SearchOrder extends JInternalFrame implements ActionListener {
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private JTableHeader jth;
	private JButton btnNewButton_2 = new JButton("\u5237\u65B0\u754C\u9762");;
	private JButton btnNewButton_1 = new JButton("\u5DF2\u63A5\u8BA2\u5355");
	private JButton btnNewButton = new JButton("\u786E\u8BA4\u63A5\u5355");
	private final JLabel label = new JLabel(
			"\u8BF7\u8F93\u5165\u60A8\u7684\u8D26\u53F7\uFF1A");
	private final JTextField textField = new JTextField();
	private final JLabel label_1 = new JLabel(
			"\u8BF7\u8F93\u5165\u60A8\u60F3\u63A5\u7684\u5355\u5B50\u5546\u5E97\u540D\uFF1A");
	private final JTextField textField_1 = new JTextField();

	public static void main(String[] args) {
		new SearchOrder();
	}

	/**
	 * Create the frame.
	 */
	public SearchOrder() {
		setFrameIcon(new ImageIcon(SearchOrder.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		setClosable(true);
		textField_1.setBounds(203, 412, 197, 24);
		textField_1.setColumns(10);
		textField.setBounds(207, 465, 193, 24);
		textField.setColumns(10);
		setIconifiable(true);
		setTitle("\u9A91\u624B\u63A5\u5355");
		setBounds(120, 50, 496, 601);
		getContentPane().setLayout(null);
		scrollPane.setBounds(14, 10, 463, 392);
		getContentPane().add(scrollPane);

		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton.setBounds(0, 514, 120, 23);
		getContentPane().add(btnNewButton);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlreadReceive ar = new AlreadReceive();
				ar.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_1.setBounds(174, 514, 120, 23);
		getContentPane().add(btnNewButton_1);

		btnNewButton_2.setFont(new Font("华文楷体", Font.PLAIN, 18));
		btnNewButton_2.setBounds(364, 514, 113, 23);
		getContentPane().add(btnNewButton_2);
		label.setBounds(14, 466, 126, 23);

		getContentPane().add(label);

		getContentPane().add(textField);
		label_1.setBounds(14, 414, 206, 18);

		getContentPane().add(label_1);

		getContentPane().add(textField_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(SearchOrder.class.getResource("/images/my.jpg")));
		label_2.setBounds(0, 406, 477, 201);
		getContentPane().add(label_2);

		btnNewButton_2.addActionListener(this);
		btnNewButton.addActionListener(this);

	}

	PTXTDataBase t1 = new PTXTDataBase();
	java.sql.Connection conn = t1.getConnection();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String shop = textField_1.getText();
		String name = textField.getText();
		if (e.getSource() == btnNewButton_2){
		try{    
			Connection conn = PTXTDataBase.getConnection();
		{
			
			Object[][] info2 = PTXTDataBase.Rsearch(conn);       //将数据库数据转换为jtable表
			// 定义表头  
			String[] title = {"商店名","商品名","是否能接单"};  
		   
			this.table = new JTable(info2,title);  
			// 显示表头  
			this.jth = this.table.getTableHeader();  
			this.scrollPane.setViewportView(table);
			
			
		}
		}catch(SQLException sqle){  
		JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);  
		}
	}
		if (e.getSource() == btnNewButton){

			// 弹出确认地址窗口
		receive r=new receive();
		r.setShop(shop);
		r.setName(name);

		try {
			if (r.checkreceive()) {
          new AlreadReceive();
				
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
		}
	}
