package cashbackDomain.purchase;

import java.util.LinkedHashMap;

import cashbackDomain.album.Album;
import cashbackDomain.objects.identity.Id;
import cashbackDomain.objects.identity.Identifiable;


public class Item extends Identifiable<Item> {
	public static final String COLLECTION_NAME = "items";	
	public static final String FIELD_NAME_1_ITEM_ORDER_ID = "orderid";
	public static final String FIELD_NAME_2_ITEM_QUANTITY = "quantity";
	public static final String FIELD_NAME_3_ITEM_UNIT_PRICE = "unitprice";
	public static final String FIELD_NAME_4_ITEM_CASHBACK = "cashback";
	public static final String FIELD_NAME_5_ITEM_ALBUM_ID = "albumId";
	
	private int quantity;
	private float unitPrice;
	private Id<Order> orderId;
	private Id<Album> albumId;
	private float cashback;
	
	
	public Item(Id<Item> id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Id<Order> getOrderId() {
		return orderId;
	}
	public void setOrder(Id<Order> orderId) {
		this.orderId = orderId;
	}
	public Id<Album> getAlbumId() {
		return albumId;
	}
	public void setAlbum(Id<Album> albumId) {
		this.albumId = albumId;
	}
	
	public float getTotalPrice() {
		return getUnitPrice()*getQuantity();
	}
	
	public float getTotalCashback() {
		return getCashbackPerUnit()*getUnitPrice();
	}

	@Override
	protected void fillHashMapInOrder(LinkedHashMap<String, Object> idHashmap) {
		idHashmap.put(FIELD_NAME_1_ITEM_ORDER_ID, getId().getId());
		idHashmap.put(FIELD_NAME_2_ITEM_QUANTITY, getQuantity());
		idHashmap.put(FIELD_NAME_3_ITEM_UNIT_PRICE, getUnitPrice());
		idHashmap.put(FIELD_NAME_4_ITEM_CASHBACK, getCashbackPerUnit());
		idHashmap.put(FIELD_NAME_5_ITEM_ALBUM_ID, getAlbumId().getId());
	}

	/**
	 * Cashback por unidade
	 * @return Cashback por unidade
	 */
	public float getCashbackPerUnit() {
		return cashback;
	}

	public void setCashback(float cashback) {
		this.cashback = cashback;
	}

}
