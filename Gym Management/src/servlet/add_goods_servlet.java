package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Goods;

public class add_goods_servlet extends HttpServlet {

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
		String goods_id = request.getParameter("goods_id");
		String goods_name = request.getParameter("goods_name");
		String goods_price = request.getParameter("goods_price");
		String goods_stock = request.getParameter("goods_stock");
		String goods_shelf = request.getParameter("goods_shelf");
		String goods_image = request.getParameter("goods_image");
		
		
		//System.out.println(id);
		
		//System.out.println("content:"+content+",,,,发布状态："+saveState+";");

		Goods goods=new Goods(goods_id,goods_name,goods_price,goods_stock,goods_shelf,goods_image);
		
		try{
			if(action.equals("addgoods")){
				if(goods.add_goods()){
					System.out.println("success");
					response.getWriter().write("success");
				}else{
					System.out.println("failed");
					response.getWriter().write("failed");
				}
			}else{
				if(goods.edit_goods()){
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
