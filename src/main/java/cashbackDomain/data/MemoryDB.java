package cashbackDomain.data;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import cashbackDomain.album.Album;
import cashbackDomain.album.Genre;
import cashbackDomain.customer.Customer;
import cashbackDomain.objects.identity.Id;
import cashbackDomain.promo.Promo;
import cashbackDomain.purchase.Item;
import cashbackDomain.purchase.Order;

/**
 * Este objeto instancia um exemplo da estrutura de dados em memória
 * e ilustra as principais regras de restrição para a consistência do sistema
 * 
 * Clone estas regras para qualquer tipo de fonte de dados
 * que voc
 * @author rodrigosantiago
 *
 */
public class MemoryDB implements DataAccessInterface{
	private final HTKeyValueStore<Order> orders = new HTKeyValueStore<Order>();
	private final HTKeyValueStore<Item> items = new HTKeyValueStore<Item>();
	private final HTKeyValueStore<Promo> promos = new HTKeyValueStore<Promo>();

	/**
	 * Mapa de albums por identificador
	 */
	private final HTKeyValueStore<Album> albums = new HTKeyValueStore<Album>();

	/**
	 * Mapa de gêneros por identificador
	 */
	private final HTKeyValueStore<Genre> genres = new HTKeyValueStore<Genre>();

	/**
	 * Clientes
	 */
	private final HTKeyValueStore<Customer> customers = new HTKeyValueStore<Customer>();


	public Set<Customer> getAllCustomers() {
		return customers.getAll();
	}

	public Set<Order> getOrders(Date begining, Date end, int PageNum) {
		return orders.getAll();
	}

	public Set<Album> getAlbums() {
		return albums.getAll();
	}

	public Set<Genre> getGenres() {
		return genres.getAll();
	}

	public Set<Order> getOrders() {
		return orders.getAll();
	}

	@Override
	public Album getAlbum(Id<Album> albumId) {
		return albums.getById(albumId);
	}

	@Override
	public Genre getGenre(Id<Genre> genreId) {
		return genres.getById(genreId);
	}

	@Override
	public Customer getCustomer(Id<Customer> customerId) {
		return customers.getById(customerId);
	}

	@Override
	public Item getItem(Id<Item> itemId) {
		return items.getById(itemId);
	}

	@Override
	public Order getOrder(Id<Order> orderId) {
		return orders.getById(orderId);
	}

	@Override
	public Promo getPromo(Id<Promo> promoId) {
		return promos.getById(promoId);
	}

	@Override
	public Set<Album> getAlbums(Set<Id<Album>> albumIds) {
		return albums.getByIds(albumIds);
	}

	@Override
	public Set<Genre> getGenres(Set<Id<Genre>> genreIds) {
		return genres.getByIds(genreIds);
	}

	@Override
	public Set<Order> getOrders(Set<Id<Order>> orderIds) {
		return orders.getByIds(orderIds);
	}

	@Override
	public Set<Item> getItems(Set<Id<Item>> itemIds) {
		return items.getByIds(itemIds);
	}

	@Override
	public Set<Promo> getPromos(Set<Id<Promo>> promoIds) {
		return promos.getByIds(promoIds);
	}

	@Override
	public Set<Customer> getCustomers(Set<Id<Customer>> customerIds) {
		return customers.getByIds(customerIds);
	}

	@Override
	public Album saveAlbum(Album toSave) {
		Album saved = albums.save(toSave);
		
		
		if(saved == toSave) {
			// o objeto é novo, não faz nada
		} else {
			// já há um album no sistema, apenas sobrescreve o gênero
			saved.setGenre(toSave.getGenreId());
		}
		
		// o genero recebe o album em sua lista		
		genres.getById(toSave.getGenreId()).getAlbumIds().add(toSave.getId()); // atribui o album correto ao genero

		return saved;
	}

	@Override
	public synchronized Genre saveGenre(Genre toSave) {
		Genre saved = genres.save(toSave);
		
		boolean duplicate = saved != toSave;
		if (duplicate) {
			// se já havia um gênero antigo no sistema,
			// adiciona os albums do parametro ao genero antigo
			saved.getAlbumIds().addAll(toSave.getAlbumIds());

		} else {
			// o genero do parametro e o recuperado são identicos, não faz nada
		}
		return saved;
	}

	@Override
	public Promo savePromo(Promo p) {
		return promos.save(p);
	}

	@Override
	public Item saveItem(Item i) {
		return items.save(i);
	}

	@Override
	public Order saveOrder(Order o) {
		return orders.save(o);
		
	}

	@Override
	public Customer saveCustomer(Customer c) {
		return customers.save(c);
	}

	@Override
	public Set<Id<Genre>> getGenreIds() {
		return genres.getAllIds();
	}

	@Override
	public Set<Id<Album>> getAlbumIds() {
		return albums.getAllIds();
	}

	@Override
	public Set<Id<Promo>> getPromoIds() {
		return promos.getAllIds();
	}

	@Override
	public Set<Id<Item>> getItemIds() {
		return items.getAllIds();
	}

	@Override
	public Set<Id<Customer>> getCustomerIds() {
		return customers.getAllIds();
	}

	@Override
	public Set<Id<Order>> getOrderIds() {
		return orders.getAllIds();
	}

	@Override
	public void deleteAllAlbums() {
		albums.removeAll();
		
	}

	@Override
	public void deleteAllCustomers() {
		customers.removeAll();
		
	}

	@Override
	public void deleteAllOrders() {
		orders.removeAll();
		
	}

	@Override
	public void deleteAllGenres() {
		genres.removeAll();
		
	}

	@Override
	public void deleteAllPromos() {
		promos.removeAll();
		
	}

	@Override
	public void deleteAllItems() {
		items.removeAll();
		
	}

	@Override
	public void deleteEverything() {
		deleteAllOrders();
		deleteAllGenres();
		deleteAllPromos();
		deleteAllItems();
		deleteAllCustomers();
		deleteAllAlbums();
	}

	@Override
	public void saveAllPromos(Set<Promo> promos) {
		for (Promo promo : promos) {
			savePromo(promo);
		}	
	}

	@Override
	public void saveAllGenres(Set<Genre> genres) {
		for (Genre genre : genres) {
			saveGenre(genre);
		}
	}

	@Override
	public void saveAllCustomers(Set<Customer> customers) {
		for (Customer customer : customers) {
			saveCustomer(customer);
		}
	}

	@Override
	public void saveAllAlbums(Set<Album> albums) {
		for (Album album : albums) {
			saveAlbum(album);
		}
		
	}

	@Override
	public void saveAllOrders(Set<Order> orders) {
		for (Order order : orders) {
			saveOrder(order);
		}
		
	}

	@Override
	public void saveAllItems(Set<Item> items) {
		for (Item item : items) {
			saveItem(item);
		}
	}

	@Override
	public Promo getPromoForDayOfWeek(DayOfWeek day, Id<Genre> genre) {
		Iterator<Promo> iterator = promos.getAll().iterator();
		while(iterator.hasNext()) {
			Promo currentPromo = iterator.next();
			if(currentPromo.getDay().equals(day)) {
				if(currentPromo.getGenreId().equals(genre)) { 
					return currentPromo;
				} else {
					continue;
				}
			} else {
				continue;
			}
		}
		
		return null; // não há promoção ativa para este dia da semana
	}

}