package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Guest_Login;

public class guest_Login_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		String guest_phone = request.getParameter("guest_phone");
		String guest_pwd = request.getParameter("guest_pwd");
		//System.out.println(guest_phone+"77777"+guest_pwd);
		Guest_Login guest_login = new Guest_Login(guest_phone,guest_pwd);
		
		
		try{
			if(guest_login.search_guest()){       
				System.out.println("success");
				request.getSession().setAttribute("own_phone",guest_phone);
				//String own_phone = (String) request.getSession().getAttribute("own_phone");
				//System.out.println(own_phone);
				
				//response.sendRedirect("admin-guest_member_list.html");
				response.getWriter().write("success");
			}else{                      
				System.out.println("failed");
				response.getWriter().write("failed");
			}
		} catch (Exception e){
			e.printStackTrace();
		}	
		
	}

}
