package sql;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import data.CUser;
import data.RUser;
import data.customdingdan;



public class PTXTDataBase {
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

	private static String toSqlString(String str) {
		return new String(" '" + str + "' ");
	}
	
	public static CUser userQquery1(String accountName) {
		CUser user1= null;
		String sql = "select * from custom where ID = " + toSqlString(accountName);
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next() == true) {
				user1= new CUser();
				user1.setId(rs.getLong(1));
				user1.setName(rs.getString(2));
				user1.setPwd(rs.getString(3));
			}
		} catch (SQLException sqle) {
			System.out.println("查询数据出现异常: " + sqle.getMessage());
		}

		return user1;
	}
	
	public static RUser userQquery2(String accountName) {
		RUser user2= null;
		String sql = "select * from rider where ID = " + toSqlString(accountName);
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next() == true) {
				user2= new RUser();
				user2.setId(rs.getLong(1));
				user2.setName(rs.getString(2));
				user2.setPwd(rs.getString(3));
			}
		} catch (SQLException sqle) {
			System.out.println("查询数据出现异常: " + sqle.getMessage());
		}

		return user2;
	}
	public static int i=1;
   
    
    
    public static Object[][] Rsearch(Connection conn) throws SQLException {
    	String sql1 = "select * from dingdan where num =0";   
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
    	Object[][] info2 = new Object[count][3];  
    	count = 0;  
    	while(rs.next()){   
    	info2[count][0] = rs.getString("shop");  
    	info2[count][1] = rs.getString("item");
    	info2[count][2] = rs.getString("num");
    	count++;  
    	}  
    	
    	return info2;
    	  
    }
    
    public static Object[][] rank(Connection conn) throws SQLException {
    	String sql2 = "select * from rider order by dingdan desc";   
    	java.sql.PreparedStatement pstm =null;
		try
		{
			pstm = conn.prepareStatement(sql2);
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
    	Object[][] info1 = new Object[count][2];  
    	count = 0;  
    	while(rs.next()){  
    	info1[count][0] = rs.getString("name");  
    	info1[count][1] = rs.getString("dingdan") ;  

    	count++;  
    	}  
    return info1;
    	  
    }
    public static customdingdan userQquery3(String riderid) {
		customdingdan dingdan= null;
		String sql = "select * from dingdan where riderid = " + toSqlString(riderid);
		try {
			Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next() == true) {
				dingdan= new customdingdan();
				dingdan.setName(rs.getString(1));
				dingdan.setPhone(rs.getString(2));
				dingdan.setRiderId(rs.getString(3));
				dingdan.setShop(rs.getString(4));
				dingdan.setItem(rs.getString(5));
				dingdan.setAmount(rs.getString(6));
				dingdan.setNum(rs.getString(7));
				dingdan.setRiderId(rs.getString(8));
			}
		} catch (SQLException sqle) {
			System.out.println("查询数据出现异常: " + sqle.getMessage());
		}

		return dingdan;
	}
}

