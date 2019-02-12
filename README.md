# cashbackDomain
Domínio do cashback

Este é o modelo lógico com todas as classes que representam o 'core' da aplicação.

## Classes Que Representam as Principais Entidades a Serem Persistidas no Negócio

**Album:** Representa um album no sistema

**Genre:** Representa um gênero musical

**Customer:** O cliente que compra músicas e discos

**Order** e **Item:** O pedido, com seus respectivos itens

**Promo:** Os valores de cashback que devem ser retornados a cada dia para cada gênero musical

## Pacotes

### cashbackDomain.data: ### 
Este pacote representa toda abstração de persistência de dados do cashbackDomain. 

Para portar todo este projeto para qualquer tipo de modelo de persistência, basta estender o modelo de dados, implementando a interface `DataAccessInterfac`. Ela funciona como uma fachada para interagir com as camadas de persistência.

Para manter o isolamento deste modelo lógico, há outros modelos *helpers*, como a interface `Hashmapper`, que serve para garantir que cada objeto saiba como mapear seus próprios campos para sistemas de persistência diferentes. Toda classe básica mencionada no topo desta página sabe 'mapear a si mesma' para qualquer sistema.

Para facilitar os testes deste projeto, há a classe `MemoryDB`, que implementa `DataAccessInterface` em uma estrutura de dados em memória.

Para minimizar a quantidade de código replicado no armazenamento de diferentes tipos de objetos, há a classe `KeyValueStore`, que essencialmente pode guardar qualquer tipo de dado.

Para portar todo este projeto para qualquer tipo de modelo de persistência, basta estender o modelo de dados, implementando a interface `DataAccessInterface`. Ela funciona como uma fachada para interagir com as camadas de persistência.

### cashbackDomain.factories ###

Aqui estão todas as fábricas dos objetos básicos. Cada uma delas estendem `AbstractCashbackObjectsFactory`. Não tem mistério.

### cashbackDomain.objects.identity ###

Este é o pacote que prepara todas as entidades básicas para serem identificáveis no sistema.

`Id` é uma classe final que representa um identificador no sistema. O identificador em si é um inteiro, e a classe é genérica, podendo ser associada especificamente a tipos diferentes de objetos.

`Identifiable` é uma classe abstrata que todos os objetos básicos implementam. Garante as operações básicas de identificação no modelo (get/setId).

### cashbackDomain.setup ###

Contém apenas uma classe, `CashbackConfig` - que representa o contexto do modelo lógico. Ele é utilizado aqui para organizar todos os objetos do sistema.
