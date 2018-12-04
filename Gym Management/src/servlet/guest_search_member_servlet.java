package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Guest_member;

public class guest_search_member_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String own_phone = (String) request.getSession().getAttribute("own_phone");
		
		
		
		System.out.println(own_phone);

		Guest_member guest=new Guest_member();
		
		
		try {
			
			String res=guest.searchguest(own_phone); //对应search_guest里面的ph
			response.getWriter().write(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}