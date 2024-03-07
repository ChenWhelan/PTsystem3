package GUi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Csearch {
    static String phone;
    
	public static Connection getConnection() {
		Connection conn = null;
		String driver_MySQL = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/PTXT?useUnicode=true&characterEncoding=utf-8";
		String account_MySQL = "root";
		String password_MySQL = "sql2000";

		try {
			Class.forName(driver_MySQL);
			conn = DriverManager.getConnection(url, account_MySQL,
					password_MySQL);
			System.out.println("创建数据库连接成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("创建数据库连接失败！");
		}
		return conn;
	}
    void setPhone(String phone) {
        this.phone = phone;
    }
    
 
 public static Object[][] search(Connection conn) throws SQLException {
 	String sql1 = "select * from dingdan where phone ='"+phone+"'";   
 	java.sql.PreparedStatement pstm =null;
 	try
		{
			pstm = conn.prepareStatement(sql1);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
 	// 执行查询  
 	ResultSet rs = pstm.executeQuery();  
 	// 计算有多少条记录  
 	int count = 0;  
 	
 	while(rs.next()){  
 	count++;  
 	}  
 	rs = pstm.executeQuery();  
 	Object[][] info = new Object[count][7];  
 	count = 0;  
 	while(rs.next()){  
 	info[count][0] = rs.getString("name");  
 	info[count][1] = rs.getString("phone") ;  
 	info[count][2] = rs.getString("address");  
 	info[count][3] = rs.getString("shop");
 	info[count][4] = rs.getString("item");
 	info[count][5] = rs.getString("amount");
 	info[count][6] = rs.getString("num");
 	count++;  
 	}  
 	
 	return info;
 	  
 }

 	
 }
