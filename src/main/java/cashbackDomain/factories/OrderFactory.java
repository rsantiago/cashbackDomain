package cashbackDomain.factories;

import java.util.Date;

import cashbackDomain.customer.Customer;
import cashbackDomain.objects.identity.Id;
import cashbackDomain.purchase.Order;

public class OrderFactory extends AbstractCashbackObjectsFactory<Order> {
	
	public OrderFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order buildOrder(Customer customer, Date when) {
		int id = ("" + customer.getId() + when.toString()).hashCode();
		
		Order o = new Order(new Id<Order>(id));
		o.setCustomer(customer.getId());
		o.setWhen(when);
		return o;
	}
	
}
