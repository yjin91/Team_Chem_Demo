package model;

public class Product {
	
	 private String SKU;
	 private String name;
	 private String image;
	 private double price;
	 private String type;
	 private int quantity;
	/**
	 * @param SKU
	 * @param name
	 * @param color
	 * @param imageNumber
	 * @param price
	 * @param type
	 * @param quantity
	 */
	public Product() {
		this.SKU = "No SKU";
		this.name = "No Name";
		this.image = "No Image";
		this.price = 0.0;
		this.type = "No Type";
		this.quantity = 0;
	}
	 
	 
	
	/**
	 * @param SKU
	 * @param name
	 * @param image
	 * @param price
	 * @param type
	 * @param quantity
	 */
	public Product(String SKU, String name, String image, double price, String type, int quantity) {
		this.SKU = SKU;
		this.name = name;
		this.image = image;
		this.price = price;
		this.type = type;
		this.quantity = quantity;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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



	public String toString() {
		
		return "Product SKU is " + SKU + ". Product Name is " + name + ".";
	}

}
