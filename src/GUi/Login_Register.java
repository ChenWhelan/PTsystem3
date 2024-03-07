package GUi;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JRadioButton;

import sql.PTXTDataBase;
import data.CUser;
import data.RUser;
import messages.Message;


import javax.swing.ImageIcon;
public class Login_Register extends JFrame{    
	static Socket socket;
	static ObjectOutputStream oos ;
	static ObjectInputStream ois ;

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login_Register() {
		init();
		
	}
	//��¼�����ʼ��
	public void init() {
		
	    JFrame frame = new JFrame("��¼");
	    frame.setResizable(false);
	    frame.setTitle("��¼/ע��");
        frame.getContentPane().setLayout(null);
        
        JLabel nameStr = new JLabel("�˺�:");
        nameStr.setForeground(new Color(0, 0, 255));
        nameStr.setFont(new Font("���Ŀ���", Font.PLAIN, 20));
        nameStr.setBounds(116, 140, 100, 25);
        frame.getContentPane().add(nameStr);
        
        JLabel passwordStr = new JLabel("����:");
        passwordStr.setForeground(new Color(255, 0, 0));
        passwordStr.setFont(new Font("���Ŀ���", Font.PLAIN, 20));
        passwordStr.setBounds(116, 211, 100, 25);
        frame.getContentPane().add(passwordStr);  
        
        JTextField userID = new JTextField();
        userID.setFont(new Font("���Ŀ���", Font.PLAIN, 15));
        userID.setBounds(182, 141, 182, 25);
        frame.getContentPane().add(userID);
        
        JPasswordField password = new JPasswordField();
        password.setBounds(182, 213, 182, 25);
        frame.getContentPane().add(password);
        
        JButton buttonlogin = new JButton("��¼");
        buttonlogin.setFont(new Font("���Ŀ���", Font.PLAIN, 20));
        buttonlogin.setBounds(116, 300, 100, 25);
        frame.getContentPane().add(buttonlogin);
        
        JButton buttonregister = new JButton("ע��");
        buttonregister.setFont(new Font("���Ŀ���", Font.PLAIN, 20));
        buttonregister.setBounds(293, 300, 100, 25);
        frame.getContentPane().add(buttonregister);  
        
        JLabel lblNewLabel = new JLabel("��Է������ϵͳ");
        lblNewLabel.setForeground(SystemColor.desktop);
        lblNewLabel.setFont(new Font("���Ŀ���", Font.PLAIN, 30));
        lblNewLabel.setBounds(151, 22, 210, 25);
        frame.getContentPane().add(lblNewLabel);
        
        JRadioButton customer_rdbtn = new JRadioButton("�˿�");
        customer_rdbtn.setFont(new Font("���Ŀ���", Font.PLAIN, 18));
        customer_rdbtn.setBounds(399, 223, 87, 25);
        frame.getContentPane().add(customer_rdbtn);
        
        JRadioButton rider_rdbtn = new JRadioButton("����");
        rider_rdbtn.setFont(new Font("���Ŀ���", Font.PLAIN, 18));
        rider_rdbtn.setBounds(399, 198, 87, 23);
        frame.getContentPane().add(rider_rdbtn);
        
        frame.setBounds(400, 100, 506, 408);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        ButtonGroup bgp=new ButtonGroup();
        bgp.add(customer_rdbtn);
        bgp.add(rider_rdbtn);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(Login_Register.class.getResource("/images/pt.jpg")));
        label.setBounds(0, 0, 500, 379);
        frame.getContentPane().add(label);
        //Ϊ��¼��ť��Ӽ�����
         buttonlogin.addActionListener(new ActionListener() {  
            

			public void actionPerformed(ActionEvent e) {
                String ID = userID.getText();
                String passwd = new String (password.getPassword());
    			CUser cu = PTXTDataBase.userQquery1(ID);
    			RUser ru = PTXTDataBase.userQquery2(ID);
    			if (ru != null && ru.verifyPwd(passwd)&&rider_rdbtn.isSelected()) {
    				new rider();
    				frame.setVisible(false);
    				rider r=new rider();
    				r.setVisible(true);

    				
    			}
    				else if (cu != null && cu.verifyPwd(passwd)&&customer_rdbtn.isSelected()) {
    					Custom c =new Custom();
    			
    			} else {
    				JOptionPane.showMessageDialog(null, "��¼ʧ��,�û����������������");
    			}
    
          
            }

			   
        });

			try {
				socket = new Socket("127.0.0.1",8888);
				oos =  new ObjectOutputStream(socket.getOutputStream()) ;
		        ois = new ObjectInputStream(socket.getInputStream()) ;
		        Message message = new Message();
		    	message.setType(0);
		    	Login_Register.oos.writeObject(message);
		    	
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
         
         //Ϊע�ᰴť��Ӽ�����
         buttonregister.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent e) {
        		 //ע��ҳ��
                 frame.setVisible(false);
        		 UserRegister ar = new UserRegister(); 
        	 }
         });
	}


	public static void main(String []args) { 
       //������
       //��¼����
   
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Register login_register = new Login_Register();
					//login_register.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}
}




