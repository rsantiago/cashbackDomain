package cashbackDomain.album;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import cashbackDomain.objects.identity.Id;
import cashbackDomain.objects.identity.Identifiable;

public class Genre extends Identifiable<Genre> {
	public static final String COLLECTION_NAME = "genres";
	public static final String FIELD_1_NAME_GENRE_NAME = "genreName";
	public static final String FIELD_2_NAME_ALBUMS_IDS = "albumsIds";
	

	public Genre(Id<Genre> id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private String name;
	/**
	 * Ids dos albums deste gênero
	 */
	private final Set<Id<Album>> albumIds = new HashSet<Id<Album>>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Recupera a lista de ids dos albums
	 * 
	 * @return o conjunto de identificadores dos albums
	 */
	public Set<Id<Album>> getAlbumIds() {
		return albumIds;
	}

	@Override
	protected void fillHashMapInOrder(LinkedHashMap<String, Object> idHashmap) {
		idHashmap.put(FIELD_1_NAME_GENRE_NAME, getName());
		idHashmap.put(FIELD_2_NAME_ALBUMS_IDS,
				getAlbumIds().stream().map(i -> i.getId()).collect(java.util.stream.Collectors.toSet()));

	}
}