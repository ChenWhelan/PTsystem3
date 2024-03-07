package GUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import sql.PTXTDataBase;
import javax.swing.ImageIcon;

public class rank extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTableHeader jth;  
	private JTable tabDemo; 
	private JScrollPane scpDemo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new rank();
	}

	/**
	 * Create the frame.
	 */
	public rank() {
		setFrameIcon(new ImageIcon(rank.class.getResource("/com/sun/java/swing/plaf/windows/icons/UpFolder.gif")));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 511, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.scpDemo = new JScrollPane();  
		this.scpDemo.setBounds(176,156,862,473);
		getContentPane().add(scpDemo); 
		this.setVisible(true);
		this.setTitle("金牌骑手排行榜");
		try{    
			Connection conn = PTXTDataBase.getConnection();
		{
			
			Object[][] info = PTXTDataBase.rank(conn);  
			// 定义表头  
			String[] title = {"姓名","接单数目"};  
		   
			this.tabDemo = new JTable(info,title);  
			// 显示表头  
			this.jth = this.tabDemo.getTableHeader();  
			this.scpDemo.setViewportView(tabDemo);
			scpDemo.setVisible(true);
		}
		}catch(SQLException sqle){  
		JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);  
		}
	}
	}