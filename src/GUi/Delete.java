package GUi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Delete {

    String phone;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/PTXT?useSSL=false";
    private String user = "root";
    private String sqlpassword = "sql2000";
    
    void setPhone(String phone) {
        this.phone = phone;
    }
  
  
 boolean check() throws SQLException, ClassNotFoundException {
        
        if(this.phone.equals("")) {
            JOptionPane.showMessageDialog(null, "手机号不得为空", "手机号为空", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        delete();
       
         return true;
}
 void delete() throws ClassNotFoundException, SQLException {
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
}
