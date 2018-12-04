package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class User {
	private String username;
	private String pwd;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn=getConn();
		// TODO Auto-generated method stub

	}
	public User(String username, String pwd){
		this.username = username;
		this.pwd = pwd;
	}
	
	public boolean register() throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		String sql="insert into user(username,pwd)values('"+username+"','"+pwd+"')";
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
	//查找用户
	public boolean searchUser() throws Exception{
		boolean flag = false;
		Connection conn=getConn();
		java.sql.Statement st = conn.createStatement();//String test="i am "+username;
		String sql = "select * from user where username = '"+username+"' and pwd= '"+pwd+"' ";
		System.out.println(sql);
		java.sql.ResultSet rs=st.executeQuery(sql);
		if(rs.next()){
			flag=true;
		}
		conn.close();
		st.close();
		rs.close();
		return flag;
	}
 
	//连接数据库
	private static Connection getConn(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/david?characterEncoding=utf8";
		String username = "root";
		String password = "";
		Connection conn=null;
		try{
			Class.forName(driver); //classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url,username,password);
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
}
