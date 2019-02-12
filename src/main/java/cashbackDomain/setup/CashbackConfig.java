package cashbackDomain.setup;

import cashbackDomain.album.Album;


import cashbackDomain.album.Genre;
import cashbackDomain.data.DataAccessInterface;
import cashbackDomain.data.MemoryDB;
import cashbackDomain.factories.AlbumFactory;
import cashbackDomain.factories.CustomerFactory;
import cashbackDomain.factories.GenreFactory;
import cashbackDomain.factories.ItemFactory;
import cashbackDomain.factories.OrderFactory;
import cashbackDomain.factories.PromoFactory;
import cashbackDomain.objects.identity.Id;

public class CashbackConfig {

	/**
	 * Para identificar o nome padrão do banco de dados em qualquer sistema.
	 * A ideia é sobrescrever este banco com configurações avançadas, caso necessário.
	 */
	public static final String DB_NAME = "cashbackdb";
	
	private final GenreFactory genreFactory;
	private final AlbumFactory albumFactory;
	private final PromoFactory promoFactory;
	private final CustomerFactory customerFactory;
	private final OrderFactory orderFactory;
	private final ItemFactory itemFactory;
	
	/** 
	 * Interface de acesso aos dados
	 */
	private final DataAccessInterface data ;

	private CashbackConfig(GenreFactory genreFactory, AlbumFactory albumFactory, PromoFactory promoFactory,
			CustomerFactory customerFactory, OrderFactory orderFactory, ItemFactory itemFactory, DataAccessInterface data) {
		super();
		this.genreFactory = genreFactory;
		this.albumFactory = albumFactory;
		this.promoFactory = promoFactory;
		this.customerFactory = customerFactory;
		this.orderFactory = orderFactory;
		this.itemFactory = itemFactory;
		this.data = data;
	}
	
	/**
	 * Adiciona um novo Gênero ao sistema
	 * 
	 * @param genreName O nome do genero que deve ser criado
	 * @return O Gênero que deve ser utilizado como referência
	 */
	public Genre addGenre(String genreName) {
		Genre newGenre = genreFactory.buildGenre(genreName);
		return data.saveGenre(newGenre);
	}
	
	/**
	 * Adiciona mais um álbum à loja
	 * 
	 * @param albumName Nome do album
	 * @param artistName Nome do artista
	 * @param genreId Identificador do gênero
	 * 
	 * @return O album criado
	 */
	public Album addAlbum(String albumName, String artistName, Id<Genre> genreId) {
		// constrói um novo album com as informações passadas
		Album a = albumFactory.buildAlbum(artistName, albumName, genreId);

		// armazena na loja, junto com o gênero
		return data.saveAlbum(a);
	}
	
	public static CashbackConfig buildConfig(DataAccessInterface data) {

		final GenreFactory genreFactory = new GenreFactory();

		final AlbumFactory albumFactory = new AlbumFactory();
		
		final PromoFactory promoFactory = new PromoFactory();
		
		final CustomerFactory customerFactory = new CustomerFactory();
		
		final OrderFactory orderFactory = new OrderFactory();
		
		final ItemFactory itemFactory = new ItemFactory();
				
		CashbackConfig config = new CashbackConfig(genreFactory, albumFactory, promoFactory, customerFactory, orderFactory, itemFactory, data) ;
				
		return config;
	}
	
	public static CashbackConfig buildMemmoryDBConfig() {
		return buildConfig(new MemoryDB());
	}
	
	/**
	 * método de teste
	 * @param args os argumentos padrão do sistema
	 */
	public static void main(String[] args) {
		CashbackConfig config = buildMemmoryDBConfig();
		System.out.println("fez a configuração inicial: " + config.toString());
	}

	public GenreFactory getGenreFactory() {
		return genreFactory;
	}


	public AlbumFactory getAlbumFactory() {
		return albumFactory;
	}


	public PromoFactory getPromoFactory() {
		return promoFactory;
	}


	public CustomerFactory getCustomerFactory() {
		return customerFactory;
	}


	public OrderFactory getOrderFactory() {
		return orderFactory;
	}


	public ItemFactory getItemFactory() {
		return itemFactory;
	}
	
	public DataAccessInterface getData() {
		return data;
	}

}
