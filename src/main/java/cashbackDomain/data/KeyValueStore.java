package cashbackDomain.data;

import java.util.Set;

import cashbackDomain.objects.identity.Id;
import cashbackDomain.objects.identity.Identifiable;

public abstract class KeyValueStore<T extends Identifiable<T>> {
	
	public abstract T getById(Id<T> id);
	public abstract Set<T> getByIds(Set<Id<T>> ids);
	public abstract Set<T> getAll();
	public abstract Set<Id<T>> getAllIds(); 
	
	
	/**
	 * Armazena um objeto no mapa interno indexado pelos identificadores.
	 * 
	 * Esta estrutura é um template que isola a implementação do sistema de persistência de dados
	 * 
	 * @param t O objeto que o sistema tenta salvar
	 * @return Retorna o objeto que o sistema está usando como referência
	 */
	public T save(T t) {
		// Como a hashtable é sincronizada, não temos problema em acessá-la diretamente.
		T actual = getById(t.getId());

		boolean objectStillDoesntExist = (actual == null);
		if (objectStillDoesntExist) {
			// insere um novo na loja
			saveInDataStructure(t);
			actual = t; // o objeto do parâmetro é o que o sistema vai usar a partir de agora
		} else {
			// não faz nada
		}

		return actual; // retorna o objeto que o sistema está usando
	}
	
	/**
	 * Salva o objeto na estrutura adequada
	 * @param t O objeto que deve ser salvo na estrutura deste armazenamento
	 */
	protected abstract void saveInDataStructure(T t) ;
}
