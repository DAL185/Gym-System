package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.article;

public class editarticle extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		String id =request.getParameter("id");

		article article=new article();
			try{
				System.out.println(id);
				String res=article.searcharticle(id);
				response.getWriter().write(res);
				//System.out.println(res);
			}catch(Exception e){
				e.printStackTrace();
			} 
			
	}

}
