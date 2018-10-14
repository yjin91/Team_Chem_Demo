package dbhelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Shoppingcart;

public class ShoppingCartQuery {

	private Connection connection;
	private ResultSet results;

	/**
	 * @author Yi Jin, Sarah Green
	 */
	public ShoppingCartQuery(String dbName, String uname, String pwd) {
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
;		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addSCProduct(Shoppingcart shoppingcart) {
		
		String query = "insert into dbfinal.shoppingcart (username, SKU, name, image, quantity, price) values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, shoppingcart.getUsername());
			ps.setString(2, shoppingcart.getSKU());
			ps.setString(3, shoppingcart.getName());
			ps.setString(4, shoppingcart.getImage());
			ps.setInt(5, shoppingcart.getQuantity());
			ps.setDouble(6, shoppingcart.getPrice());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doReadSC(String username) {
		
		String query = "select * from dbfinal.shoppingcart where username = ?";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			
			ps.setString(1, username);
			
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
			Shoppingcart shoppingcart = new Shoppingcart();
			
			shoppingcart.setScid(this.results.getInt("scid"));
			shoppingcart.setUsername(this.results.getString("username"));
			shoppingcart.setSKU(this.results.getString("SKU"));
			shoppingcart.setName(this.results.getString("name"));
			shoppingcart.setImage(this.results.getString("image"));
			shoppingcart.setPrice(this.results.getDouble("price"));
			shoppingcart.setQuantity(this.results.getInt("quantity"));
			
			div += "<div class='product-squares'>";
			div += "<div class='product-block'>";
			div += "<img src='./_img/" + shoppingcart.getImage() + "'>";
			div += "<div class='product-detail'>";
			div += "<p class='name'><b>Item:</b> " + shoppingcart.getName() + "</p>";
			div += "<p class='cost'><b>Price:</b> " + shoppingcart.getPrice() + "</p>";
			div += "<p class='quantity'><b>Quantity:</b> " + shoppingcart.getQuantity() + "</p>";
			div += "<p class='individ-total'><b>Total:</b> " + shoppingcart.getPrice()*shoppingcart.getQuantity() + "</p>";
			div += "<form name=updateshoppingcart action=updatesc method=post >";
			div += "<input type='hidden' name='number' value='" + shoppingcart.getQuantity() + "' />";
			div += "<input type='hidden' name='SKU' value='" + shoppingcart.getSKU() + "' />";
			div += "<input type='hidden' name='scid' value='" + shoppingcart.getScid() + "' />";
			div += "<input class='remove' type=submit name=remove value='Remove' />";
			div += "</form>";
			div += "</div>";
			div += "</div>";
			div += "</div>";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return div;
	}
	
	
	public int caltotal(String username) {
		int carttotal = 0;
		
		String query = "select sum(quantity*price) as carttotal from dbfinal.shoppingcart where username = ?";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			ps.setString(1, username);
			
			ResultSet results = ps.executeQuery();
			
			results.next();
			carttotal = results.getInt("carttotal");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return carttotal;
	}
	
	
	public void doDeleteSC (int scid) {
		
		String query = "delete from dbfinal.shoppingcart where scid = ?";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			
			ps.setInt(1,scid);
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
