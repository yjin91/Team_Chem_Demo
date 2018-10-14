package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbhelpers.ShoppingCartQuery;
import dbhelpers.ViewProductQuery;
import model.Product;
import model.Shoppingcart;

/**
 * Servlet implementation class UpdateInventoryServlet
 */
@WebServlet(
		description = "this controller is used to update product inventory and shopping cart", 
		urlPatterns = { 
				"/UpdateInventoryServlet", 
				"/update"
		})
public class UpdateInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInventoryServlet() {
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
		HttpSession session = request.getSession();
		
		String url = "";
		String SKU = request.getParameter("SKU");
		int quantity = 0;
		int number = Integer.parseInt(request.getParameter("number"));
		
		ViewProductQuery vp = new ViewProductQuery("dbfinal", "root", "123456");
		
		int inventorynumber = vp.getInventoryNumber(SKU);
		
		if (inventorynumber >= number) {
			
			quantity = inventorynumber - number;
			vp.updateInventory(SKU, quantity);
			
			url = "viewproduct";
			
			Product product = vp.getproductinfo(SKU);
			String name = product.getName();
			String image = product.getImage();
			Double price = product.getPrice();
			String username = (String) session.getAttribute("username");
			
			Shoppingcart shoppingcart = new Shoppingcart();
			
			shoppingcart.setUsername(username);
			shoppingcart.setSKU(SKU);
			shoppingcart.setName(name);
			shoppingcart.setImage(image);
			shoppingcart.setQuantity(number);
			shoppingcart.setPrice(price);
			
			ShoppingCartQuery sc = new ShoppingCartQuery("dbfinal", "root", "123456");			
			sc.addSCProduct(shoppingcart);
			
			
		} else {
			url = "/notenoughinventory.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
