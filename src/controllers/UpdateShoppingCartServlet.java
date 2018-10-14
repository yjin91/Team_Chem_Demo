package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbhelpers.ShoppingCartQuery;
import dbhelpers.ViewProductQuery;

/**
 * Servlet implementation class UpdateShoppingCartServlet
 */
@WebServlet(
		description = "this controller is used to update shopping cart and inventory when user click remove button", 
		urlPatterns = { 
				"/UpdateShoppingCartServlet", 
				"/updatesc"
		})
public class UpdateShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "viewsc";
		int quantity = 0;
		String SKU = request.getParameter("SKU");
		int scid = Integer.parseInt(request.getParameter("scid"));
		int number = Integer.parseInt(request.getParameter("number"));
		
		ShoppingCartQuery sc = new ShoppingCartQuery("dbfinal", "root", "123456"); 
		sc.doDeleteSC(scid);
		
		ViewProductQuery vp = new ViewProductQuery("dbfinal", "root", "123456");
		
		int inventorynumber = vp.getInventoryNumber(SKU);
		quantity = inventorynumber + number; 
		
		vp.updateInventory(SKU, quantity);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	
		
	
	}

}
