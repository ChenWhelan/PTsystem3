package GUi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class credit {

    String id;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/PTXT?useSSL=false";
    private String user = "root";
    private String sqlpassword = "sql2000";
    
    void setID(String id) {
        this.id = id;
    }
  
  
 boolean check() throws SQLException, ClassNotFoundException {
        
        if(this.id.equals("")) {
            JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��", "�˺�Ϊ��", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        credit1();
        credit2();
        credit3();
         return true;
}
 void credit1() throws ClassNotFoundException, SQLException {
 	Class.forName(driver);
 	String sql = "update rider set credit = credit-1 where id ='"+id+"'";   
	
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
	System.out.println("�ɹ�");
 	
 }
 void credit2() throws ClassNotFoundException, SQLException {
	 	Class.forName(driver);
	 	String sql = "update rider set income = income-1 where id ='"+id+"'";   
		
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
		System.out.println("�ɹ�");
	 	
	 }
 void credit3() throws ClassNotFoundException, SQLException {
	 	Class.forName(driver);
	 	String sql = "update rider set dingdan = dingdan-1 where id ='"+id+"'";   
		
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
		System.out.println("�޸ĵ����ݿ�ɹ�");
	 	
	 }
}
