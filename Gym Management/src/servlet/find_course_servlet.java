package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Course;

public class find_course_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		//String action = request.getParameter("action");
		//String username=request.getParameter("username");
		String keywords=request.getParameter("keywords");
		//System.out.println(username);
		System.out.println(keywords);
		//System.out.println(action);
		
		Course course=new Course();
		
		try{
			
			
				String res=course.find_course(keywords);
				//System.out.println(res);
				response.getWriter().write(res);
				
			
		}catch(Exception e){
			e.printStackTrace();
		} 
		
	}

}
