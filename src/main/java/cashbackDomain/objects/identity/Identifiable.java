package cashbackDomain.objects.identity;


import java.util.LinkedHashMap;

import cashbackDomain.data.Hashmapper;

public abstract class Identifiable<T> implements Hashmapper {
	private Id<T> id;
	
	/**
	 * Para qualquer sistema de persistência, este é o nome do campo identificador
	 */
	public static final String ID_FIELD_NAME = "id"; 

	
	public Identifiable (Id<T> identifier) {
		this.id = identifier;
	}
	
	public Id<T> getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	public boolean equals(Object other) {
		if(other instanceof Identifiable<?>) {
			Identifiable<?> toIdentifiable = (Identifiable<?>) other;
			return this.getId().equals(toIdentifiable.getId());
		} else {
			return false;
		}
	}
	
	public String toString () {
		return id + "";
	}
	
	public LinkedHashMap<String, Object> toHashMap() {
		LinkedHashMap<String, Object> hashmap = new LinkedHashMap<String, Object>();
		hashmap.put(ID_FIELD_NAME, getId().getId());
		fillHashMapInOrder(hashmap);
		return hashmap;
	}

	
	/**
	 * Preenche a hashtable criada para retornar uma estrutura facilitada
	 * para inserção do banco de dados
	 * @param idHashmap o mapa que deve ser preenchido com as informações da classe
	 */
	protected abstract void fillHashMapInOrder(LinkedHashMap<String, Object> idHashmap);
}
