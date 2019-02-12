package cashbackDomain.promo;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

import cashbackDomain.album.Genre;
import cashbackDomain.factories.PromoFactory;

public class PromoUtils {
	private static void buildDefaultPromoItemsForGenre(PromoFactory f, 
			HashSet<Promo> promos, 
			Genre genre, 
			float sun, float mon, float tue, float wed, float thu, float fri, float sat) {
		
		
		promos.add(f.buildPromo(sun, DayOfWeek.SUNDAY, genre));
		promos.add(f.buildPromo(mon, DayOfWeek.MONDAY, genre));
		promos.add(f.buildPromo(tue, DayOfWeek.TUESDAY, genre));
		promos.add(f.buildPromo(wed, DayOfWeek.WEDNESDAY, genre));
		promos.add(f.buildPromo(thu, DayOfWeek.THURSDAY, genre));
		promos.add(f.buildPromo(fri, DayOfWeek.FRIDAY, genre));
		promos.add(f.buildPromo(sat, DayOfWeek.SATURDAY, genre));
	}
	
	private static void buildDefaultPromoItemsForPop(PromoFactory f, HashSet<Promo> promos, Genre pop) {
		buildDefaultPromoItemsForGenre(f, promos, pop, 0.25f, 0.07f, 0.06f, 0.2f, 0.10f, 0.15f, 0.20f);
	}
	
	private static void buildDefaultPromoItemsForMPB(PromoFactory f, HashSet<Promo> promos, Genre mpb) {
		buildDefaultPromoItemsForGenre(f, promos, mpb, 0.3f, 0.05f, 0.1f, 0.15f, 0.20f, 0.25f, 0.30f);
	}
	
	private static void buildDefaultPromoItemsForClassic(PromoFactory f, HashSet<Promo> promos, Genre classic) {
		buildDefaultPromoItemsForGenre(f, promos, classic, 0.35f, 0.03f, 0.05f, 0.08f, 0.13f, 0.18f, 0.25f);
	}
	
	private static void buildDefaultPromoItemsForRock(PromoFactory f, HashSet<Promo> promos, Genre rock) {
		buildDefaultPromoItemsForGenre(f, promos, rock, 0.40f, 0.1f, 0.15f, 0.15f, 0.15f, 0.20f, 0.40f);
	}
	
	public static Set<Promo> getDefaultPromos(Genre pop, Genre mpb, Genre classic, Genre rock) {
		HashSet<Promo> promos = new HashSet<Promo>();
		PromoFactory f = new PromoFactory();
		
		// padrão visitor para acumular as promocoes
		buildDefaultPromoItemsForPop(f, promos, pop);
		buildDefaultPromoItemsForMPB(f, promos, mpb);
		buildDefaultPromoItemsForClassic(f, promos, classic);
		buildDefaultPromoItemsForRock(f, promos, rock);
		
		return promos;
		
	}
	
	
}
