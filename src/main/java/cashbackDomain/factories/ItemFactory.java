package cashbackDomain.factories;

import cashbackDomain.album.Album;
import cashbackDomain.data.DataAccessInterface;
import cashbackDomain.objects.identity.Id;
import cashbackDomain.promo.Promo;
import cashbackDomain.purchase.Item;
import cashbackDomain.purchase.Order;

public class ItemFactory extends AbstractCashbackObjectsFactory<Item> {


	public ItemFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item buildItem(Album a, Order o, int quantity) {
		// identificador de um novo item é o seguinte:
		// nome do album + nome do cliente + data do pedido
		int id = ("" + a.getId() + o.getId() + o.getWhen()).hashCode();
		Item i = new Item(new Id<Item>(id));
		
		i.setAlbum(a.getId());
		i.setOrder(o.getId());
		i.setQuantity(quantity);
		i.setUnitPrice((float)a.getPrice());
		
		return i;
	}
	
	public Item buildItem(Album album, Order order, int quantity, DataAccessInterface data) {
		// pega a promocao para o pedido atual
		Promo promoForDayOfWeek = data.getPromoForDayOfWeek(order.getOrderDay(), album.getGenreId());
		
		//constroi um item
		Item newItem = buildItem(album, order, quantity);
		
		// calcula o cashback de cada album
		newItem.setCashback(album.calcCashback(promoForDayOfWeek));
		
		// adiciona o preço total do item ao total da ordem
		order.addToTotal(newItem.getTotalPrice());
		// adiciona o cashback total do item ao total da ordem
		order.addToCashback(newItem.getTotalCashback());
		
		// retorna o novo item
		return newItem;
	}
}
