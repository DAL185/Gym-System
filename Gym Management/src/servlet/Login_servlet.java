package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;

public class Login_servlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		//System.out.println(username+"77777"+pwd);
		User user = new User(username,pwd);
		try{
			if(user.searchUser()){       
				System.out.println("success");
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
