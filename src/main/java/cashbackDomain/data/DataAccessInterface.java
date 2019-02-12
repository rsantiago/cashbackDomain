package cashbackDomain.data;

import java.time.DayOfWeek;
import java.util.Set;



import cashbackDomain.album.Album;
import cashbackDomain.album.Genre;
import cashbackDomain.customer.Customer;
import cashbackDomain.objects.identity.Id;
import cashbackDomain.promo.Promo;
import cashbackDomain.purchase.Item;
import cashbackDomain.purchase.Order;

public interface DataAccessInterface {
	
	public Album getAlbum(Id<Album> albumId);
	public Genre getGenre(Id<Genre> genreId);
	public Customer getCustomer(Id<Customer> customerId);
	public Item getItem(Id<Item> itemId);
	public Order getOrder(Id<Order> orderId);
	public Promo getPromo(Id<Promo> promoId);
	
	public Promo getPromoForDayOfWeek(DayOfWeek day, Id<Genre> genre);
	
	public Set<Album> getAlbums(Set<Id<Album>> albumIds);
	public Set<Genre> getGenres(Set<Id<Genre>> genreIds);
	public Set<Order> getOrders(Set<Id<Order>> orderIds);
	public Set<Item> getItems(Set<Id<Item>> itemIds);
	public Set<Promo> getPromos(Set<Id<Promo>> promoIds);
	public Set<Customer> getCustomers(Set<Id<Customer>> customerIds);
	
	public Album saveAlbum(Album a);
	public Genre saveGenre(Genre g);
	public Promo savePromo(Promo p);
	public Item saveItem(Item i);
	public Order saveOrder(Order o);
	public Customer saveCustomer(Customer c);
	
	public void saveAllPromos(Set<Promo> promos);
	public void saveAllGenres(Set<Genre> genres);
	public void saveAllCustomers(Set<Customer> customers);
	public void saveAllAlbums(Set<Album> albums);
	public void saveAllOrders(Set<Order> orders);
	public void saveAllItems(Set<Item> items);
	
	public Set<Id<Genre>> getGenreIds();
	public Set<Id<Album>> getAlbumIds();
	public Set<Id<Promo>> getPromoIds();
	public Set<Id<Item>> getItemIds();
	public Set<Id<Order>> getOrderIds();
	public Set<Id<Customer>> getCustomerIds();
	
	public void deleteAllAlbums();
	public void deleteAllCustomers();
	public void deleteAllOrders();
	public void deleteAllGenres();
	public void deleteAllPromos();
	public void deleteAllItems();
	public void deleteEverything();
		
}	
