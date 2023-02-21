package shopping.model;

public class Order extends Product{
	private int orderId;
	private int uid;
	private int quantity;
	private String date;
	public Order() {
		
	}
	public Order(int orderId ,int uid, int quantity, String date) {
		super();
		this.orderId = orderId;
		this.uid = uid;
		this.quantity = quantity;
		this.date =date;
	}
	public Order(int uid, int quantity, String date ) {
		super();
		this.uid = uid;
		this.quantity = quantity;
		this.date = date;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public String toString() {
		return "["+orderId+" "+uid+ " "+quantity+" "+date+"]";
	}
}
