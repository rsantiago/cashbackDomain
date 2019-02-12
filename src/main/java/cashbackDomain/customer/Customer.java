package cashbackDomain.customer;

import static java.util.stream.Collectors.*;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import cashbackDomain.objects.identity.Id;
import cashbackDomain.objects.identity.Identifiable;
import cashbackDomain.purchase.Order;

public class Customer extends Identifiable<Customer> {
	public static final String COLLECTION_NAME = "customers";
	public static final String FIELD_1_NAME_CUSTOMER_NAME = "customername";
	public static final String FIELD_2_NAME_ORDERS_IDS = "orderIds";	
	
	public Customer(Id<Customer> id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private String name;

	private final Set<Id<Order>> orderIds = new HashSet<Id<Order>>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Id<Order>> getOrderIds() {
		return orderIds;
	}

	@Override
	protected void fillHashMapInOrder(LinkedHashMap<String, Object> idHashmap) {
		idHashmap.put(FIELD_1_NAME_CUSTOMER_NAME, getName());
		idHashmap.put(FIELD_2_NAME_ORDERS_IDS, getOrderIds().stream().map(i -> i.getId()).collect(toSet()));	
	}
}
