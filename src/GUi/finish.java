package GUi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import java.util.ArrayList;

import javax.swing.JOptionPane;



public class finish {

    String phone;
    String riderid;

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/PTXT?useSSL=false";
    private String user = "root";
    private String sqlpassword = "sql2000";
    
    void setPhone(String phone) {
        this.phone = phone;
    }
    void setRiderID(String riderid) {
        this.riderid = riderid;
    }
 boolean check() throws SQLException, ClassNotFoundException {
        
        if(this.phone.equals("")) {
            JOptionPane.showMessageDialog(null, "手机号不得为空", "手机号为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(this.riderid.equals("")) {
            JOptionPane.showMessageDialog(null, "账号不得为空", "账号为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        finish1();
        finish2();
        finish3();
         return true;
}
 void finish1() throws ClassNotFoundException, SQLException {
 	Class.forName(driver);
 	String sql = "delete from dingdan where phone ='"+phone+"'";   
	
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
	System.out.println("删除到数据库成功");
 	
 }
 void finish2() throws ClassNotFoundException, SQLException {
	 	Class.forName(driver);
	 	String sql = "update rider set income = income+3 where id ='"+riderid+"'";   
		
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
 void finish3() throws ClassNotFoundException, SQLException {
	 	Class.forName(driver);
	 	String sql = "update rider set dingdan = dingdan+1 where id ='"+riderid+"'";   
		
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

