package cashbackDomain.factories;

import cashbackDomain.album.Album;
import cashbackDomain.album.Genre;
import cashbackDomain.objects.identity.Id;

/**
 * Builder para albums
 * 
 * @author rodrigosantiago
 *
 */
public class AlbumFactory extends AbstractCashbackObjectsFactory<Album> {
	
	
	
	
	public AlbumFactory() {
		super();
	}

	public Album buildAlbum(String artistName, String albumName, Id<Genre> g) {
		Album a = new Album(new Id<Album>(artistName.hashCode()));
				
		a.setArtist(artistName);
		a.setName(albumName);
		a.setGenre(g);
		a.setPrice((float)Math.random()*100); // preço gerado randomicamente
		
		return a;
	}
	
	

}
