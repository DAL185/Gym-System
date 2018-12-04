package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Course;

public class add_course_servlet extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String action = request.getParameter("action");
		String course_id = request.getParameter("course_id");
		String course_name = request.getParameter("course_name");
		String course_date = request.getParameter("course_date");
		String course_time = request.getParameter("course_time");
		String course_coach = request.getParameter("course_coach");
		String course_room = request.getParameter("course_room");
		
		
		//System.out.println(id);
		
		//System.out.println("content:"+content+",,,,发布状态："+saveState+";");

		Course course=new Course(course_id,course_name,course_date,course_time,course_coach,course_room);
		
		try{
			if(action.equals("editcourse")){
				if(course.edit_course()){
					System.out.println("success");
					response.getWriter().write("success");
				}else{
					System.out.println("failed");
					response.getWriter().write("failed");
				}
			}else{
				if(course.add_course()){
					System.out.println("success");
					response.getWriter().write("success");
				}else{
					System.out.println("failed");
					response.getWriter().write("failed");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
