package association.demo;

public class OrderMain {

	public static void main(String[] args) {
		
		Product p1=new Product();
		p1.setName("Mobile");
		p1.setPid(7865);
		p1.setPrice(5667f);
		
		Order o1=new Order();
		o1.setOrderId("OM8654");
		o1.setQuantity(1);
		o1.setProd(p1);
		
		System.out.println(" Calling toString()");
		System.out.println(o1);
		
		System.out.println(" ------------------");
		System.out.println("    Order Details  ");
		System.out.println(" ------------------");
		System.out.println(" Order Id     :"+o1.getOrderId());
		System.out.println(" Quantity     :"+o1.getQuantity());
		System.out.println(" Product Name :"+o1.getProd().getName());
		System.out.println(" Product Price:"+o1.getProd().getPrice());

	}

}
