package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Statement;

public class Guest_course {
	String course_id;
	String course_name;
	String course_date;
	String course_time;
	String course_coach;
	String course_room;
	
	public Guest_course(String course_id,String course_name,String course_date,String course_time,String course_coach,String course_room){
		this.course_id=course_id;
		this.course_name=course_name;
		this.course_date=course_date;
		this.course_time=course_time;
		this.course_coach=course_coach;
		this.course_room=course_room;
	}
	
	public Guest_course(){}
	
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
