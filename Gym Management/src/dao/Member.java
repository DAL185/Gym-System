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

public class Member{

	String id;
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
	
	public Member(String id,String name,String gender,String type,String duetime,String phone,String height,String weight,String surround,String fatrate,String heartrate,String advice,String remark){
		
		this.id=id;
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
	public Member(){}
	
	public String search_member() throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from member_info order by pubdate desc; " ;
		rs=st.executeQuery(sql);
		//System.out.println(sql);
		JSONArray result=new JSONArray();
		while(rs.next()){
			JSONObject obj=new JSONObject();
			int id=rs.getInt("id");
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
			obj.put("id",id);
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
			result.put(obj);
		}
		conn.close();
		st.close();
		rs.close();
		return result.toString();
	}
	
	public String find_member(String keywords) throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from member_info where id='"+keywords+"' OR name='"+keywords+"' OR phone='"+keywords+"'  order by pubdate desc; " ;
		rs=st.executeQuery(sql);
		System.out.println(sql);
		JSONArray result=new JSONArray();
		while(rs.next()){
			JSONObject obj=new JSONObject();
			int id=rs.getInt("id");
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
			obj.put("id",id);
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
			result.put(obj);
		}
		conn.close();
		st.close();
		rs.close();
		return result.toString();
	}
	
	public boolean add_member() throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		DateFormat d=DateFormat.getDateTimeInstance();
		String pubdate = d.format(new Date());//获取系统当前时间
		String sql="insert into member_info(name,gender,pubdate,type,duetime,phone,height,weight,surround,fatrate,heartrate,advice,remark)values('"+name+"','"+gender+"','"+pubdate+"','"+type+"','"+duetime+"','"+phone+"','"+height+"','"+weight+"','"+surround+"','"+fatrate+"','"+heartrate+"','"+advice+"','"+remark+"')";
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
	public String edit_searchmember(String id) throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from member_info where id='"+id+"'" ;
		rs=st.executeQuery(sql);
		System.out.println(sql);
		JSONObject obj=new JSONObject();
		
		if(rs.next()){
			
			//int id=rs.getInt("id");
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
			
			obj.put("id",id);
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
	
	public boolean edit_member() throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		DateFormat d=DateFormat.getDateTimeInstance();
		//String pubdate = d.format(new Date());//获取系统当前时间
		String sql="update member_info set name='"+name+"',gender='"+gender+"',type='"+type+"',duetime='"+duetime+"',phone='"+phone+"',height='"+height+"',weight='"+weight+"',surround='"+surround+"',fatrate='"+fatrate+"',heartrate='"+heartrate+"',advice='"+advice+"',remark='"+remark+"' where id='"+id+"' ";
		//System.out.println(sql);
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
	public boolean del_member(String id) throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		//DateFormat d=DateFormat.getDateTimeInstance();
		//String date=d.format(new Date());
		//String date=dateFormat.format( now );
		String sql="delete from member_info where id='"+id+"'";
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
