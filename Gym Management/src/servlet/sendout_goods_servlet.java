package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyGoods;

public class sendout_goods_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		
		String sendout_goods_id = request.getParameter("linkgoods_id");
		
		System.out.println(sendout_goods_id);
		
		
		MyGoods mygoods=new MyGoods();
		

		try {
			
			//String res=mycourse.order_course(ordercourse_id); 
			//response.getWriter().write(res);
		
			if(mygoods.sendout_goods(sendout_goods_id)){
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
