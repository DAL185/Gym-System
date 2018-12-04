package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Statement;

public class PayGoods {
	String buygoods_id;
	String linkgoods_id;
	String buygoods_name;
	String buygoods_price;
	String buygoods_stock;
	String buygoods_shelf;
	String customer_name;
	String customer_phone;
	String customer_address;


	public PayGoods(String linkgoods_id,
			String buygoods_name,String buygoods_price,
			String buygoods_stock,String buygoods_shelf,
			String customer_name,String customer_phone,String customer_address){
	
		this.linkgoods_id=linkgoods_id;
		this.buygoods_name=buygoods_name;
		this.buygoods_price=buygoods_price;
		this.buygoods_stock=buygoods_stock;
		this.buygoods_shelf=buygoods_shelf;
		this.customer_name=customer_name;
		this.customer_phone=customer_phone;
		this.customer_address=customer_address;
		
	}

	public PayGoods(){}
	
	public boolean pay_goods() throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		String sql="insert into buygoods_info(linkgoods_id,buygoods_name,buygoods_price,buygoods_stock,buygoods_shelf,customer_name,customer_phone,customer_address)" +
				"values('"+linkgoods_id+"','"+buygoods_name+"','"+buygoods_price+"','"+buygoods_stock+"','"+buygoods_shelf+"','"+customer_name+"','"+customer_phone+"','"+customer_address+"')";
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
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
