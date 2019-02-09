package association.demo;

public class Order {

	private String orderId;
	private int quantity;
	
	//P is an object of Product class
	private Product prod;
	
	
	@Override
	public String toString()
	{
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", p="
				+ prod + "]";
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderId, int quantity, Product p) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.prod = p;
	}
	
}
