package GUi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Paysuccess extends JFrame implements ActionListener{
	private JButton button =  new  JButton("确认");
	
	public static void main(String[] args) {
		new Paysuccess();
		}
	
	
	public Paysuccess() {
		JFrame frame = new JFrame();
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("付款成功");
		this.setBounds(100,200,258,285);
		this.setVisible(true);
		
		//付款成功
		JLabel labelsuccess = new JLabel("付款成功！");
		labelsuccess.setFont(new Font("楷体", Font.PLAIN, 18));
		labelsuccess.setAlignmentY(CENTER_ALIGNMENT);
		labelsuccess.setBounds(162, 94, 91, 67);//字的位置
		this.getContentPane().add(labelsuccess);
			
		//确认按钮
		button.setBounds(179, 160, 74, 30);
		this.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Paysuccess.class.getResource("/images/pay.jpg")));
		label.setBounds(0, 0, 253, 256);
		getContentPane().add(label);
		button.addActionListener(this);
				
		this.setResizable(false);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == button){
			// 关闭当前窗口
			new Order();
			this.dispose();
		}
		
	}
	
	

}