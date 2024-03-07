package GUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;

/*
 * ע�����
 * 
 */
public class UserRegister extends JFrame{
	UserRegister () {
		init();
		
		
	}
	void init() {
            JFrame frame = new JFrame("ע���˺�");
            frame.setResizable(false);
            frame.setTitle("\u6CE8\u518C\u8D26\u53F7");
            frame.getContentPane().setLayout(null);
           
            
            JLabel nameStr = new JLabel("�û���:");
            nameStr.setFont(new Font("���Ŀ���", Font.PLAIN, 20));
            nameStr.setBounds(116, 80, 100, 25);
            frame.getContentPane().add(nameStr);
        
            JLabel IDStr = new JLabel("�˺�:");
            IDStr.setFont(new Font("���Ŀ���", Font.PLAIN, 20));
            IDStr.setBounds(116, 138, 100, 25);
            frame.getContentPane().add(IDStr);

            JLabel passwordStr = new JLabel("����:");
            passwordStr.setFont(new Font("���Ŀ���", Font.PLAIN, 20));
            passwordStr.setBounds(116, 194, 100, 25);
            frame.getContentPane().add(passwordStr);  
               
            JLabel confrimStr = new JLabel("ȷ������:");
            confrimStr.setFont(new Font("���Ŀ���", Font.PLAIN, 20));
            confrimStr.setBounds(116, 247, 100, 30);
            frame.getContentPane().add(confrimStr);
            
            JTextField userName = new JTextField();
            userName.setBounds(221, 82, 150, 25);
            frame.getContentPane().add(userName);

            JTextField userID = new JTextField();
            userID.setBounds(221, 140, 150, 25);
            frame.getContentPane().add(userID);

            JPasswordField password = new JPasswordField();
            password.setBounds(221, 196, 150, 25);
            frame.getContentPane().add(password);

            JPasswordField confrimPassword = new JPasswordField();
            confrimPassword.setBounds(221, 252, 150, 25);
            frame.getContentPane().add(confrimPassword);
            
            JButton buttonregister = new JButton("ע��");
            buttonregister.setFont(new Font("���Ŀ���", Font.PLAIN, 20));
            buttonregister.setBounds(116, 342, 100, 25);
            frame.getContentPane().add(buttonregister);
            
            JButton reset = new JButton("\u91CD\u7F6E");
            reset.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent arg0) {
            		userName.setText(" ");
            		userID.setText(" ");
            		password.setText("");
            		confrimPassword.setText("");
            		
            		
            		
            	}
            });
            reset.setFont(new Font("���Ŀ���", Font.PLAIN, 20));
            reset.setBounds(274, 343, 97, 23);
            frame.getContentPane().add(reset);
            
            JLabel lblNewLabel = new JLabel("\u6CE8\u518C\u754C\u9762");
            lblNewLabel.setForeground(Color.BLUE);
            lblNewLabel.setFont(new Font("���Ŀ���", Font.PLAIN, 30));
            lblNewLabel.setBounds(194, 26, 130, 25);
            frame.getContentPane().add(lblNewLabel);
            
            JRadioButton customer_rdbtn = new JRadioButton("�˿�");
            customer_rdbtn.setFont(new Font("���Ŀ���", Font.PLAIN, 18));
            customer_rdbtn.setBounds(221, 294, 61, 25);
            frame.getContentPane().add(customer_rdbtn);
            
            JRadioButton rider_rdbtn = new JRadioButton("����");
            rider_rdbtn.setFont(new Font("���Ŀ���", Font.PLAIN, 18));
            rider_rdbtn.setBounds(310, 295, 61, 23);
            frame.getContentPane().add(rider_rdbtn);
            
            
            ButtonGroup bgp=new ButtonGroup();
            bgp.add(customer_rdbtn);
            bgp.add(rider_rdbtn);
            
            JLabel label = new JLabel("");
            label.setIcon(new ImageIcon(UserRegister.class.getResource("/images/\u6CE8\u518C.jpg")));
            label.setBounds(0, 0, 512, 392);
            frame.getContentPane().add(label);


            frame.setBounds(400, 100, 518, 421);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
          //Ϊע�ᰴť���Ӽ�����
            buttonregister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = userName.getText();
				String ID = userID.getText();
				String passwd = new String(password.getPassword());
				String confrimpasswd = new String(confrimPassword.getPassword());
				if (rider_rdbtn.isSelected()) {
					// ���ȷ�������ת��������
					RRegister rregister = new RRegister();
					rregister.setID(ID);
					rregister.setName(name);
					rregister.setPassword(passwd);
					rregister.setconfirmpasswd(confrimpasswd);
					// ���ע��ɹ������ص�¼����
					try {
						if (rregister.JudgeRegister()) {

							frame.setVisible(false);
							Login_Register login_register = new Login_Register();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (customer_rdbtn.isSelected()) {
					CRegister cregister = new CRegister();
					cregister.setID(ID);
					cregister.setName(name);
					cregister.setPassword(passwd);
					cregister.setconfirmpasswd(confrimpasswd);
					// ���ע��ɹ������ص�¼����
					try {
						if (cregister.JudgeRegister()) {

							frame.setVisible(false);
							Login_Register login_register = new Login_Register();
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
                
            });
	}
}
