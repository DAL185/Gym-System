package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Statement;

public class Guest_member{

	
	
	String name;
	String gender;
	String type;
	String duetime;
	String phone;
	String height;
	String weight;
	String surround;
	String fatrate;
	String heartrate;
	String advice;
	String remark;
	
	
public Guest_member(String name,String gender,String type,String duetime,String phone,String height,String weight,String surround,String fatrate,String heartrate,String advice,String remark){
		
		
		this.name=name;
		this.gender=gender;
		this.type=type;
		this.duetime=duetime;
		this.phone=phone;
		this.height=height;
		this.weight=weight;
		this.surround=surround;
		this.fatrate=fatrate;
		this.heartrate=heartrate;
		this.advice=advice;
		this.remark=remark;//在class里构造一个方法
	}
	public Guest_member(){}
	
	
	
	public String searchguest(String ph) throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		
		String sql="select * from member_info where phone='"+ph+"'" ;
		rs=st.executeQuery(sql);
		System.out.println(sql);
		JSONObject obj=new JSONObject();
		
		if(rs.next()){
			
			
			String name=rs.getString("name");
			String gender=rs.getString("gender");
			String pubdate=rs.getString("pubdate");
			String type=rs.getString("type");
			String duetime=rs.getString("duetime");
			String phone=rs.getString("phone");
			String height=rs.getString("height");
			String weight=rs.getString("weight");
			String surround=rs.getString("surround");
			String fatrate=rs.getString("fatrate");
			String heartrate=rs.getString("heartrate");
			String advice=rs.getString("advice");
			String remark=rs.getString("remark");
			
			
			obj.put("name",name);
			obj.put("gender",gender);
			obj.put("pubdate",pubdate);
			obj.put("type",type);
			obj.put("duetime",duetime);
			obj.put("phone",phone);
			obj.put("height",height);
			obj.put("weight",weight);
			obj.put("surround",surround);
			obj.put("fatrate",fatrate);
			obj.put("heartrate",heartrate);
			obj.put("advice",advice);
			obj.put("remark",remark);
			
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
