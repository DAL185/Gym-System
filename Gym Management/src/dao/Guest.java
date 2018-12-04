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

public class Guest{

	
	String guest_name;
	String guest_gender;
	String guest_type;
	String guest_duetime;
	String guest_phone;
	String guest_height;
	String guest_weight;
	String guest_surround;
	String guest_fatrate;
	String guest_heartrate;
	String guest_advice;
	String guest_remark;
	String course_id;
	String course_name;
	String course_date;
	String course_time;
	String course_coach;
	String course_room;
	
	public Guest(String guest_name,String guest_gender,String guest_type,String guest_duetime,String guest_phone,String guest_height,String guest_weight,String guest_surround,String guest_fatrate,String guest_heartrate,String guest_advice,String guest_remark,
			String course_id,String course_name,String course_date,String course_time,String course_coach,String course_room){
		
		this.guest_name=guest_name;
		this.guest_gender=guest_gender;
		this.guest_type=guest_type;
		this.guest_duetime=guest_duetime;
		this.guest_phone=guest_phone;
		this.guest_height=guest_height;
		this.guest_weight=guest_weight;
		this.guest_surround=guest_surround;
		this.guest_fatrate=guest_fatrate;
		this.guest_heartrate=guest_heartrate;
		this.guest_advice=guest_advice;
		this.guest_remark=guest_remark;//在class里构造一个方法
		this.course_id=course_id;
		this.course_name=course_name;
		this.course_date=course_date;
		this.course_time=course_time;
		this.course_coach=course_coach;
		this.course_room=course_room;
	}
	public Guest(){}
	
	
	
	public String searchguest(String guest_phone) throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from member_info where phone='"+guest_phone+"'" ;
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
	
	public String guest_searchcourse() throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from course_info order by course_date desc"; 
		rs=st.executeQuery(sql);
		System.out.println(sql);
		JSONArray result=new JSONArray();
		while(rs.next()){
			JSONObject obj=new JSONObject();
			int course_id=rs.getInt("course_id");
			String course_name=rs.getString("course_name");
			String course_date=rs.getString("course_date");
			String course_time=rs.getString("course_time");
			String course_coach=rs.getString("course_coach");
			String course_room=rs.getString("course_room");
			
			obj.put("course_id",course_id);
			obj.put("course_name",course_name);
			obj.put("course_date",course_date);
			obj.put("course_time",course_time);
			obj.put("course_coach",course_coach);
			obj.put("course_room",course_room);
			result.put(obj);
		}
		conn.close();
		st.close();
		rs.close();
		return result.toString();
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
