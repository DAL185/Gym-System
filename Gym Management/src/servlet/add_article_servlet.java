package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.article;

public class add_article_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String id =request.getParameter("id");
		String action =request.getParameter("action");
		String title =request.getParameter("title");
		String content =request.getParameter("content");
		String date =request.getParameter("date");
		String location =request.getParameter("location");
		String saveState =request.getParameter("saveState");
		String author =request.getParameter("author");
		System.out.println(id);
		
		article article=new article(id,title,content,date,location,saveState,author);
		try{
			if(action.equals("edit")){
				if(article.saveArticle()){
					System.out.println("success");
					response.getWriter().write("success");
				}else{
					System.out.println("failed");
					response.getWriter().write("failed");
				}
			}else{
				if(article.addArticle()){
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

	
	public void init() throws ServletException {
		// Put your code here
	}

}
