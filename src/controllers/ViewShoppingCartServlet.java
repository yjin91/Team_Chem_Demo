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

/**
 * Servlet implementation class ViewShoppingCartServlet
 */
@WebServlet(
		description = "this controller is used to display all the product in the shopping cart", 
		urlPatterns = { 
				"/ViewShoppingCartServlet", 
				"/viewsc"
		})
public class ViewShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int carttotal = 0;
        
		ShoppingCartQuery sc = new ShoppingCartQuery("dbfinal", "root", "123456");
		
		sc.doReadSC(username);
		String div = sc.getHTMLTable();
		request.setAttribute("div", div);
		
		ShoppingCartQuery sc1 = new ShoppingCartQuery("dbfinal", "root", "123456");
		
		carttotal = sc1.caltotal(username);
		
		request.setAttribute("carttotal", carttotal);
		
		
		String url = "/shoppingcart.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
