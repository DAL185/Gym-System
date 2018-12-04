package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class article {
	String id;
	String title;
	String content;
	String date;
	String location;
	String saveState;
	String author;
	
	
public  article(String title,String content,String date,String location,String saveState,String author){
   
     this.title=title;
     this.content=content;
     this.date=date;
     this.location=location;
     this.saveState=saveState;
     this.author=author;
  
}
public  article(String id,String title,String content,String date,String location,String saveState,String author){
	this.id=id;
    this.title=title;
    this.content=content;
    this.date=date;
    this.location=location;
    this.saveState=saveState;
    this.author=author;
 
}
public article(){
	
}
public boolean addArticle() throws Exception{
	Connection conn=getConn();
	boolean flag=false;
	Statement st=(Statement) conn.createStatement();
	DateFormat d=DateFormat.getDateTimeInstance();
	String date=d.format(new Date());
	//String date=dateFormat.format( now );
	String sql="insert into article(title,content,date,location,saveState,author) values('"+title+"','"+content+"','"+date+"','"+location+"','"+saveState+"','"+author+"')";
	//System.out.println(sql);
	if(st.executeUpdate(sql)>0){
		flag=true;
	}
	conn.close();
	st.close();
	return flag;
}

public boolean saveArticle() throws Exception{
	Connection conn=getConn();
	boolean flag=false;
	Statement st=(Statement) conn.createStatement();
	DateFormat d=DateFormat.getDateTimeInstance();
	String date=d.format(new Date());
	//String date=dateFormat.format( now );
	String sql="update article set  title='"+title+"',content='"+content+"',date='"+date+"',location='"+location+"',saveState='"+saveState+"',author='"+author+"' where id='"+id+"'";
	System.out.println(sql);
	if(st.executeUpdate(sql)>0){
		flag=true;
	}
	conn.close();
	st.close();
	return flag;
}


public String searcharticle(String id) throws Exception{
	Connection conn=getConn();
	Statement st=(Statement) conn.createStatement();
	ResultSet rs=null;
	String sql="select * from article where id='"+id+"'";
	//System.out.println(sql);
	rs=(ResultSet) st.executeQuery(sql);
	JSONObject obj=new JSONObject();
	
	if(rs.next()){
		
		
		
		String title=rs.getString("title");
		String content=rs.getString("content");
		String date=rs.getString("date");
		String location=rs.getString("location");
		String saveState=rs.getString("saveState");
		String author=rs.getString("author");
		
		obj.put("id", id);
		obj.put("title", title);
		obj.put("content", content);
		obj.put("date", date);
		obj.put("location", location);
		obj.put("saveState", saveState);
		obj.put("author", author);

		
		
	}
	conn.close();
	st.close();
	rs.close();
	
	return obj.toString();
	
}


public boolean delarticle(String id) throws Exception{
	Connection conn=getConn();
	boolean flag=false;
	Statement st=(Statement) conn.createStatement();
	//DateFormat d=DateFormat.getDateTimeInstance();
	//String date=d.format(new Date());
	//String date=dateFormat.format( now );
	String sql="delete from article where id='"+id+"'";
	//System.out.println(sql);
	if(st.executeUpdate(sql)>0){
		flag=true;
	}
	conn.close();
	st.close();
	return flag;
	}
public String article_list_ctrl(String username) throws Exception{
	Connection conn=getConn();
	Statement st=(Statement) conn.createStatement();
	ResultSet rs=null;
	String sql="select * from article where author='"+username+"' order by date desc;";
	//System.out.println(sql);
	rs=(ResultSet) st.executeQuery(sql);
	
	
	JSONArray result=new JSONArray();
	while(rs.next()){
		JSONObject obj=new JSONObject();
		
		int id=rs.getInt("id");
		String title=rs.getString("title");
		String content=rs.getString("content");
		String date=rs.getString("date");
		String location=rs.getString("location");
		String saveState=rs.getString("saveState");
		String author=rs.getString("author");
		
		obj.put("id", id);
		obj.put("title", title);
		obj.put("content", content);
		obj.put("date", date);
		obj.put("location", location);
		obj.put("saveState", saveState);
		obj.put("author", author);
		result.put(obj);
		
		
	}
	conn.close();
	st.close();
	rs.close();
	
	return result.toString();
	
}
private static Connection getConn(){
	String driver ="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/js?useUnicode=true&characterEncoding=utf8";
	String username="root";
	String password="19960103";
	Connection conn=null;
	try{
		Class.forName(driver);
		conn=DriverManager.getConnection(url,username,password);
	}catch (ClassNotFoundException e){
		e.printStackTrace();
	}catch (SQLException e){
		e.printStackTrace();
	}
	return conn;
			
}
}
