package cashbackDomain.factories;

import cashbackDomain.customer.Customer;
import cashbackDomain.objects.identity.Id;

public class CustomerFactory extends AbstractCashbackObjectsFactory<Customer> {

	public CustomerFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer buildCustomer(String customerName) {
		Customer c = new Customer(new Id<Customer>(customerName.hashCode()));
		c.setName(customerName);
		
		return c;
		
	}
}
