package cashbackDomain.promo;

import java.time.DayOfWeek;
import java.util.LinkedHashMap;

import cashbackDomain.album.Genre;
import cashbackDomain.objects.identity.Id;
import cashbackDomain.objects.identity.Identifiable;

public class Promo extends Identifiable<Promo> {
	
	/*
	 * Nomes dos campos para sistemas de persistência,
	 * como bancos de dados
	 */
	public static final String COLLECTION_NAME = "promos";
	public static final String FIELD_1_NAME_PROMO_GENRE_ID = "genreid";
	public static final String FIELD_2_NAME_PROMO_DAY = "day";
	public static final String FIELD_3_NAME_PROMO_AMOUNT  = "amout";
	
	private float amount;

	private Id<Genre> genreId;
	
	private DayOfWeek day;
	
	public Promo(Id<Promo> id) {
		super(id);
		// TODO Auto-generated constructor stub
	}


	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Id<Genre> getGenreId() {
		return genreId;
	}

	public void setGenre(Id<Genre> genreId) {
		this.genreId = genreId;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}


	@Override
	protected void fillHashMapInOrder(LinkedHashMap<String, Object> idHashmap) {
		idHashmap.put(FIELD_1_NAME_PROMO_GENRE_ID, getGenreId().getId());
		idHashmap.put(FIELD_2_NAME_PROMO_DAY, getDay().getValue());
		idHashmap.put(FIELD_3_NAME_PROMO_AMOUNT,getAmount());
				
	}
	
}
