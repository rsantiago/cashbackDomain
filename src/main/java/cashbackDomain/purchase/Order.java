package cashbackDomain.purchase;

import java.util.Calendar;
import java.util.Date;
import static java.util.stream.Collectors.*;

import java.time.DayOfWeek;
import java.util.HashSet;

import java.util.LinkedHashMap;
import java.util.Set;
import cashbackDomain.customer.Customer;
import cashbackDomain.objects.identity.Id;
import cashbackDomain.objects.identity.Identifiable;

public class Order extends Identifiable<Order> {
	public static final String COLLECTION_NAME = "orders";
	
	/**
	 * Estes campos estão aqui para facilitar
	 * a indexação dos campos em sistemas de persistência
	 * nos bancos de dados
	 */
	public static final String FIELD_1_NAME_ORDER_WHEN="quando";
	public static final String FIELD_2_NAME_ORDER_TOTAL="quantidade";
	public static final String FIELD_3_NAME_ORDER_ITEMS_IDS="itemsIds";
	public static final String FIELD_4_NAME_ORDER_CASHBACK = "cashback";
	public static final String FIELD_5_NAME_ORDER_CUSTOMER_ID = "customerid";
	
	
	private Date when;
	private float total;
	private float cashback;
	private Id<Customer> customerId;
	private Set<Id<Item>> items = new HashSet<Id<Item>>();

	public Order(Id<Order> id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getCashback() {
		return cashback;
	}

	public void setCashback(float cashback) {
		this.cashback = cashback;
	}

	
	public Id<Customer> getCustomerId() {
		return customerId;
	}

	public void setCustomer(Id<Customer> customerId) {
		this.customerId = customerId;
	}

	public Set<Id<Item>> getItems() {
		return items;
	}

	public void setItems(Set<Id<Item>> items) {
		this.items = items;
	}
	
	/**
	 * Adiciona ao total do preço.
	 * Utilizado quando um item novo de compra é criado
	 * 
	 * @param priceToAdd O preço do item totalizado a ser adicionado a este pedido
	 */
	public void addToTotal(float priceToAdd) {
		setTotal(getTotal()+priceToAdd);
	}
	
	/**
	 * Adiciona mais ao valor que será retornado ao usuário
	 * @param cashbackToAdd valor a ser adicionado ao cashback
	 */
	public void addToCashback(float cashbackToAdd) {
		setCashback(getCashback()+cashbackToAdd);
	}

	@Override
	protected void fillHashMapInOrder(LinkedHashMap<String, Object> identifiedHasmap) {
		identifiedHasmap.put(FIELD_1_NAME_ORDER_WHEN, getWhen());
		identifiedHasmap.put(FIELD_2_NAME_ORDER_TOTAL, getTotal());
		identifiedHasmap.put(FIELD_3_NAME_ORDER_ITEMS_IDS, getItems().stream().map(id -> id.getId()).collect(toSet())); // transforma a lista de objetos num set simples de números
		identifiedHasmap.put(FIELD_4_NAME_ORDER_CASHBACK, getCashback());
		identifiedHasmap.put(FIELD_5_NAME_ORDER_CUSTOMER_ID, getCustomerId().getId()); 
	}
	
	public DayOfWeek getOrderDay() {
		Date when = getWhen();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(when);
		int dayValue = calendar.get(Calendar.DAY_OF_WEEK);
		return DayOfWeek.of(dayValue);
	}

}
