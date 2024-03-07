package GUi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class receive {
	String shop;
    String name;
    String phone;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/PTXT?useSSL=false";
    private String user = "root";
    private String sqlpassword = "sql2000";
    
    void setShop(String shop) {
        this.shop = shop;
    }
  
    void setName(String name) {
        this.name = name;
    }
 boolean checkreceive() throws SQLException, ClassNotFoundException {
        
        if(this.shop.equals("")) {
            JOptionPane.showMessageDialog(null, "商店名不得为空", "商店名为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.name.equals("")) {
            JOptionPane.showMessageDialog(null, "账号名不得为空", "账号名为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
       
       
       receive();
       receive2();
       receive3();
         return true;
}
 void receive() throws ClassNotFoundException, SQLException {
 	Class.forName(driver);
 	String sql = "update dingdan set num = 1 where shop ='"+shop+"'";   
	
	try
	{
		Connection conn = DriverManager.getConnection(url, user, sqlpassword);
    	
		Statement state =conn.createStatement();
		state.executeUpdate(sql);
	        conn.close();
	} catch (SQLException e)
	{
		
		e.printStackTrace();
	}	
	System.out.println("修改到数据库成功");
 	
 }
 void receive2() throws ClassNotFoundException, SQLException {
	 	String sql= "update dingdan set riderid ='"+name+"'where shop ='"+shop+"'";
	 	Class.forName(driver);
	 	try {
	 		Connection conn = DriverManager.getConnection(url, user, sqlpassword);
	    	
			Statement state =conn.createStatement();
			state.executeUpdate(sql);
		        conn.close();
		        
	 	}catch(SQLException ex) {
	 		System.out.println("接单失败！");
	 	}
	 	
	 }
 void receive3() throws ClassNotFoundException, SQLException {
	 	Class.forName(driver);
	 	String sql = "update rider set dingdan = dingdan-1 where id ='"+name+"'";   
		
		try
		{
			Connection conn = DriverManager.getConnection(url, user, sqlpassword);
	    	
			Statement state =conn.createStatement();
			state.executeUpdate(sql);
		        conn.close();
		} catch (SQLException e)
		{
			
			e.printStackTrace();
		}	
		System.out.println("修改到数据库成功");
	 	
	 }
}