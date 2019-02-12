package cashbackDomain.album;

import java.util.LinkedHashMap;

import cashbackDomain.objects.identity.Id;
import cashbackDomain.objects.identity.Identifiable;
import cashbackDomain.promo.Promo;

public class Album extends Identifiable<Album> {
	public static String COLLECTION_NAME = "albums";
	public static String FIELD_1_NAME_ALBUM_NAME = "albumname";
	public static String FIELD_2_NAME_ALBUM_ARTIST = "albumartist";
	public static String FIELD_3_NAME_PRICE = "price";
	public static String FIELD_4_NAME_GENRE_ID = "genreid";

	public Album(Id<Album> id) {
		super(id);
	}

	private String artist = null;
	private String name = null;
	private float price = 0;
	private Id<Genre> genreId = null;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Id<Genre> getGenreId() {
		return genreId;
	}

	public void setGenre(Id<Genre> genreId) {
		this.genreId = genreId;
	}
	
	public float calcCashback(Promo p) {
		return getPrice() * p.getAmount();
	}

	@Override
	protected void fillHashMapInOrder(LinkedHashMap<String, Object> idHashmap) {
		idHashmap.put(FIELD_1_NAME_ALBUM_NAME, getName());
		idHashmap.put(FIELD_2_NAME_ALBUM_ARTIST, getArtist());
		idHashmap.put(FIELD_3_NAME_PRICE, getPrice());
		idHashmap.put(FIELD_4_NAME_GENRE_ID, getGenreId().getId());
	}

}
