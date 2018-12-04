package servlet;

import java.io.IOException;//导入包

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Course;

public class edit_course_servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String course_id = request.getParameter("course_id");
		
		//System.out.println(id);

		Course course=new Course();
		
		
		try {
			//System.out.println(id);
			String res=course.edit_searchcourse(course_id);
			response.getWriter().write(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}