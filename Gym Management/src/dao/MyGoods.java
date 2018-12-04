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

public class MyGoods {
	String buygoods_id;
	String linkgoods_id;
	String buygoods_name;
	String buygoods_price;
	String buygoods_stock;
	String buygoods_shelf;
	String customer_name;
	String customer_phone;
	String customer_address;
	String goods_sendout;


	public MyGoods(String linkgoods_id,
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

	public MyGoods(){}
	
	public String search_mygoods() throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from buygoods_info";
		rs=st.executeQuery(sql);
		System.out.println(sql);
		JSONArray result=new JSONArray();
		while(rs.next()){
			JSONObject obj=new JSONObject();
			int linkgoods_id=rs.getInt("linkgoods_id");
			String buygoods_name=rs.getString("buygoods_name");
			String buygoods_price=rs.getString("buygoods_price");
			String buygoods_stock=rs.getString("buygoods_stock");
			String buygoods_shelf=rs.getString("buygoods_shelf");
			String customer_name=rs.getString("customer_name");
			String customer_phone=rs.getString("customer_phone");
			String customer_address=rs.getString("customer_address");
			String goods_sendout=rs.getString("goods_sendout");
			
			
			obj.put("linkgoods_id",linkgoods_id);
			obj.put("buygoods_name",buygoods_name);
			obj.put("buygoods_price",buygoods_price);
			obj.put("buygoods_stock",buygoods_stock);
			obj.put("buygoods_shelf",buygoods_shelf);
			obj.put("customer_name",customer_name);
			obj.put("customer_phone",customer_phone);
			obj.put("customer_address",customer_address);
			obj.put("goods_sendout",goods_sendout);
			result.put(obj);
		}
		conn.close();
		st.close();
		rs.close();
		return result.toString();
	}
	
	public boolean del_mygoods(String delgoods_id) throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		
		String sql="delete from buygoods_info where linkgoods_id='"+delgoods_id+"'";
		//System.out.println(sql);
		if(st.executeUpdate(sql)>0){
			flag=true;
		}
		conn.close();
		st.close();
		return flag;
	}
	
	public boolean sendout_goods(String sendout_goods_id) throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		String sql="update buygoods_info set goods_sendout='Sended out' where linkgoods_id='"+sendout_goods_id+"' ";
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
