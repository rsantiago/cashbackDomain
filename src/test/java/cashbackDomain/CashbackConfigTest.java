/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package cashbackDomain;

import org.junit.Test;


import cashbackDomain.album.Album;
import cashbackDomain.album.Genre;
import cashbackDomain.objects.identity.Id;
import cashbackDomain.promo.Promo;
import cashbackDomain.promo.PromoUtils;
import cashbackDomain.setup.CashbackConfig;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

public class CashbackConfigTest {
	
    @Test public void testConfigCreation() {
        CashbackConfig config = CashbackConfig.buildMemmoryDBConfig();
        assertNotNull("someLibraryMethod should return different than null", config);
        assertNotNull("Fábrica de promo não é nula", config.getPromoFactory());
        assertNotNull("Fábrica de genero não é nula", config.getGenreFactory());
        assertNotNull("Fábrica de albums não é nula", config.getAlbumFactory());
        assertNotNull("Fábrica de clientes não é nula", config.getCustomerFactory());
        assertNotNull("Loja não é nula", config.getPromoFactory());
        assertNotNull("Fábrica de item de compra não é nula", config.getItemFactory());
        assertNotNull("Fábrica de pedidos não é nula", config.getOrderFactory());
        
        Genre genSertanejao = config.getGenreFactory().buildGenre("Sertanejão");
        Genre genSertanejao2 = config.getGenreFactory().buildGenre("Sertanejão");
        
        // teste de identidade - para saber se os ids dos objetos são iguais
        assertTrue("id do sertanejo do banco identico ao id do sertanejo lido", genSertanejao.getId().equals(genSertanejao2.getId()));
        // teste de identidade - para saber se os objetos passam no teste equals()
        assertTrue("Os objetos sao iguais", genSertanejao.equals(genSertanejao2));
        
        Genre genRock = config.getGenreFactory().buildGenre("Rock");
        Genre genForro = config.getGenreFactory().buildGenre("Forró");
        Genre genPagode = config.getGenreFactory().buildGenre("Pagode");
        
        Genre newGenSertanejao = config.getData().saveGenre(genSertanejao);
        Genre newGenRock = config.getData().saveGenre(genRock);
        Genre newGenForro = config.getData().saveGenre(genForro);
        Genre newGenPagode = config.getData().saveGenre(genPagode);
        
        assertNotNull("Sertanejao retornado", newGenSertanejao);
        assertNotNull("Forro retornado", newGenForro);
        assertNotNull("Rock retornado", newGenRock);
        assertNotNull("Pagode retornado", newGenPagode);
        
        
        assertTrue("Sertanejao inserido identico ao retornado", newGenSertanejao == genSertanejao);
        assertTrue("Forro inserido identico ao retornado", newGenForro == genForro);
        assertTrue("Rock inserido identico ao retornado", newGenRock == genRock);
        assertTrue("Pagode inserido identico ao retornado", newGenPagode == genPagode);

        
        Set<Genre> values = config.getData().getGenres(config.getData().getGenreIds());
        assertTrue("Quatro generos na lista", values.size()==4);
        Iterator<Genre> iterator = values.iterator();
        
        assertNotNull("Primeiro genero: ", iterator.next().getName()!=null );
        assertNotNull("Segundo genero: ", iterator.next().getName()!=null);
        assertNotNull("Terceiro genero: ", iterator.next().getName()!=null);
        assertNotNull("Quarto genero: ", iterator.next().getName()!=null);
        assertFalse("Não há mais gêneros: ", iterator.hasNext());
        
        Album zeze = config.getAlbumFactory().buildAlbum("Zezé de camargo", "Nas estradas da vida", genSertanejao.getId());
        Album martinho = config.getAlbumFactory().buildAlbum("MArtinho da Vila", "Devagar, Devagarinho", genPagode.getId());
        Album metallica = config.getAlbumFactory().buildAlbum("Metallica", "Nothing Else Matters", genRock.getId());
        Album alceu = config.getAlbumFactory().buildAlbum("Alceu Valença", "La Belle de Jour", genForro.getId());
        
        config.getData().saveAlbum(zeze);
        config.getData().saveAlbum(martinho);
        config.getData().saveAlbum(metallica);
        config.getData().saveAlbum(alceu);
        
        Album retrievedMetallica = config.getData().getAlbum(metallica.getId());
        Album retrievedMartinho = config.getData().getAlbum(martinho.getId());
        Album retrievedZeze = config.getData().getAlbum(zeze.getId());
        Album retrievedAlceu = config.getData().getAlbum(alceu.getId());
        
        assertTrue("Objetos identicos", retrievedMetallica == metallica);
        assertTrue("MArtinho", retrievedMartinho == martinho);
        assertTrue("Alceu", retrievedAlceu == alceu);
        assertTrue("Zeze", retrievedZeze == zeze);
        
        assertTrue("Genero rock" ,config.getData().getGenre(retrievedMetallica.getGenreId()) == genRock);
        assertTrue("Genero pagode" ,config.getData().getGenre(retrievedMartinho.getGenreId()) == genPagode);
        assertTrue("Genero forro" ,config.getData().getGenre(retrievedAlceu.getGenreId()) == genForro);
        assertTrue("Genero sertanejao" ,config.getData().getGenre(retrievedZeze.getGenreId()) == genSertanejao);
        
        // insercao de objetos iguais aos já existentes. Primeiro, Genero
        Genre genSertanejaoSosia = config.getGenreFactory().buildGenre("Sertanejão");
        Genre genSertanejaoRetrieved = config.getData().saveGenre(genSertanejaoSosia);
        
        assertTrue("Objetos diferentes" , genSertanejaoSosia != genSertanejaoRetrieved);
        assertTrue("Objeto retornado é o mesmo da primeira versão", genSertanejaoRetrieved == genSertanejao);
        
        // Depois, Disco - nao pode inserir este novo
        Album zezeSosia = config.getAlbumFactory().buildAlbum("Zezé de camargo", "Nas estradas da vida", genSertanejao.getId());
        Album zezeRetrieved = config.getData().saveAlbum(zezeSosia);
        assertTrue("Objetos diferentes", zezeSosia != zezeRetrieved);
        assertTrue("Objetos iguais", zezeRetrieved == zeze);
        assertTrue("Objetos diferentes - os generos adicionados junto ao algum", genSertanejaoSosia != config.getData().getGenre(zezeRetrieved.getGenreId()));
        assertTrue("Objetos iguais - os generos adicionados junto ao algum", config.getData().getGenre(zezeRetrieved.getGenreId()) == genSertanejao);
        
        assertTrue("4 Albums inseridos",config.getData().getAlbumIds().size()==4);
        assertTrue("4 categorias inseridas",config.getData().getGenreIds().size()==4);
        
        // configura e testa as promocoes padronizadas
        
        // rock já existe
        Genre pop = config.getGenreFactory().buildGenre("Pop");
        Genre mpb = config.getGenreFactory().buildGenre("MPB");
        Genre classic = config.getGenreFactory().buildGenre("Classic");
        
        Set<Promo> defaultPromos = PromoUtils.getDefaultPromos(pop, mpb, classic, genRock);
        
        assertTrue("Número correto de promos criadas", defaultPromos.size()==28);
        
        config.getData().saveAllPromos(defaultPromos);
        Set<Id<Promo>> readPromoIds = config.getData().getPromoIds();
        assertTrue("Número correto de ids de promos lidas", readPromoIds.size()==28);
        
        Set<Promo> readPromos = config.getData().getPromos(readPromoIds);
        
        assertTrue("Número correto de promos lidas", readPromos.size()==28);
        
        
    }
}
