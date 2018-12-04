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

public class Goods {
	String goods_id;
	String goods_name;
	String goods_price;
	String goods_stock;
	String goods_shelf;
	String goods_image;


	public Goods(String goods_id,String goods_name,String goods_price,String goods_stock,String goods_shelf,String goods_image){
		this.goods_id=goods_id;
		this.goods_name=goods_name;
		this.goods_price=goods_price;
		this.goods_stock=goods_stock;
		this.goods_shelf=goods_shelf;
		this.goods_image=goods_image;
	}

	public Goods(){}
	
	public boolean add_goods() throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		String sql="insert into goods_info(goods_name,goods_price,goods_stock,goods_shelf,goods_image)values('"+goods_name+"','"+goods_price+"','"+goods_stock+"','"+goods_shelf+"','"+goods_image+"')";
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
	public String search_goods() throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from goods_info " ;
		rs=st.executeQuery(sql);
		//System.out.println(sql);
		JSONArray result=new JSONArray();
		while(rs.next()){
			JSONObject obj=new JSONObject();
			int goods_id=rs.getInt("goods_id");
			String goods_image=rs.getString("goods_image");
			String goods_name=rs.getString("goods_name");
			String goods_price=rs.getString("goods_price");
			String goods_stock=rs.getString("goods_stock");
			String goods_shelf=rs.getString("goods_shelf");
			
			
			obj.put("goods_id",goods_id);
			obj.put("goods_image",goods_image);
			obj.put("goods_name",goods_name);
			obj.put("goods_price",goods_price);
			obj.put("goods_stock",goods_stock);
			obj.put("goods_shelf",goods_shelf);
			
			result.put(obj);
		}
		conn.close();
		st.close();
		rs.close();
		return result.toString();
	}
	
	public String edit_searchgoods(String goods_id) throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from goods_info where goods_id='"+goods_id+"'" ;
		rs=st.executeQuery(sql);
		System.out.println(sql);
		JSONObject obj=new JSONObject();
		
		if(rs.next()){

			//int goods_id=rs.getInt("goods_id");
			String goods_image=rs.getString("goods_image");
			String goods_name=rs.getString("goods_name");
			String goods_price=rs.getString("goods_price");
			String goods_stock=rs.getString("goods_stock");
			String goods_shelf=rs.getString("goods_shelf");
			
			
			obj.put("goods_id",goods_id);
			obj.put("goods_image",goods_image);
			obj.put("goods_name",goods_name);
			obj.put("goods_price",goods_price);
			obj.put("goods_stock",goods_stock);
			obj.put("goods_shelf",goods_shelf);
			
		}
		conn.close();
		st.close();
		rs.close();
		return obj.toString();
	}
	
	public boolean edit_goods() throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		DateFormat d=DateFormat.getDateTimeInstance();
		//String pubdate = d.format(new Date());//获取系统当前时间
		String sql="update goods_info set goods_name='"+goods_name+"',goods_price='"+goods_price+"',goods_stock='"+goods_stock+"',goods_shelf='"+goods_shelf+"',goods_image='"+goods_image+"' where goods_id='"+goods_id+"' ";
		//System.out.println(sql);
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
	public boolean del_goods(String delgoods_id) throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		
		String sql="delete from goods_info where goods_id='"+delgoods_id+"'";
		//System.out.println(sql);
		if(st.executeUpdate(sql)>0){
			flag=true;
		}
		conn.close();
		st.close();
		return flag;
	}
	
	public String buy_searchgoods(String goods_id) throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from goods_info where goods_id='"+goods_id+"'" ;
		rs=st.executeQuery(sql);
		System.out.println(sql);
		JSONObject obj=new JSONObject();
		
		if(rs.next()){

			//int goods_id=rs.getInt("goods_id");
			String goods_image=rs.getString("goods_image");
			String goods_name=rs.getString("goods_name");
			String goods_price=rs.getString("goods_price");
			String goods_stock=rs.getString("goods_stock");
			String goods_shelf=rs.getString("goods_shelf");
			
			
			obj.put("goods_id",goods_id);
			obj.put("goods_image",goods_image);
			obj.put("goods_name",goods_name);
			obj.put("goods_price",goods_price);
			obj.put("goods_stock",goods_stock);
			obj.put("goods_shelf",goods_shelf);
			
		}
		conn.close();
		st.close();
		rs.close();
		return obj.toString();
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