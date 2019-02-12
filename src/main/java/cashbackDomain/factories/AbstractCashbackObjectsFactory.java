package cashbackDomain.factories;

import cashbackDomain.objects.identity.Identifiable;

/**
 * Todas as fábricas que estendem esta classe possuem em seus builders os segredos de como gerar os identificadores únicos para o sistema
 * @author rodrigosantiago
 *
 * @param <T> O tipo que esta fábrica vai instanciar
 */
public abstract class AbstractCashbackObjectsFactory<T extends Identifiable<T>> {
	public AbstractCashbackObjectsFactory() {
	}
}