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


public class MyCourse {
	
	String ordercourse_id;
	String mycourse_id;
	String mycourse_name;
	String mycourse_date;
	String mycourse_time;
	String mycourse_coach;
	String mycourse_room;
	
	public MyCourse(String ordercourse_id,String mycourse_id,String mycourse_name,String mycourse_date,String mycourse_time,String mycourse_coach,String mycourse_room){
		this.ordercourse_id=ordercourse_id;
		this.mycourse_id=mycourse_id;
		this.mycourse_name=mycourse_name;
		this.mycourse_date=mycourse_date;
		this.mycourse_time=mycourse_time;
		this.mycourse_coach=mycourse_coach;
		this.mycourse_room=mycourse_room;
	}
	
	public MyCourse(){}      //无参构造方法
	
	public boolean order_course(String ordercourse_id) throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		String sql="insert into mycourse_info(ordercourse_id,mycourse_name,mycourse_date,mycourse_time,mycourse_coach,mycourse_room)" +
					"select course_id,course_name,course_date,course_time,course_coach,course_room from course_info where course_id='"+ordercourse_id+"'  ";
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
	public String search_mycourse() throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from mycourse_info" ;
		rs=st.executeQuery(sql);
		System.out.println(sql);
		JSONArray result=new JSONArray();
		while(rs.next()){
			JSONObject obj=new JSONObject();
			int ordercourse_id=rs.getInt("ordercourse_id");
			String mycourse_name=rs.getString("mycourse_name");
			String mycourse_date=rs.getString("mycourse_date");
			String mycourse_time=rs.getString("mycourse_time");
			String mycourse_coach=rs.getString("mycourse_coach");
			String mycourse_room=rs.getString("mycourse_room");
			
			obj.put("ordercourse_id",ordercourse_id);
			obj.put("mycourse_name",mycourse_name);
			obj.put("mycourse_date",mycourse_date);
			obj.put("mycourse_time",mycourse_time);
			obj.put("mycourse_coach",mycourse_coach);
			obj.put("mycourse_room",mycourse_room);
			result.put(obj);
		}
		conn.close();
		st.close();
		rs.close();
		return result.toString();
	}
	
	public boolean del_mycourse(String ordercourse_id) throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		
		String sql="delete from mycourse_info where ordercourse_id='"+ordercourse_id+"'";
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
