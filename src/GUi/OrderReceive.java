package GUi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OrderReceive {
    static String riderid;
    
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
			System.out.println("�������ݿ����ӳɹ���");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ�����ʧ�ܣ�");
		}
		return conn;
	}
    void setRiderID(String riderid) {
        this.riderid = riderid;
    }
    

 public static Object[][] riderid(Connection conn) throws SQLException {
 	String sql1 = "select * from dingdan where riderid ='"+riderid+"'";   
 	java.sql.PreparedStatement pstm =null;
 	try
		{
			pstm = conn.prepareStatement(sql1);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
 	// ִ�в�ѯ  
 	ResultSet rs = pstm.executeQuery();  
 	// �����ж�������¼  
 	int count = 0;  
 	
 	while(rs.next()){  
 	count++;  
 	}  
 	rs = pstm.executeQuery();  
 	Object[][] info = new Object[count][5];  
 	count = 0;  
 	while(rs.next()){  
 	info[count][0] = rs.getString("name");  
 	info[count][1] = rs.getString("phone") ;  
 	info[count][2] = rs.getString("address");  
 	info[count][3] = rs.getString("shop");
 	info[count][4] = rs.getString("item");
 	
 	count++;  
 	}  
 	
 	return info;
 	  
 }

 	
 }

