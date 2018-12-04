package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyGoods;

public class delete_mygoods_servlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		String delgoods_id =request.getParameter("linkgoods_id");

		MyGoods mygoods=new MyGoods();
		try{
			if(mygoods.del_mygoods(delgoods_id)){
				System.out.println("success");
				response.getWriter().write("success");
			}else{
				System.out.println("failed");
				response.getWriter().write("failed");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		//System.out.println(request.getParameter("id"));
	}
}

