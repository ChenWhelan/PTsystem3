package GUi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class add {
	String shop;
    String item;
    String amount;
    String name;
    String address;
    String phone;
    
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/PTXT?useSSL=false";
    private String user = "root";
    private String sqlpassword = "sql2000";
    
    void setShop(String shop) {
        this.shop = shop;
    }
    void setItem(String item) {
        this.item = item;
    }
    void setAmount(String amount) {
        this.amount = amount;
    }
    void setName(String name) {
        this.name = name;
    }
    void setPhone(String phone) {
        this.phone = phone;
    }
    void setAddress(String address) {
        this.address = address;
    }
 boolean checkdingdan() throws SQLException, ClassNotFoundException {
        
        if(this.shop.equals("")) {
            JOptionPane.showMessageDialog(null, "�̵�������Ϊ��", "�̵���Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.item.equals("")) {
            JOptionPane.showMessageDialog(null, "��Ʒ������Ϊ��", "��Ʒ��Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.amount.equals("")) {
            JOptionPane.showMessageDialog(null, "Ԥ������Ϊ��", "Ԥ�����Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(this.name.equals("")) {
            JOptionPane.showMessageDialog(null, "��������Ϊ��", "����Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.phone.equals("")) {
            JOptionPane.showMessageDialog(null, "�ֻ��Ų���Ϊ��", "�ֻ���Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.address.equals("")) {
            JOptionPane.showMessageDialog(null, "��ַ����Ϊ��", "��ַΪ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        JOptionPane.showMessageDialog(null, "�ɹ�");
        adddingdan();
         return true;
}
 public void adddingdan() throws ClassNotFoundException, SQLException {
 	String sql="insert into dingdan (name, phone, address,shop,item,amount,num) values (?,?,?,?,?,?,'0')";
 	Class.forName(driver);
 	try {
	    	Connection conn = DriverManager.getConnection(url, user, sqlpassword);
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, this.name);
	        ps.setString(2, this.phone);
	        ps.setString(3, this. address);
	        ps.setString(4, this.shop);
	        ps.setString(5, this.item);
	        ps.setString(6, this.amount);
	        ps.executeUpdate();
	        ps.close();	
	        conn.close();
	        
 	}catch(SQLException ex) {
 		System.out.println("��Ӷ���ʧ�ܣ�");
 	}
 	
 }
}