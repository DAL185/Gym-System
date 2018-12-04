package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyCourse;

public class order_course_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		String ordercourse_id = request.getParameter("course_id");
		
		System.out.println(ordercourse_id);
		
		
		MyCourse mycourse=new MyCourse();
		

		try {
			
			//String res=mycourse.order_course(ordercourse_id); 
			//response.getWriter().write(res);
		
			if(mycourse.order_course(ordercourse_id)){
				System.out.println("success");
				response.getWriter().write("success");
			}else{
				System.out.println("failed");
				response.getWriter().write("failed");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
