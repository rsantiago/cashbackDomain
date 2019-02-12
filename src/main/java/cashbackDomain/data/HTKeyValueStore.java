package cashbackDomain.data;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import cashbackDomain.objects.identity.Id;
import cashbackDomain.objects.identity.Identifiable;

/**
 * Armazenamento em memória, via hashtable (para fins de teste e implementação
 * de referência)
 * 
 * @author rodrigosantiago
 *
 * @param <T> O tipo que esta classe vai armazenar
 */
public class HTKeyValueStore<T extends Identifiable<T>> extends KeyValueStore<T> {

	private final Hashtable<Id<T>, T> storeMap = new Hashtable<Id<T>, T>();

	protected void saveInDataStructure(T t) {
		storeMap.put(t.getId(), t);
	}

	public T getById(Id<T> id) {
		return storeMap.get(id);
	}

	public Set<T> getByIds(Set<Id<T>> ids) {
		Set<T> set = new HashSet<T>();
		for (Id<T> id : ids) {
			set.add(storeMap.get(id));
		}

		return set;
	}

	public Set<T> getAll() {
		HashSet<T> set = new HashSet<T>();
		set.addAll(storeMap.values());
		return set;
	}

	public Set<Id<T>> getAllIds() {
		HashSet<Id<T>> set = new HashSet<Id<T>>();
		set.addAll(storeMap.keySet());
		return set;
	}

	public void removeAll() {
		storeMap.clear();
	}
}
