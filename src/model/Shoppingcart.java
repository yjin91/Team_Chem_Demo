package model;

public class Shoppingcart {

	 private int scid;
	 private String username;
	 private String SKU;
	 private String name;
	 private String image;
	 private double price;
	 private int quantity;
	/**
	 * 
	 */
	public Shoppingcart() {
		
		this.scid = 0;
		this.username = "no username";
		this.SKU = "No SKU";
		this.name = "No Name";
		this.image = "No Image";
		this.price = 0.0;
		this.quantity = 0;
	}
	/**
	 * @param username
	 * @param sKU
	 * @param name
	 * @param image
	 * @param price
	 * @param type
	 * @param quantity
	 */
	public Shoppingcart(int scid, String username, String SKU, String name, String image, double price, int quantity) {
		this.scid = scid;
		this.username = username;
		this.SKU = SKU;
		this.name = name;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	
	
	/**
	 * @return the scid
	 */
	public int getScid() {
		return scid;
	}
	/**
	 * @param scid the scid to set
	 */
	public void setScid(int scid) {
		this.scid = scid;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the sKU
	 */
	public String getSKU() {
		return SKU;
	}
	/**
	 * @param sKU the sKU to set
	 */
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	 
	
	
	 
}


