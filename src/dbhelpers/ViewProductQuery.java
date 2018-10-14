package dbhelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;
import model.User;

public class ViewProductQuery {

	private Connection connection;
	private ResultSet results;

	/**
	 * @author Yi Jin, Sarah Green
	 */
	public ViewProductQuery(String dbName, String uname, String pwd) {
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
;		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void doRead() {
		
		String query = "select * from dbfinal.products order by type desc;";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String getHTMLTable() {
		String div = "";
		
		try {
			while(this.results.next()) {
			Product product = new Product();
			
			product.setSKU(this.results.getString("SKU"));
			product.setType(this.results.getString("type"));
			product.setImage(this.results.getString("image"));
			product.setName(this.results.getString("name"));
			product.setPrice(this.results.getDouble("price"));
			product.setQuantity(this.results.getInt("quantity"));
			
			div += "<div class='product-block'>";
			div += "<img src='./_img/" + product.getImage() + "'>";
			div += "<div class='product-detail'>";
			div += "<p class='name'>" + product.getName() + "</p>";
			div += "<p class='cost'>$" + product.getPrice() + "</p>";
			div += "<p class='quantity'>Only " + product.getQuantity() + " left in stock</p>";
			div += "<form name=updateproduct action=update method=post >";
			div += "<input class='sku-input' name='SKU' type='text' readonly='readonly' value='" + product.getSKU() + "' />";
			div += "<br />";
			div += "<label class='qty'>Qty:</label>";
			div += "<input class='quantity-input' name='number' type='number' min='1' max='10' value='1'>";
			div += "<input class='cart-add' type=submit name=submit value='Add to Cart' />";
			div += "</form>";
			div += "</div>";
			div += "</div>";
			
			
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return div;
	}
	
	public int getInventoryNumber(String SKU) {
		int inventoryNumber = 0;
		
		String query = "select quantity from dbfinal.products where SKU = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, SKU);
			ResultSet results = ps.executeQuery();
			
			results.next();
            inventoryNumber = results.getInt("quantity");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return inventoryNumber;
	}
	
	public void updateInventory(String SKU, int quantity) {
		 
		String query = "update dbfinal.products set quantity = ? where SKU = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, quantity);
			ps.setString(2, SKU);
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public Product getproductinfo(String SKU) {
		Product product = null;
		
		String query = "select * from dbfinal.products where SKU = ?";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			
			ps.setString(1, SKU);
			ResultSet results = ps.executeQuery();
			
			results.next();
			
			product = new Product(
					results.getString("SKU"),
					results.getString("name"),
					results.getString("image"),
					results.getDouble("price"),
					results.getString("Type"),
					results.getInt("quantity")
					);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
		
	}
	
	   
}
