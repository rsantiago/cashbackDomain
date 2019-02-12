package cashbackDomain.data;
import java.util.LinkedHashMap;


public interface Hashmapper {
	/**
	 * Este método serve para facilitar o trabalho de inserção dos dados
	 * deste objeto nos diferentes sistemas de persistência
	 * 
	 * O retorno deve ser no seguinte formato:
	 * 1 - As chaves são os nomes das variáveis,
	 * que se tornam as colunas nos sistemas de persistência
	 * 
	 * 2 - Os valores são os valores das variáveis respecitvas às colunas
	 * 
	 * Exemplo:
	 * 
	 * Nome da coluna: "id"
	 * Valor: 1 (resultado de chamada à getId()
	 * 
	 * Atenção: se o tipo de dados tiver alguma sublista (exemplo,
	 * os ids da lista de discos de uma categoria),
	 * o valor da hashtable deverá conter um Set
	 * com os respectivos ids
	 * 
	 * Atenção: Se o objeto tiver um Id,
	 * este hashmap deve apenas retornar o valor
	 * do inteiro pertencente ao id
	 * 
	 * @return Uma lista encadeada, com os campos e valores inseridos
	 * na ordem em que serão persistidos
	 */
	public LinkedHashMap<String, Object> toHashMap();
}
