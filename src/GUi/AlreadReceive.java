package GUi;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import sql.PTXTDataBase;
import data.CUser;
import data.customdingdan;

public class AlreadReceive extends JFrame implements ActionListener {
	private JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private JTableHeader jth;
	private JButton btnNewButton_1 = new JButton("\u5237\u65B0\u754C\u9762");
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton = new JButton("\u53D6\u6D88\u8BA2\u5355");
	private JButton btnNewButton_2 = new JButton("\u5B8C\u6210\u8BA2\u5355");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlreadReceive frame = new AlreadReceive();
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
	public AlreadReceive() {
		setResizable(false);

		setTitle("\u5DF2\u63A5\u8BA2\u5355");
		setBounds(700, 250, 660, 687);
		getContentPane().setLayout(null);

		scrollPane.setBounds(10, 19, 630, 357);
		getContentPane().add(scrollPane);

		btnNewButton.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(14, 604, 121, 35);
		getContentPane().add(btnNewButton);

		btnNewButton_1.setFont(new Font("华文楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(524, 604, 116, 35);
		getContentPane().add(btnNewButton_1);

		JLabel label = new JLabel(
				"\u8BF7\u8F93\u5165\u60A8\u7684\u9A91\u624B\u8D26\u53F7\uFF1A");
		label.setFont(new Font("楷体", Font.PLAIN, 25));
		label.setBounds(10, 386, 275, 37);
		getContentPane().add(label);

		textField_4 = new JTextField();
		textField_4.setBounds(10, 442, 341, 24);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JLabel label_1 = new JLabel(
				"\u8BF7\u8F93\u5165\u60A8\u9700\u8981\u64CD\u4F5C\u7684\u5355\u5B50\u7684\u624B\u673A\u53F7\u7801\uFF1A");
		label_1.setFont(new Font("华文楷体", Font.PLAIN, 25));
		label_1.setBounds(10, 485, 425, 33);
		getContentPane().add(label_1);

		textField_5 = new JTextField();
		textField_5.setBounds(10, 547, 341, 24);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);

		btnNewButton_2.setFont(new Font("STKaiti", Font.PLAIN, 20));
		btnNewButton_2.setBounds(271, 604, 121, 35);
		getContentPane().add(btnNewButton_2);
		btnNewButton_1.addActionListener(this);
		btnNewButton.addActionListener(this);
		btnNewButton_2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton_1) {
			String riderid = textField_4.getText();
			OrderReceive or = new OrderReceive();
			or.setRiderID(riderid);
			try {
				Connection conn = OrderReceive.getConnection();
				{

					Object[][] info = OrderReceive.riderid(conn);
					// 定义表头
					String[] title = { "姓名", "手机号码", "地址", "商店名", "商品名" };

					this.table = new JTable(info, title);

					this.jth = this.table.getTableHeader();

					this.scrollPane.setViewportView(table);
				}
			} catch (SQLException sqle) {
				JOptionPane.showMessageDialog(null, "数据操作错误", "错误",
						JOptionPane.ERROR_MESSAGE);

			}
		}

		if (e.getSource() == btnNewButton) {
			String phone = textField_5.getText();
			String riderid = textField_4.getText();
			RDelete rd = new RDelete();
			credit c = new credit();
			customdingdan dingdan = PTXTDataBase.userQquery3(riderid);
			rd.setPhone(phone);
			c.setID(riderid);

			try {
				if(dingdan.verifyPwd(phone)){
				if (rd.check()) {
					if (c.check()) {
						JOptionPane.showMessageDialog(null, "信用分减少，扣除收入", "注意",
								JOptionPane.ERROR_MESSAGE);
					}

				}
				}else{
					JOptionPane.showMessageDialog(null, "请输入正确手机号");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btnNewButton_2) {
			String phone = textField_5.getText();
			String riderid = textField_4.getText();
			customdingdan dingdan = PTXTDataBase.userQquery3(riderid);
			finish f = new finish();
			f.setPhone(phone);
			f.setRiderID(riderid);
			try {
				if(dingdan.verifyPwd(phone)){
					if (f.check()) {
						JOptionPane.showMessageDialog(null, "恭喜你完成订单！加油，打工人！");
					}
				}else{
					JOptionPane.showMessageDialog(null, "请输入正确手机号");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
