package cashbackDomain.factories;

import cashbackDomain.album.Genre;
import cashbackDomain.objects.identity.Id;

public class GenreFactory extends AbstractCashbackObjectsFactory<Genre> {
	
	

	public GenreFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genre buildGenre(String genreName) {
		Genre g = new Genre(new Id<Genre>(genreName.hashCode()));
		
		g.setName(genreName);
		
		return g;
	}
	
	
}
