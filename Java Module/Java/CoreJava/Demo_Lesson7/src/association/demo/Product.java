package association.demo;

public class Product {

	private int pid;
	private float price;
	private String name;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, float price, String name) {
		super();
		this.pid = pid;
		this.price = price;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", price=" + price + ", name=" + name
				+ "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
