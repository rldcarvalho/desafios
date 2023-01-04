package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarrinhoComprasFactoryTest {

	String cliente1 = "João";
	String cliente2 = "Maria";
	String cliente3 = "José";

	Produto produto1 = new Produto(1L, "Celular");
	Produto produto2 = new Produto(2L, "Notebook");
	Produto produto3 = new Produto(3L, "Tv");
	Produto produto4 = new Produto(4L, "Geladeira");
	Produto produto5 = new Produto(5L, "Fogão");

	Item item1 = new Item(produto1, BigDecimal.valueOf(2500), 3);
	Item item2 = new Item(produto2, BigDecimal.valueOf(4500), 1);
	Item item3 = new Item(produto3, BigDecimal.valueOf(1999), 5);
	Item item4 = new Item(produto4, BigDecimal.valueOf(2499.95), 1);
	Item item5 = new Item(produto5, BigDecimal.valueOf(700), 3);
	Item item5Corrigido = new Item(produto5, BigDecimal.valueOf(800), 4);

	List<Item> listaItem1 = new ArrayList<>(Arrays.asList(item1, item2));
	List<Item> listaItem2 = new ArrayList<>(Arrays.asList(item4, item5));

	CarrinhoCompras carrinho1 = new CarrinhoCompras(cliente1, listaItem1);
	CarrinhoCompras carrinho2 = new CarrinhoCompras(cliente2, listaItem2);
	CarrinhoCompras carrinho3 = new CarrinhoCompras(cliente3, new ArrayList<>());

	List<CarrinhoCompras> listaDeCarrinhos = new ArrayList<>(Arrays.asList(carrinho1, carrinho2));

	CarrinhoComprasFactory carrinhos = new CarrinhoComprasFactory(listaDeCarrinhos);

	BigDecimal totalTicketMedioDosCarrinhos = new BigDecimal("8299.98");

	@Test
	@Order(1)
	void deveriaRetornarUmNovoCarrinhoDeComprasAUmClienteSemCarrinho(){
		assertEquals(carrinho3, carrinhos.criar(cliente3));
	}

	@Test
	@Order(2)
	void deveriaRetornarCarrinhoExistenteCasoClientePassadoNaCriacaoJaExistir(){
		assertEquals(carrinho1, carrinhos.criar(cliente1));
		assertEquals(carrinho2, carrinhos.criar(cliente2));
	}

	@Test
	@Order(3)
	void deveriaRetornarOValorDoTicketMedioDosCarrinhosArredondado(){
		assertEquals(totalTicketMedioDosCarrinhos, carrinhos.getValorTicketMedio());
	}

	@Test
	@Order(4)
	void deveriaRetornarTrueAoInvalidarUmCarrinhoCorretamente(){
		assertTrue(carrinhos.invalidar(cliente2));
	}

	@Test
	@Order(5)
	void deveriaRetornarFalseAoInvalidarUmCarrinhoInexistente(){
		assertFalse(carrinhos.invalidar(cliente3));
	}

}