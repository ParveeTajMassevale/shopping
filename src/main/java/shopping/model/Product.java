package shopping.model;

public class Product {
	private int id;
	private String name;
	private String category;
	private Double price;
	private String image;
	public Product(){
		
	}
	public Product(int id, String name, String category, Double price, String image) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return category;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPrice() {
		return price;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImage() {
		return image;
	}
	public String toString() {
		return "["+id + " " +name +" "+category +" "+price +" "+image+"]";  
	}
}
