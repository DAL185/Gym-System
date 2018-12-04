package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.article;

public class list_article_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String username=request.getParameter("username");
		//System.out.println("username"+username);
		article article=new article();
		try{
			String res=article.article_list_ctrl(username);
			//System.out.println(res);
			response.getWriter().write(res);
			
		}catch(Exception e){
			e.printStackTrace();
		} 
		
	}

}
