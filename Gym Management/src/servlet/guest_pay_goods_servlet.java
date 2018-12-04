package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PayGoods;

public class guest_pay_goods_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String linkgoods_id = request.getParameter("goods_id");
		String buygoods_name = request.getParameter("goods_name");
		String buygoods_price = request.getParameter("goods_price");
		String buygoods_stock = request.getParameter("goods_stock");
		String buygoods_shelf = request.getParameter("goods_shelf");
		String customer_name = request.getParameter("customer_name");
		String customer_phone = request.getParameter("customer_phone");
		String customer_address = request.getParameter("customer_address");
		
		
		//System.out.println(id);

		PayGoods paygoods=new PayGoods(linkgoods_id,
				buygoods_name,buygoods_price,buygoods_stock,
				buygoods_shelf,customer_name,customer_phone,customer_address);
		
		
		try {
			//System.out.println(linkgoods_id);
			if(paygoods.pay_goods()){
				System.out.println("success");
				response.getWriter().write("success");
			}else{
				System.out.println("failed");
				response.getWriter().write("failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}