package cashbackDomain.factories;

import java.time.DayOfWeek;

import cashbackDomain.album.Genre;
import cashbackDomain.objects.identity.Id;
import cashbackDomain.promo.Promo;

public class PromoFactory extends AbstractCashbackObjectsFactory<Promo> {

	
	
	public PromoFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promo buildPromo(float amount, DayOfWeek day, Genre g) {
		int id = ("" + amount + day.toString() + g.getName()).hashCode(); 
		
		Promo p = new Promo(new Id<Promo>(id));
		
		p.setAmount(amount);
		p.setDay(day);
		p.setGenre(g.getId());
		
		return p;
	}	
}
