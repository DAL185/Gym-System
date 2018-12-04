package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Member;

public class search_member_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		//System.out.println("username"+username);
		Member member=new Member();
		try{
			String res=member.search_member();
			//System.out.println(res);
			response.getWriter().write(res);
			
		}catch(Exception e){
			e.printStackTrace();
		} 
		
	}

}
