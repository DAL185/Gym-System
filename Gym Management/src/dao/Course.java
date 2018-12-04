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

public class Course {
	String course_id;
	String course_name;
	String course_date;
	String course_time;
	String course_coach;
	String course_room;
	


	//有参构造方法
	public Course(String course_id,String course_name,String course_date,String course_time,String course_coach,String course_room){
		this.course_id=course_id;
		this.course_name=course_name;
		this.course_date=course_date;
		this.course_time=course_time;
		this.course_coach=course_coach;
		this.course_room=course_room;
	}
	
	public Course(){}      //无参构造方法
	
	public boolean add_course() throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		String sql="insert into course_info(course_name,course_date,course_time,course_coach,course_room)values('"+course_name+"','"+course_date+"','"+course_time+"','"+course_coach+"','"+course_room+"')";
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
	public String search_course() throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from course_info order by course_date desc; " ;
		rs=st.executeQuery(sql);
		//System.out.println(sql);
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
	
	public String find_course(String keywords) throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from course_info where course_id='"+keywords+"' OR course_name='"+keywords+"' OR course_coach='"+keywords+"' OR course_room='"+keywords+"' order by course_date desc; " ;
		rs=st.executeQuery(sql);
		//System.out.println(sql);
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
	
	
	public String edit_searchcourse(String course_id) throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from course_info where course_id='"+course_id+"'" ;
		rs=st.executeQuery(sql);
		System.out.println(sql);
		JSONObject obj=new JSONObject();
		
		if(rs.next()){
			
			//int id=rs.getInt("id");
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
			
		}
		conn.close();
		st.close();
		rs.close();
		return obj.toString();
	}
	
	
	
	public boolean edit_course() throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		String sql="update course_info set course_name='"+course_name+"',course_date='"+course_date+"',course_time='"+course_time+"',course_coach='"+course_coach+"',course_room='"+course_room+"' where course_id='"+course_id+"'";
		//System.out.println(sql);
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
	public boolean del_course(String course_id) throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		//DateFormat d=DateFormat.getDateTimeInstance();
		//String date=d.format(new Date());
		//String date=dateFormat.format( now );
		String sql="delete from course_info where course_id='"+course_id+"'";
		//System.out.println(sql);
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