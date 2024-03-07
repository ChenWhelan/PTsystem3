package GUi;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Order extends JFrame implements ActionListener {
	private JButton button = new JButton("查询");
	private JButton button1 = new JButton("退单");
	private JButton btnNewButton = new JButton("\u518D\u4E0B\u4E00\u5355");
	private JTableHeader jth;
	private JTable tabDemo;
	private JScrollPane scpDemo;
	private JLabel l = new JLabel("请输入您下单所用的手机号：");
	private JTextField userphone = new JTextField();
	int numClicks = 0;
	int credit=100;
	private final JLabel label = new JLabel("");
	public static void main(String[] args) {
		new Order();
	}

	public Order() {
		setResizable(false);
		JFrame frame = new JFrame();
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("已下订单界面");
		this.setBounds(100, 200, 997, 696);
		this.setVisible(true);

		// 退单按钮
		button.setBounds(51, 550, 250, 60);
		this.getContentPane().add(button);
		button.addActionListener(this);

		// 确认订单按钮
		button1.setBounds(376, 550, 250, 60);
		this.getContentPane().add(button1);
		button1.addActionListener(this);

		// 订单界面
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(184, 140, 636, 373);
		getContentPane().add(scpDemo);
		l.setFont(new Font("楷体", Font.PLAIN, 15));

		this.getContentPane().add(l);
		l.setBounds(184, 67, 195, 60);

		this.getContentPane().add(userphone);
		userphone.setBounds(390, 74, 300, 46);

		btnNewButton.setBounds(693, 550, 250, 60);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);
		button1.setMnemonic(KeyEvent.VK_I); //设置按钮的热键为'I'
		label.setIcon(new ImageIcon(Order.class.getResource("/images/\u5403_\u770B\u56FE\u738B.jpg")));
		label.setBounds(0, 0, 981, 657);
		
		getContentPane().add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String phone = userphone.getText();
		if (e.getSource() == button) {
			Csearch cs = new Csearch();
			cs.setPhone(phone);
			try {
				Connection conn = Csearch.getConnection();
				{

					Object[][] info = Csearch.search(conn); // 将数据库数据转换为jtable表
					// 定义表头
					String[] title = { "姓名", "手机号码", "地址", "商品名", "商品名",
							"预付金额", "是否被接单" };

					this.tabDemo = new JTable(info, title);

					this.jth = this.tabDemo.getTableHeader();

					this.scpDemo.setViewportView(tabDemo);
				}
			} catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
						JOptionPane.ERROR_MESSAGE);

			}
		}
		if (e.getSource() == button1) {
			Delete d = new Delete();
			d.setPhone(phone);
			try {
				if (d.check()) {
					
					new Custom();

				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.dispose();
		}
		if (e.getSource() == btnNewButton) {
			new Custom();
			this.dispose();
		}
	}
}
